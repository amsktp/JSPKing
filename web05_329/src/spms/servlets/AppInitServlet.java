package spms.servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AppInitServlet extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		
		System.out.println("AppInitServlet 준비...");
		super.init();
		
		String driver = "";
		String url = "";
		String user = "";
		String password = "";
		
		Connection conn = null;
		
		try {
			
			ServletContext sc = this.getServletContext();
			
//			driver = sc.getInitParameter("a"); //오류 내기
			driver = sc.getInitParameter("driver");
			url = sc.getInitParameter("url");
			user = sc.getInitParameter("user");
			password = sc.getInitParameter("password");
			
			// 클래스 로드
			// 1. jdbc드라이버 등록

			// 우리가 가져온 jdbc파일의 클래스.파일명
			Class.forName(driver);
			System.out.println("오라클 드라이버 로드 성공");
			
			// 2. 데이터베이스 연결
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 드라이버 연결 성공");

			sc.setAttribute("conn", conn);
			
			System.out.println("DB 연결 성공");
		
		
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("AppInitServlet 마무리...");

		super.destroy();
		
		ServletContext sc = this.getServletContext();
		
		Connection conn = (Connection) sc.getAttribute("conn");
		
		try {
			if(conn != null) {
				conn.close();
				System.out.println("DB 연결 해제");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}
