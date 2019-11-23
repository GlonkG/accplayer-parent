package com.congee.controller;

import com.congee.domain.Accplayer;
import com.congee.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SearchesController {
    @Autowired
    SearchService searchService;
    //搜索
    @RequestMapping("/multiQuery")

    public List<Accplayer> search(@RequestParam("print")String print){
        try {
            return searchService.search(print);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/search")
    public  List<Accplayer> search(){
        List<Accplayer> accplayers = searchService.searchAll();
        if(accplayers!=null){
            return accplayers;
        }
        return  null;
    }
}
