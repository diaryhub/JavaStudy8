package com.study.s1.region;

public class RegionTest {

	public static void main(String[] args) throws Exception {
		System.out.println("테스트 시작");

		RegionController regionController = new RegionController();
		
		regionController.start();
		
		System.out.println("테스트 끝");
		
	}

}
