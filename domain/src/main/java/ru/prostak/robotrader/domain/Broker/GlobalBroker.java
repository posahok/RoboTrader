package ru.prostak.robotrader.domain.Broker;

import java.util.HashMap;
import java.util.List;

import ru.prostak.robotrader.domain.Model.Security.AbstractSecurity;
import ru.prostak.robotrader.domain.Repository.IBrokerRepository;

public class GlobalBroker {
    private HashMap<IBrokerRepository, List<String>> brokersDataBank;

    public GlobalBroker(){
        brokersDataBank = new HashMap<>();
    }

    public void attachRepository(IBrokerRepository repository){
        List<String> availableIdentifiers = repository.getAvailableIdentifiers();
        brokersDataBank.put(repository, availableIdentifiers);
    }

    public AbstractSecurity getSecurityByIdentifier(String identifier){
        AbstractSecurity result = null;

        for(IBrokerRepository broker: brokersDataBank.keySet())
            if(brokersDataBank.get(broker).contains(identifier))
                result = broker.getSecurity(identifier);

        return result;
    }

    public boolean buy(String identifier, int lots){
        boolean result = false;

        for(IBrokerRepository broker: brokersDataBank.keySet())
            if(brokersDataBank.get(broker).contains(identifier))
                result = broker.buy(identifier, lots);


        return result;
    }

    public boolean sell(String identifier, int lots){
        boolean result = false;

        for(IBrokerRepository broker: brokersDataBank.keySet())
            if(brokersDataBank.get(broker).contains(identifier))
                result = broker.sell(identifier, lots);


        return result;
    }
}
