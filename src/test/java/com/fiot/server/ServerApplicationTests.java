package com.fiot.server;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServerApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(ServerApplicationTests.class);

	@Resource
	MongoTemplate mongoTemplate;

	@Before
	public void testBefore() {
		log.info("------------START------------");
	}

	@After
	public void testAfter() {
		log.info("------------ END ------------");
	}

	@Test
	public void saveModelCollection() {
		// mongoTemplate.save(new AuthProjectModelEntity("shibo", "SHIBO_MODEL",
		// "这是世博文化中心项目", "shibo.jpg", ""));
	}
}
