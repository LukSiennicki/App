package pl.siennicki;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.LocalDate;

public class WalutoApp {
    public static void main(String[] args) throws IOException {

        DataConverter dataConverter = new JsonDataConverter();

        OkHttpClient client = new OkHttpClient();


        Request eurRequest = new RequestBuilder().currency(Currency.EUR)
                .date(LocalDate.now())
                .dataFormat(DataFormat.JSON)
                .build();

        Response response = client.newCall(eurRequest).execute();
        String jsonString = response.body().string();

        CurrencyInfo currencyInfo = dataConverter.convertData(jsonString);

        System.out.println("response: sprzedaz 100 >>> " + currencyInfo.getName() + " : " + (100 * currencyInfo.getSell()));
        System.out.println("response: kupno 100 >>> " + currencyInfo.getName() + " : " + (100 * currencyInfo.getBuy()));


    }
}
