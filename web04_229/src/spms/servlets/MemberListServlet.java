package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 - 아주 강력한 주석
@WebServlet("/member/list")

//어노테이션에서 initParams 하기
//@WebServlet(
//	urlPatterns = ("/member/list"),
//	initParams = {
//		@WebInitParam(name="driver", value="oracle.jdbc.driver.OracleDrvier"),
//		@WebInitParam(name="url", value="jdbc:oracle:thin:@localhost:1521:xe"),
//		@WebInitParam(name="user", value="jsp"),
//		@WebInitParam(name="password", value="jsp12")
//	}
//)
public class MemberListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// java.sql 안에 있는 걸로 해야함
		// 서블릿은 항상 5개를 만들어야 하므로 제너릭 서블릿으로 만들면 서비스만 만들면 됨

		// jdbc란 Java DataBase Connectivity

		// jdbc는 6개의 순서를 지켜야만 한다

		// 선언은 큰 순부터 선언해준다 conn -> stmt -> rs

		Connection conn = null; // 연결
		Statement stmt = null; // 상태
		ResultSet rs = null; // 결과

		// 사용할 jdbc:드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		String user = "jsp";
		String password = "jsp12";

		try {
			// 클래스 로드
			// 1. jdbc드라이버 등록

			// 우리가 가져온 jdbc파일의 클래스.파일명
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);

			// 3. sql 실행 객체 준비
			stmt = conn.createStatement();

			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE" + " FROM MEMBER" + " ORDER BY MNO ASC";

			// sql 실행문
			// 4. 결과 가져오기
			rs = stmt.executeQuery(sql);

			res.setContentType("text/html");
			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();
			String htmlStr = "";

			htmlStr += "<html><head><title>회원목록</title></head>";
			htmlStr += "<body><h1>회원목록</h1>";

			// 추가 버튼
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";

			// 5. 출력
			// rs는 length나 size가 없다. 무조건 next()로만 가능
			while (rs.next()) {
						
						htmlStr += rs.getInt("mno") + "," ;
						htmlStr += "<a href='./update?mNo=" + rs.getInt("mNo") + "'>";
						htmlStr += rs.getString("mname") ;
						htmlStr += "</a>" + "," ;
						htmlStr += rs.getString("email") + ",";
						htmlStr += rs.getDate("cre_date") ;
						htmlStr += "<input type='hidden' name='mNo' value='" + rs.getInt("mno") + "'>";
						htmlStr += "<a href='./delete?mNo=" + rs.getInt("mNo") + "'>";
						htmlStr += "<input type='submit' value='회원탈퇴'>" ;
						htmlStr += "</a>" + "," ;
						htmlStr += "<br/>";
			}

			htmlStr +="</body></html>";
			
			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 6. 자원 해제

			// 무조건 해제하는 순서는 rs -> stmt -> conn (작은순)

			// 결과셋 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			// 상태 해제
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			// 연결 해제
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		} // finally 종료
	} // doget end

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		req.setCharacterEncoding("UTF-8");

		Connection conn = null;
		PreparedStatement pstmt = null;

		ServletContext sc = this.getServletContext();

		String driver = sc.getInitParameter("driver");
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		
		int mNo = Integer.parseInt(req.getParameter("mNo"));

		String sql = "";

		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드");

			conn = DriverManager.getConnection(url, user, password);

			sql += "delete from member ";
			sql += "where mno = ?";

			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mNo);

			// 이 순간 이미 데이터베이스에 반영됨
			pstmt.executeUpdate();

			res.sendRedirect("./list");

//			res.setContentType("text/html");
//			res.setCharacterEncoding("UTF-8");
//
//			PrintWriter out = res.getWriter();
//
//			String htmlStr = "";
//
//			htmlStr += "<html><head><title>회원정보 수정</title>";
//			htmlStr += "</head>";
//			htmlStr += "<body>";
//			htmlStr += "<p>수정 성공입니다.!</p>";
//			htmlStr += "<a href='list'>";
//			htmlStr += "<input type='button' value='리스트 이동'>";
//			htmlStr += "</a>";
//			htmlStr += "</body></html>";
//			
//			out.println(htmlStr);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (conn != null) {

				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

	}

}
