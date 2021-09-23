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
● 아래 사진은 회원가입을 스타일 적용한 화면입니다.<br>
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
● 아래 사진은 아이디 찾기 스타일 적용한 화면입니다.(참고로 주어진 값을 입력되어 있습니다.)<br>
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
● 아래 사진은 비밀번호 찾기를 스타일 적용한 화면입니다.(참고로 주어진 값을 입력되어 있습니다.)<br>
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
● 아래 사진은 회원정보를 스타일 적용한 화면입니다.<br>
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
6). 회원 삭제(feat. 비밀번호 확인)<br>
● 아래 사진은 회원정보 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134271465-a89609ff-1a67-4f1a-bd90-9c6e0c8bb4ee.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 회원 삭제 기능을 구현한 코드입니다.(비밀번호 확인 기능도 들어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134271509-5fc8ac18-03c8-43ea-8445-6194a428ef97.png" width="800" height="400"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 회원 삭제 기능을 구현한 코드입니다.(비밀번호 확인 기능도 들어 있습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134271560-11e88871-d324-4bde-a22e-4b5922597cf8.png" width="300" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 회원 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134271636-de742003-2045-4806-857a-ce157c32e3aa.png" width="400" height="150"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 회원 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134271838-d99e5623-2fe8-401d-ba06-192f836dc11e.png" width="400" height="50"><br>
<br>
● 아래 사진은 xml에서 회원 삭제 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134271894-3456a8aa-3f2a-4500-b2bf-f2affdfbb8a3.png" width="300" height="125"><br>
<br>
● 아래 사진은 CustomPasswordEncoder 클래스를 만들어서 입력한 비밀번호와 인코딩된 비밀번호를 비교하는 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134136748-ef4ed171-d208-4a91-b0ad-543fedf3139e.png" width="400" height="50"><br>
<br>
● 아래 사진은 비밀번호 확인 화면을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134141237-83e0dbc0-28c6-4a45-b705-9eb380c0ebe5.png" width="400" height="200"><br>
<br>
● 아래 사진은 회원 수정 화면에서 수정할 값을 입력하여 회원 정보 수정 처리 결과 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134275656-8a950bff-f283-4cb4-a417-c00e279cd93a.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : deleteUserInfo(), deleteUserAuth()
<br>
● 사용자가 회원 정보에서 회원 삭제 버튼을 누르면 비밀번호 확인 페이지로 이동해서 비밀번호를 입력해서 비밀번호 확인을 누르면 CustomPasswordEncoder 클래스의 matches() 메서드를 통해 인코딩된 비밀번호와 일치하는지 확인하고 일치하면 DB에서 있는 해당 테이블의 데이터를 삭제하고 세션값을 삭제하여 자동 로그아웃가 되어 로그인 페이지로 리다이렉트가 되고 일치하지 않으면 비밀번호 확인 페이지로 돌아가게 됩니다. 
<br>
<br>
7). 회원 목록(관리자 페이지)<br>
● 아래 사진은 메인 페이지(관리자 전용)을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134276534-fc6e0e57-4318-4713-83b8-bbb00b16659f.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 회원 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134276585-710b1e6d-f255-4879-848d-57cf16aca5c6.png" width="300" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 회원 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134276716-48649ea1-c9db-41e4-ba9c-dfa56f91d309.png" width="200" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 회원 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134276794-5b6669c8-f48d-4e9d-8bb6-e4f7fe70f08d.png" width="200" height="50"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 회원 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134276889-b00e0898-b6b7-4be3-a818-07637431192d.png" width="300" height="25"><br>
<br>
● 아래 사진은 xml에서 회원 목록 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134276957-96efda9b-fbb7-4607-818c-eb4564496580.png" width="400" height="50"><br>
<br>
● 아래 사진은 회원 목록 페이지입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277742-15016afc-ca3b-4203-9454-bc724b0e1e18.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : userList()<br>
● 관리자가 회원 관리 메뉴를 누르면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 관리자 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에서 해당 조건을 조회하여 데이터를 보냅니다. 그래서 조회된 데이터들을 가져와서 웹 페이지를 처리합니다. 
<br>
<br>
8). 다른 회원 상세보기(관리자 페이지)<br>
● 아래 사진은 회원 목록을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277333-13b5cc3e-4b0d-413e-a562-32e157b1deaa.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 다른 회원 상세보기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277523-65b6578a-bd92-4003-b25a-a4458d78fe42.png" width="300" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 다른 회원 상세보기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277563-b5207321-b770-4837-8976-c8490904b536.png" width="200" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 다른 회원 상세보기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277585-a076a818-01ef-4735-af1c-9382591eb3cf.png" width="200" height="50"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 다른 회원 상세보기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277620-c1d98d17-5eba-4270-91ae-075dca801664.png" width="300" height="25"><br>
<br>
● 아래 사진은 xml에서 다른 회원 상세보기 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277883-cbc5b203-d887-4411-a2da-98d476697ff3.png" width="400" height="50"><br>
<br>
● 아래 사진은 해당 특정 회원 상세보기 페이지입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277964-2a03df82-7135-4f48-9551-b4ac4927b6f3.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : selectUserInfoDetail()<br>
● 관리자가 회원 목록에서 해당 id에 있는 상세보기 링크를 클릭하면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 관리자 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에서 해당 조건을 조회하여 데이터를 보냅니다. 그래서 조회된 데이터들을 가져와서 웹 페이지를 처리합니다. 
<br>
<br>
9). 다른 회원 수정(관리자 페이지)<br>
● 아래 사진은 다른 회원 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134278092-93ebbb6b-20d1-4b89-b406-cc0a0282d9c0.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 다른 회원 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134278515-f8eaaa01-bc84-4b2f-b17d-914c9b186f19.png" width="300" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 다른 회원 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134278544-43e7cf22-fe99-4576-85b3-19363d3d0b8a.png" width="200" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 다른 회원 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134278562-46992be5-2e02-48bf-ac5a-fbcd6cd49dbe.png" width="200" height="50"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 다른 회원 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134277620-c1d98d17-5eba-4270-91ae-075dca801664.png" width="300" height="25"><br>
<br>
● 아래 사진은 xml에서 다른 회원 수정 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134278662-eae79d3e-ccd8-4b18-ad79-ac89b4307a4e.png" width="400" height="100"><br>
<br>
● 아래 사진은 다른 회원 수정 기능 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134278856-1ea95a23-c0ed-4493-9d3d-86723431874a.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : updateUserInfo()
<br>
● 관리자가 해당 id의 회원 정보에서 입력할 값을 수정하여 회원 수정 버튼을 누르면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 관리자 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에 있는 데이터를 수정하여 회원목록 페이지로 이동합니다.
<br>
<br>
10). 다른 회원 삭제(관리자 페이지)<br>
● 아래 사진은 회원 목록을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279071-4ad079d9-bf8b-470f-bf98-b7832b679179.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 다른 회원 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279230-82d9b479-0a22-4378-bfd8-8abddb8bca8f.png" width="300" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 다른 회원 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279255-65253157-21db-446b-862a-78477d0ba281.png" width="200" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 다른 회원 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279282-f0ea02e3-0524-4020-9661-8bf0fc33e103.png" width="200" height="50"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 다른 회원 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279312-22276341-3ba9-4443-a42d-70d3fa13accb.png" width="300" height="25"><br>
<br>
● 아래 사진은 xml에서 다른 회원 삭제 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279334-e6d2570c-2935-40c3-9962-8c8ae6883df6.png" width="400" height="100"><br>
<br>
● 아래 사진은 다른 회원 삭제 기능 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134279940-e34e0524-dd6c-4837-8035-e536af8eec87.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : deleteUserInfo()
<br>
● 관리자가 회원 목록에서 해당 id의 삭제 링크을 클릭하면 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 관리자 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문울 통해서 해당 테이블에 있는 데이터를 삭제하여 회원목록 페이지로 이동합니다.
<br>
<br>
11). 게시판 등록 <br>
● 아래 사진은 게시판 등록을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134280145-5e8f7dda-2892-46e9-80e8-dfdcef1b7733.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 게시판 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134280204-cfa67c3e-1f2c-41f3-b799-0987ef747236.png" width="600" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 게시판 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134280322-154e42b8-933b-4c4f-9896-f26244363d7b.png" width="600" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 게시판 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134280348-091dfff8-1d3f-4cd5-8cbf-3e9baf556983.png" width="600" height="150"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 게시판 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134280384-7fc95ae6-250c-4bea-bae1-499ae6ee0386.png" width="300" height="50"><br>
<br>
● 아래 사진은 xml에서 게시판 등록 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134280583-ed531542-9ac4-4e83-9670-a9f1741ff410.png" width="400" height="200"><br>
<br>
● 아래 사진은 게시판 등록 기능을 처리한 화면입니다.(게시판 목록 페이지로 리다이렉트했습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134280648-55d7c784-aff5-4136-ae2a-e60e6ffc9343.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : add(),addFile()
<br>
● 사용자가 게시판 등록 페이지에서 입력할 데이터를 입력하여 게시판 등록을 누르면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 게시물 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 추가하여 게시판 목록 페이지로 리다이렉트합니다.
<br>
<br>
12). 게시판 목록 및 검색<br>
● 아래 사진은 메인 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134445970-e60ab4c4-2c5e-4e07-99b3-c431b7d32a9a.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 게시판 목록 및 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134446117-d5fc7bdb-83f6-452a-83d2-d850c2327b36.png" width="400" height="200"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 게시판 목록 및 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134446263-cabf117e-3e5b-47be-9992-9ff0c31fb934.png" width="300" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 게시판 목록 및 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134446362-fbd58406-429c-4df3-8dd2-9e27b4219f08.png" width="300" height="150"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 게시판 목록 및 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134467127-64b3d289-f294-4616-9523-97f24d9d6a22.png" width="300" height="50"><br>
<br>
● 아래 사진은 xml에서 게시판 등록 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134467229-901bc505-8330-4381-814f-1ec7fbc687da.png" width="400" height="800"><br>
<br>
● 아래 사진은 Criteria라는 DTO 클래스를 만들어서 검색 및 페이지 관련된 URL를 추가하는 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134467751-bf3b9da6-eb2e-477f-98bc-3a999a5b2c13.png" width="500" height="100"><br>
● 아래 사진은 게시판 목록을 이동하는 페이지입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134467846-4a6525b3-39f1-41e6-b600-9485abbd24aa.png" width="400" height="200"><br>
● 아래 사진은 입력한 키워드로 검색하여 게시판 목록 처리 결과를 보여주는 페이지입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134468034-66ad4661-2df9-4481-856c-387ec44cf12b.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : list(), getTotal() 
<br>
● 사용자가 게시판 메뉴를 클릭하면 해당 url 요청을 보냅니다. 컨트롤러에서 게시물 서비스를 처리하게 합니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터들을 조회하여 게시판 목록 페이지로 이동합니다. 
<br>
● 게시판 목록 페이지에서 키워드를 입력하고 검색을 누르면 게시판 목록 들어갈 때 같지만 차이점은 Criteria 클래스에서 getListLink() 메서드를 통해서 자동적으로 url에다 매개변수를 추가합니다. 그리고 다시 게시판 목록 페이지로 리다이렉트합니다.  
<br>
<br>
13). 해당 게시판 상세보기 및 댓글 목록<br>
● 아래 사진은 게시판 목록을 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134468454-44cd6eae-1081-4c8a-9650-72055c3651a8.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 상세보기 및 댓글 목록 능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134468519-3485893a-c4cc-4ee2-a39e-a47beff07827.png" width="600" height="300"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 상세보기 및 댓글 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134468553-c246119c-bcff-4116-a7d1-1c41ec550784.png" width="500" height="150"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 상세보기 및 댓글 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134468620-8dc71dc6-1517-4d60-9d31-6c3ec0215e26.png" width="500" height="300"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 상세보기 및 댓글 목록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134468674-69e5bbd1-d5c8-4d8f-a911-b941f2132e5a.png" width="500" height="150"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 상세보기 및 댓글 목록 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134470101-03a42135-515d-4744-b745-39af9216e7ee.png" width="500" height="400"><br>
<br>
● 아래 사진은 해당 게시판 상세보기 및 댓글 목록 기능을 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134469534-3a79289e-dbbd-43e9-a030-e13f9a977487.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : selectName(), updateReadCount(), selectBoard(), selectBoardFileList(),
selectReplyList() 
<br>
● 사용자가 해당 게시판 제목을 클릭하면 요청한 해당 url 요청을 보냅니다. 컨트롤러에서 게시물 서비스를 처리하게 합니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터들을 조회하여 해당 게시판 첨부파일, 사용자 이름, 해당 게시판 정보 그리고 해당 게시물의 등록된 댓글을 가져옵니다. 해당 게시판 상세보기 페이지로 이동합니다. 그리고 해당 게시물의 조회수가  해당 게시물을 클릭할 때마다 1씩 올라갑니다. 
<br>
<br>
14). 해당 게시판 수정<br>
● 아래 사진은 해당 게시판 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134469709-d75f017c-507b-446b-8132-0c221442ccb1.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134473763-5c298b38-1bed-4c02-a6b0-c26521967e6f.png" width="500" height="150"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134476214-f4a50aa3-c970-4bf1-bac2-cdd2ab553412.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134476617-d43574f1-c21a-4edc-8938-b2e97ef62164.png" width="400" height="100"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134476744-c29e0406-45ec-493b-84f4-4db23a747f3a.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 수정 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134476915-c0e31bff-b0d2-4956-947a-086dbe94994c.png" width="400" height="150"><br>
<br>
● 아래 사진은 해당 게시판 수정 기능을 처리한 화면입니다.(해당 게시판 상세보기 페이지로 리펙토링합니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134469534-3a79289e-dbbd-43e9-a030-e13f9a977487.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : updateBoard()
<br>
● 사용자가 해당 게시물에 수정할 값을 입력하여 수정을 누르면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 게시물 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 수정하여 게시판 목록에 리다이렉트를 합니다. 
<br>
<br>
