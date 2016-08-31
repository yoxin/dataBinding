package cn.ac.yoxin.databinding;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhengyoxin on 16-8-31.
 */
public class ApiRespones {

    private int result;
    private String message;

    @SerializedName("data")
    private List<AD> AdList;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AD> getAdList() {
        return AdList;
    }

    public void setAdList(List<AD> AdList) {
        this.AdList = AdList;
    }

    public static class AD {
        private int itemId;
        private String itemDesc;
        private String logoPath;

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public String getItemDesc() {
            return itemDesc;
        }

        public void setItemDesc(String itemDesc) {
            this.itemDesc = itemDesc;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }
    }
}
