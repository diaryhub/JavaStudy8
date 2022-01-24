package com.study.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.s1.util.DBConnector;

public class DepartmentDAO {
	
	//DAO (Data Access object)
	private DBConnector dbConnector;
	
	public DepartmentDAO() {
	dbConnector = new DBConnector();
	}
	
	public void getDEP_EMPList() throws SQLException {
		
		Connection con = dbConnector.getConnect();
		String sql = "SELECT D.*,E.* FROM departments D INNER JOIN employees E ON (e.department_id = d.department_id);";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			
			
			
		}
		
		
	}
	
	public DepartmentDTO getOne(Integer department_id) throws SQLException {
		DepartmentDTO departmentDTO = null;
		//1. DB login
		Connection con = dbConnector.getConnect();
		//2. SQL Query
		String SQL = "SELECT * FROM departments WHERE department_id = ? ";
		//3. Query send
			PreparedStatement st = con.prepareStatement(SQL);
		//4. ? setting
			//st.set데이터타입(int index, 값); 
			//index는 ? 의 순서 번호
			//그러나 oracle은 1번부터 시작
			st.setInt(1, department_id);
		//5. result set		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
		}	
		
		//6. resource close
		rs.close();
		st.close();
		con.close();
		
		return departmentDTO;
		
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
