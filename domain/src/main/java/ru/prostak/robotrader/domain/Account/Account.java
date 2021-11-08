package ru.prostak.robotrader.domain.Account;

import java.math.BigDecimal;

import ru.prostak.robotrader.domain.Broker.GlobalBroker;
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
    }

    public boolean buy(String identifier, int lots){
        boolean result = false;

        result = broker.buy(identifier, lots);

        if(result){
            AbstractSecurity boughtSecurity = broker.getSecurityByIdentifier(identifier);
            switch (boughtSecurity.getType()){
                case BOND:
                    portfolio.addBond((Bond)boughtSecurity, lots);
                case ETF:
                    portfolio.addEtf((ETF)boughtSecurity, lots);
                case STOCK:
                    portfolio.addStock((Stock)boughtSecurity, lots);
                case CRYPTO:
                    portfolio.addCrypto((CryptoCurrency) boughtSecurity, lots);
                case UNKNOWN:
                    System.out.println("Wtf is this???: " + boughtSecurity.getIdentifier());
            }
        }

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
