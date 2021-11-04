package ru.prostak.robotrader.domain.Debug;

import ru.prostak.robotrader.domain.Account.Account;
import ru.prostak.robotrader.domain.Repository.IBrokerRepository;

public class Main {
    public static void main(String[] args) {

        IBrokerRepository tinkoffRepository = null;// = new TinkoffRepository(...);
        IBrokerRepository binanceRepository = null;// = new BinanceRepository(...);

        Account account = new Account();
        account.attachRepository(tinkoffRepository);
        account.attachRepository(binanceRepository);
    }
}
