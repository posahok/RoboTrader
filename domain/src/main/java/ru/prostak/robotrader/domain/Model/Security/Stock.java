package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class Stock extends AbstractSecurity{

    public Stock(String ticker, Currency currency){
        this.type = SecurityType.STOCK;
        this.ticker = ticker;
        this.currency = currency;
    }

}
