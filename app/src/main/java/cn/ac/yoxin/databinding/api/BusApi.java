package cn.ac.yoxin.databinding.api;



import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by zhengyoxin on 16-8-22.
 */
interface BusApi {
    @GET("http://op.juhe.cn/onebox/bus/query")
    ApiResponse<BusInfo> getBusInfo(
            @Query("station") String station,
            @Query("key") String key
    );

    @GET("http://op.juhe.cn/onebox/bus/query")
    Call<String> getBusInfoString(
            @Query("station") String station,
            @Query("key") String key
    );
}
