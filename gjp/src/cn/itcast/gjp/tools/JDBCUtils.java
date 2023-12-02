package cn.itcast.gjp.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

/*
 * ��ȡ���ݿ����ӵĹ�����
 * ʵ�����ӳ�,dbcp���ӳ�
 */
public class JDBCUtils {
	//����BasicDataSource����
	private static BasicDataSource datasource = new BasicDataSource();
	//��̬�����,ʵ�ֱ�Ҫ��������
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
			throw new RuntimeException("���ݿ�����ʧ��");
		}
	}
	public static DataSource getDataSource() {
		return datasource;
	}
}
