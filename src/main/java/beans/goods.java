package beans;

public class goods {
    //货物id
    private int gid;
    //货名
    private String ganme;
    //货物价格
    private double price;
    //简介
    private String t1;
    //温馨提示
    private String t2;
    //图片数量
    private int gpnum;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGanme() {
        return ganme;
    }

    public void setGanme(String ganme) {
        this.ganme = ganme;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getT1() {
        return t1;
    }

    public void setT1(String t1) {
        this.t1 = t1;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public int getGpnum() {
        return gpnum;
    }

    public void setGpnum(int gpnum) {
        this.gpnum = gpnum;
    }

    @Override
    public String toString() {
        return "goods{" +
                "gid=" + gid +
                ", ganme='" + ganme + '\'' +
                ", price=" + price +
                ", t1='" + t1 + '\'' +
                ", t2='" + t2 + '\'' +
                ", gpnum=" + gpnum +
                '}';
    }
}
