package pl.siennicki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class JsonDataConverter implements DataConverter {

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .create();

    @Override
    public CurrencyInfo convertData(String data) {
        ExchangeRate exchangeRate = gson.fromJson(data, ExchangeRate.class);
        return createCurrencyInfo(exchangeRate);

    }

    @NotNull
    private CurrencyInfo createCurrencyInfo(ExchangeRate exchangeRate) {
        Rate rate = exchangeRate.getRates().get(0);

        return new CurrencyInfo(
                exchangeRate.getCurrency(),
                rate.getEffectiveDate(),
                rate.getAsk(),
                rate.getBid()
        );
    }
}
