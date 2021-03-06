package com.congee.shiro;
import com.congee.domain.User;
import com.congee.domain.Wanan;
import com.congee.service.UserService;
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
 * @date: 2019/11/14
 * @time: 9:05
 */
public class MyRealm extends AuthorizingRealm {
    private final static Logger log = LoggerFactory.getLogger(MyRealm.class);
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Autowired
    private UserService userService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String loginName = (String) authenticationToken.getPrincipal();
        log.info("登录名为============================="+loginName);
        User user = userService.findByUserTel(loginName);
        log.info("根据登录名查询为====================="+user.toString());
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(loginName,user.getUserPwd(),getName());
        return simpleAuthenticationInfo;
    }
}

