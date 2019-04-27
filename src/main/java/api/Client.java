package api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;

public class Client {
    private static String ACCECC_TOKEN = null;
    //public static String PROJECT_NAME = null;
    private static final String BASE_URL = "https://api.taiga.io/api/v1";

    public static JsonObject getAccessToken(String email, String password) throws IOException {
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"username\":\"" + email + "\",\"password\":\"" + password + "\",\"type\":\"normal\"}");
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/auth")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        JsonObject object = new JsonParser().parse(jsonString).getAsJsonObject();
        ACCECC_TOKEN = object.get("auth_token").getAsString();
        return object;

    }


    public static Response post(String url, JsonObject jsonObject){
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType,jsonObject.toString());
        Request request = new Request.Builder()
                .url(BASE_URL + url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + ACCECC_TOKEN)
                .build();
         Response response = null;
        try {
           response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()){
            new Error("http error code:" + String.valueOf(response.code()));
        }
        return response;
    }




    public static JsonObject createIssue(JsonObject issueJson) throws IOException{
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, issueJson.toString());
        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1/issues")
                .post(body)
                .addHeader("Authorization", "Bearer " + ACCECC_TOKEN)
                .addHeader("Content-Type", "application/json")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "220850ac-7817-4550-9c45-2da104ef0b41")
                .build();

        Response response = client.newCall(request).execute();
        String jsonString = response.body().string();
        return new JsonParser().parse(jsonString).getAsJsonObject();
    }

    public static Response delete(String url, JsonObject jsonObject){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(BASE_URL + url + "/" + jsonObject.get("id").getAsString())
                .delete(null)
                .addHeader("Authorization", "Bearer " + ACCECC_TOKEN)
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "a373ad95-0463-4f6c-b637-beef1ce23a6f")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()){
            new Error("http error code:" + String.valueOf(response.code()));
        }
        return response;
    }

    public static Response get(String url){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.taiga.io/api/v1" + url )
                .get()
                .addHeader("Authorization", "Bearer " + ACCECC_TOKEN)
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "878d6377-b31e-400c-a9cb-54a3e9be30ff")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (!response.isSuccessful()){
            new Error("http error code:" + String.valueOf(response.code()));
        }
        return response;
    }
}