package beans;


public class cart {
    //用户id
    private int uid;
    //商品id
    private int gid;
    //是否收藏
    private boolean isStar;
    //是否加入购物车
    private boolean isCart;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public boolean isStar() {
        return isStar;
    }

    public void setStar(boolean star) {
        isStar = star;
    }

    public boolean isCart() {
        return isCart;
    }

    public void setCart(boolean cart) {
        isCart = cart;
    }

    @Override
    public String toString() {
        return "cart{" +
                "uid=" + uid +
                ", gid=" + gid +
                ", isStar=" + isStar +
                ", isCart=" + isCart +
                '}';
    }
}
