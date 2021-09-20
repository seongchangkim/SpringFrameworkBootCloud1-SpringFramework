<h1>웹 드라이브 프로그램</h1>

<h2>개발환경</h2>
# Front-End<br>
● HTML5<br>
● CSS3<br>
● JavaScript(ES6)<br>
● Bootstrap 4.0<br>
● jQuery 3.6.0<br>
<br>
# Back-End<br>
● Java 11<br>
● Servlet 3.1.0<br>
● JSP 2.3<br>
● Tomcat 9.0.41<br>
● Mysql 8.0.22<br>
● Spring Framework 5.0.2<br>
● MyBatis 1.3.2<br>
● Spring Security 5.0.2<br>
● Maven 2.9<br>
<br>

# 설계 구조<br> 
![1](https://user-images.githubusercontent.com/74657556/133912052-95680412-f7b4-4b27-8b30-bff8cd64743c.JPG)

![1](https://user-images.githubusercontent.com/74657556/133912094-263ff7df-a3fe-400b-a637-ccb11158343a.png)

<h3># Back-End</h3>
1). 회원 가입<br>
● 아래 사진은 회원가입 화면을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133960793-f6bd69e1-7018-4f1c-a002-53e06be04eb8.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 회원가입 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133960822-922944f6-c877-48f5-9c17-c05b7a4ab334.png" width="400" height="150"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 회원가입 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133960825-fb555e1b-f18d-43a3-9ac2-8b3dc43d069e.png" width="200" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 회원가입 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133960832-77c43d6f-e364-40fb-9d3e-62e4f01da86f.png" width="400" height="200"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 회원가입 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133960834-baa37f0c-ed1d-4018-8764-a30e987f24d1.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 회원가입 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133960836-ce08f2a5-4f1c-4448-b0ed-8b7d9ec9ed72.png" width="400" height="100"><br>
<br>

<설명>
- 매퍼 메서드 : register(),registerAuth()
- 회원가입 페이지에서 입력한 정보를 입력하고 회원 가입을 하면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 회원 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 DB에 삽입하여 입력한 데이터를 데이터베이스에 저장합니다.  
<br>
2). 로그인<br>
● 아래 사진은 로그인 화면을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133965019-df54ad03-2d00-482d-9fa2-52d3bf19291c.png" width="400" height="200"><br>
<br>
● 아래 사진은 spring security를 설정한 xml파일의 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133965372-911628bc-0920-4b11-8070-959afa20ac13.png" width="1000" height="1000"><br>
<br>
● 아래 사진은 CustomLoginSuccessHandler라는 java파일에 로그인 성공 시 처리하는 메소드입니다. <br>
<img src="https://user-images.githubusercontent.com/74657556/133965884-6eab2990-e17c-4791-baf0-854588877e89.png" width="400" height="200"><br>
<br>
● 아래 사진은 권한이 ROLE-USER일 때 로그인 처리 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133966313-bd3dbd29-a01d-4879-ad74-febb8d126281.png" width="400" height="200"><br>
<br>
● 아래 사진은 권한이 ROLE-ADMIN일 때 로그인 처리 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/133966347-88bfd71a-4e8e-4df8-949b-bec89645a3b1.png" width="400" height="200"><br>
<br>

<설명> 
- 사용자가 로그인 요청 시 security-context에서 설정한 url로 보내게 됩니다. 로그인 성공할 경우, 사용자 정보를 가져와서 세션에 저장합니다. 그리고 사용자 권한을 가져옵니다. 
- 사용자 권한에 따라 메인 페이지를 다르고 각 권한의 페이지를 이용할 수 있도록 웹 서버와 네트워크 연결을 유지하게 됩니다. 






