package beans;

public class User {
    //用户id
    private int id;
    //用户名
    private String email;
    //用户手机号
    private String phone;
    //密码
    private String pwd;
    //用户名
    private String uname;
//    //地址
//    private String address;
//    //用户余额
//    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

//    public String getAddress() {
//        return address;
//    }

//    public void setAddress(String address) {
//        this.address = address;
//    }

//    public double getBalance() {
//        return balance;
//    }

//    public void setBalance(double balance) {
//        this.balance = balance;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", uname='" + uname + '\'' +
                '}';
    }


    public User(int id, String email, String phone, String pwd, String uname) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.pwd = pwd;
        if(uname.equals("")||uname==null)
            this.uname=email;
        else
            this.uname = uname;
    }

    public User(String email, String phone, String pwd, String uname) {
        this.email = email;
        this.phone = phone;
        this.pwd = pwd;
        if(uname.equals("")||uname==null)
            this.uname=email;
        else
            this.uname = uname;
    }

    public User(int id) {
        this.id = id;
        this.email = null;
        this.phone = null;
        this.pwd = null;
        this.uname=null;
    }

    public User(String email, String phone, String pwd) {
        this.email = email;
        this.phone = phone;
        this.pwd = pwd;
        this.uname=email;

    }

    public User() {
        super();
    }
}
