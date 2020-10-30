package pl.siennicki;

import java.io.IOException;

public class CurrencyApi {
    private final DataConverter dataConverter = new JsonDataConverter();

    private final Client client = Client.INSTANCE;

    public CurrencyInfo getInfoForCurrency(Currency currency) throws IOException {
        System.out.println(client.hashCode());
        String jsonString = client.executeRequest(currency,DataFormat.JSON);

        return dataConverter.convertData(jsonString);
    }
}
