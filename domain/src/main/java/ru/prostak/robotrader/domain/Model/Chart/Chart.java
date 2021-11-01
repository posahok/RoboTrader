package ru.prostak.robotrader.domain.Model.Chart;

import java.util.ArrayList;

import ru.prostak.robotrader.domain.Model.Enum.Interval;

public class Chart {
    private String identifier;

    private Interval interval;

    private ArrayList<Candle> candle;

    public Chart(String identifier, Interval interval, ArrayList<Candle> candle) {
        this.identifier = identifier;
        this.interval = interval;
        this.candle = candle;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

    public ArrayList<Candle> getCandle() {
        return candle;
    }

    public void setCandle(ArrayList<Candle> candle) {
        this.candle = candle;
    }
}



