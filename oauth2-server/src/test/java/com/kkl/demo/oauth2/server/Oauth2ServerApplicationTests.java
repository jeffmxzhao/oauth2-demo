package com.kkl.demo.oauth2.server;

import com.ulisesbocchio.jasyptspringboot.encryptor.DefaultLazyEncryptor;
import lombok.extern.log4j.Log4j2;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("default")
@Log4j2
public class Oauth2ServerApplicationTests {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}

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

	@Test
	public void testBCryptEncoder(){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("123");
		log.debug(encodedPassword);
		log.debug(passwordEncoder.matches("123", encodedPassword));
	}
}
