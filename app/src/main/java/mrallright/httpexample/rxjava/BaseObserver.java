package mrallright.httpexample.rxjava;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/**
 * Created by liuyong
 * Data: 2017/8/3
 * Github:https://github.com/MrAllRight
 */

public class BaseObserver<T> implements Observer<T> {
    ResponseListener listener;

    public BaseObserver(ResponseListener listener) {
        this.listener = listener;
    }

    public interface ResponseListener<T> {
        void onSuccess(T t);
        void onFail(String error);
    }
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull T t) {
        listener.onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        listener.onFail(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
