package com.minyou.manba.network;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.minyou.manba.util.LogUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;



public class AESGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;
    private JsonBridge jsonBridge;


    AESGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }
    AESGsonResponseBodyConverter(Gson gson, TypeAdapter<T> adapter,JsonBridge jsonBridge) {
        this.gson = gson;
        this.adapter = adapter;
        this.jsonBridge = jsonBridge;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {

        byte[] bytes = value.bytes();

        String encryption_content = new String(bytes, "UTF-8");// 未解密的串

        LogUtil.d("OkHttp", "解密前 : ---" + new Gson().toJson(value));
        LogUtil.d("OkHttp", "解密前 : " + encryption_content);

        //String decrypt_text = Assistant.UnBoxing(encryption_content);// 解密后的串
        String decrypt_text = encryption_content;
        LogUtil.d("OkHttp", "解密后 : " + decrypt_text);
        if(jsonBridge!=null){
            jsonBridge.onJson(decrypt_text);
        }
        //解密字符串
        return adapter.fromJson(decrypt_text);
    }

    public static abstract class JsonBridge{
        public abstract void onJson(String json);
    }


}
