package mrallright.httpexample.retrofit;

/**
 * Created by liuyong
 * Data: 2017/7/31
 * Github:https://github.com/MrAllRight
 */

public class ResultEntity<T> {
    /**
     *    服务器返回数据一般就是{"code":0, "message":"123", "data:":泛型}
     *   但是我们这边是测试，返回的数据格式如下，所以我们的结果处理只需要对info做处理就行
     *
     {"info": [{
     "id": "5718",
     "name": "\u300a\u5200\u950b\u4e4b\u5203\u300b\u5f00\u6d4b\u793c\u5305",
     "gamename": "\u5200\u950b\u4e4b\u5203",
     "icon": "http:\/\/i5.72g.com\/upload\/201606\/201606081043002654.jpg",
     "remain": "48",
     "gifttype": "1",
     "consume": "0",
     "content": "\u91d1\u5e01*10W\uff0c\u7fbd\u7075\u4e4b\u5fc3*500\uff0c\u9501\u8fb9\u7b26*2"
     },
     {
     "id": "6686",
     "name": "\u822a\u6d77\u738b\u542f\u822a\u6691\u671f\u793c\u5305",
     "gamename": "\u822a\u6d77\u738b\u542f\u822a",
     "icon": "http:\/\/i3.72g.com\/upload\/201606\/201606240949087788.jpg",
     "remain": "3",
     "gifttype": "1",
     "consume": "0",
     "content": "\u4ee5\u4e0b\u793c\u5305\u968f\u673a\u53d1\u653e\u4e00\u4e2a\uff1a\n1\uff1a100\u94bb \uff0c\u6d77\u76d7\u4fbf\u5f53*2 \uff0c\u5927\u94b1\u888b*2 \uff0c\u6676\u77f3\u5927\u793c\u5305*2 \uff0c\u8d85\u7ea7\u7ecf\u9a8c\u836f\u6c34*2\n2\uff1a\u94bb*188 \uff0c\u6d77\u76d7\u4fbf\u5f53*5 \uff0c\u5927\u94b1\u888b*5 \uff0c\u6676\u77f3\u5927\u793c\u5305*5 \uff0c\u8d85\u7ea7\u7ecf\u9a8c\u836f\u6c34*5\n3\uff1a\u8def\u98de\u788e\u7247*10 \uff0c\u94bb*88 \uff0c\u6d77\u76d7\u4fbf\u5f53*1 \uff0c\u5927\u94b1\u888b*1 \uff0c\u6676\u77f3\u5927\u793c\u5305*1\n4\uff1a\u94bb*188 \uff0c\u6d77\u76d7\u4fbf\u5f53*5 \uff0c\u5927\u94b1\u888b*5 \uff0c\u6676\u77f3\u5927\u793c\u5305*5 \uff0c\u8d85\u7ea7\u7ecf\u9a8c\u836f\u6c34*5\n5\uff1a100\u94bb \uff0c\u6d77\u76d7\u4fbf\u5f53*2 \uff0c\u5927\u94b1\u888b*2 \uff0c\u6676\u77f3\u5927\u793c\u5305*2 \uff0c\u8d85\u7ea7\u7ecf\u9a8c\u836f\u6c34*2\n6\uff1a\u94bb*188 \uff0c\u6d77\u76d7\u4fbf\u5f53*5 \uff0c\u5927\u94b1\u888b*5 \uff0c\u6676\u77f3\u5927\u793c\u5305*5 \uff0c\u8d85\u7ea7\u7ecf\u9a8c\u836f\u6c34*5\n7\uff1a\u8def\u98de\u788e\u7247*10 \uff0c\u94bb*88 \uff0c\u6d77\u76d7\u4fbf\u5f53*1 \uff0c\u5927\u94b1\u888b*1 \uff0c\u6676\u77f3\u5927\u793c\u5305*1"
     }]}
     */
//    private int code;
//    private String message;
    private T info;

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }
}
