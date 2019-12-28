package software.dzjz.retrieval.service;

import software.dzjz.retrieval.model.DzjzModel;
import software.dzjz.retrieval.request.AdvSearchReq;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DzjzService {

    DzjzModel get(String id);

    List<DzjzModel> searchEs(String keyword) throws IOException;

    List<DzjzModel> advsearch(AdvSearchReq advSearchReq);

    long countAll() throws IOException;

    DzjzModel searchEsById(String id);

    List<DzjzModel> searchByAh(String ah);
}
