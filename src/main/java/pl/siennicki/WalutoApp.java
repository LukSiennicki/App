package pl.siennicki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class WalutoApp {

    static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .create();

    public static void main(String[] args) throws IOException {
//        String daneZInternetu = "{\"table\":\"C\",\"currency\":\"euro\",\"code\":\"EUR\",\"rates\":[{\"no\":\"173/C/NBP/2020\"," +
//                "\"effectiveDate\":\"2020-09-04\",\"bid\":4.3895,\"ask\":4.4781}]}";
//
//        ExchangeRate data = gson.fromJson(daneZInternetu, ExchangeRate.class);
//
//        System.out.println(data.getRates().get(0).getAsk());
//        System.out.println(data.getRates().get(0).getBid());

        OkHttpClient client = new OkHttpClient();

        Request usdRequest = new Request.Builder()
                .url("http://api.nbp.pl/api/exchangerates/rates/c/EUR/2020-09-04/?format=json")
                .build();

        Response response = client.newCall(usdRequest).execute();

        String jsonString = response.body().string();
        ExchangeRate exchangeRate = gson.fromJson(jsonString, ExchangeRate.class);

        Rate rate = exchangeRate.getRates().get(0);

        System.out.println(response.code());
        System.out.println("response: sprzedaz 100 >>> " + exchangeRate.getCurrency() + " : " + (100 * rate.getBid()));
        System.out.println("response: kupno 100 >>> " + exchangeRate.getCurrency() + " : " + (100 * rate.getAsk()));



    }
}
