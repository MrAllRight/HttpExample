package mrallright.httpexample.rxjava;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by liuyong
 * Data: 2017/7/31
 * Github:https://github.com/MrAllRight
 */

public interface RetrofitService {
    @FormUrlEncoded
    @POST("app/gift/gift_list/")
    Observable<ResponseBody> getGameList(@FieldMap Map<String, String> map);
}
