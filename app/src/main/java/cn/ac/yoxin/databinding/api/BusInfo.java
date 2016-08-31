package cn.ac.yoxin.databinding.api;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhengyoxin on 16-8-22.
 */
public class BusInfo {

    public String title;

    @SerializedName("list")
    public List<Bus> Buses;

    public static class Bus {
        String name;
        String tel;
        String adds;

        @Override
        public String toString() {
            return "bus{" +
                    "name=" + name +
                    ", tel='" + tel + '\'' +
                    ", adds='" + adds + '\'' +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getAdds() {
            return adds;
        }

        public void setAdds(String adds) {
            this.adds = adds;
        }
    }

    @Override
    public String toString() {
        return "data{" +
                "title=" + title +
                ", Buses='" + Buses + '\'' +
                '}';
    }
}
