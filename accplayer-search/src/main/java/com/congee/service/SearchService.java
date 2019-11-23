package com.congee.service;

import com.congee.domain.Accplayer;

import java.util.List;

public interface SearchService {
    //搜索
    List<Accplayer> search(String print);
    List<Accplayer> searchAll();
}
