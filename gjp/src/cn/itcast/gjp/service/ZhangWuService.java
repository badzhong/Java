package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

/*
 * ҵ�����
 * ������һ��,���Ʋ�controller������
 * ��������,���ݸ�dao��,�������ݿ�
 * ����dao���е���,���Աλ��,����Dao��Ķ���
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	/*
	 * ���巽��,ʵ��ɾ������
	 * �ɿ��Ʋ����,���ݲ���zwid
	 * ����dao�㷽��,���ݲ���zwid
	 */

	public int deleteZhangWu(int zwid) {
		return dao.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽��,ʵ���޸�����
	 * �ɿ��Ʋ����,����ZhangWu����
	 * ����dao�㷽��,����ZhangWu����
	 */
	public int exitZhangWu(ZhangWu zw) {
		return dao.exitZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ���������
	 * ���ɿ��Ʋ���ã�����ZhangWu����
	 * ����dao�㷽��,����ZhangWu����
	 */
	public int addZhangWu(ZhangWu zw) {
		return dao.addZhangWu(zw); 
	}
	
	/*
	 * ���巽��,ʵ��������ѯ����
	 * �����ɿ��Ʋ����,����2�������ַ���
	 * ����dao��ķ���,����2�������ַ���
	 * ��ȡ����ѯ�����
	 */
	public List<ZhangWu> select(String startDate,String endDate) {
		return dao.select(startDate, endDate);
	}
	
	/*
	 * ���巽��,ʵ�ֲ�ѯ���е���������
	 * �˷����ɿ��Ʋ����,�˷�����ȥ����dao��ķ���
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}




}
