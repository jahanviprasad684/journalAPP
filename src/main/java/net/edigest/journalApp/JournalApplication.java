package net.edigest.journalApp;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class JournalApplication {

	public static void main(String[] args) {

		 ApplicationContext context = SpringApplication.run(JournalApplication.class, args);
		 Environment environment = context.getEnvironment();
		 System.out.println(environment.getActiveProfiles()[0]);

	}

	@Bean
	public PlatformTransactionManager anyName(MongoDatabaseFactory dbFactory){
		return new MongoTransactionManager(dbFactory);
	}

}

//In mongoDB PlatformTransactionalManager manages the transaction
// mongoDBTransactionManager implemented the PlatformTransactionalManager
