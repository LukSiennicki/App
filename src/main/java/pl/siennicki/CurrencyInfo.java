package pl.siennicki;

import java.time.LocalDate;

public class CurrencyInfo {

    private String name;
    private LocalDate date;
    private double buy;
    private double sell;

    public CurrencyInfo(String name, LocalDate date, double buy, double sell) {
        this.name = name;
        this.date = date;
        this.buy = buy;
        this.sell = sell;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getBuy() {
        return buy;
    }

    public double getSell() {
        return sell;
    }
}
