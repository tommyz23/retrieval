package software.dzjz.retrieval.controller.vo;

public class BaseInfoVO {

    private long totalnum;

    public BaseInfoVO() {

    }

    public BaseInfoVO(long totalnum) {
        this.totalnum = totalnum;
    }

    public long getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(long totalnum) {
        this.totalnum = totalnum;
    }
}
