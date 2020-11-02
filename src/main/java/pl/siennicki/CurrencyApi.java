package pl.siennicki;

import java.io.IOException;

public class CurrencyApi {
    private final DataConverter dataConverter;
    private final Client client;

    public CurrencyApi(Client client, DataConverter dataConverter){
        this.client = client;
        this.dataConverter = dataConverter;
    }

    public CurrencyInfo getInfoForCurrency(Currency currency) throws IOException {
        String dataString = client.executeRequest(currency,dataConverter.getType());

        return dataConverter.convertData(dataString);
    }
}
