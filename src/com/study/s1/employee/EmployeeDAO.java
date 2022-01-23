package com.study.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.study.s1.util.DBConnector;

public class EmployeeDAO {

private DBConnector dbConnector;
	
	public EmployeeDAO() {
	dbConnector = new DBConnector();
	}
	
	public EmployeeDTO getOne(Integer employee_id) throws SQLException {
		
		EmployeeDTO employeeDTO = null;
		
		Connection con = dbConnector.getConnect();
		
		// 2. SQL Query 문 작성
		String sql = "SELECT * FROM employees WHERE employee_id = ? ";
		
		// 3. 작성한 SQL Query를 미리 전송
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, employee_id);
		
		// 4. ? 값을 세팅, 없으면 통과
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getDate("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getInt("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
		}	
		
		rs.close();
		st.close();
		con.close();
		
		
		return employeeDTO;
	}
	
	public List<EmployeeDTO> getList() throws SQLException{
		
		ArrayList<EmployeeDTO> list = new ArrayList<EmployeeDTO>();
		
		// 1. DB에 로그인
				Connection con = dbConnector.getConnect();
				
				// 2. SQL Query 문 작성
				String sql = "SELECT * FROM employees";
				
				// 3. 작성한 SQL Query를 미리 전송
				
				PreparedStatement st = con.prepareStatement(sql);
				
				
				// 4. ? 값을 세팅, 없으면 통과
				// 5. 최종 전송 후 결과 처리
				ResultSet rs = st.executeQuery();
				
				//dbConnector.getConnect().prepareStatement("SELECT * FROM departments").excuteQuery();
				
				while(rs.next()) {
					EmployeeDTO employeeDTO = new EmployeeDTO();
					employeeDTO.setEmployee_id(rs.getInt("employee_id"));
					employeeDTO.setFirst_name(rs.getString("first_name"));
					employeeDTO.setLast_name(rs.getString("last_name"));
					employeeDTO.setEmail(rs.getString("email"));
					employeeDTO.setPhone_number(rs.getString("phone_number"));
					employeeDTO.setHire_date(rs.getDate("hire_date"));
					employeeDTO.setJob_id(rs.getString("job_id"));
					employeeDTO.setSalary(rs.getInt("salary"));
					employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
					employeeDTO.setManager_id(rs.getInt("manager_id"));
					employeeDTO.setDepartment_id(rs.getInt("department_id"));
					list.add(employeeDTO);
					
				}
				rs.close();
				st.close();
				con.close();
	
				return list;
		}
	
	
}
