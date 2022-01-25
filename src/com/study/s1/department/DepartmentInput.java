package com.study.s1.department;

import java.util.Scanner;

public class DepartmentInput {
	
	private Scanner sc;
	private DepartmentDTO departmentDTO;
	public DepartmentDTO setInsert() {
		departmentDTO = new DepartmentDTO();
		sc = new Scanner(System.in);
		System.out.println("부서 ID 입력:");
		departmentDTO.setDepartment_id(sc.nextInt());
		System.out.println("부서명 입력:");
		departmentDTO.setDepartment_name(sc.next());
		System.out.println("부서 지역 입력:");
		departmentDTO.setLocation_id(sc.nextInt());
		System.out.println("매니저 ID 입력:");
		departmentDTO.setManager_id(sc.nextInt());
		
		return departmentDTO;
	}
	
	public DepartmentDTO setDelete() {
		departmentDTO = new DepartmentDTO();
		sc = new Scanner(System.in);
		System.out.println("삭제할 ID 입력:");
		departmentDTO.setDepartment_id(sc.nextInt());
		return departmentDTO;
	}
	
	
}
