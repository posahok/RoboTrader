package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class CryptoCurrency extends AbstractSecurity{

    public CryptoCurrency(String ticker, Currency currency){
        this.type = SecurityType.CRYPTO;
        this.ticker = ticker;
        this.currency = currency;
    }
}
