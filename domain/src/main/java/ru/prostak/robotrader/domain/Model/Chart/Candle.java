package ru.prostak.robotrader.domain.Model.Chart;

import java.math.BigDecimal;
import java.util.Calendar;

import ru.prostak.robotrader.domain.Model.Enum.Interval;

/**
    Model-representation of the single chart candle
 */
public class Candle {

    //Unique identifier of security to which the candle belongs (figi/ticker/name/etc)
    private String identifier;

    //Open value
    private BigDecimal open;

    //Close value
    private BigDecimal close;

    //Highest value
    private BigDecimal high;

    //Lowest value
    private BigDecimal low;

    //Volume
    private BigDecimal volume;

    //Candle timestamp
    private Calendar time;

    //Candle interval
    private Interval interval;

    //Object constructor
    private Candle(String identifier,
                   BigDecimal open,
                   BigDecimal close,
                   BigDecimal high,
                   BigDecimal low,
                   BigDecimal volume,
                   Calendar time){
        this.identifier = identifier;
        this.open = open;
        this.close = close;
        this.high = high;
        this.low = low;
        this.volume = volume;
        this.time = time;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Calendar getTime() {
        return time;
    }

    public void setTime(Calendar time) {
        this.time = time;
    }
}
