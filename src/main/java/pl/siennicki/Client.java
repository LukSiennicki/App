package pl.siennicki;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Client {
    private static Client client;
    private final OkHttpClient okHttpClient = new OkHttpClient();

    private Client(){

    }

    public static Client getINSTANCE() {
        if(client == null){
            synchronized (Client.class){
                if(client == null){
                    client = new Client();
                }
            }
        }
        return client;
    }

    public String executeRequest(Currency currency, DataFormat dataFormat) throws IOException {
        Request newRequest = new RequestBuilder()
                .currency(currency)
                .dataFormat(dataFormat)
                .build();

        Response response = okHttpClient.newCall(newRequest).execute();
        return response.body().string();
    }
}
