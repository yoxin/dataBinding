package cn.ac.yoxin.databinding.api;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zhengyoxin on 16-8-25.
 */
public class ApiResponse<T> {

    @SerializedName("error_code")
    public int error_code;

    @SerializedName("reason")
    public String reason;

    @SerializedName("result")
    public T data;

    public ApiResponse(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "error_code=" + error_code +
                ", reason='" + reason + '\'' +
                ", data=" + data +
                '}';
    }
}
