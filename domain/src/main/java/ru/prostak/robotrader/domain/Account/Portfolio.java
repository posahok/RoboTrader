package ru.prostak.robotrader.domain.Account;

import com.sun.tools.sjavac.comp.dependencies.PublicApiCollector;

import java.math.BigDecimal;

import java.util.HashMap;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Security.*;

class Portfolio {
    public HashMap<Currency, BigDecimal> balance;

    public HashMap<Bond, Integer> bonds;

    public HashMap<Stock, Integer> stocks;

    public HashMap<ETF, Integer> etfs;

    public HashMap<CryptoCurrency, Integer> cryptos;

    public Portfolio(){
        this.balance = new HashMap<>();

        for(Currency currency: Currency.values())
            balance.put(currency, BigDecimal.ZERO);

        this.bonds = new HashMap<>();
        this.stocks = new HashMap<>();
        this.etfs = new HashMap<>();
        this.cryptos = new HashMap<>();
    }

    public void addBond(Bond bond, int lots){
        int currentLots = 0;
        if(bonds.containsKey(bond))
            currentLots = bonds.get(bond);
        bonds.put(bond, currentLots+ lots);
    }

    public void addStock(Stock stock, int lots){
        int currentLots = 0;
        if(stocks.containsKey(stock))
            currentLots = stocks.get(stock);
        stocks.put(stock, currentLots+ lots);
    }

    public void addEtf(ETF etf, int lots){
        int currentLots = 0;
        if(etfs.containsKey(etf))
            currentLots = etfs.get(etf);
        etfs.put(etf, currentLots+ lots);
    }

    public void addCrypto(CryptoCurrency crypto, int lots){
        int currentLots = 0;
        if(cryptos.containsKey(crypto))
            currentLots = cryptos.get(crypto);
        cryptos.put(crypto, currentLots+ lots);
    }


    public void Print() {
        System.out.println("Balance:");
        for(Currency currency: balance.keySet()){
            System.out.println(currency.name() + ": " + balance.get(currency));
        }
        System.out.println();

        System.out.println("Bonds:");
        for(Bond bond: bonds.keySet()){
            System.out.println(bond.toString() + ": " + bonds.get(bond));
        }
        System.out.println();

        System.out.println("Stocks:");
        for(Stock stock: stocks.keySet()){
            System.out.println(stock.toString() + ": " +stocks.get(stock));
        }
        System.out.println();

        System.out.println("ETFs:");
        for(ETF etf: etfs.keySet()){
            System.out.println(etf.toString() + ": " +etfs.get(etf));
        }
        System.out.println();

        System.out.println("Crypto Currencies:");
        for(CryptoCurrency cryptoCurrency: cryptos.keySet()){
            System.out.println(cryptoCurrency.toString() + ": " +cryptos.get(cryptoCurrency));
        }
        System.out.println();
    }
}
