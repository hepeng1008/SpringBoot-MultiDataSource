import DB.DBApplication;
import DB.UserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes= DBApplication.class)
public class DBApplicationTests {

	@Autowired
	private UserService userService;

	@Before
	public void setUp(){
		userService.DeleteAllUsers();
	}

	@Test
	public void test() throws Exception{
		userService.create("a",1);
		userService.create("b",1);
		userService.create("c",1);
		userService.create("d",1);
		userService.create("e",1);
		Assert.assertEquals(5,userService.getUserCount());

		userService.deleteByName("a");
		userService.deleteByName("b");
		Assert.assertEquals(3,userService.getUserCount());

		System.out.println(userService.getAllUsers());
	}
}
