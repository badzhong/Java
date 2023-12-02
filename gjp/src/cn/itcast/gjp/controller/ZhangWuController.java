package cn.itcast.gjp.controller;

import java.util.List;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.service.ZhangWuService;

/*
 * 控制器层
 * 接收视图层的数据,将数据传递给service层
 * 成员位置,创建service对象
 */
public class ZhangWuController {
	private ZhangWuService service = new ZhangWuService(); 
	
	/*
	 * 定义方法,实现删除账务功能
	 * 由视图层调用,传递参数zwid
	 * 调用service层的方法,传递zwid对象
	 */
	public int deleteZhangWu(int zwid) {
		return service.deleteZhangWu(zwid);
	}
	
	/*
	 * 定义方法,实现修改账务功能
	 * 由视图层调用,传递参数,也是ZhangWu类型的对象
	 * 调用service层的方法,传递ZhangWu对象
	 */
	public int exitZhangWu(ZhangWu zw) {
		return service.exitZhangWu(zw);
	}
	
	/*
	 * 定义方法，实现账务添加功能
	 * 由视图层调用，传递参数(传递过来的参数不能是5个数据，传递的是一个ZhangWu类型的对象)
	 * 本方法调用service层的方法，传递ZhangWu对象，获取到添加后的结果集(添加成功影响的行数，int)
	 */
	public int addZhangWu(ZhangWu zw) {
		return service.addZhangWu(zw);
	}
	
	/*
	 * 定义方法,实现条件查询账务
	 * 方法由视图层调用,传递2个日期的字符串
	 * 调用service层的方法,传递2个日期字符串,获取结果集
	 * 结果集返回给试图
	 */
	public List<ZhangWu> select(String startDate,String endDate) {
		
		return service.select(startDate, endDate);
	}
	
	/*
	 * 控制层类定义方法,实现查询所有的账务数据
	 * 方法由视图层调用,方法再去调用service层
	 */
	public List<ZhangWu> selectAll() {
		return service.selectAll();
	}




}
