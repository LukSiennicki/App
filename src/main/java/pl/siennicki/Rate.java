
package pl.siennicki;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class Rate {

    @SerializedName("no")
    @Expose
    private String no;
    @SerializedName("effectiveDate")
    @Expose
    private LocalDate effectiveDate;
    @SerializedName("bid")
    @Expose
    private double bid;
    @SerializedName("ask")
    @Expose
    private double ask;
    @SerializedName("mid")
    @Expose
    private double mid;

    public String getNo() {
        return no;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public double getBid() {
        return bid;
    }

    public double getAsk() {
        return ask;
    }

    public double getMid() {
        return mid;
    }
}
