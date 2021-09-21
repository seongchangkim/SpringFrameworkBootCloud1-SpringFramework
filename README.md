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
<설명><br>
● 매퍼 메서드 : register(),registerAuth()<br>
● 회원가입 페이지에서 입력한 정보를 입력하고 회원 가입을 하면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 회원 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 DB에 삽입하여 입력한 데이터를 데이터베이스에 저장합니다.  
<br>
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

<설명><br> 
● 사용자가 로그인 요청 시 security-context에서 설정한 url로 보내게 됩니다. 로그인 성공할 경우, 사용자 정보를 가져와서 세션에 저장합니다. 그리고 사용자 권한을 가져옵니다.<br>
● 사용자 권한에 따라 메인 페이지를 다르고 각 권한의 페이지를 이용할 수 있도록 웹 서버와 네트워크 연결을 유지하게 됩니다.<br>
<br>
3). 아이디 찾기<br>
● 아래 사진은 아이디 찾기 화면을 스타일 적용한 화면입니다.(참고로 주어진 값을 입력되어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134134755-ed2fab1e-7d79-45f3-a4a0-c8c13cd69db2.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 아이디 찾기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134132501-9e648b7c-e0ac-47bb-881a-92e491bbd15d.png" width="500" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 아이디 찾기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134132723-8c8b71ef-1607-48a1-bbe8-84f73a90dd75.png" width="400" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 아이디 찾기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134132955-d43e0a53-c04a-4f35-8923-0908125a0d4a.png" width="400" height="75"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 아이디 찾기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134133173-df7d4b31-e681-47d0-8e64-915d3846474b.png" width="700" height="25"><br>
<br>
● 아래 사진은 xml에서 아이디 찾기 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134133320-3cc294ba-507a-4930-bc81-aa03f3791fa9.png" width="400" height="50"><br>
<br>
● 아래 사진은 아이디 찾기 기능을 처리한 결과 페이지입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134133663-1f154e7a-4bf5-4927-bbdc-d720d1fa8d23.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : findingIdProcess()<br> 
● 아이디 찾기에서 찾고자 아이디에 대한 입력 정보를 입력하고 아이디 찾기를 클릭하면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 회원 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에 있는 데이터를 조회하여 아이디 처리결과 페이지로 이동하여 찾고자 ID를 찾을 수 있습니다. 
<br>
<br>
4). 비밀번호 찾기 & 변경<br>
● 아래 사진은 비밀번호 찾기 화면을 스타일 적용한 화면입니다.(참고로 주어진 값을 입력되어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134135274-a28fde45-38bb-4ca6-806b-e74c96017a9e.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 비밀번호 찾기 & 변경 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134135475-315171b4-41bf-41ec-97dc-6e9a51d29e81.png" width="800" height="400"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 비밀번호 찾기 & 변경 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134136190-3c2a90f5-f190-49f3-a52f-2ae807e2e392.png" width="500" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 비밀번호 찾기 & 변경 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134135920-01f59550-4d51-4d2b-8e35-e61faaea55b4.png" width="500" height="100"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 아이디 찾기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134136331-004ceb95-c86c-41ee-ac19-59e32036d300.png" width="700" height="50"><br>
<br>
● 아래 사진은 xml에서 아이디 찾기 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134136416-2967e2a5-34e4-48b8-9180-d205e93b13c8.png" width="400" height="100"><br>
<br>
● 아래 사진은 CustomPasswordEncoder 클래스를 만들어서 입력한 비밀번호와 인코딩된 비밀번호를 비교하는 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134136748-ef4ed171-d208-4a91-b0ad-543fedf3139e.png" width="400" height="50"><br>
<br>
● 아래 사진은 비밀번호 변경 화면을 스타일 적용한 화면입니다.(참고로 주어진 값을 입력되어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134137685-a9d125ca-982f-4ab4-b2bb-e859d2be2cb7.png" width="400" height="200"><br>
<br>
● 아래 사진은 비밀번호 변경 기능을 처리한 결과 페이지입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134137807-8c58ff8a-ef94-4ae8-b957-559ea7e61ba4.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : findingPassword(), isUpdatePassword()
<br> 
● 비밀번호 찾기에서 찾기 원하는 비밀번호에 대한 입력 정보를 입력하고 비밀번호 찾기를 클릭하면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 회원 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에 있는 데이터를 조회하여 찾고자 비밀번호가 있으면 비밀번호 변경 페이지로 이동하고 없으면 다시 비밀번호 찾기 페이지로 돌아갑니다. 
<br>
● 비밀번호 변경에서 변경하고자 비밀번호를 입력하고 비밀번호 변경을 클릭하면 입력한 데이터를 가지고 URL 요청을 보냅니다. 만약 입력한 비밀번호과 DB에서 저장된 비밀번호(비밀번호 찾기 처리 과정에서 비밀번호 변경 페이지에 찾기 원하는 비밀번호를 가져왔고 그것을 요청한 값을 보냈습니다.) 이 일치하지 않으면 URL이 일치하는 컨트롤러에서 비밀번호 변경 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에 있는 데이터를 수정하여 비밀번호 변경 처리 결과 페이지로 이동하고 그렇지 못하면 비밀번호 변경 페이지로 돌아갑니다.
<br><br>
5). 회원 수정(feat. 비밀번호 확인)<br>
● 아래 사진은 회원정보 화면을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134138472-7ae6de1a-033f-45c7-a515-dbc39c7400f6.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 회원 수정 기능을 구현한 코드입니다.(비밀번호 확인 기능도 들어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134139076-71e40434-791c-4484-863b-811546e80bfb.png" width="800" height="400"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 회원 수정 기능을 구현한 코드입니다.(비밀번호 확인 기능도 들어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134138871-0bdfa689-bb38-4110-a2c9-d20445225774.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 회원 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134139318-2d57ef02-894d-4fba-9561-07e37a785521.png" width="300" height="50"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 회원 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134139530-2a11aac5-5c75-4db6-821f-0e8ebf2a113a.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 회원 수정 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134139825-021a1256-980c-42f5-9897-9fa9fbd6997c.png" width="200" height="100"><br>
<br>
● 아래 사진은 CustomPasswordEncoder 클래스를 만들어서 입력한 비밀번호와 인코딩된 비밀번호를 비교하는 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134136748-ef4ed171-d208-4a91-b0ad-543fedf3139e.png" width="400" height="50"><br>
<br>
● 아래 사진은 비밀번호 확인 화면을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134141237-83e0dbc0-28c6-4a45-b705-9eb380c0ebe5.png" width="400" height="200"><br>
<br>
● 아래 사진은 비밀번호 확인 페이지에서 일치한 비밀번호 입력한 후 회원 수정 화면을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134140427-5f64722a-1b7a-44b0-ba92-e5fee0b0beb0.png" width="400" height="200"><br>
<br>
● 아래 사진은 회원 수정 화면에서 수정할 값을 입력하여 회원 정보 수정 처리 결과 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134141590-e2714916-6175-48ba-b539-428f373901d4.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : updateUserInfo()
<br>
● 사용자가 회원 정보에서 회원 수정 버튼을 누르면 비밀번호 확인 페이지로 이동해서 비밀번호를 입력해서 비밀번호 확인을 누르면 CustomPasswordEncoder 클래스의 matches() 메서드를 통해 인코딩된 비밀번호와 일치하는지 확인하고 일치하면 회원수정 페이지로 이동하고 일치하지 않으면 비밀번호 확인 페이지로 돌아가게 됩니다.<br>
● 다시 회원 수정 페이지에서 회원 정보 수정할 값을 입력하고 회원 수정을 클릭하면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 회원 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에 있는 데이터를 수정하여 회원정보 페이지로 리다이렉트를 됩니다.
<br>
<br>



