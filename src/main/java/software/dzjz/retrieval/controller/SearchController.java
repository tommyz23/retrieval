package software.dzjz.retrieval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.common.CommonUtil;
import software.dzjz.retrieval.common.EmBusinessError;
import software.dzjz.retrieval.controller.vo.BaseInfoVO;
import software.dzjz.retrieval.model.ContextHolder;
import software.dzjz.retrieval.model.DzjzModel;
import software.dzjz.retrieval.model.UserContextModel;
import software.dzjz.retrieval.request.AdvSearchReq;
import software.dzjz.retrieval.request.SearchReq;
import software.dzjz.retrieval.service.DzjzService;
import software.dzjz.retrieval.service.SpryService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private DzjzService dzjzService;

    @Autowired
    private SpryService spryService;

    @RequestMapping("getbaseinfo")
    @ResponseBody
    public CommonRes getBaseInfo() throws IOException {

        UserContextModel userContext = (UserContextModel) ContextHolder
                .getUserContext();
        //统计es上的电子卷宗数量
        long total = dzjzService.countAll();

        BaseInfoVO baseInfoVO = new BaseInfoVO(total);
        return CommonRes.create(baseInfoVO);
    }

    @RequestMapping("search")
    @ResponseBody
    public CommonRes search(@RequestBody @Valid SearchReq searchReq, BindingResult bindingResult) throws BusinessException, IOException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        List<DzjzModel> dzjzModels = dzjzService.searchEs(searchReq.getKeyword());

        //return CommonRes.create(filter(dzjzModels));
        return CommonRes.create(dzjzModels);
    }

    @RequestMapping("advsearch")
    @ResponseBody
    public CommonRes advsearch(@RequestBody AdvSearchReq advSearchReq) {

        List<DzjzModel> dzjzModels = dzjzService.advsearch(advSearchReq);

        //return CommonRes.create(filter(dzjzModels));
        return CommonRes.create(dzjzModels);
    }

    private List<DzjzModel> filter(List<DzjzModel> dzjzModels) {
        UserContextModel userContext = (UserContextModel) ContextHolder
                .getUserContext();

        List<DzjzModel> list = new ArrayList<>();

        //过滤承办人是当前登录用户的电子卷宗
        for(DzjzModel model : dzjzModels) {
            if(userContext.getYhbh() == spryService.getCbrByAjxh(model.getAjxh()).getSprybh()) {
               list.add(model);
            }
        }
        return list;
    }


}
