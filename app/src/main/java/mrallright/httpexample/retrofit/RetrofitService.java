package mrallright.httpexample.retrofit;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
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
    Call<ResultEntity<List<GameBean>>> getGameList(@FieldMap Map<String, String> map);
}
