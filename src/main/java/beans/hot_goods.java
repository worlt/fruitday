package beans;

public class hot_goods {
    //热卖商品id
    private int hid;

    public int getHid() {
        return hid;
    }

    public void setHid(int hid) {
        this.hid = hid;
    }

    @Override
    public String toString() {
        return "hot_goods{" +
                "hid=" + hid +
                '}';
    }
}
