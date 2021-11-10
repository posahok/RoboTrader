package ru.prostak.robotrader.data.Repository

import okhttp3.internal.toImmutableList
import ru.prostak.robotrader.domain.Repository.IBrokerRepository

import ru.prostak.robotrader.domain.Model.Enum.Currency
import ru.prostak.robotrader.domain.Model.Enum.SecurityType
import ru.prostak.robotrader.domain.Model.Security.*
import ru.tinkoff.invest.openapi.model.rest.Currency as TinkoffCurrency
import ru.tinkoff.invest.openapi.okhttp.OkHttpOpenApi;
import ru.tinkoff.invest.openapi.model.rest.*;

class TinkoffRepository(private val token: String, private val sandboxMode: Boolean): IBrokerRepository {

    private val api = OkHttpOpenApi(token, sandboxMode)
    init {
        if (api.isSandboxMode)
            api.sandboxContext.performRegistration(SandboxRegisterRequest()).join()
    }

    override fun getAvailableIdentifiers(): List<String> {
        val result = mutableListOf<String>()

        val marketCurrencies = api.marketContext.marketCurrencies.get().instruments
        val marketBonds = api.marketContext.marketBonds.get().instruments
        val marketEtfs = api.marketContext.marketEtfs.get().instruments
        val marketStocks = api.marketContext.marketStocks.get().instruments

        result.addAll(marketCurrencies.map { it.figi })
        result.addAll(marketBonds.map { it.figi })
        result.addAll(marketEtfs.map { it.figi })
        result.addAll(marketStocks.map { it.figi })

        return result.toImmutableList()

    }

    override fun getSecurity(identifier: String): AbstractSecurity {
        val instrument = api.marketContext.searchMarketInstrumentByFigi(identifier).get().get()
        val currency = when (instrument.currency) {
            TinkoffCurrency.USD -> Currency.USD
            TinkoffCurrency.EUR -> Currency.EUR
            TinkoffCurrency.RUB -> Currency.RUB
            TinkoffCurrency.GBP -> Currency.GBP
            TinkoffCurrency.CHF -> Currency.CHF
            TinkoffCurrency.CNY -> Currency.CNY
            TinkoffCurrency.HKD -> Currency.HKD
            TinkoffCurrency.JPY -> Currency.JPY
            TinkoffCurrency.TRY -> Currency.TRY
        }
        return  when (instrument.type) {
            InstrumentType.BOND -> Bond(identifier, currency)
            InstrumentType.CURRENCY -> CryptoCurrency(identifier, currency)
            InstrumentType.ETF -> ETF(identifier, currency)
            InstrumentType.STOCK -> Stock(identifier, currency)
        }

    }

    override fun sell(identifier: String, lots: Int): Boolean {
        val marketOrderRequest = MarketOrderRequest()
        marketOrderRequest.lots = lots
        marketOrderRequest.operation = OperationType.SELL
        val order = api.ordersContext.placeMarketOrder(identifier, marketOrderRequest, api.userContext.accounts.get().accounts[0].brokerAccountId).get()
        return order.requestedLots == lots
    }

    override fun buy(identifier: String, lots: Int): Boolean {
        val marketOrderRequest = MarketOrderRequest()
        marketOrderRequest.lots = lots
        marketOrderRequest.operation = OperationType.BUY
        val order = api.ordersContext.placeMarketOrder(identifier, marketOrderRequest, api.userContext.accounts.get().accounts[0].brokerAccountId).get()
        return order.requestedLots == lots
    }
}