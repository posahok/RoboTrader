package ru.prostak.robotrader.domain.Account;

import java.math.BigDecimal;
import java.util.HashMap;

import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Model.Security.AbstractSecurity;
import ru.prostak.robotrader.domain.Repository.IBrokerRepository;

public class Account {
    private Portfolio portfolio;

    private HashMap<String, AbstractSecurity> availableSecutiries;

    public Account(){
        this.portfolio = new Portfolio();
        availableSecutiries = new HashMap<>();
    }

    public void attachRepository(IBrokerRepository repository){

        for(AbstractSecurity security: repository.updateAvailableSecurities()){
            String identifier = security.getIdentifier();
            if(!availableSecutiries.containsKey(identifier))
                availableSecutiries.put(identifier, security);
        }

        for(Currency currency: Currency.values()){
            BigDecimal balance = repository.getBalance(currency);
            if(balance != null)
                portfolio.balance.put(currency, balance);
        }

    }



}
