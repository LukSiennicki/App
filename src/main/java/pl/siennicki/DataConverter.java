package pl.siennicki;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface DataConverter {
    CurrencyInfo convertData(String data) throws JsonProcessingException;

    DataFormat getType();
}
