package com.study.s1.start;

import java.util.List;

import com.study.s1.location.LocationDAO;
import com.study.s1.location.LocationDTO;
import com.study.s1.location.LocationView;

public class StartMain {

	public static void main(String[] args) throws Exception {
		
		System.out.println("DB연동 테스트 시작");
		
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();
		
		List<LocationDTO> list =  locationDAO.getList();
		locationView.view(list);
		System.out.println("DB연동 테스트 끝");
		
	}

}
