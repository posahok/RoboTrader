package ru.prostak.robotrader.domain.Account;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;

import ru.prostak.robotrader.domain.Model.Security.*;

public class Portfolio {
    private HashMap<Currency, BigDecimal> balance;

    private HashMap<Bond, Integer> bonds;

    private HashMap<Stock, Integer> stocks;

    private HashMap<ETF, Integer> etfs;

    private HashMap<CryptoCurrency, Integer> cryptos;

    public Portfolio(){
        this.balance = new HashMap<>();
        this.bonds = new HashMap<>();
        this.stocks = new HashMap<>();
        this.etfs = new HashMap<>();
        this.cryptos = new HashMap<>();
    }
}
