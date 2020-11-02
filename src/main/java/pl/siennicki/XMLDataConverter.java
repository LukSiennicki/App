package pl.siennicki;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jetbrains.annotations.NotNull;

public class XMLDataConverter implements DataConverter{
    ObjectMapper xmlMapper = new XmlMapper();

    @Override
    public CurrencyInfo convertData(String data) throws JsonProcessingException {
        ExchangeRate exchangeRate = xmlMapper.readValue(data, ExchangeRate.class);
        return createCurrencyInfo(exchangeRate);
    }

    @Override
    public DataFormat getType() {
        return DataFormat.XML;
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
