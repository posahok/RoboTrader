package ru.prostak.robotrader.domain.Exception;

import ru.prostak.robotrader.domain.Model.Security.AbstractSecurity;

public class NegativeSecurityCountException extends Exception{

    public NegativeSecurityCountException(AbstractSecurity security, int lots){
        //todo implementation
    }
}
