package com.study.s1.department;

import java.util.Scanner;

public class DepartmentController {
	
	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private DepartmentInput departmentInput;
	private Scanner sc;
	
	public DepartmentController() {
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		departmentInput = new DepartmentInput(); 
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서 번호 검색");
			System.out.println("3. 부서 정보 추가");
			System.out.println("4. 부서 정보 변경");
			System.out.println("5. 부서 정보 삭제");
			System.out.println("6. 종료");
			
			DepartmentDTO departmentDTO = new DepartmentDTO();
			int result;
			String message;
			
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
			case 3:
				departmentDTO = departmentInput.setInsert();
				result = departmentDAO.setInsert(departmentDTO);
				departmentView.view(result);
				break;
			case 4:
				departmentDTO = departmentInput.setInsert();
				result = departmentDAO.setUpdate(departmentDTO);
				departmentView.view(result);
				break;
			case 5:
				departmentDTO = departmentInput.setDelete();
				result = departmentDAO.setDelete(departmentDTO);
				departmentView.view(result);
				break;
			default:
				flag = false; 
			}
		}
	}
}
