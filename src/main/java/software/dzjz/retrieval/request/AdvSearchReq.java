package software.dzjz.retrieval.request;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class AdvSearchReq {

    private String ah;

    private String ajxz;

    private String ajmc;

    private String wjlx;

    private Date jarq;

    private Date larq;

    public String getAh() {
        return ah;
    }

    public void setAh(String ah) {
        this.ah = ah;
    }

    public String getAjxz() {
        return ajxz;
    }

    public void setAjxz(String ajxz) {
        this.ajxz = ajxz;
    }

    public String getAjmc() {
        return ajmc;
    }

    public void setAjmc(String ajmc) {
        this.ajmc = ajmc;
    }

    public String getWjlx() {
        return wjlx;
    }

    public void setWjlx(String wjlx) {
        this.wjlx = wjlx;
    }

    public Date getJarq() {
        return jarq;
    }

    public void setJarq(Date jarq) {
        this.jarq = jarq;
    }

    public Date getLarq() {
        return larq;
    }

    public void setLarq(Date larq) {
        this.larq = larq;
    }
}
