package cn.ac.yoxin.databinding.api;

import android.text.TextUtils;

import java.io.IOException;
import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by zhengyoxin on 16-8-22.
 */
public class BusModel {
    private static final String KEY = "87c7666e5efa97874a00414c857b6d62";
    private final BusApi busApi;

    private BusModel() {
        Retrofit retrofit = RetrofitProvider.getBuilder().build();
        busApi = retrofit.create(BusApi.class);
    }

    public static BusModel getInstance() {
        return BusModelHolder.mInstance;
    }

    private static class BusModelHolder {
        public static BusModel mInstance = new BusModel();
    }

    public BusInfo getBusInfo(String city) {
        return busApi.getBusInfo(city, KEY).data;
    }

    public List<BusInfo.Bus> getBuses(String city) {
        if (TextUtils.isEmpty(city))
            return null;
        return busApi.getBusInfo(city, KEY).data.Buses;
    }

    public String getBusInfoString(String city) {
        String busInfo = null;
        try {
            busInfo = busApi.getBusInfoString(city, KEY).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return busInfo;
    }
}
