package mrallright.httpexample.mvp;

import java.util.List;
import java.util.Map;

/**
 * Created by liuyong
 * Data: 2017/8/3
 * Github:https://github.com/MrAllRight
 */

public class HttpModel implements HttpPresent.Model{
    HttpPresent.View view;

    public HttpModel(HttpPresent.View view) {
        this.view = view;
    }

    @Override
    public void getGameList(Map map) {
        HttpCenter.getInstance().getGameList(new BaseObserver(new BaseObserver.ResponseListener<List<GameBean>>() {
            @Override
            public void onSuccess(List<GameBean> gameBeen) {
               view.showTvResult(gameBeen);
            }

            @Override
            public void onFail(String error) {

            }
        }),map);
    }
//    interface HttpCallBack{
//        void showTvResult(List<GameBean> beanList);
//    }
//    public void getGameList(Map map, final Handler handler, final HttpCallBack callback){
//        //在Activity中调用了网络请求，从职责上这应该是m的部分
//        HttpCenter.getInstance().getGameList(new BaseObserver(new BaseObserver.ResponseListener<List<GameBean>>() {
//            @Override
//            public void onSuccess(List<GameBean> beanList) {
//                //handler 机制
////                Message message=new Message();
////                message.what=0;
////                Bundle bundle=new Bundle();
////                bundle.putParcelableArrayList("bean", (ArrayList<? extends Parcelable>) beanList);
////                message.setData(bundle);
////                handler.sendMessage(message);
////                Log.d("info","bean"+beanList.size());
//
//                //CallBack机制
//                callback.showTvResult(beanList);
//
////                tvResult.setText(beanList.get(0).toString());这个地方不能更新ui了，怎么办
//            }
//
//            @Override
//            public void onFail(String error) {
//
//            }
//        }), map);
//    }
}
