package com.user.mgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class UserMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserMgmtApplication.class, args);
	}

}
