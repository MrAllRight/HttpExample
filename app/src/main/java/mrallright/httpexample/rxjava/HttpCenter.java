package mrallright.httpexample.rxjava;


import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import mrallright.httpexample.retrofit.ResultEntity;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by liuyong
 * Data: 2017/7/31
 * Github:https://github.com/MrAllRight
 */

public class HttpCenter {
    public RetrofitService service;
    public static final String BASE_URL = "http://zhushou.72g.com/";//BASE_URL请以/结尾

    private static class HttpCenterHolder {
        private static final HttpCenter INSTANCE = new HttpCenter();
    }

    public static final HttpCenter getInstance() {
        return HttpCenterHolder.INSTANCE;
    }

    private HttpCenter() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava2适配器
                .build();
        service = retrofit.create(RetrofitService.class);
    }

    public void getGameList(Observer observer, Map map) {
        post(observer, service.getGameList(map));
    }

    private <T1, T2> void post(Observer<T1> observer, Observable<ResultEntity<T2>> observable) {
        observable.map(new Function<ResultEntity<T2>, T1>() {
            @Override
            public T1 apply(@NonNull ResultEntity<T2> t2ResultEntity) throws Exception {
                return (T1) t2ResultEntity.getInfo();
            }
                    })
                .subscribeOn(Schedulers.io())//指定网络请求在io线程
                .observeOn(AndroidSchedulers.mainThread())//指定返回结果处理在主线程，这样我们就可以在onnext中更新ui了
                .subscribe(observer);
    }
}
