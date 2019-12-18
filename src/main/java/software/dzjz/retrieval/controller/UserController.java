package software.dzjz.retrieval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.common.CommonUtil;
import software.dzjz.retrieval.common.EmBusinessError;
import software.dzjz.retrieval.model.UserModel;
import software.dzjz.retrieval.request.LoginReq;
import software.dzjz.retrieval.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {

    public static final String CURRENT_USER_SESSION = "currentUserSession";

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private UserService userService;


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

//    @GetMapping("/login")
//    public String toLogin(ModelMap model){
//
////        FYEnum[] values = FYEnum.values();
////        model.addAttribute("fyInfos",values);
//        return "/login";
//    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView("/index");

        modelAndView.addObject("userCount", userService.countAllUser());
        modelAndView.addObject("CONTROLLER_NAME","admin");
        modelAndView.addObject("ACTION_NAME","index");
        return modelAndView;
    }

    @RequestMapping("list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView("/list");
        return modelAndView;
    }

//    @RequestMapping("/loginpage")
//    public ModelAndView loginpage(){
//        ModelAndView modelAndView = new ModelAndView("/login.html");
//        return modelAndView;
//    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRes getUser(@RequestParam(name="id")Integer id) throws BusinessException {
        UserModel userModel = userService.getUser(id);
        if(userModel == null){
            //return CommonRes.create(new CommonError(EmBusinessError.NO_OBJECT_FOUND),"fail");
            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
        }else{
            return CommonRes.create(userModel);
        }

    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        if(bindingResult.hasErrors()){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
        }
        UserModel userModel = userService.login(loginReq.getTelphone(),loginReq.getPassword());
        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION,userModel);

        return "redirect:/index";
    }



    @RequestMapping("/logout")
    @ResponseBody
    public CommonRes logout() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        httpServletRequest.getSession().invalidate();
        return CommonRes.create(null);
    }

    //获取当前用户信息
    @RequestMapping("/getcurrentuser")
    @ResponseBody
    public CommonRes getCurrentUser(){
        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
        return CommonRes.create(userModel);
    }
}
