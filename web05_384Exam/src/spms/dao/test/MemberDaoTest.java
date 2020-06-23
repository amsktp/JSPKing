package spms.dao.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import spms.dao.MemberDao;
import spms.dto.MemberDto;

public class MemberDaoTest {

	@Test
	public void testMemberBatchDelete() throws Exception {

		Connection conn = null;

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jsp";
		String password = "jsp12";

		Class.forName(driver);

		conn = DriverManager.getConnection(url, user, password);

		MemberDao memberDao = new MemberDao();
		memberDao.setConnection(conn);

		List<MemberDto> memberList = memberDao.selectList();

		ArrayList<MemberDto> myParamList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			myParamList.add(memberList.get(i));
		}
		
		int[] resultNumArr = memberDao.memberBatchDelete(memberList);
		
		int[] expecteds = new int[] {
				-2, -2, -2
		};
		
		assertArrayEquals(expecteds, resultNumArr);
		
		
		
	
//		List<MemberDto> resultList = memberDao.selectList();
//		System.out.println(memberList.size()-3 + " : " + resultList.size());
		
//		assertEquals(memberList.size()-3, resultList.size());
		
		
		
//		assertArrayEquals이 완벽하게 일치되는지 확인
//		assertEquls 하나만 비교
//		assertFalse 아니면 true
//		assert
		
		
	}

}
