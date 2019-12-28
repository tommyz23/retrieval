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

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private DzjzService dzjzService;

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

        return CommonRes.create(dzjzModels);
    }

    @RequestMapping("advsearch")
    @ResponseBody
    public CommonRes advsearch(@RequestBody AdvSearchReq advSearchReq) {

        List<DzjzModel> dzjzModels = dzjzService.advsearch(advSearchReq);
        return CommonRes.create(dzjzModels);
    }


}
