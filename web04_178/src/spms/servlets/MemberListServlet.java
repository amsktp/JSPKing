package spms.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MemberListServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//java.sql 안에 있는 걸로 해야함
		//서블릿은 항상 5개를 만들어야 하므로 제너릭 서블릿으로 만들면 서비스만 만들면 됨
		
		//jdbc란 Java DataBase Connectivity

		//jdbc는 6개의 순서를 지켜야만 한다
		
		//선언은 큰 순부터 선언해준다 conn -> stmt -> rs
		
		Connection conn = null;	//연결
		Statement stmt = null;	//상태
		ResultSet rs = null;	//결과

		
		//사용할 jdbc:드라이버:드라이버 타입:서버주소와 포트:db서비스 아이디
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String user = "jsp";
		String password = "jsp12";

		try {
			//클래스 로드
			//1. jdbc드라이버 등록
			
			//우리가 가져온 jdbc파일의 클래스.파일명
			Class.forName("oracle.jdbc.driver.OracleDriver");

			//2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			
			//3. sql 실행 객체 준비
			stmt = conn.createStatement();
			
			String sql = "select mno, mname, email, cre_date" + 
						" from member" + 
						" order by mno asc";

			//sql 실행문
			//4. 결과 가져오기
			rs = stmt.executeQuery(sql);

			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");

			PrintWriter out = response.getWriter();

			String htmlStr = "";
			
			
			out.println("<html><head><title>회원목록</title></head>");
			out.println("<body><h1>회원목록</h1>");
			
			//추가 버튼
			htmlStr += "<p>";
			htmlStr += "<a href='./add'>신규 회원";
			htmlStr += "</a>";
			htmlStr += "</p>";
			
			out.println(htmlStr);
			
			
			//5. 출력
			//rs는 length나 size가 없다. 무조건 next()로만 가능
			while (rs.next()) {
				out.println(
					rs.getInt("mno") + "," + 
					rs.getString("mname") + "," + 
					rs.getString("email") + "," + 
					rs.getDate("cre_date") + "<br/>"
				);
			}

			out.println("</body></html>");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6. 자원 해제
			
			//무조건 해제하는 순서는 rs -> stmt -> conn (작은순)
			
			//결과셋 해제
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			//상태 해제
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

			//연결 해제
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
