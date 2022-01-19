package com.study.s1.start;

import java.util.List;

import com.study.s1.department.DepartmentDAO;
import com.study.s1.department.DepartmentDTO;
import com.study.s1.department.DepartmentView;

public class StartMain {

	public static void main(String[] args) throws Exception {
		
		System.out.println("DB연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		
		List<DepartmentDTO> ar = departmentDAO.getList();
		departmentView.view(ar);
		System.out.println("DB연동 테스트 끝");
		
	}

}
