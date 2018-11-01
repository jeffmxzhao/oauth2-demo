package com.kkl.demo.oauth2.server;

import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import lombok.extern.log4j.Log4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.springframework.core.env.StandardEnvironment;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("dev")
@Log4j
public class Oauth2ServerApplicationTests {

	@Test
	public void contextLoads() {

	}

	private static final String JASYPT_ENCRYPTOR_PASSWORD = "jasypt.encryptor.password";

	/**
	 * jasypt.encryptor.password 对应 配置中心 application-dev.yml 中的密码
	 */
	@Test
	public void testEnvironmentProperties() {
		System.setProperty(JASYPT_ENCRYPTOR_PASSWORD, "123456");
		StringEncryptor stringEncryptor = new DefaultLazyEncryptor(new StandardEnvironment());

		//加密方法
		log.debug(stringEncryptor.encrypt("abcd"));
		//解密方法
		log.debug(stringEncryptor.decrypt("OIjW7TZWol1lLgwaaoLcFA=="));
	}
}
