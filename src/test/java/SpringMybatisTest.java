import com.uestc.domain.Customer;
import com.uestc.mapper.CustomerMapper;
import com.uestc.service.CustomerService;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMybatisTest {
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
        CustomerService customerService=applicationContext.getBean(CustomerService.class);
        //增加customer
        Customer customer=new Customer();
        customer.setName("王俊杰888");
        customer.setGender("男");
        customer.setAddress("成都市");
        customer.setTelephone("12345");
        customerService.insert(customer);
    }
}
