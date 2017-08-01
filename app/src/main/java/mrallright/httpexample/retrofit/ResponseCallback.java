package mrallright.httpexample.retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by liuyong
 * Data: 2017/7/31
 * Github:https://github.com/MrAllRight
 */
public  class ResponseCallback<T> {
    private Call<ResultEntity<T>> mCall;//拿到所有的call请求，集中处理
    //返回结果处理后通过接口传给需要结果显示的地方，一般是activity，在activity中实现这个接口
    public interface ResponseListener<T> {
        void onSuccess(T t);
        void onFail(String error);
    }
    public ResponseCallback(Call call) {
        mCall = call;
    }
    //对结果进行处理，说明一下在这里与okhttp不同的地方时，callback是在主线程直接可以更新ui，而okhttp则是工作线程需要通过handler等把结果传给主线程
    public void handleResponse(final ResponseListener listener) {
        mCall.enqueue(new Callback<ResultEntity<T>>() {
            @Override
            public void onResponse(Call<ResultEntity<T>> call, Response<ResultEntity<T>> response) {
                if (response.isSuccessful() && response.errorBody() == null) {
                    listener.onSuccess((T) response.body().getInfo());
                }
            }

            @Override
            public void onFailure(Call<ResultEntity<T>> call, Throwable t) {
                listener.onFail(t.getMessage().toString());
            }
        });
    }
    }