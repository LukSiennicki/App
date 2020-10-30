package pl.siennicki;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public enum Client {
    INSTANCE;

    private final OkHttpClient okHttpClient = new OkHttpClient();

    public String executeRequest(Currency currency, DataFormat dataFormat) throws IOException {
        Request newRequest = new RequestBuilder()
                .currency(currency)
                .dataFormat(dataFormat)
                .build();

        Response response = okHttpClient.newCall(newRequest).execute();
        return response.body().string();
    }
}
