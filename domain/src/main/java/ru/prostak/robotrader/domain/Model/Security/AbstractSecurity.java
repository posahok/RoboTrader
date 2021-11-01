package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class AbstractSecurity {
    protected SecurityType type;

    protected String ticker;

    protected Currency currency;

}
