package pl.siennicki;

import okhttp3.HttpUrl;
import okhttp3.Request;

import java.time.LocalDate;

public class RequestBuilder {
    private static final String SCHEMA = "http";
    private static final String BACKHEND_HOST = "api.nbp.pl";
    private static String DATE_FORMAT_QUERY_PARAM = "format";

    private Currency currency = Currency.JPY;
    private LocalDate date = LocalDate.now();
    private DataFormat dataFormat = DataFormat.JSON;

    public RequestBuilder currency(Currency currency) {
        if(currency != null){
            this.currency = currency;
        }
        return this;
    }

    public RequestBuilder date(LocalDate date) {
        if(date != null){
            this.date = date;
        }
        return this;
    }

    public RequestBuilder dataFormat(DataFormat dataFormat) {
        if(dataFormat != null){
            this.dataFormat = dataFormat;
        }
        return this;
    }

    public Request build(){
        HttpUrl url = createUrl();
        return new Request.Builder()
                .url(url)
                .build();
    }

    private HttpUrl createUrl() {
        return new HttpUrl.Builder()
                .scheme(SCHEMA)
                .host(BACKHEND_HOST)
                .addPathSegments("api/exchangerates/rates/c")
                .addPathSegment(currency.name())
                .addPathSegment(DateProvider.getLastWorkingDateAsString(date))
                .addQueryParameter(DATE_FORMAT_QUERY_PARAM,dataFormat.name())
                .build();
    }
}
