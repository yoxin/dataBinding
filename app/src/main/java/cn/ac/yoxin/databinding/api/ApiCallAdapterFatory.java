package cn.ac.yoxin.databinding.api;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;

/**
 * Created by zhengyoxin on 16-8-25.
 */
public class ApiCallAdapterFatory extends CallAdapter.Factory{
    @Override
    public CallAdapter<?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        // 获取原始类型
        Class<?> rawType = getRawType(returnType);
        // 返回值必须是ApiResponse并且带有泛型
        if (rawType == ApiResponse.class && returnType instanceof ParameterizedType) {
            return new ApiCallAdapter(returnType);
        }
        return null;
    }
}
