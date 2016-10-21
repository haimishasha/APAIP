package com.cdsecond.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SqlHelper {

	/**
	 * 数据库驱动加载
	 */
	static {
		try {
			Class.forName(Resource.getDriver());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库连接对象
	 */
	public static Connection getConnection(){
		try {
			return DriverManager.getConnection(Resource.getUrl(),Resource.getUser(),Resource.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 执行sql语句
	 */
	public static Integer executeUpdate(String sql){
	    return executeUpdate(sql, null);
	}
	/**
	 * 执行sql语句
	 * @param sql sql语句
	 * @param params sql参数集合。key为参数的顺序，Value为参数的值
	 * @return 执行结果
	 */
	public static Integer executeUpdate(String sql,Map<Integer, String> params){
		//1、获取链接对象
		Connection conn=getConnection();
		Integer rst=0;
		//2定义statement对象
		PreparedStatement pstmt = null ;
		try{
			pstmt = conn.prepareStatement(sql);
			//3处理参数
			if(params!=null){
				Set<Integer> set = params.keySet();
		     	Iterator<Integer> ite = set.iterator();
		     	while(ite.hasNext()){
		     		Integer key = ite.next();
		     		String value = params.get(key);
		     		pstmt.setString(key, value);
		     	}
			}
			rst=pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)
					pstmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rst;
	}
	
	/**
	 * 查询数据集合，返回对象的list
	 * 1、查询出结果集resultset
	 * 2、将resultset转换为list对象
	 * @param sql
	 * @param params 
	 * @param cls
	 * @return
	 */
	public static List executeQuery(String sql,Map<Integer, String> params,Class cls){
		Connection conn=getConnection();
		PreparedStatement pstmt;
		List list = new ArrayList();
		try {
			pstmt = conn.prepareStatement(sql);
			//处理参数
			if(params!=null){
				Set<Integer> set = params.keySet();
		     	Iterator<Integer> ite = set.iterator();
		     	while(ite.hasNext()){
		     		Integer key = ite.next();
		     		String value = params.get(key);
		     		pstmt.setString(key, value);
		     	}
			}
			ResultSet resset = pstmt.executeQuery();
			list = SetToEntity.resultsettolist(resset, cls);
			resset.close();
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	/**
	 * 
	 * @param sql
	 * @param cls
	 * @return
	 */
	public static List executeQuery(String sql,Class<?> cls){
		return executeQuery(sql, null, cls);
	}
	
	/**
	 * 查询一个对象。如果没有找到则返回Null
	 * @param <T>
	 * @param sql
	 * @param params
	 * @param t
	 * @return
	 */
	public static <T> T executeDetail(String sql,Map<Integer, String> params,T t){
		List list = executeQuery(sql,params,t.getClass());
		if(list.size()>0){
			t = (T)list.get(0);
		}else{
			t=null;
		}
		return t;
	}
	/**
	 * 
	 * @param <T>
	 * @param sql
	 * @param t
	 * @return
	 */
	public static <T> T executeDetail(String sql,T t){
		return executeDetail(sql,null,t);
	}
}

