package software.dzjz.retrieval.service;

import software.dzjz.retrieval.model.SpryModel;

import java.util.List;

public interface SpryService {

    /**
     * 根据案件序号取得所有审判人员
     * @param ajxh
     * @return
     */
    public List<SpryModel> getSprysByAjxh(Integer ajxh);

    /**
     * 根据案件序号获取承办人信息
     * @param ajxh
     * @return
     */
    public SpryModel getCbrByAjxh(Integer ajxh);

    /**
     * 在审判人员中得到承办人
     * @param sprys 审判人员
     * @return
     */
    public SpryModel getCbrInSprys(List<SpryModel> sprys);
}
