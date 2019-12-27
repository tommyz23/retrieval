package software.dzjz.retrieval.service;

import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.model.UserModel;

public interface UserService {

    UserModel getUser(Integer id);

    UserModel login(String telphone,String password) throws BusinessException, BusinessException;

    Integer countAllUser();
}
