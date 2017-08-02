package mrallright.httpexample.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import mrallright.httpexample.R;
import okhttp3.ResponseBody;


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
        HttpCenter.getInstance().service.getGameList(map)
                .subscribeOn(Schedulers.io())//指定网络请求在io线程
                .observeOn(AndroidSchedulers.mainThread())//指定返回结果处理在主线程，这样我们就可以在onnext中更新ui了
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            tvResult.setText(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
