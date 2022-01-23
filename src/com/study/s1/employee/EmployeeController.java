package com.study.s1.employee;

import java.util.Scanner;


public class EmployeeController {
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private Scanner sc;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. 사원 리스트 출력");
			System.out.println("2. 사원 번호 검색");
			System.out.println("3. 종료");
			
			int select = sc.nextInt();
			
			switch (select)
			{
			case 1:
				employeeView.view(employeeDAO.getList());
				break;
			case 2:
				System.out.print("검색할 사원 번호 입력:");
				employeeView.view(employeeDAO.getOne(sc.nextInt()));
				break;
			default:
				flag = false; 
			}
		}
	}
}
