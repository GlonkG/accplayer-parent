package com.congee.dao;

import com.congee.domain.Accplayer;
import com.congee.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

/**
 * @author: 小米粥
 * @description: com.congee.dao
 * @date: 2019/11/12
 * @time: 18:58
 */
public interface AccplayerRepository extends JpaRepository<Accplayer,Integer> {
    //根据陪玩资质分页查询
    public Page<Accplayer> findByAAudit(Integer aAudit,Pageable pageable);
    //根据板块名称查询陪玩--by yhf
    public List<Accplayer> findByGName(String gName);

    //by sml
    //根据游戏类型名称和陪玩性别查询陪玩--闪电邀约
    public List<Accplayer>  findAccplayerByGNameAndUserGender(String game, String userGender);

    //根据陪玩性别查询陪玩--找陪玩
    public List<Accplayer> findAccplayerByUserGender(String usergender);

    //根据类型对陪玩的查询--找陪玩--by sml
    public List<Accplayer> findAccplayerByGName(String game);

    //根据昵称和id查询陪玩--首页搜索引擎 findAccplayerByGNameAndApidContaining
    public List<Accplayer> findAccplayerByGNameContainingAndApid(String gname,Integer apid);

    //根据陪玩昵称查找陪玩--?
    public List<Accplayer> findAccplayerByuserNickname(String userNickname);

    //测试详情
    public List<Accplayer> findByApid(Integer apid);

    //测试根据用户ID查询
    public Accplayer findByUid(Integer uid);

    //八元专区
    List<Accplayer> findAccplayerByGPrice(Double gprice);


}
