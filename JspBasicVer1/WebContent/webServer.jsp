<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	웹 용어
	
	서버(server)와 클라이언트(client)
	
	문제를 해결해 달라고 요청하는 쪽이 클라이언트
	문제를 해결해서 올려보내는 쪽이 서버다
	
	요청(request)/응답(response)
		클라이언트가 서버에게 문제를 해결해달라고 요구하는 행위는 요청(request)라고 한다.
		반대로 서버가 문제를 해결해서 클라이언트에게 보여주는 행위는 응답(response)라고 한다.
	
	따라서 웹 브라우저가 클라이언트이고, 웹 서버는 서버라 할 수 있다.
	
	프로토콜(protocol, 규약, 규칙, 약속)
	
	서버쪽에서 문제를 제대로 해결했는지 실패했는지에 따라 약속된 값을
	클라이언트로 보낼 수 있는데 이를 응답 상태코드(status code)라고 한다.
	 
	상태코드	상태설명
	200		요청이 성공적으로 처리되었다
	400		잘못된 요청이다
	404		요청한 자원을 못 찾았다, 서버가 요청한 파일이나 스크립트를 찾지 못함
			경로가 잘못되거나 없는 jsp/servlet을 호출
	405		메서드 적용 안됨 -> doGet()이 없는데 GET방식으로 호출
	500		서버 내부에서 오류가 발생하였다 -> 문법오류 등 서버코드에서 문제 발생
	
	웹 서버(Web Server)
		웹 서버는 서버쪽 컴퓨터에 있는 소프트웨어이다.
		클라이언트의 요청을 받아서 웹 페이지
		(html, 그림파일, css, 자바스크립트 등으로 구성된 문서)를
		클라이언트인 웹 브라우저에 응답하는 역할을 한다.
	
	HTTP(Hypertext Transfer Protocol)
		웹 서버에서 서버-클라이언트 사이에 대화(request/response)를 할 수 있도록
		만든 규약이다.
	
		HTTP는 헤더(header)와 바디(body)로 구성된다.
		서버의 간단한 정보, 응답 내용의 타입 및 인코딩, 응답 크기 등이 포함된다.
		응답헤더가 브라우저에게 전달되면 응답바디 내용이 브라우저에게 출력된다.	
	
	FTP(File Transfer Protocol)
		클라이언트와 서버간에 파일을 주고받기 위해 만든 통신규약 입니다.
	
	Telnet
		인터넷이나 LAN(Local Area NetWork) 상에서 문자 기반으로
		원격의 컴퓨터를 제어하기 위해 만든 통신 규약입니다.
		요즘은 보안 때문에 SSH(Secure Shell) 프로토콜 기반 원격 접속
		프로그램을 주로 사용합니다.
	
	SMTP(Simple Mail Transfer Protocol)
		인터넷 상에서 메일을 보내기 위한 통신 규약입니다.
		
	POP3(Post Office Protocol version 3)
		 이메일을 가져오는데 사용하는 통신 규약이며
		 POP3는 이메일을 가져온 후
		 서버의 메일을 삭제합니다.
		 
	IRC(Internet Relay Chat)
		실시간 채팅을 위해 만든 통신 규약입니다.
			 
	
</body>
</html>