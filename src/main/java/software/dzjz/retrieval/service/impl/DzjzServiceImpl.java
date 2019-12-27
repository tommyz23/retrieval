package software.dzjz.retrieval.service.impl;

import com.alibaba.fastjson.JSON;

import org.apache.lucene.search.TotalHits;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;

import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.dzjz.retrieval.mapper.DzjzwjModelMapper;
import software.dzjz.retrieval.model.DzjzModel;
import software.dzjz.retrieval.model.DzjzwjModel;
import software.dzjz.retrieval.service.DzjzService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class DzjzServiceImpl implements DzjzService {

    @Autowired
    private RestHighLevelClient highLevelClient;

    @Autowired
    private DzjzwjModelMapper dzjzwjModelMapper;


    @Override
    public DzjzModel get(String id) {
        return null;
    }

    @Override
    public List<DzjzModel> searchEs(String keyword) throws IOException {
        Map<String, Object> result = new HashMap<>();

//        SearchRequest searchRequest = new SearchRequest("shop");
//        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
//        sourceBuilder.query(QueryBuilders.matchQuery("name",keyword));
//        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
//        searchRequest.source(sourceBuilder);
//
//        List<Integer> shopIdsList = new ArrayList<>();
//        SearchResponse searchResponse = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHit[] hits =  searchResponse.getHits().getHits();
//        for(SearchHit hit : hits){
//            shopIdsList.add(new Integer(hit.getSourceAsMap().get("id").toString()));
//        }

        SearchRequest searchRequest = new SearchRequest("dzjzxx_index");

        List<DzjzModel> list = new ArrayList<>();

        try {

            //搜索体
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            QueryStringQueryBuilder queryBuilder = new QueryStringQueryBuilder(keyword);
            queryBuilder.field("ajmc").field("ocrText");

            //构建高亮体
            HighlightBuilder highlightBuilder = new HighlightBuilder();
            highlightBuilder.preTags("<span style=\"color:red\">");
            highlightBuilder.postTags("</span>");
            //高亮字段
            highlightBuilder.field("ajmc").field("ocrText");

            //搜索体
            searchSourceBuilder.highlighter(highlightBuilder);
            searchSourceBuilder.query(queryBuilder);
            searchRequest.source(searchSourceBuilder);
            //searchSourceBuilder.from(page.getPageNum()).size(page.getPageSize());

            //执行查询
            SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            SearchHit[] hits =  response.getHits().getHits();


            for(SearchHit searchHit: hits) {
                String sourceAsString = searchHit.getSourceAsString();
                DzjzModel dzjzModel = JSON.parseObject(sourceAsString, DzjzModel.class);
                Map<String, HighlightField> highlightFields = searchHit.getHighlightFields();
                HighlightField highlightAjmc = highlightFields.get("ajmc");
                if(highlightAjmc != null) {
                    Text[] titleTexts = highlightAjmc.fragments();
                    String ajmc = "";
                    for(Text text : titleTexts) {
                        ajmc += text;
                    }
                    dzjzModel.setAjmc(ajmc);
                }
                HighlightField highlightOcrText = highlightFields.get("ocrText");
                if(highlightOcrText != null) {
                    Text[] titleTexts = highlightOcrText.fragments();
                    String ocrText = "";
                    for(Text text : titleTexts) {
                        ocrText += text;
                    }
                    dzjzModel.setOcrText(ocrText);
                }
                list.add(dzjzModel);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public long countAll() throws IOException {
        SearchRequest searchRequest = new SearchRequest("dzjzxx_index");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query();
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));
        searchRequest.source(sourceBuilder);

        SearchResponse response = highLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        TotalHits totalHits = response.getHits().getTotalHits();

        return totalHits.value;
    }

    @Override
    public Integer countBySpry(String spry) {

        //根据当前登录用户的审判人员编号获取案件序号集合

        //根据案件序号集合查询电子卷宗数量
        List<DzjzwjModel> dzjzwjModels = dzjzwjModelMapper.selectByCjr(spry);
        return dzjzwjModels.size();
    }

    @Override
    public DzjzModel searchEsById(String id) {
        DzjzModel dzjzModel = new DzjzModel();
        return dzjzModel;
    }
}
