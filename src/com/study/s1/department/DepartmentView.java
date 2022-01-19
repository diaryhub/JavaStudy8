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
}
