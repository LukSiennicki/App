package pl.siennicki;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class WalutoApp {

    static Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDate.class, new JsonDeserializer() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                @Override
                public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
                    throws JsonParseException{
                    return LocalDate.parse(json.getAsString(), formatter);
                }
            })
            .create();

    public static void main(String[] args) {

        String daneZInternetu = "{\"table\":\"C\",\"currency\":\"euro\",\"code\":\"EUR\",\"rates\":[{\"no\":\"173/C/NBP/2020\"," +
                "\"effectiveDate\":\"2020-09-04\",\"bid\":4.3895,\"ask\":4.4781}]}";

        ExchangeRate data = gson.fromJson(daneZInternetu, ExchangeRate.class);

        System.out.println(data.getRates().get(0).getAsk());
        System.out.println(data.getRates().get(0).getBid());
    }
}
