package com.study.s1.location;

import java.util.List;

public class LocationView {
	
	public void view(List<LocationDTO> list) {
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i).getLocation_id()+"\t");
			System.out.print(list.get(i).getStreet_adress()+"\t");
			System.out.print(list.get(i).getPostal_code()+"\t");
			System.out.print(list.get(i).getCity()+"\t");
			System.out.print(list.get(i).getState_province()+"\t");
			System.out.println(list.get(i).getCountry_id()+"\t");
			System.out.println("=========================================");
		}
		
		
	}
	
	
}
