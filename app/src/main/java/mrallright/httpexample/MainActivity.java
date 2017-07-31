package mrallright.httpexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    private String GET_URL = "https://www.baidu.com/";
    public static final String POST_URL = "http://zhushou.72g.com/app/gift/gift_list/";
    private OkHttpClient client;
    /**
     * MediaType，即是Internet Media Type，互联网媒体类型；是我们在传输数据时定义的媒体类型，现在大部分数据传输都是json(application/json;)
     * 其他格式本篇不会设计，以后也不会设计，关键是我也不会
     */
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client = new OkHttpClient();
        try {
            //GET请求
            run(GET_URL);
            //POST请求
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("page", "1");
            jsonObject.put("code", "news");
            jsonObject.put("pageSize", "20");
            jsonObject.put("parentid", "0");
            jsonObject.put("type", "1");
            post(POST_URL, jsonObject.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * This program downloads a URL and print its contents as a string
     *
     * @param url
     * @return
     * @throws IOException
     */
    void run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "get response=" + response.body().string());
            }
        });
    }

    ;

    /**
     * This program posts data to a service
     *
     * @param url
     * @param json
     * @return
     * @throws IOException
     */
    void post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d(TAG, "post response=" + response.body().string());
            }
        });

    }
}
