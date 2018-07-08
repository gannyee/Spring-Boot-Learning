package test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

public class JdbcRealmTest {

    DruidDataSource dataSource = new DruidDataSource();

    @Before
    public void setup(){
        dataSource.setUrl("jdbc:mysql://192.168.11.106:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("root123");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

    }

    @Test
    public void testAuthentication(){

        JdbcRealm jdbcRealm = new JdbcRealm();

        jdbcRealm.setDataSource(dataSource);
        jdbcRealm.setPermissionsLookupEnabled(true);

         String sql = "select password from test_user where user_name = ?";
        jdbcRealm.setAuthenticationQuery(sql);

        //1.构建SecurityManager环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        //2. 主体提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);

        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("Mark","123456");

        subject.login(usernamePasswordToken);

        System.out.println("isAuthenticated: " + subject.isAuthenticated());

//        subject.checkRole("admin");
//        subject.checkPermission("user:select");

    }
}
