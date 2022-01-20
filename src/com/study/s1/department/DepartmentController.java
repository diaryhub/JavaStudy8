package com.study.s1.department;

import java.util.Scanner;

public class DepartmentController {
	
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentController() {
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 종료");
			
			int select = sc.nextInt();
			
			switch (select)
			{
			case 1:
				departmentView.view(departmentDAO.getList());
				break;
			case 2:
				System.out.print("검색할 부서 번호 입력:");
				departmentView.view(departmentDAO.getOne(sc.nextInt()));
				break;
			default:
				flag = false; 
			}
		}
	}
}
