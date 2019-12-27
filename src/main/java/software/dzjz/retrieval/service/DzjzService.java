package software.dzjz.retrieval.service;

import software.dzjz.retrieval.model.DzjzModel;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface DzjzService {

    DzjzModel get(String id);

    List<DzjzModel> searchEs(String keyword) throws IOException;

    long countAll() throws IOException;

    Integer countBySpry(String spry);

    DzjzModel searchEsById(String id);
}
