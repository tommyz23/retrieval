package software.dzjz.retrieval.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.model.UserModel;
import software.dzjz.retrieval.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

//    public static final String CURRENT_USER_SESSION = "currentUserSession";
//
//    @Autowired
//    private HttpServletRequest httpServletRequest;
//
//    @Autowired
//    private UserService userService;


    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "test";
    }

//    @GetMapping("/login")
//    public String toLogin(ModelMap model){
//
//        FYEnum[] values = FYEnum.values();
//        model.addAttribute("fyInfos",values);
//        return "/login";
//    }

//    @RequestMapping("/index")
//    public ModelAndView index(){
//        ModelAndView modelAndView = new ModelAndView("/index");
//
//        //modelAndView.addObject("userCount", userService.countAllUser());
//        modelAndView.addObject("CONTROLLER_NAME","admin");
//        modelAndView.addObject("ACTION_NAME","index");
//        return modelAndView;
//    }
//
//    @RequestMapping("list")
//    public ModelAndView list(){
//        ModelAndView modelAndView = new ModelAndView("/list");
//        return modelAndView;
//    }


//    @RequestMapping("/get")
//    @ResponseBody
//    public CommonRes getUser(@RequestParam(name="id")Integer id) throws BusinessException {
//        UserModel userModel = userService.getUser(id);
//        if(userModel == null){
//            //return CommonRes.create(new CommonError(EmBusinessError.NO_OBJECT_FOUND),"fail");
//            throw new BusinessException(EmBusinessError.NO_OBJECT_FOUND);
//        }else{
//            return CommonRes.create(userModel);
//        }
//
//    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(@RequestBody @Valid LoginReq loginReq, BindingResult bindingResult) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
//        if(bindingResult.hasErrors()){
//            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, CommonUtil.processErrorString(bindingResult));
//        }
//        UserContextModel contextModel = userService.login(loginReq.getYhdm(),loginReq.getYhkl());
//        httpServletRequest.getSession().setAttribute(CURRENT_USER_SESSION,contextModel);
//
//        return "redirect:/index";
//    }



//    @RequestMapping("/logout")
//    @ResponseBody
//    public CommonRes logout() throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
//        httpServletRequest.getSession().invalidate();
//        return CommonRes.create(null);
//    }

    //获取当前用户信息
//    @RequestMapping("/getcurrentuser")
//    @ResponseBody
//    public CommonRes getCurrentUser(){
//        UserModel userModel = (UserModel) httpServletRequest.getSession().getAttribute(CURRENT_USER_SESSION);
//        return CommonRes.create(userModel);
//    }
}
