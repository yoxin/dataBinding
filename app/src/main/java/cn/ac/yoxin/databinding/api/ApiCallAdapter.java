package cn.ac.yoxin.databinding.api;

import java.io.IOException;
import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Response;

/**
 * Created by zhengyoxin on 16-8-25.
 */
public class ApiCallAdapter implements CallAdapter<ApiResponse<?>> {

    private final Type responseType;

    public ApiCallAdapter(Type responseType) {
        this.responseType = responseType;
    }

    @Override
    public Type responseType() {
        return responseType;
    }

    @Override
    public <R> ApiResponse<?> adapt(Call<R> call) {
        return getApiResponse(call);
    }

    private <R> ApiResponse<?> getApiResponse(Call<R> call) {
        Response<ApiResponse<?>> response = null;
        try {
            response = (Response<ApiResponse<?>>) call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (response != null && response.isSuccessful()) {
            return response.body();
        }
        return null;
    }

}
