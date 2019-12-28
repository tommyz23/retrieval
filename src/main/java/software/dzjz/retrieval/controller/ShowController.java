package software.dzjz.retrieval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.model.DzjzModel;
import software.dzjz.retrieval.model.DzjzwjModel;
import software.dzjz.retrieval.service.DzjzService;

@Controller
public class ShowController {

    @Autowired
    private DzjzService dzjzService;

    @RequestMapping("/show")
    @ResponseBody
    public CommonRes show(String ah) {

        //根据案号获取相应的电子卷宗信息
        //DzjzwjModel dzjzwjModel = dzjzService.searchByAh(ah);
        //返回给前端
        return CommonRes.create(null);
    }
}
