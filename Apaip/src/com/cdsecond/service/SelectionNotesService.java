package com.cdsecond.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cdsecond.bean.Applicant;
import com.cdsecond.bean.SelectionNotes;
import com.cdsecond.dao.ApplicantDao;
import com.cdsecond.dao.SelectionNotesDao;

public class SelectionNotesService {
	/**
	 * 无参构造方法
	 */
	public SelectionNotesService() {
		// TODO Auto-generated constructor stub
	}
	
	public static boolean addSelectionNotes(SelectionNotes selectionNotes) throws ClassNotFoundException, SQLException, IOException{
		
		boolean flag = true;
		
		SelectionNotesDao dao = new SelectionNotesDao();
		
		flag = dao.addSelectionNotes(selectionNotes);
		
		System.out.println(flag + "=====================");
		
		return flag;
	}

	public static boolean deleteSelectionNotes(String selectionNotesID) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = true;
		
		SelectionNotesDao dao = new SelectionNotesDao();
		
		flag = dao.deleteSelectionNotes(selectionNotesID);
		
		return flag;
	}
	
	public static List<SelectionNotes> selectSelectionNotes(SelectionNotes selectionNotes,int currentPage) throws ClassNotFoundException, SQLException, IOException {
		
		SelectionNotesDao dao = new SelectionNotesDao();
		
		String s = dao.sqlStatement(selectionNotes);
		
		List<SelectionNotes> list = dao.selectSelectionNotes(s, currentPage);
		
		System.out.println(list);
		
		return list;
	}
	
	public static boolean updateSelectionNotes(SelectionNotes selectionNotes) throws ClassNotFoundException, SQLException, IOException {
		
		boolean flag = true;
		
		SelectionNotesDao dao = new SelectionNotesDao();
		
		dao.updateSelectionNotes(selectionNotes);
		
		return flag;
	}

}
