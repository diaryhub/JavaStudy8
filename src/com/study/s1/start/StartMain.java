package com.study.s1.start;

import java.util.List;
import java.util.Scanner;

import com.study.s1.department.DepartmentDAO;
import com.study.s1.department.DepartmentDTO;
import com.study.s1.department.DepartmentView;

public class StartMain {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("DB연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		
		DepartmentDTO departmentDTO =   departmentDAO.getOne(20);
		departmentView.view(departmentDTO);
		System.out.println("DB연동 테스트 끝");
		
	}

}
