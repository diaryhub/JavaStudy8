package com.study.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.study.s1.util.DBConnector;

public class DepartmentDAO {
	
	//DAO (Data Access object)
	private DBConnector dbConnector;
	
	public DepartmentDAO() {
	dbConnector = new DBConnector();
	}
	public List<DepartmentDTO> getList() throws Exception{
		//SELECT * FROM DEPARTMENTS;
		
		ArrayList<DepartmentDTO> arrayList = new ArrayList<>();
		// 1. DB에 로그인
		Connection con = dbConnector.getConnect();
		
		// 2. SQL Query 문 작성
		String sql = "SELECT * FROM departments";
		
		// 3. 작성한 SQL Query를 미리 전송
		
		PreparedStatement st = con.prepareStatement(sql);
		
		
		// 4. ? 값을 세팅, 없으면 통과
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		//dbConnector.getConnect().prepareStatement("SELECT * FROM departments").excuteQuery();
		
		while(rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setDepartment_id(rs.getInt("DEPARTMENT_ID"));
			departmentDTO.setManager_id(rs.getInt("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getInt("LOCATION_ID"));
			arrayList.add(departmentDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return arrayList;
	}
	
}
