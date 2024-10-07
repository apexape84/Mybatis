package com.ogiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.ConnectionPoolDataSource;
import java.lang.management.ManagementFactory;
import java.util.Date;


public class Application {
    private static String driver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost/menudb";
    private static String user="ohgiraffers";
    private static String password="ohgiraffers";
    public static void main(String[] args) {
        Environment environment = new Environment(
                "dev",
                new JdbcTransactionFactory(),   // 수동으로 커밋하겠다는 얘기
                // ManagementFactory : 이건 자동 커밋
                new PooledDataSource(driver,url,user,password)  // ConnectionPool 사용
                // UnpooledDataSource : ConnectionPool 사용
        );

        Configuration configuration = new Configuration(environment);   // mybatis 설정

        configuration.addMapper(Mapper.class);

        /*SqlSession;
        SqlSessionFactory factory = new SqlSessionFactoryBuilder()
        SqlSessionFactoryBuilder;*/

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession sqlSession = factory.openSession(false);
        // 전달인자는 autocommit설정 여부(boolean)

        Mapper mapper = sqlSession.getMapper(Mapper.class);

        Date date = mapper.selectSysDate();

        System.out.println("date = " + date);

        sqlSession.close();

    }
}
