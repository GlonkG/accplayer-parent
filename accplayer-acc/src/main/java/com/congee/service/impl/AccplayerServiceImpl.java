package com.congee.service.impl;

import com.congee.dao.AccplayerRepository;
import com.congee.domain.Accplayer;
import com.congee.service.AccplayerService;
import com.congee.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
 * @author: 小米粥
 * @description: com.congee.service.impl
 * @date: 2019/11/12
 * @time: 19:04
*/

@Service
public class AccplayerServiceImpl implements AccplayerService {
    @Autowired
    private AccplayerRepository accplayerRepository;
    @Override
    public Accplayer updAccplayer(Accplayer accplayer) {
        Accplayer accplayer1 = accplayerRepository.saveAndFlush(accplayer);
        return accplayer1;
    }

    @Override
    public Result findByZero(Integer aAudit,Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Accplayer> accplayers = accplayerRepository.findByAAudit(aAudit, pageable);
        Result result = new Result();
        if(aAudit==1){
            result.setCode(200);
            result.setMessage("审核通过");
        }else{
            result.setCode(-1);
            result.setMessage("审核不通过，请检查自我信息是否有误");
        }
        result.setList(accplayers.getContent());
        result.setTotal(accplayers.getTotalElements());
        return result;
    }

    @Override
    public Accplayer findByApid(Integer apid) {
        Optional<Accplayer> byId = accplayerRepository.findById(apid);
        if(byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    @Override
    public Result findEcharts(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page-1,size);
        Page<Accplayer> all = accplayerRepository.findAll(pageable);
        Result result = new Result();
        result.setTotal(all.getTotalElements());
        result.setList(all.getContent());
        result.setMessage("后台echarts分页查询成功");
        result.setCode(200);
        return result;
    }

    @Override
    public void delAccplayer(Integer apid) {
        accplayerRepository.deleteById(apid);
    }

    @Override
    public List<Accplayer> findByGName(String gName) {
        List<Accplayer> byGName = accplayerRepository.findByGName(gName);
        return byGName;
    }
     /*
     * 批量删除陪玩
     * @param apid
    */
    @Override
    public boolean deleteAccplayers(String[] apid) {
        int count = 0;
        for (String apid1 : apid) {
            Integer id = Integer.valueOf(apid1);
            accplayerRepository.deleteById(id);
            count ++;
        }
        if(count==apid.length){
            return true;
        }
        return false;
    }

    @Override
    public void addAccplayer(Accplayer accplayer) {
       accplayerRepository.save(accplayer);
    }


    @Override
    public List<Accplayer> findAccplayerBygName(String game) {
        List<Accplayer> accplayerByGames = accplayerRepository.findAccplayerByGName(game);
        if (accplayerByGames!=null){
            return accplayerByGames;
        }
        return null;
    }


    @Override
    public List<Accplayer> findAccplayerBygNameAndUserGender(String game, String usergender) {
        List<Accplayer> accplayerBygNameAndgGender = accplayerRepository.findAccplayerByGNameAndUserGender(game, usergender);
        if (accplayerBygNameAndgGender!=null){
            return accplayerBygNameAndgGender;
        }
        return null;
    }

    @Override
    public List<Accplayer> findAccplayerByUserGender(String usergender) {
        List<Accplayer> accplayerByUserGender = accplayerRepository.findAccplayerByUserGender(usergender);
        if(accplayerByUserGender!=null){
            return accplayerByUserGender.subList(0,4);
        }
        return null;
    }

    @Override
    public List<Accplayer> findAccplayerByGNameContainingAndApid(String gname,Integer apid) {
        List<Accplayer> accplayerByGNameContainingAndApid = accplayerRepository.findAccplayerByGNameContainingAndApid(gname,apid);
        if(accplayerByGNameContainingAndApid!=null){
            return accplayerByGNameContainingAndApid;
        }
        return null;
    }

    @Override
    public List<Accplayer> findAccplayerByuserNicknamer(String userNicknamer) {
        List<Accplayer> accplayerByuserNickname = accplayerRepository.findAccplayerByuserNickname(userNicknamer);
        return accplayerByuserNickname;
    }

    @Override
    public List<Accplayer> findUserBecometime() {
        Sort userBecometime = new Sort(Sort.Direction.DESC, "userBecometime");
        List<Accplayer> all = accplayerRepository.findAll(userBecometime);
        if(all!=null){
            System.out.println(all.subList(0,8));//最新入驻:将通过审核的时间降序返回前八个
            return all.subList(0,8);
        }
        return null;
    }

    @Override
    public List<Accplayer> findUserPrice() {
        Sort userBecometime = new Sort(Sort.Direction.DESC, "gPrice");
        List<Accplayer> all = accplayerRepository.findAll(userBecometime);
        if(all!=null){
            System.out.println(all.subList(0,8));//最新入驻:将通过审核的时间降序返回前八个
            return all.subList(0,8);
        }
        return null;
    }

    @Override
    public List<Accplayer> findByApids(Integer apid) {
        return accplayerRepository.findByApid(apid);
    }

    @Override
    public List<Accplayer> findANum( ) {
        Sort Aunm = new Sort(Sort.Direction.DESC,"aNum");
        List<Accplayer> accplayerByAnum = accplayerRepository.findAll(Aunm);
        if(accplayerByAnum!=null){
            return accplayerByAnum.subList(0,4);
        }
        return null;
    }

    @Override
    public Accplayer findByUid(Integer uid) {
        Accplayer accplayer = accplayerRepository.findByUid(uid);
        if(accplayer!=null){
            return accplayer;
        }
        return null;
    }

    @Override
    public List<Accplayer> findAccplayerByGPrice(Double gprice) {
        List<Accplayer> accplayerByGprice = accplayerRepository.findAccplayerByGPrice(gprice);
        if(accplayerByGprice!=null){
            return accplayerByGprice;
        }
        return null;
    }
}
