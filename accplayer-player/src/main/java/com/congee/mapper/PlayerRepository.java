package com.congee.mapper;

import com.congee.domain.Attention;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Attention,Integer> {

    public List<Attention> findByApidAndUid(Integer apid,Integer pid);
}
