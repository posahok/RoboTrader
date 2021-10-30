package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class ETF extends AbstractSecurity{

    public ETF(String ticker){
        this.type = SecurityType.ETF;
        this.ticker = ticker;
    }

}
