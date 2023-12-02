package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

/*
 * ʵ�ֶ����ݱ�gjp_zhangwu ������ɾ�Ĳ����
 * dbutils������������Ա����QueryRunner����,ָ������Դ
 */
public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	/*
	 * ���巽��,ʵ���޸�������
	 * ��ҵ������,����zwid����
	 * �������е�����,�����ݱ���ɾ��
	 */
	public int deleteZhangWu(int zwid) {
		try {
			//д��ɾ�����ݵ�SQL���
			String sql="DELETE FROM gjp_zhangwu WHERE zwid=?";
			//����qr���󷽷�update,ִ��ɾ��
			return qr.update(sql, zwid);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("ɾ��ʧ��");
		}
	}
	
	/*
	 * ���巽��,ʵ���޸�������
	 * ��ҵ������,����ZhangWu����
	 * �������е�����,���µ����ݱ�
	 */
	public int exitZhangWu(ZhangWu zw) {
		try {
			//�������ݵ�SQL���
			String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
			//�����������,�����еĲ����Ž�������
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			//����qr���󷽷�update,ִ�и���
			return qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("�޸�ʧ��");
		}
	}
	
	/*
	 * ���巽��,ʵ�����������
	 * ��ҵ������,����ZhangWu����
	 * ��ZhangWu�����е�����,��ӵ����ݱ�
	 */
	public int addZhangWu(ZhangWu zw) {
		//д��������ݵ�SQL���
		try {
			String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description)VALUES(?,?,?,?,?)";
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			return qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("�������ʧ��");
		}
	}
	
	/*
	 * ���巽��,��ѯ���ݿ�,��������ȥ��ѯ�����
	 * ��ҵ������,��ѯ�Ľ�����洢��Bean����,�洢��List����
	 * �����ߴ���2�������ַ���
	 */
	public List<ZhangWu> select(String startDate,String endDate) {
		try {
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object[] params = {startDate,endDate};
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class),params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("������ѯʧ��");
		}
	}
	
	/*
	 * ���巽��,��ѯ���ݿ�,��ȡ���е���������
	 * ����,��ҵ������
	 * �����,�����е���������,�洢��Bean������,�洢��������
	 */
	public List<ZhangWu> selectAll(){
		try {
			//��ѯ�������ݵ�SQL���
			String sql = "SELECT * FROM gjp_zhangwu";
			//����qr����ķ���,query����,�����BeanListHandler
			List<ZhangWu> list;
			list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("��ѯ��������ʧ��");
		}
		
	}

}
