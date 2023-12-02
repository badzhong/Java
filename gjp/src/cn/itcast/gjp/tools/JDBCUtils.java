package cn.itcast.gjp.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * 获取数据库连接的工具类
 * 实现连接池,dbcp连接池
 */
public class JDBCUtils {
	//创建BasicDataSource对象
	private static BasicDataSource datasource = new BasicDataSource();
	//静态代码块,实现必要参数设置
	static {
		try {
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
			Properties pro = new Properties();
			pro.load(is);
			datasource.setDriverClassName(pro.getProperty("driverClass"));
			datasource.setUrl(pro.getProperty("url"));
			datasource.setUsername(pro.getProperty("username"));
			datasource.setPassword(pro.getProperty("password"));
			Connection con = datasource.getConnection();
			datasource.setInitialSize(10);
			datasource.setMaxActive(10);
			datasource.setMaxIdle(5);
			datasource.setMinIdle(2);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("数据库连接失败");
		}
	}
	public static DataSource getDataSource() {
		return datasource;
	}
}
