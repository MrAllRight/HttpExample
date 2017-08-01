package mrallright.httpexample.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mrallright.httpexample.R;
import retrofit2.Call;

/**
 * Created by liuyong
 * Data: 2017/7/31
 * Github:https://github.com/MrAllRight
 */

public class RetrofitActivity extends AppCompatActivity {
    private String TAG = "RetrofitActivity";
    private TextView tvResult;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);
        tvResult= (TextView) findViewById(R.id.tv_result);
        //POST请求和上篇一样，创建请求体
        try {
           final Map<String, String> map = new HashMap<String, String>();
            map.put("page", "1");
            map.put("code", "news");
            map.put("pageSize", "20");
            map.put("parentid", "0");
            map.put("type", "1");
            Call<ResultEntity<List<GameBean>>> call= HttpCenter.getInstance().service.getGameList(map);
            new ResponseCallback<List<GameBean>>(call).handleResponse(new ResponseCallback.ResponseListener<List<GameBean>>() {
                @Override
                public void onSuccess(List<GameBean> gameBeens) {
                    if(gameBeens!=null&&gameBeens.size()>0)
                    tvResult.setText(gameBeens.get(0).toString());
                }

                @Override
                public void onFail(String error) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
