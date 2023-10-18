package beans;

public class User {
    //用户id
    private int id;
    //用户名
    private String uname;
    //用户手机号
    private String phone;
    //密码
    private String password;
    //地址
    private String address;
    //用户余额
    private double balance;

    public User(String uname, String phone, String password) {
        this.uname = uname;
        this.phone = phone;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return uname;
    }

    public void setName(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public User(int id, String uname, String phone, String password, String address, double balance) {
        this.id = id;
        this.uname = uname;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.balance = balance;
    }

    public User() {
    }
}
