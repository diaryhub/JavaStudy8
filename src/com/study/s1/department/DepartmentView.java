package com.study.s1.department;

import java.util.List;

public class DepartmentView {
	public void view (List<DepartmentDTO> ar) throws Exception {
		
		for(int i=0;i<ar.size();i++) {
		System.out.print(ar.get(i).getDepartment_name()+"\t");
		System.out.print(ar.get(i).getDepartment_id()+"\t");
		System.out.print(ar.get(i).getManager_id()+"\t");
		System.out.println(ar.get(i).getLocation_id()+"\t");
		System.out.println("===============================================");
		}
	}
	
	public void view(DepartmentDTO departmentDTO) {
		System.out.print(departmentDTO.getDepartment_name()+"\t");
		System.out.print(departmentDTO.getDepartment_id()+"\t");
		System.out.print(departmentDTO.getManager_id()+"\t");
		System.out.println(departmentDTO.getLocation_id()+"\t");
		System.out.println("===============================================");
	}
	
	public void view(int result) {
		if(result>0) {
			System.out.println("성공");
		}
		else {
			System.out.println("실패");
		}
	}
	
}
