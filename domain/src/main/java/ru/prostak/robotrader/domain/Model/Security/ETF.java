package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class ETF extends AbstractSecurity{

    public ETF(String identifier, Currency currency){
        this.type = SecurityType.ETF;
        this.identifier = identifier;
        this.currency = currency;
    }


}
