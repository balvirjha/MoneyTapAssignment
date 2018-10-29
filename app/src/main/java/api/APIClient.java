package api;

import android.content.Context;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class APIClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context context) {

        int cacheSize = 100 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().cache(cache).addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(APIConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();


        return retrofit;
    }

}
