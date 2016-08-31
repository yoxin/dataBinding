package cn.ac.yoxin.databinding.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zhengyoxin on 16-8-22.
 */
public class RetrofitProvider {
    private static OkHttpClient client;
    public static Retrofit.Builder getBuilder() {
        return createRetrofit();
    }

    private static Retrofit.Builder createRetrofit() {
        client = new OkHttpClient();
        return new Retrofit.Builder()
                .baseUrl("http://op.juhe.cn/")
                .client(client)
                .addCallAdapterFactory(new ApiCallAdapterFatory())
                .addConverterFactory(new StringConverters())
                .addConverterFactory(GsonConverterFactory.create(gson));
    }

    private static Gson gson = createGson();

    private static Gson createGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new ApiTypeAdapterFactory(ApiResponse.class))
                .create();
    }
}
