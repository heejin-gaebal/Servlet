package com.kh.app.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	//객체 생성없이 바로 사용
	public static SqlSession getSqlSession() throws Exception {
		String resource = "/conf.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession ss = sqlSessionFactory.openSession(false);
		//openSession(false); boolean타입 autocommit 여부 
		
		return ss;
	}
}
