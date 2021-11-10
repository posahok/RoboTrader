package ru.prostak.robotrader.domain.Account;


import java.math.BigDecimal;

import java.util.HashMap;

import ru.prostak.robotrader.domain.Exception.NegativeSecurityCountException;
import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Security.*;

public class Portfolio {
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

    public void updateBalance(HashMap<Currency, BigDecimal> balance){
        for(Currency currency: balance.keySet())
            this.balance.put(currency, balance.get(currency));
    }

    public void changeBondCount(Bond bond, int lots) throws NegativeSecurityCountException{
        int currentLots = 0;
        if(bonds.containsKey(bond))
            currentLots = bonds.get(bond);

        int newBondCount = currentLots + lots;

        if(newBondCount >= 0)
            bonds.put(bond, newBondCount);
        else
            throw new NegativeSecurityCountException(bond, newBondCount);
    }

    public void changeStockCount(Stock stock, int lots) throws NegativeSecurityCountException{
        int currentLots = 0;
        if(stocks.containsKey(stock))
            currentLots = stocks.get(stock);

        int newBondCount = currentLots + lots;

        if(newBondCount >= 0)
            stocks.put(stock, newBondCount);
        else
            throw new NegativeSecurityCountException(stock, newBondCount);
    }

    public void changeEtfCount(ETF etf, int lots) throws NegativeSecurityCountException{
        int currentLots = 0;
        if(etfs.containsKey(etf))
            currentLots = etfs.get(etf);

        int newBondCount = currentLots + lots;

        if(newBondCount >= 0)
            etfs.put(etf, newBondCount);
        else
            throw new NegativeSecurityCountException(etf, newBondCount);
    }

    public void changeCryptoCount(CryptoCurrency crypto, int lots) throws NegativeSecurityCountException{
        int currentLots = 0;
        if(cryptos.containsKey(crypto))
            currentLots = cryptos.get(crypto);

        int newBondCount = currentLots + lots;

        if(newBondCount >= 0)
            cryptos.put(crypto, newBondCount);
        else
            throw new NegativeSecurityCountException(crypto, newBondCount);
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
