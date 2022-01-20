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
		System.out.println(departmentDTO.getDepartment_name());
		System.out.println(departmentDTO.getDepartment_id());
		System.out.println(departmentDTO.getManager_id());
		System.out.println(departmentDTO.getLocation_id());
	}
	
}
