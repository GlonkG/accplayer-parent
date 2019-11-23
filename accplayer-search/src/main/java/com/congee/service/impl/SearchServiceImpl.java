package com.congee.service.impl;
import com.congee.dao.AccplayerReponsitory;
import com.congee.domain.Accplayer;
import com.congee.service.SearchService;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    RestHighLevelClient restHighLevelClient;
    @Autowired
    AccplayerReponsitory accplayerReponsitory;
    @Override
    public List<Accplayer> search(String print) {
            SearchRequest searchRequest = new SearchRequest("accplayer-es");
            //设置type
            searchRequest.types("doc");
            //构建搜索源对象
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
            SearchSourceBuilder query = searchSourceBuilder.query(QueryBuilders.multiMatchQuery(print,"userNickname").minimumShouldMatch("50").field("userNickname",10));
            //设置搜索源
            SearchRequest source = searchRequest.source(searchSourceBuilder);
            //设置分页
                int page = 1;
                int pagesize = 2;
                int from=(page-1)*pagesize;
                query.from(from);
                query.size(pagesize);
            //执行搜索
            SearchResponse search = null;
            try {
                search = restHighLevelClient.search(searchRequest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            SearchHits hits = search.getHits();
            System.out.println("查到"+hits.getTotalHits()+"数据");
            //查询到的source
            List<Accplayer> list = new ArrayList<>();
            for (SearchHit shit: hits) {
                System.out.println(shit.getId());
                Map<String, Object> sourceAsMap = shit.getSourceAsMap();
                Accplayer accplayer =new Accplayer();
                accplayer.setApid(Integer.valueOf(shit.getId()));
                //accplayer.setUid((String)(sourceAsMap.get("uid")));
                accplayer.setAccVoice(sourceAsMap.get("accVoice")+"");
                accplayer.setGPid(sourceAsMap.get("gPid")+"");
                //accplayer.setGid(String.valueOf(sourceAsMap.get("gid")));
                accplayer.setUserGender(sourceAsMap.get("userGender")+"");
                accplayer.setGPrice((double)sourceAsMap.get("gPrice"));
                accplayer.setGDuanwei(sourceAsMap.get("gDuanwei")+"");
                accplayer.setAccPic(sourceAsMap.get("accPic")+"");
                accplayer.setGName(sourceAsMap.get("gName")+"");
                accplayer.setGDaqu(sourceAsMap.get("gDaqu")+"");
                accplayer.setUserNickname(sourceAsMap.get("userNickname")+"");
                accplayer.setADescription(sourceAsMap.get("aDescription")+"");
                accplayer.setDatumPic(sourceAsMap.get("datumPic")+"");
                System.out.println(accplayer);
                list.add(accplayer);
            }
            return  list;
        }
    @Override
    public List<Accplayer> searchAll() {
        List<Accplayer> all = accplayerReponsitory.findAll();
        for (Accplayer acc: all) {
            Map<String, Object> map = new HashMap<>();
            map.put("apid",acc.getApid());
            map.put("aDescription",acc.getADescription());
            map.put("aNum",acc.getANum());
            map.put("gDaqu",acc.getGDaqu());
            map.put("gDuanwei",acc.getGDuanwei());
            map.put("userGender",acc.getUserGender());
            map.put("gName",acc.getGName());
            map.put("gPrice",acc.getGPrice());
            map.put("accPic",acc.getAccPic());
            map.put("uid",acc.getUid());
            map.put("gPid",acc.getGPid());
            map.put("accVoice",acc.getAccVoice());
            map.put("userNickname",acc.getUserNickname());
            map.put("gid",acc.getGid());
            map.put("datumPic",acc.getDatumPic());
            //map.put("userBecometime",acc.getUserBecometime());
            IndexRequest indexRequest = new IndexRequest("accplayer-es", "doc", acc.getApid()+"");
            IndexRequest source = indexRequest.source(map);
            try {
                IndexResponse index = restHighLevelClient.index(indexRequest);
                DocWriteResponse.Result result = index.getResult();
                System.out.println("响应结果为=====》》》"+result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return all;
    }

}
