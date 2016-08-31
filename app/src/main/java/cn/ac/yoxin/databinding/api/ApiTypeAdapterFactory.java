package cn.ac.yoxin.databinding.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by zhengyoxin on 16-8-26.
 */
public class ApiTypeAdapterFactory<C> implements TypeAdapterFactory {

    Class<C> cls;
    final ApiTypeAdapterFactory context;

    public ApiTypeAdapterFactory(Class<C> cls) {
        this.cls = cls;
        context = this;
    }

    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        return type.getRawType() == ApiResponse.class
                ? (TypeAdapter<T>) createAdapter(gson, type)
                : null;
    }

    private <T> ApiTypeAdapter createAdapter(Gson gson, TypeToken<T> type) {
        return new ApiTypeAdapter(gson, type);
    }

    private class ApiTypeAdapter extends TypeAdapter<C>{
        private static final String KEY_RESULT = "result";
        private static final String KEY_REASON = "reason";
        private static final String KEY_CODE = "error_code";

        final Gson gson;
        final TypeToken type;
        TypeAdapter delegate;
        TypeAdapter<JsonElement> elementAdapter;

        public <C> ApiTypeAdapter(Gson gson, TypeToken<C> type) {
            this.gson = gson;
            this.type = type;
            delegate = gson.getDelegateAdapter(context, type);
            elementAdapter = gson.getAdapter(JsonElement.class);
        }

        @Override
        public void write(JsonWriter out, C value) throws IOException {
            elementAdapter.write(out, delegate.toJsonTree(value));
        }

        @Override
        public C read(JsonReader in) throws IOException {
            JsonElement jsonElement = elementAdapter.read(in);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            JsonPrimitive code = jsonObject.getAsJsonPrimitive(KEY_CODE);
            JsonElement reason = jsonObject.get(KEY_REASON);
            String msg = reason.getAsString();
            int errorCode = code.getAsInt();
            System.out.println("errorCode=" + errorCode + ";msg="+msg);
            if (errorCode == 0) {
                return (C) delegate.fromJsonTree(jsonElement);
            } else {
                return null;
            }
        }
    }

}

