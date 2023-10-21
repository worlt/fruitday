package beans;

public class hotfruits {
    //热卖商品id
    private int fid;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    @Override
    public String toString() {
        return "hot_goods{" +
                "fid=" + fid +
                '}';
    }
}
