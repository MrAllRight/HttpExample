package mrallright.httpexample.retrofit;

import retrofit2.Retrofit;
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
                .build();
        service = retrofit.create(RetrofitService.class);
    }
}
