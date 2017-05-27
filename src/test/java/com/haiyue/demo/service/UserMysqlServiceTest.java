package com.haiyue.demo.service;

import com.haiyue.demo.models.User;
import com.haiyue.demo.service.impl.UserMysqlServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author liuhaiming on 2017/5/27.
 */
// 在JUnit中有很多个Runner，他们负责调用你的测试代码，每一个Runner都有各自的特殊功能，你要根据需要选择不同的Runner来运行你的测试代码。
// 如果我们只是简单的做普通Java测试，不涉及spring Web项目，你可以省略@RunWith注解，这样系统会自动使用默认Runner来运行你的代码。
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMysqlServiceTest {
	private static Logger log = LogManager.getLogger(UserMysqlServiceTest.class.getName());

	@Autowired
	private UserMysqlServiceImpl mysqlService;

	// 在所有测试方法前执行一次，一般在其中写上整体初始化的代码
	@BeforeClass
	public static void beforeClass() {
		System.out.println("1==============================================");
	}

	// 在每个测试方法前执行，一般用来初始化方法
	@Before
	public void before() {
		log.info(2 + "==============================================");
	}

	// 测试方法
	@Test
	// 测试方法执行超过1000毫秒后算超时，测试将失败
	// @Test(timeout = 1000)
	// 测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败
	// @Test(expected = Exception.class)
	// 执行测试时将忽略掉此方法，如果用于修饰类，则忽略整个类
	// @Ignore(“not ready yet”)
	public void getUserByIdTest() throws Exception {
		log.info("");
		log.info(3 + "==============================================");
		String id = "960cf64bdc9a48c8b128b2186bc25416";
		User user = mysqlService.getUserById(id);
		Assert.assertNotNull(user);
	}

	// TODO 

	// 在每个测试方法后执行，在方法执行完成后要做的事情
	@After
	public void after() {
		log.info(4 + "==============================================");
	}

	// 在所有测试方法后执行一次，一般在其中写上销毁和释放资源的代码
	@AfterClass
	public static void afterClass() {
		log.info(5 + "==============================================");
	}

}
