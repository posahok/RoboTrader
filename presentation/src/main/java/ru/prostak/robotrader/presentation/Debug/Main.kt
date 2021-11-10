package ru.prostak.robotrader.presentation.Debug

import ru.prostak.robotrader.domain.Account.Account
import ru.prostak.robotrader.domain.Broker.GlobalBroker
import ru.prostak.robotrader.domain.Repository.IBrokerRepository

import ru.prostak.robotrader.data.Repository.TinkoffRepository

fun main() {
    val tinkoffRepository: IBrokerRepository  = TinkoffRepository("", false)

    val broker = GlobalBroker()
    broker.attachRepository(tinkoffRepository)

    val account = Account(broker)

//    println("RUB balance: " + account.getBalance(Currency.RUB))
//    println("USD balance: " + account.getBalance(Currency.USD))
//    println("EUR balance: " + account.getBalance(Currency.EUR))

//    if (account.buy("BBG005H7MXN2", 1)) {
//        println("Successfully bought 1 FXDE etfs")
//    } else {
//        println("Failed to buy 1 FXDE etfs")
//    }

    //account.PrintPortfolio()
}