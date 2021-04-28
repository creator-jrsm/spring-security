package test;

import com.eshore.MainSecurity;
import com.eshore.mapper.UserMapper;
import com.eshore.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainSecurity.class)
public class SqlTest {

   @Resource
   private UserMapper userMapper;

    @Test
    public void select(){
        User user=userMapper.getUserByName("b");
        User user1=userMapper.selectById(1);
        System.err.println(user);
    }
}
