package mrallright.httpexample.mvp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liuyong
 * Data: 2017/7/31
 * Github:https://github.com/MrAllRight
 */

public class GameBean implements Parcelable{

        /**
         * id : 5718
         * name : 《刀锋之刃》开测礼包
         * gamename : 刀锋之刃
         * icon : http://i5.72g.com/upload/201606/201606081043002654.jpg
         * remain : 48
         * gifttype : 1
         * consume : 0
         * content : 金币*10W，羽灵之心*500，锁边符*2
         */

        private String id;
        private String name;
        private String gamename;
        private String icon;
        private String remain;
        private String gifttype;
        private String consume;
        private String content;

    protected GameBean(Parcel in) {
        id = in.readString();
        name = in.readString();
        gamename = in.readString();
        icon = in.readString();
        remain = in.readString();
        gifttype = in.readString();
        consume = in.readString();
        content = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(name);
        dest.writeString(gamename);
        dest.writeString(icon);
        dest.writeString(remain);
        dest.writeString(gifttype);
        dest.writeString(consume);
        dest.writeString(content);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GameBean> CREATOR = new Creator<GameBean>() {
        @Override
        public GameBean createFromParcel(Parcel in) {
            return new GameBean(in);
        }

        @Override
        public GameBean[] newArray(int size) {
            return new GameBean[size];
        }
    };

    public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGamename() {
            return gamename;
        }

        public void setGamename(String gamename) {
            this.gamename = gamename;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getRemain() {
            return remain;
        }

        public void setRemain(String remain) {
            this.remain = remain;
        }

        public String getGifttype() {
            return gifttype;
        }

        public void setGifttype(String gifttype) {
            this.gifttype = gifttype;
        }

        public String getConsume() {
            return consume;
        }

        public void setConsume(String consume) {
            this.consume = consume;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

    @Override
    public String toString() {
        return "GameBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gamename='" + gamename + '\'' +
                ", icon='" + icon + '\'' +
                ", remain='" + remain + '\'' +
                ", gifttype='" + gifttype + '\'' +
                ", consume='" + consume + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
