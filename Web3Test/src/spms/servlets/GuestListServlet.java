package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션 - 아주 강력한 주석
//@WebServlet("/guest/list")
public class GuestListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// java.sql 안에 있는 걸로 해야함
		// 서블릿은 항상 5개를 만들어야 하므로 제너릭 서블릿으로 만들면 서비스만 만들면 됨

		// jdbc란 Java DataBase Connectivity

		// jdbc는 6개의 순서를 지켜야만 한다

		// 선언은 큰 순부터 선언해준다 conn -> stmt -> rs

		Connection conn = null; // 연결
		Statement stmt = null; // 상태
		ResultSet rs = null; // 결과

		ServletContext sc = this.getServletContext();

		// 사용할 jdbc:드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String url = sc.getInitParameter("url");
		String user = sc.getInitParameter("user");
		String password = sc.getInitParameter("password");
		String driverUrl = sc.getInitParameter("driver");

		try {
			// 클래스 로드
			// 1. jdbc드라이버 등록

			// 우리가 가져온 jdbc파일의 클래스.파일명
			Class.forName(driverUrl);

			// 2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);

			// 3. sql 실행 객체 준비
			stmt = conn.createStatement();

			String sql = "SELECT MNO, MNAME, EMAIL, CRE_DATE, mod_date, user_id, sal" + " FROM guest"
					+ " ORDER BY MNO ASC";

			// sql 실행문
			// 4. 결과 가져오기
			rs = stmt.executeQuery(sql);

			res.setContentType("text/html");

			res.setCharacterEncoding("UTF-8");

			PrintWriter out = res.getWriter();

			String htmlStr = "";

			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");

			// 추가 버튼
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";

			// 5. 출력
			// rs는 length나 size가 없다. 무조건 next()로만 가능
			while (rs.next()) {

				htmlStr += rs.getInt("mno") + ",";
				htmlStr += "<a href='./update?mNo=" + rs.getInt("mNo") + "'>";
				htmlStr += rs.getString("mname");
				htmlStr += "</a>" + ",";
				htmlStr += rs.getString("email") + ",";
				htmlStr += rs.getDate("cre_date") + ",";
				htmlStr += rs.getString("user_id") + ",";
				htmlStr += rs.getInt("sal");
				htmlStr += "<input type='button' value='회원탈퇴' onclick='location.href=\"./delete?mNo=" + rs.getInt("mNo") + "\"'>";
				htmlStr += "<br/>";
			}

			htmlStr += "</body></html>";

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
	} // service end
}
