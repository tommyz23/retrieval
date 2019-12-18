package software.dzjz.retrieval.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.common.EmBusinessError;
import software.dzjz.retrieval.dal.UserModelMapper;
import software.dzjz.retrieval.model.UserModel;
import software.dzjz.retrieval.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserModelMapper userModelMapper;

    @Override
    public UserModel getUser(Integer id) {
        return userModelMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserModel login(String telphone, String password) throws BusinessException {
        UserModel userModel = userModelMapper.selectByTelphoneAndPassword(telphone,password);
        if(userModel == null){
            throw new BusinessException(EmBusinessError.LOGIN_FAIL);
        }
        return userModel;
    }

    @Override
    public Integer countAllUser() {
        return userModelMapper.countAllUser();
    }
}
