package software.dzjz.retrieval.request;

import javax.validation.constraints.NotBlank;

public class LoginReq {

    @NotBlank(message = "用户名不能为空")
    private String yhdm;
    @NotBlank(message = "密码不能为空")
    private String yhkl;

    public String getYhdm() {
        return yhdm;
    }

    public void setYhdm(String yhdm) {
        this.yhdm = yhdm;
    }

    public String getYhkl() {
        return yhkl;
    }

    public void setYhkl(String yhkl) {
        this.yhkl = yhkl;
    }
}
