package com.github.dreamroute.locker.misc.test.mapper;

import com.github.dreamroute.locker.misc.domain.JobInfo;
import com.github.dreamroute.locker.misc.mapper.JobInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JobInfoMapperTest {
	
	private static SqlSession sqlSession = null;

	@BeforeClass
	public static void doInitTest() throws Exception {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		sqlSession = sqlSessionFactory.openSession(true);
	}

	@Test
	public void updateUserPojoTest() {
		JobInfoMapper jobInfoMapper = sqlSession.getMapper(JobInfoMapper.class);
		JobInfo jobInfo = new JobInfo();
		jobInfo.setId(1L);
		jobInfo.setName("111");
		jobInfo.setGroup("group");
		jobInfo.setCronVar("www");
		jobInfo.setClassName("cn");
		jobInfo.setContext("ctx");
		jobInfo.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		jobInfo.setVersion(0L);
		jobInfo.setState(1);
		jobInfo.setIsDelete(1);
		jobInfoMapper.updateByPrimaryKey(jobInfo);
	}

}
