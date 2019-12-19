import com.uestc.mapper.CustomerMapper;
import com.uestc.domain.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void test(){
        SqlSessionFactory sqlSessionFactory=null;
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        try {
            InputStream inputStream= Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=builder.build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSession sqlSession=sqlSessionFactory.openSession();
        CustomerMapper customerMapper=sqlSession.getMapper(CustomerMapper.class);
        //增加customer
        Customer customer=new Customer();
        customer.setName("王杰");
        customer.setGender("男");
        customer.setAddress("成都市");
        customer.setTelephone("12345");
        customerMapper.insertSelective(customer);

        sqlSession.commit();
        sqlSession.close();
    }
}
