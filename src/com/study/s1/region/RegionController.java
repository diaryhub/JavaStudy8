package com.study.s1.region;

import java.util.Scanner;

public class RegionController {
	private RegionInput regionInput;
	private RegionView regionView;
	private RegionDAO regionDAO;
	private Scanner sc;
	
	public RegionController() {
		
		regionDAO = new RegionDAO();
		regionInput = new RegionInput();
		regionView = new RegionView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception{
		boolean flag = true;
		while(flag) {
			System.out.println("1. region 추가");
			System.out.println("2. region 수정");
			System.out.println("3. region 삭제");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			int result=0;
			String message;
			RegionDTO regionDTO = new RegionDTO();
			switch(select) {
			case 1:
				regionDTO = regionInput.setInsert();
			 result =  regionDAO.setInsert(regionDTO);
			 message = "fail";
			 if (result>0) {message = "success";}
			 regionView.view(message);
				break;
			case 2:
				regionDTO = regionInput.setInsert();
				result = regionDAO.setUpdate(regionDTO);
				message = "fail";
				if(result>0) {message="success";}
				regionView.view(message);
				break;
			case 3:
				regionDTO = regionInput.setDelete();
				result = regionDAO.setDelete(regionDTO);
				message= "fail"; 
				if(result>0) {message = "success";}
				regionView.view(message);
				break;
			default:
				System.out.println("종료");
				flag = false;
			}
			
			
		}
	}
}
