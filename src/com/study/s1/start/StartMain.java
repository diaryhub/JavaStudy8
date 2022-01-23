package com.study.s1.start;

public class StartMain {

	public static void main(String[] args) throws Exception{
		System.out.println("DB연동 테스트 시작");
		FrontController frontController = new FrontController();
		frontController.mainStart();
		System.out.println("DB연동 테스트 끝");
	}

}
