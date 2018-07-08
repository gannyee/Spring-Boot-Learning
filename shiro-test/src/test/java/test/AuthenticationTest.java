package test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class AuthenticationTest {

    //ָ��Realm
    private SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();


    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("Mark","123456","admin","user");
    }
    @Test
    public void testAuthentication(){
        //1.����SecurityManager����
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        //2. �����ύ��֤����
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("Mark","123456");

        subject.login(usernamePasswordToken);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

        subject.checkRoles("admin","user");

    }
}
