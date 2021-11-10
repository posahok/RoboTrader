package ru.prostak.robotrader.domain.Account;

import java.math.BigDecimal;

import ru.prostak.robotrader.domain.Broker.GlobalBroker;
import ru.prostak.robotrader.domain.Exception.NegativeSecurityCountException;
import ru.prostak.robotrader.domain.Exception.UnknownSecurityTypeException;
import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Security.AbstractSecurity;
import ru.prostak.robotrader.domain.Model.Security.Bond;
import ru.prostak.robotrader.domain.Model.Security.CryptoCurrency;
import ru.prostak.robotrader.domain.Model.Security.ETF;
import ru.prostak.robotrader.domain.Model.Security.Stock;

public class Account {
    private Portfolio portfolio;
    private GlobalBroker broker;

    public Account(GlobalBroker broker){
        this.portfolio = new Portfolio();
        this.broker = broker;

        portfolio.updateBalance(broker.getBalance());
    }

    public boolean buy(String identifier, int lots){
        boolean result = false;

        result = broker.buy(identifier, lots);

        try{
            if(result){
                AbstractSecurity boughtSecurity = broker.getSecurity(identifier);
                switch (boughtSecurity.getType()){
                    case BOND:
                        if(boughtSecurity instanceof Bond)
                            portfolio.changeBondCount((Bond)boughtSecurity, lots);
                    case ETF:
                        if(boughtSecurity instanceof ETF)
                            portfolio.changeEtfCount((ETF)boughtSecurity, lots);
                    case STOCK:
                        if(boughtSecurity instanceof Stock)
                            portfolio.changeStockCount((Stock)boughtSecurity, lots);
                    case CRYPTO:
                        if(boughtSecurity instanceof CryptoCurrency)
                            portfolio.changeCryptoCount((CryptoCurrency)boughtSecurity, lots);
                    case UNKNOWN:
                        throw new UnknownSecurityTypeException(boughtSecurity.getIdentifier());
                }
            }
        } catch (NegativeSecurityCountException | UnknownSecurityTypeException exception){}


        return result;
    }

    public boolean sell(String identifier, int lots){
        broker.sell(identifier, lots);
        return  false;
    }

    public BigDecimal getBalance(Currency currency){
        return portfolio.balance.get(currency);
    }

    public void PrintPortfolio(){
        portfolio.Print();
    }

}
