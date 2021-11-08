package ru.prostak.robotrader.domain.Debug;

import java.math.BigDecimal;

import ru.prostak.robotrader.domain.Account.Account;
import ru.prostak.robotrader.domain.Broker.GlobalBroker;
import ru.prostak.robotrader.domain.Model.Enum.Currency;
import ru.prostak.robotrader.domain.Repository.IBrokerRepository;

public class Main {
    public static void main(String[] args) {

        IBrokerRepository tinkoffRepository = null; // = new TinkoffRepository();
       // IBrokerRepository binanceRepository = null; //new BinanceRepository();

        GlobalBroker broker = new GlobalBroker();
        broker.attachRepository(tinkoffRepository);
      //  broker.attachRepository(binanceRepository);

        Account account = new Account(broker);

        System.out.println("RUB balance: " + account.getBalance(Currency.RUB));
        System.out.println("USD balance: " + account.getBalance(Currency.USD));
        System.out.println("EUR balance: " + account.getBalance(Currency.EUR));

        if(account.buy("FXDE", 1)){
            System.out.println("Successfully bought 1 FXDE etfs");
        } else {
            System.out.println("Failed to buy 1 FXDE etfs");
        }

        account.PrintPortfolio();


    }
}
