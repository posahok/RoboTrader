package ru.prostak.robotrader.domain.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import ru.prostak.robotrader.domain.Model.Chart.Chart;
import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Enum.Interval;
import ru.prostak.robotrader.domain.Model.Security.AbstractSecurity;

public interface IBrokerRepository {

    List<String> getAvailableIdentifiers();

    AbstractSecurity getSecurity(String identifier);

    boolean sell(String identifier, int lots);

    boolean buy(String identifier, int lots);

    HashMap<Currency, BigDecimal> getBalance();
}
