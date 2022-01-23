package com.study.s1.location;

import java.util.Scanner;


public class LocationController {
	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			
			System.out.println("1. 지역 리스트 출력");
			System.out.println("2. 지역 번호 검색");
			System.out.println("3. 종료");
			
			int select = sc.nextInt();
			
			switch (select)
			{
			case 1:
				locationView.view(locationDAO.getList());
				break;
			case 2:
				System.out.print("검색할 지역 번호 입력:");
				locationView.view(locationDAO.getOne(sc.nextInt()));
				break;
			default:
				flag = false; 
			}
		}
	}
}
