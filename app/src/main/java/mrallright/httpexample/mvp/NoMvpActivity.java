package mrallright.httpexample.mvp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import mrallright.httpexample.R;

/**
 * Created by liuyong
 * Data: 2017/8/3
 * Github:https://github.com/MrAllRight
 */
public class NoMvpActivity extends AppCompatActivity {
    private TextView tvResult;
    private HttpModel httpModel;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    tvResult.setText(((GameBean) msg.getData().getParcelableArrayList("bean").get(0)).toString());
                    break;
            }
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit);//布局和retrofit一样，使用textview显示结果
        tvResult = (TextView) findViewById(R.id.tv_result);
//        httpModel = new HttpModel();
//        //POST请求和上篇一样，创建请求体
//        final Map<String, String> map = new HashMap<String, String>();
//        map.put("page", "1");
//        map.put("code", "news");
//        map.put("pageSize", "20");
//        map.put("parentid", "0");
//        map.put("type", "1");
//        httpModel.getGameList(map, handler, new HttpModel.HttpCallBack() {
//            @Override
//            public void showTvResult(List<GameBean> beanList) {
//                tvResult.setText(beanList.get(0).toString());
//
//            }
//        });
    }
}
