package com.study.s1.region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.study.s1.util.DBConnector;

public class RegionDAO {
	
	private DBConnector dbConnector;
	private Scanner sc;
	public RegionDAO() {
		dbConnector = new DBConnector();
		sc = new Scanner(System.in);
	}
	
	public int setUpdate(RegionDTO regionDTO)throws Exception {
	
		Connection con = dbConnector.getConnect();
		String sql = "UPDATE REGIONS SET REGION_NAME = ? WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, regionDTO.getRegion_name());
		st.setLong(2, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	
	public int setDelete(RegionDTO regionDTO)throws Exception {
		
		Connection con = dbConnector.getConnect();
		String sql = "DELETE REGIONS WHERE REGION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, regionDTO.getRegion_id());
		
		int result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	
	public int setInsert(RegionDTO regionDTO)throws Exception {
		// 1. DB 연결
		Connection con =dbConnector.getConnect();
		
		//java는 기본적으로 auto commit
		//auto commit 해제 
		// 2. SQL Query문 생성
		String sql = "INSERT INTO REGIONS ( REGION_ID , REGION_NAME ) VALUES ( ? , ? ) ";
		// 3. 미리 던지기
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 세팅
		st.setLong(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		
		// 6. 자원 해제
		st.close();
		con.close();
		
		return result;
	}
	
	
}
