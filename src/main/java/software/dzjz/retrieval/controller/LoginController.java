package software.dzjz.retrieval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.common.CommonUtil;
import software.dzjz.retrieval.common.EmBusinessError;
import software.dzjz.retrieval.model.FYEnum;
import software.dzjz.retrieval.model.UserContextModel;
import software.dzjz.retrieval.request.LoginReq;
import software.dzjz.retrieval.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class LoginController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";

    @Autowired
    private LoginService loginService;

    @Autowired
    private HttpServletRequest httpServletRequest;

    @RequestMapping("/getfyinfo")
    @ResponseBody
    public CommonRes getFyInfo(){

        FYEnum[] values = FYEnum.values();

        return CommonRes.create(values);
    }

    @RequestMapping("/login")
    @ResponseBody
    public CommonRes login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult, HttpServletRequest request) throws BusinessException {
        if(bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }

        UserContextModel userContextModel = loginService.login(loginReq.getYhdm(), loginReq.getYhkl());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION, userContextModel);

        return CommonRes.create(userContextModel);
    }

    @RequestMapping("/logout")
    public CommonRes logout(){
        httpServletRequest.getSession().invalidate();
        return CommonRes.create(null);
        //return "redirect:/login";
    }

    //获取当前用户信息
    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public CommonRes getCurrentUser() {
        UserContextModel userContextModel = (UserContextModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonRes.create(userContextModel);
    }
}
