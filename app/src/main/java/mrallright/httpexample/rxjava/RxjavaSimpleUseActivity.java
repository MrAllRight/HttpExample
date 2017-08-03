package mrallright.httpexample.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mrallright.httpexample.R;
import mrallright.httpexample.retrofit.GameBean;


/**
 * Created by liuyong
 * Data: 2017/8/2
 * Github:https://github.com/MrAllRight
 */

public class RxjavaSimpleUseActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);//布局和retrofit一样，使用textview显示结果
        tvResult = (TextView) findViewById(R.id.tv_result);
        //POST请求和上篇一样，创建请求体
        final Map<String, String> map = new HashMap<String, String>();
        map.put("page", "1");
        map.put("code", "news");
        map.put("pageSize", "20");
        map.put("parentid", "0");
        map.put("type", "1");
        HttpCenter.getInstance().getGameList(new BaseObserver(new BaseObserver.ResponseListener<List<GameBean>>() {
            @Override
            public void onSuccess(List<GameBean> beanList) {
               tvResult.setText(beanList.get(0).toString());
            }

            @Override
            public void onFail(String error) {

            }
        }), map);
    }
}
