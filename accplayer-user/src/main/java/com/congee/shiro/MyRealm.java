package com.congee.shiro;

import com.congee.UserApplication;
import com.congee.dao.WananRepository;
import com.congee.domain.Wanan;
import com.congee.service.WananService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: 小米粥
 * @description: com.congee.shiro
 * @date: 2019/11/13
 * @time: 15:42
 */
public class MyRealm extends AuthorizingRealm {
    private final static Logger log = LoggerFactory.getLogger(MyRealm.class);
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Autowired
    private WananService wananService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        log.info("登录名为============================="+loginName);
        Wanan wanan = wananService.findByName(loginName);
        log.info("根据登录名查询为====================="+wanan.toString());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(loginName,wanan.getPass(),getName());
        return simpleAuthenticationInfo;
    }
}
