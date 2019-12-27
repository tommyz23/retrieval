package software.dzjz.retrieval.controller.vo;

public class BaseInfoVO {

    private long totalnum;

    private Integer dealnum;

    public BaseInfoVO() {

    }

    public BaseInfoVO(long totalnum, Integer dealnum) {
        this.totalnum = totalnum;
        this.dealnum = dealnum;
    }

    public long getTotalnum() {
        return totalnum;
    }

    public void setTotalnum(long totalnum) {
        this.totalnum = totalnum;
    }

    public Integer getDealnum() {
        return dealnum;
    }

    public void setDealnum(Integer dealnum) {
        this.dealnum = dealnum;
    }
}
