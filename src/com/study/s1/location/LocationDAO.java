package com.study.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.study.s1.util.DBConnector;

public class LocationDAO {
	
	

	private DBConnector dbConnector;
	
	public LocationDAO() {
		dbConnector = new DBConnector();
	}
	
	public LocationDTO getOne(Integer location_id) throws SQLException {
		LocationDTO locationDTO = null;
		//1. DB login
		Connection con = dbConnector.getConnect();
		//2. SQL Query
		String SQL = "SELECT * FROM locations WHERE location_id = ? ";
		//3. Query send
			PreparedStatement st = con.prepareStatement(SQL);
		//4. ? setting
			//st.set데이터타입(int index, 값); 
			//index는 ? 의 순서 번호
			//그러나 oracle은 1번부터 시작
			st.setInt(1, location_id);
		//5. result set		
		ResultSet rs = st.executeQuery();
		if(rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
		}	
		
		//6. resource close
		rs.close();
		st.close();
		con.close();
		
		return locationDTO;
	}
	
	public List<LocationDTO> getList() throws Exception {
		ArrayList<LocationDTO> arrayList = new ArrayList<>();
		//1. DB 로그인
		
		Connection con = dbConnector.getConnect();
		//2. SQL Query문 생성
		String sql = "SELECT * FROM locations";
		//3. Query 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();
		//4. ? 세팅
		
		//5. 최종 전송 후 결과 처리
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			arrayList.add(locationDTO);
		}
		
		
		//6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		return arrayList;
	}
	
}
