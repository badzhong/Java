package cn.itcast.gip.view;

import java.util.List;
import java.util.Scanner;

import cn.itcast.gjp.controller.ZhangWuController;
import cn.itcast.gjp.domain.ZhangWu;

/*
 * ��ͼ��,�û������Ͳ����Ľ���
 * ���ݴ��ݸ�controller��ʵ��
 * ��Աλ��,����controller
 */
public class MainView {
	private ZhangWuController controller = new ZhangWuController();
	
	/*
	 * ʵ�ֽ���Ч��
	 * �����û�����
	 * ��������,���ò�ͬ�Ĺ��ܷ���
	 */
	public void run() {
		//����Scanner�����,������������
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("---------------�ܼ��ż�ͥ�������---------------");
			System.out.println("1.�������2.�༭����3.ɾ������4.��ѯ����5.�˳�ϵͳ");
			System.out.println("������Ҫ�����Ĺ������[1-5]:");
			//�����û��Ĳ˵�ѡ��
			int choose = sc.nextInt();
			//��ѡ��Ĳ˵��ж�,���ò�ͬ�Ĺ���
			switch (choose) {
			case 1:
				//ѡ���������,�����������ķ���
				addZhangWu();
				break;
			case 2:
				//ѡ��༭����,���ñ༭����ķ���
				editZhangWu();
				break;
			case 3:
				//ѡ��ɾ������,����ɾ������ķ���
				deleteZhangWu();
				break;
			case 4:
				//ѡ���ѯ����,���ò�ѯ����ķ���
				selectZhangWu();
				break;
			case 5:
				//�˳�ϵͳ
				System.exit(0);
				break;

			default:
				break;
			}
		}
	}
	
	/*
	 * ʵ�ַ���,ʵ�ֶ������ɾ������
	 * ʵ��˼��:
	 * 	�����û�������,����һ����������
	 * 	���ÿ��Ʋ㷽��,����һ������
	 */
	private void deleteZhangWu() {
		//���ò�ѯ�����������ݵĹ���,��ʾ����
		selectAll();
		//������������,����ѡ��һ�����ɾ��
		System.out.println("����ɾ������");
		Scanner sc = new Scanner(System.in);
		System.out.println("������Ҫɾ�������id(���):");
		int zwid = sc.nextInt();
		int result = controller.deleteZhangWu(zwid);
		if (result == 1) {
			System.out.println("ɾ���ɹ�");
		}else {
			System.out.println("ɾ��ʧ��");
		}
		
/*		if(controller.deleteZhangWu(zwid) == 1) {
			System.out.print("ȷ��Ҫɾ����������Ϣ��");
			System.out.println("ȷ��ɾ������1,ȡ��ɾ������2��");
			int choose = sc.nextInt();
			if(choose == 1) {
				controller.deleteZhangWu(zwid);
				System.out.println("ɾ���ɹ�");
			}else if(choose == 2) {
				System.out.println("ȡ��ɾ��");
			}
		}else {
			System.out.println("ɾ��ʧ��");
		}*/
	}

	/*
	 * ���巽��,ʵ�ֶ�����ı༭����
	 * ʵ��˼��:
	 * 	�����û�������
	 * 	���ݵ���Ϣ,��װ��ZhangWu����
	 * 	���ÿ��Ʋ�ķ���,����ZhangWu����,ʵ�ֱ༭
	 */
	private void editZhangWu() {
		//���ò�ѯ�����������ݵĹ���,��ʾ����
		//������������,����ѡ��һ������޸�
		selectAll();
		Scanner sc = new Scanner(System.in);
		System.out.println("����༭����)");
		
		/*System.out.println("��ѡ����Ҫ�༭����Ŀ");
		System.out.println("1.�������ơ�2.�����3.�����˻���4.����ʱ�䡡5.��������");
		int print = sc.nextInt();
		switch (print) {
		case 1:
			
			break;

		default:
			break;
		}*/
		System.out.println("������Ҫ�޸������id(���:");
		int zwid = sc.nextInt();
		System.out.println("�����޸ĺ����������:");
		String flname = sc.next();
		System.out.println("�����޸ĺ���:");
		Double money = sc.nextDouble();
		System.out.println("�����޸ĺ���˻�:");
		String zhanghu = sc.next();
		System.out.println("�����޸ĺ������,��ʽxxxx-xx-xx:");
		String createtime = sc.next();
		System.out.println("�����޸ĺ�ľ�������:");
		String description = sc.next();
		//�������û����������,��װ��ZhangWu������
		ZhangWu zw = new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//����controller���еķ���,ʵ�ֱ༭����
		int result = controller.exitZhangWu(zw);
		if(result == 1) {
			System.out.println("�޸ĳɹ�");
		}else {
			System.out.println("�޸�ʧ��");
		}
		
	}
	
	/*
	 * ���巽��addZhangWu
	 * �������ķ������û��ڽ�����ѡ��˵�1��ʱ����á�
	 * ʵ��˼�룺
	 * 	  ���ռ������룬5�����룬����controller�㷽��
	 */
	public void addZhangWu() {
		System.out.println("�������������,������");
		Scanner sc = new Scanner(System.in);
		System.out.println("������������");
		String flname = sc.next();
		System.out.println("������");
		Double money = sc.nextDouble();
		System.out.println("�����˻�");
		String zhanghu = sc.next();
		System.out.println("��������,��ʽxxxx-xx-xx");
		String createtime = sc.next();
		System.out.println("������������");
		String description = sc.next();
		//�����յ�������,����controller��ķ���,���ݲ���
		//���û���������в���,��װ��ZhangWu����
		ZhangWu zw = new ZhangWu(0, flname, money, zhanghu, createtime, description);
		int result = controller.addZhangWu(zw);
		if(result == 1) {
			System.out.println("������ӳɹ�");
		}else {
			System.out.println("�������ʧ��");
		}
		
	}
	/*
	 * ���巽��selectZhangWu();
	 * ��ʾ��ѯ�ķ�ʽ1 ���в�ѯ 2������ѯ
	 * �����û���ѡ��
	 */
	public void selectZhangWu() {
		System.out.println("1.��ѯ����	2.������ѯ");
		Scanner sc = new Scanner(System.in);
		int selectChoose = sc.nextInt();
		//�жϸ����û���ѡ��,���ò�ͬ�Ĺ���
		switch (selectChoose) {
		case 1:
			//ѡ���ѯ����,���ò�ѯ���еķ���
			selectAll();
			break;
		case 2:
			//ѡ��������ѯ,���ô��в�ѯ�����ķ���
			select();
			break;

		default:
			break;
		}
	}
	/*
	 * ���巽��,��ʵ�ֲ�ѯ���е���������
	 */
	public void selectAll() {
		//���ÿ��Ʋ��еķ���,��ѯ���е���������
		List<ZhangWu> list = controller.selectAll();
		if(list.size()!=0) {
			print(list);
		}else {
			System.out.println("û�в�ѯ������");
		}
	}
	
	/*
	 * ���巽��,ʵ��������ѯ��������
	 * �ṩ�û�����������,��ʼ���ںͽ�������
	 * 2������,���ݵ�controller��
	 * ����controller�ķ���,����2�����ڲ���
	 * ��ȡ��controller��ѯ�Ľ����,��ӡ
	 */
	public void select() {
		System.out.println("ѡ��������ѯ,�������ڸ�ʽΪxxxx-xx-xx");
		Scanner sc = new Scanner(System.in);
		System.out.print("�����뿪ʼ������");
		String startDate = sc.nextLine();
		System.out.print("���������������");
		String endDate = sc.nextLine();
		//����controller��ķ���,��������,��ȡ��ѯ�����
		List<ZhangWu> list = controller.select(startDate, endDate);
		if(list.size()!=0) {
			print(list);
		}else {
			System.out.println("û�в�ѯ������");
		}
		
		
	}
	//����������ݷ���,����List����,��������,������
	public void print(List<ZhangWu> list) {
		//�����ͷ
		System.out.println("ID\t�б�\t\t�˻�\t\t���\t\tʱ��\t\t˵��");
		//��������,����������̨
		for(ZhangWu zw : list) {
			System.out.println(zw.getZwid()+"\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()
					+"\t\t"+zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t"+zw.getDescription());
		}
	}
}
