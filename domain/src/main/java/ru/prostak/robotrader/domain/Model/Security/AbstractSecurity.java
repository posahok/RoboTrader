package ru.prostak.robotrader.domain.Model.Security;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.SecurityType;

public class AbstractSecurity {
    protected SecurityType type;

    protected String identifier;

    protected Currency currency;

    public SecurityType getType() {
        return type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return identifier;
    }
}
