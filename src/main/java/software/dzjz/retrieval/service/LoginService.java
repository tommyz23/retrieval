package software.dzjz.retrieval.service;

import software.dzjz.retrieval.common.BusinessException;
import software.dzjz.retrieval.model.UserContextModel;


public interface LoginService {

    UserContextModel login(String yhdm, String yhkl) throws BusinessException;
}
