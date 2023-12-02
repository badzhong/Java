package cn.itcast.gjp.service;

import java.util.List;

import cn.itcast.gjp.dao.ZhangWuDao;
import cn.itcast.gjp.domain.ZhangWu;

/*
 * 业务层类
 * 接收上一层,控制层controller的数据
 * 经过计算,传递给dao层,操作数据库
 * 调用dao层中的类,类成员位置,创建Dao类的对象
 */
public class ZhangWuService {
	private ZhangWuDao dao = new ZhangWuDao();
	
	/*
	 * 定义方法,实现删除账务
	 * 由控制层调用,传递参数zwid
	 * 调用dao层方法,传递参数zwid
	 */

	public int deleteZhangWu(int zwid) {
		return dao.deleteZhangWu(zwid);
	}
	
	/*
	 * 定义方法,实现修改账务
	 * 由控制层调用,传递ZhangWu对象
	 * 调用dao层方法,传递ZhangWu对象
	 */
	public int exitZhangWu(ZhangWu zw) {
		return dao.exitZhangWu(zw);
	}
	
	/*
	 * 定义方法，实现添加账务
	 * 是由控制层调用，传递ZhangWu对象
	 * 调用dao层方法,传递ZhangWu对象
	 */
	public int addZhangWu(ZhangWu zw) {
		return dao.addZhangWu(zw); 
	}
	
	/*
	 * 定义方法,实现条件查询账务
	 * 方法由控制层调用,传递2个日期字符串
	 * 调用dao层的方法,传递2个日期字符串
	 * 获取到查询结果集
	 */
	public List<ZhangWu> select(String startDate,String endDate) {
		return dao.select(startDate, endDate);
	}
	
	/*
	 * 定义方法,实现查询所有的账务数据
	 * 此方法由控制层调用,此方法再去调用dao层的方法
	 */
	public List<ZhangWu> selectAll() {
		return dao.selectAll();
	}




}
