package com.congee.service.impl;

import com.congee.dao.GameRepository;
import com.congee.domain.Game;
import com.congee.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;
    @Override
    public List<Game> findByGName(String gName) {
        List<Game> byGName = gameRepository.findByGName(gName);
        return byGName;
    }
}
