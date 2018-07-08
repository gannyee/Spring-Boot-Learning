package com.gannyee.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomRealm extends AuthorizingRealm {


    Map<String,String> userMap = new HashMap<String, String>();

    {
        userMap.put("Mark","283538989cef48f3d7d8a1c1bdf2008f");
        super.setName("customRealm");
    }
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();

        Set<String> roles = getRolesByUsername(username);

        Set<String> permission = getPermissionByUsername(username);

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        simpleAuthorizationInfo.setStringPermissions(permission);
        return simpleAuthorizationInfo;

    }

    private Set<String> getPermissionByUsername(String username) {
        Set<String> permissionSets = new HashSet<String>();
        permissionSets.add("user:add");
        permissionSets.add("user:delete");
        return permissionSets;
    }

    private Set<String> getRolesByUsername(String username) {

        Set<String> roleSets = new HashSet<String>();
        roleSets.add("admin");
        roleSets.add("user");
        return roleSets;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //1从主体认证信息中获取主体的用户名
        String username = (String) authenticationToken.getPrincipal();

        //2通过用户名到数据获取凭证
        String password = getPasswordByUsername(username);

        if (null == password){
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo("Mark",password,"customRealm");
        simpleAuthenticationInfo.setCredentialsSalt(ByteSource.Util.bytes("Mark"));
        return simpleAuthenticationInfo;
    }

    /**
     * 模拟数据库
     * @param username
     * @return
     */
    private String getPasswordByUsername(String username) {
        //
        return  userMap.get(username);
    }

    public static void main(String[] args) {
        Md5Hash md5Hash = new Md5Hash("123456","Mark");
        System.out.println(md5Hash.toString());
    }
}
