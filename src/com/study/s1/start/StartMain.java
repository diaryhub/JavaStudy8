package com.study.s1.start;

import com.study.s1.department.DepartmentController;

public class StartMain {

	public static void main(String[] args) throws Exception{
	
		System.out.println("DB연동 테스트 시작");
		DepartmentController controller = new DepartmentController();
		
		controller.start();
		
		System.out.println("DB연동 테스트 끝");
		
	}

}
