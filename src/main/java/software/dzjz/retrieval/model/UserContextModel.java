package software.dzjz.retrieval.model;

public class UserContextModel {
    /**
     * 用户编号
     */
    private long yhbh;
    /**
     * 法院编号
     */
    private long fybh;
    /**
     * 法院代码
     */
    private String fydm;
    /**
     * 用户代码
     */
    private String yhdm;
    /**
     * 用户名称
     */
    private String yhmc;
    /**
     * 用户部门
     */
    private String yhbm;
    /**
     * 用户身份
     */
    private String yhsf;
//    /**
//     * 用户角色
//     */
//    private List<XtjsModel> yhjs;
    /**
     * 当前系统的用户权限
     */
    private String yhqx;
    /**
     * 用户登陆的IP地址
     */
    private String ip;
    /**
     * 用户密码
     * （供调用其他系统时使用）
     */
    private String password;

    private boolean qyDzjz=false;

    public long getYhbh() {
        return yhbh;
    }
    public void setYhbh(long yhbh) {
        this.yhbh = yhbh;
    }
    public long getFybh() {
        return fybh;
    }
    public void setFybh(long fybh) {
        this.fybh = fybh;
    }
    public String getYhdm() {
        return yhdm;
    }
    public void setYhdm(String yhdm) {
        this.yhdm = yhdm;
    }
    public String getYhmc() {
        return yhmc;
    }
    public void setYhmc(String yhmc) {
        this.yhmc = yhmc;
    }
    public String getYhbm() {
        return yhbm;
    }
    public void setYhbm(String yhbm) {
        this.yhbm = yhbm;
    }
    public String getYhsf() {
        return yhsf;
    }
    public void setYhsf(String yhsf) {
        this.yhsf = yhsf;
    }
//    public List<XtjsModel> getYhjs() {
//        return yhjs;
//    }
//    public void setYhjs(List<XtjsModel> yhjs) {
//        this.yhjs = yhjs;
//    }
    public String getYhqx() {
        return yhqx;
    }
    public void setYhqx(String yhqx) {
        this.yhqx = yhqx;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getFydm() {
        return fydm;
    }
    public void setFydm(String fydm) {
        this.fydm = fydm;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isQyDzjz() {
        return qyDzjz;
    }
    public void setQyDzjz(boolean qyDzjz) {
        this.qyDzjz = qyDzjz;
    }

}

