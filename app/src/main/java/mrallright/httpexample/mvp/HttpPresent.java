package mrallright.httpexample.mvp;

import java.util.List;
import java.util.Map;

/**
 * Created by liuyong
 * Data: 2017/8/3
 * Github:https://github.com/MrAllRight
 */

public class HttpPresent {
    interface View {
        void showTvResult(List<GameBean> beanList);
    }
    interface Model {
        void getGameList(Map map);
    }
}
