package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

/*
 * ��������
 * ������ͼ�������,�����ݴ��ݸ�service��
 * ��Աλ��,����service����
 */
public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService(); 
	
	/*
	 * ���巽��,ʵ��ɾ��������
	 * ����ͼ�����,���ݲ���zwid
	 * ����service��ķ���,����zwid����
	 */
	public int deleteZhangWu(int zwid) {
		return service.deleteZhangWu(zwid);
	}
	
	/*
	 * ���巽��,ʵ���޸�������
	 * ����ͼ�����,���ݲ���,Ҳ��ZhangWu���͵Ķ���
	 * ����service��ķ���,����ZhangWu����
	 */
	public int exitZhangWu(ZhangWu zw) {
		return service.exitZhangWu(zw);
	}
	
	/*
	 * ���巽����ʵ��������ӹ���
	 * ����ͼ����ã����ݲ���(���ݹ����Ĳ���������5�����ݣ����ݵ���һ��ZhangWu���͵Ķ���)
	 * ����������service��ķ���������ZhangWu���󣬻�ȡ����Ӻ�Ľ����(��ӳɹ�Ӱ���������int)
	 */
	public int addZhangWu(ZhangWu zw) {
		return service.addZhangWu(zw);
	}
	
	/*
	 * ���巽��,ʵ��������ѯ����
	 * ��������ͼ�����,����2�����ڵ��ַ���
	 * ����service��ķ���,����2�������ַ���,��ȡ�����
	 * ��������ظ���ͼ
	 */
	public List<ZhangWu> select(String startDate,String endDate) {
		
		return service.select(startDate, endDate);
	}
	
	/*
	 * ���Ʋ��ඨ�巽��,ʵ�ֲ�ѯ���е���������
	 * ��������ͼ�����,������ȥ����service��
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}




}
