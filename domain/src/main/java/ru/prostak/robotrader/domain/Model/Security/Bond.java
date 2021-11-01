package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class Bond extends AbstractSecurity{

    public Bond(String ticker, Currency currency){
        this.type = SecurityType.BOND;
        this.ticker = ticker;
        this.currency = currency;
    }

}
