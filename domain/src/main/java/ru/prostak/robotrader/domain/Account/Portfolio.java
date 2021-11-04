package ru.prostak.robotrader.domain.Account;

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
        this.bonds = new HashMap<>();
        this.stocks = new HashMap<>();
        this.etfs = new HashMap<>();
        this.cryptos = new HashMap<>();
    }
}
