package cn.itcast.gjp.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.itcast.gjp.domain.ZhangWu;
import cn.itcast.gjp.tools.JDBCUtils;

/*
 * 实现对数据表gjp_zhangwu 数据增删改查操作
 * dbutils工具类完成类成员创建QueryRunner对象,指定数据源
 */
public class ZhangWuDao {
	private QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
	
	/*
	 * 定义方法,实现修改账务功能
	 * 由业务层调用,传递zwid参数
	 * 将对象中的数据,从数据表中删除
	 */
	public int deleteZhangWu(int zwid) {
		try {
			//写出删除数据的SQL语句
			String sql="DELETE FROM gjp_zhangwu WHERE zwid=?";
			//调用qr对象方法update,执行删除
			return qr.update(sql, zwid);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("删除失败");
		}
	}
	
	/*
	 * 定义方法,实现修改账务功能
	 * 由业务层调用,传递ZhangWu对象
	 * 将对象中的数据,更新到数据表
	 */
	public int exitZhangWu(ZhangWu zw) {
		try {
			//更新数据的SQL语句
			String sql = "UPDATE gjp_zhangwu SET flname=?,money=?,zhanghu=?,createtime=?,description=? WHERE zwid=?";
			//定义对象数组,将所有的参数放进数组中
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription(),zw.getZwid()};
			//调用qr对象方法update,执行更新
			return qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("修改失败");
		}
	}
	
	/*
	 * 定义方法,实现添加账务功能
	 * 由业务层调用,传递ZhangWu对象
	 * 由ZhangWu对象中的数据,添加到数据表
	 */
	public int addZhangWu(ZhangWu zw) {
		//写出添加数据的SQL语句
		try {
			String sql = "INSERT INTO gjp_zhangwu (flname,money,zhanghu,createtime,description)VALUES(?,?,?,?,?)";
			Object[] params = {zw.getFlname(),zw.getMoney(),zw.getZhanghu(),zw.getCreatetime(),zw.getDescription()};
			return qr.update(sql, params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("数据添加失败");
		}
	}
	
	/*
	 * 定义方法,查询数据库,带有条件去查询账务表
	 * 由业务层调用,查询的结果集存储到Bean对象,存储到List集合
	 * 调用者传递2个日期字符串
	 */
	public List<ZhangWu> select(String startDate,String endDate) {
		try {
			String sql = "SELECT * FROM gjp_zhangwu WHERE createtime BETWEEN ? AND ?";
			Object[] params = {startDate,endDate};
			return qr.query(sql, new BeanListHandler<ZhangWu>(ZhangWu.class),params);
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("条件查询失败");
		}
	}
	
	/*
	 * 定义方法,查询数据库,获取所有的账务数据
	 * 方法,由业务层调用
	 * 结果集,将所有的账务数据,存储到Bean对象中,存储到集合中
	 */
	public List<ZhangWu> selectAll(){
		try {
			//查询账务数据的SQL语句
			String sql = "SELECT * FROM gjp_zhangwu";
			//调用qr对象的方法,query方法,结果集BeanListHandler
			List<ZhangWu> list;
			list = qr.query(sql, new BeanListHandler<>(ZhangWu.class));
			return list;
		} catch (SQLException e) {
			System.out.println(e);
			throw new RuntimeException("查询所有账务失败");
		}
		
	}

}
