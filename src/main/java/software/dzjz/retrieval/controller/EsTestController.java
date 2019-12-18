package software.dzjz.retrieval.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.common.EmBusinessError;
import software.dzjz.retrieval.model.DzjzModel;
import software.dzjz.retrieval.service.DzjzService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class EsTestController {

    @Autowired
    private DzjzService dzjzService;

    @RequestMapping("search")
    public String search(ModelMap model, String keyword) throws BusinessException, IOException {
        if(StringUtils.isEmpty(keyword)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        List<DzjzModel> dzjzModels = dzjzService.searchEs(keyword);
        model.addAttribute("list", dzjzModels);
        return "list";
    }

    @RequestMapping("count")
    public String countAll(ModelMap model) throws IOException {

        //统计es上的电子卷宗数量
        long num = dzjzService.countAll();
        model.addAttribute("num", num);

        //统计审判人员处理过的电子卷宗数量

        return "index";
    }

//    @RequestMapping("/jznr")
//    public String jznr(HttpServletRequest request, HttpServletResponse response,
//                       ModelMap model) {
//
//        String ah = request.getParameter("");
//        String
//
//    }


}
