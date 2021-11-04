package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class Bond extends AbstractSecurity{

    public Bond(String identifier, Currency currency){
        this.type = SecurityType.BOND;
        this.identifier = identifier;
        this.currency = currency;
    }

}
