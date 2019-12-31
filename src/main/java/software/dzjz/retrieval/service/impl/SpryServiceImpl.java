package software.dzjz.retrieval.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.dzjz.retrieval.mapper.SpryModelMapper;
import software.dzjz.retrieval.model.SpryModel;
import software.dzjz.retrieval.service.SpryService;
import software.dzjz.retrieval.util.StringUtil;

import java.util.List;

@Service
public class SpryServiceImpl implements SpryService {

    @Autowired
    private SpryModelMapper spryModelMapper;

    @Override
    public List<SpryModel> getSprysByAjxh(Integer ajxh) {
        List<SpryModel> spryModels = spryModelMapper.getSprysByAjxh(ajxh);
        return spryModels;
    }

    @Override
    public SpryModel getCbrByAjxh(Integer ajxh) {
        List<SpryModel> spryModels = getSprysByAjxh(ajxh);
        return getCbrInSprys(spryModels);
    }

    @Override
    public SpryModel getCbrInSprys(List<SpryModel> sprys) {
        for(SpryModel model : sprys) {
            if(StringUtil.equals(model.getSfcbr(), "Y")) {
                return model;
            }
        }
        return null;
    }
}
