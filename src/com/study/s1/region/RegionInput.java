package com.study.s1.region;

import java.util.Scanner;

public class RegionInput {
	
	private Scanner sc;
	
	public RegionInput() {
		sc=new Scanner(System.in);
	}
	
	public RegionDTO setDelete() {
		
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("REGION_ID 입력:");
		regionDTO.setRegion_id(sc.nextLong());
		
		return regionDTO;
	}
	
	public RegionDTO setInsert() {
		
		RegionDTO regionDTO = new RegionDTO();
		System.out.println("REGION_ID 입력:");
		regionDTO.setRegion_id(sc.nextLong());
		System.out.println("REGIO_NAME 입력:");
		regionDTO.setRegion_name(sc.next());
	
		return regionDTO;
	}
	
}
