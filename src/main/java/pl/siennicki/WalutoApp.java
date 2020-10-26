package pl.siennicki;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDate;

public class WalutoApp {

    static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new LocalDateDeserializer())
            .create();

    public static void main(String[] args) {



        String daneZInternetu = "{\"table\":\"C\",\"currency\":\"euro\",\"code\":\"EUR\",\"rates\":[{\"no\":\"173/C/NBP/2020\"," +
                "\"effectiveDate\":\"2020-09-04\",\"bid\":4.3895,\"ask\":4.4781}]}";

        ExchangeRate data = gson.fromJson(daneZInternetu, ExchangeRate.class);

        System.out.println(data.getRates().get(0).getAsk());
        System.out.println(data.getRates().get(0).getBid());
    }
}
