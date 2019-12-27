package software.dzjz.retrieval.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.common.CommonRes;
import software.dzjz.retrieval.common.EmBusinessError;
import software.dzjz.retrieval.mapper.XtglYhbModelMapper;
import software.dzjz.retrieval.model.UserContextModel;
import software.dzjz.retrieval.model.UserModel;
import software.dzjz.retrieval.model.XtglYhbModel;
import software.dzjz.retrieval.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private XtglYhbModelMapper xtglYhbModelMapper;

//    @Override
//    public CommonRes identify(HttpServletRequest request, String yhdm, String yhkl) {
//        List<XtglYhbModel> xtglYhbModels = xtglYhbModelMapper.selectByYhdm(yhdm);
//
//        //如果账号密码对上的话 从这开始
//        if(null == xtglYhbModels || xtglYhbModels.isEmpty()){
//            return CommonRes.create("用户不存在");
//        }
//
//        final XtglYhbModel xtglYhbModel = xtglYhbModels.get(0);
//
//        if(!StringUtils.equals(yhkl,xtglYhbModel.getYhkl())){
//            return CommonRes.create("密码错误");
//        }
//
//        request.getSession().removeAttribute("userContext");
//        String ip = request.getRemoteAddr();
//
//        UserContextModel userContext = new UserContextModel();
//        userContext.setYhbh(xtglYhbModel.getYhbh());
//        //userContext.setFybh(Integer.valueOf(fyEnum.getFybh()));
//        //userContext.setFydm(fyEnum.getFydm());
//        userContext.setYhdm(yhdm);
//        userContext.setYhbm(xtglYhbModel.getYhbm());
//        userContext.setYhmc(xtglYhbModel.getYhmc());
//        userContext.setYhsf(xtglYhbModel.getYhsf());
//        userContext.setPassword(xtglYhbModel.getYhkl());
//        userContext.setIp(ip);
//
//        request.getSession().setAttribute("userContext", userContext);
//
//        return CommonRes.create(null);
//
//    }

    @Override
    public UserContextModel login(String yhdm, String yhkl) throws BusinessException {
        XtglYhbModel xtglYhbModel = xtglYhbModelMapper.selectByYhdmAndYhkl(yhdm, yhkl);
        if(xtglYhbModel == null) {
            throw new BusinessException(EmBusinessError.LOGIN_FAIL);
        }

        UserContextModel userContext = new UserContextModel();
        userContext.setYhbh(xtglYhbModel.getYhbh());
        //userContext.setFybh(Integer.valueOf(fyEnum.getFybh()));
        //userContext.setFydm(fyEnum.getFydm());
        userContext.setYhdm(yhdm);
        userContext.setYhbm(xtglYhbModel.getYhbm());
        userContext.setYhmc(xtglYhbModel.getYhmc());
        userContext.setYhsf(xtglYhbModel.getYhsf());
        userContext.setPassword(xtglYhbModel.getYhkl());

        return userContext;
    }
}
