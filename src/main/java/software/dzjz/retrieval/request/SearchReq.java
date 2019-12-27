package software.dzjz.retrieval.request;

import javax.validation.constraints.NotBlank;

public class SearchReq {

    @NotBlank(message = "搜索关键词不能为空")
    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
