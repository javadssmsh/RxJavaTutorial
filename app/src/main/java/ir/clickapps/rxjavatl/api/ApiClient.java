package ir.clickapps.rxjavatl.api;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getApiClient(String URL) {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
