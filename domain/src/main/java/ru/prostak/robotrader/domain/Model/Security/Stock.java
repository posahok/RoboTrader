package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class Stock extends AbstractSecurity{

    public Stock(String identifier, Currency currency){
        this.type = SecurityType.STOCK;
        this.identifier = identifier;
        this.currency = currency;
    }

}
