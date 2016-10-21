package com.cdsecond.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cdsecond.bean.User;
import com.cdsecond.common.SqlHelper;



public class UserDAO {

	public Integer add(User user) {
		
		String sql="insert into user(userName,userPassword,userTrueName,userSex,IDCard,userPhone,userAddr,userStatus)"
				+ "values (?,?,?,?,?,?,?,?)";
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, user.getUserName());
		map.put(2, user.getUserPassword());
		map.put(3, user.getUserTrueName());
		map.put(4, user.getUserSex());
		map.put(5, user.getIDCard());
		map.put(6, user.getUserPhone());
		map.put(7, user.getUserAddr());
		map.put(8, String.valueOf(user.getUserStatus()));
		
		Integer rtn = SqlHelper.executeUpdate(sql, map);
		
		return rtn;
	}
	
	public Integer edit(User user) {
		
		String sql="update user set userPassword=?,userTrueName=?,userSex=?,IDCard=?,userPhone=?,userAddr=?,userStatus=? where userID=?";
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, user.getUserPassword());
		map.put(2, user.getUserTrueName());
		map.put(3, user.getUserSex());
		map.put(4, user.getIDCard());
		map.put(5, user.getUserPhone());
		map.put(6, user.getUserAddr());
		map.put(7, String.valueOf(user.getUserStatus()));
		map.put(8, user.getUserID());
		
		Integer rtn = SqlHelper.executeUpdate(sql, map);
		
		return rtn;
	}
	
	public Integer delete(User user) {
		
		String sql="update user set userStatus=? where userID=?";
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, String.valueOf(user.getUserStatus()));
		map.put(2, user.getUserID());
		
		Integer rtn = SqlHelper.executeUpdate(sql, map);
		
		return rtn;
	}
	public List search(User user) {
		
		String sql="select * from user where 0=0 ";
		Map<Integer, String> map = new HashMap<Integer, String>();
		Integer i=0;
		if(user.getUserName()!=null && !user.getUserName().equals("")){
			sql+=" and userName=?";
			i++;
			map.put(i, user.getUserName());
		}
		if(user.getUserTrueName()!=null && !user.getUserTrueName().equals("")){
			sql+=" and userTrueName=?";
			i++;
			map.put(i, user.getUserTrueName());
		}
		//调用数据库操作
		List list;
		if(i==0)
		{
			list = SqlHelper.executeQuery(sql, User.class);
		}else{
			list =  SqlHelper.executeQuery(sql, map, User.class);
		}
		return list;
	}

	public User searchone(String username) {
		String sql="select * from user where userid=?";
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, username);
		
		return SqlHelper.executeDetail(sql, map, new User());
		
		
	}
	public List searchall(){
		String sql="select * from user";
		List list = SqlHelper.executeQuery(sql, User.class);
		return list;
	}
}