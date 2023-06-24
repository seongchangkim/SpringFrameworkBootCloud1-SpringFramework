<h1>웹 드라이브 프로그램</h1>

<h2>개발환경</h2>
# Front-End<br>
● HTML5<br>
● CSS3<br>
● JavaScript<br>
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

## API 소개
### 1. User API
|Url|Http Method|기능|Parameter
|:---|:---:|:---:|:---:|
|/cloud/register|POST|회원가입|○id(String)<br/> ○password(String)<br/> ○name(String)<br/> ○email(String)<br/> ○tel(String)<br/>
|/cloud/login|POST|로그인|○id(String)<br/> ○password(String)
|/logout|GET|로그아웃|-
|/cloud/findingId|POST|아이디 찾기|○email(String), ○tel(String), ○name(String),
|/cloud/findingPassword|POST|비밀번호 찾기|○id(String)<br/> ○name(String)<br/> ○email(String)<br/> ○tel(String)<br/> 
|/cloud/updatePassword|POST|비밀번호 수정|○id(String)<br/> ○password(String)<br/> ○v_pw(String)
|/cloud/user/profile|GET|프로필 상세보기|○id(String)<br/>
|/cloud/user/updateUserInfo|POST|프로필 수정|○id(String)<br/> ○name(String)<br/> ○email(String)<br/> ○tel(String)<br/>
|/cloud/user/updateUserInfoPasswordVerify|POST|프로필 수정 비밀번호 확인|○id(String)<br/> ○password(String)
|/cloud/user/deleteUserInfoPasswordVerify|POST|비밀번호 확인 후 회원 탈퇴|○id(String)<br/> ○password(String)
<br/>

### 2. Admin API
|Url|Http Method|기능|Parameter
|:---|:---:|:---:|:---:|
|/cloud/admin/userList|GET|회원 목록(페이징 처리 및 검색)|- 
|/cloud/admin/selectUserInfoDetail|GET|회원 상세보기|○id(String)
|/cloud/admin/profile|GET|관리자 프로필 상세보기|○id(String)
|/cloud/admin/updateUserInfo|POST|회원 수정|○id(String)<br/> ○email(String)<br/> ○name(String)<br/> ○tel(String)<br/>
|/cloud/admin/updateUserInfoYourself|POST|로그인된 회원 수정|○id(String)<br/> ○email(String)<br/> ○name(String)<br/> ○tel(String)<br/>
|/cloud/admin/deleteUserInfo|GET|회원 삭제|○id(String)<br/>
|/cloud/admin/updateUserInfoPasswordVerify|POST|회원 수정 비밀번호 확인|○id(String)<br/> ○password(String)
|/cloud/admin/deleteUserInfoPasswordVerify|POST|회원 삭제 비밀번호 확인|○id(String)<br/> ○password(String)
<br/>

### 3. Board API
|Url|Http Method|기능|Parameter
|:---|:---:|:---:|:---:|
|/cloud/board/list|GET|게시판 목록(페이징 처리 및 검색)|○pageNum(number)<br/> ○amount(number)<br/> ○type(String)<br/> ○keyword(String)<br/>
|/cloud/board/add|POST|게시판 생성|○id(String)<br/> ○name(String)<br/> ○title(String)<br/> ○files(Array<File>)<br/> ○content(String)<br/>
|/cloud/board/openBoard|GET|게시판 상세보기|○bno(number)<br/> ○pageNum(number)<br/> ○amount(number)<br/> ○type(String)<br/> ○keyword(String)<br/>
|/cloud/board/updateBoard|POST|게시판 수정|○bno(number)<br/> ○title(String)<br/> ○content(String)<br/> ○pageNum(number)<br/> ○amount(number)<br/> ○type(String)<br/> ○keyword(String)<br/>
|/cloud/board/deleteBoard|POST|게시판 삭제|○bno(number)<br/> ○title(String)<br/> ○content(String)<br/> ○pageNum(number)<br/> ○amount(number)<br/> ○type(String)<br/> ○keyword(String)<br/>
|/cloud/board/downloadFile|GET|게시판 첨부파일 다운로드|○idx(number)<br/>
<br/>

### 4. Reply API
|Url|Http Method|기능|Parameter
|:---|:---:|:---:|:---:|
|/cloud/reply/add|POST|댓글 추가|○id(String)<br/> ○name(String)<br/> ○bno(number)<br/> ○reply(String)<br/>
|/cloud/reply/updateReply|POST|댓글 수정|○bno(number)<br/> ○rno(number)<br/> ○reply(String)<br/> 
|/cloud/reply/deleteReply|POST|댓글 삭제|○bno(number)<br/> ○rno(number)<br/> ○reply(String)<br/> 

### 5. File API
|Url|Http Method|기능|Parameter
|:---|:---:|:---:|:---:|
|/cloud/upload|POST|파일 업로드|○id(String)<br/> ○files(Array<File>)<br/>
|/cloud/download|GET|파일 다운로드|○fno(number)<br/>
|/cloud/deleteYNUpdateFile|GET|파일 휴지통 이동|○fno(number)<br/>
|/cloud/fileKeyWord|GET|파일 검색|○keyWord(String)<br/>
|/cloud/recycleBin|GET|웹 드라이브 휴지통 조회|-
|/cloud/emptytrash|GET|웹 드라이브 휴지통 비우기|○fno(number)<br/>
|/cloud/restore|GET|파일 복구|○fno(number)<br/>
<br/>
※ 속성이 email이고 데이터 타입이 String이면 email(String)으로 작성했습니다.

<h2>설계 구조</h2>
<img src="https://user-images.githubusercontent.com/74657556/135004871-a5113251-e3d7-49b0-9233-fe1da43059f9.JPG">

<img src="https://user-images.githubusercontent.com/74657556/133912094-263ff7df-a3fe-400b-a637-ccb11158343a.png">

<h2>사이트 맵</h2>
<img src="https://user-images.githubusercontent.com/74657556/135008664-ab21e76f-a911-48a6-bded-8ae44e855c45.png">

<h2>Front-End 주요 기능</h2>
<b># JavaScript으로 유효성 검사</b>
<img src="https://user-images.githubusercontent.com/74657556/135009576-5846cbdd-9417-4d01-9a01-e1ac30501ea5.JPG">
<img src="https://user-images.githubusercontent.com/74657556/135009591-d47df665-40ac-41de-b648-05bb62398633.JPG">

<b># Jquery로 숫자만 입력할 수 있는 기능 및 전화번호 4자리, 8자리 입력 시 하이폰 자동 추가 기능</b>
<img src="https://user-images.githubusercontent.com/74657556/135048759-9fd97684-149a-4fd7-b744-fc45d6134517.gif">

# 숫자만 입력하기
<h2>Back-End</h2>
0). spring 설정<br>
<div>
  <div>
      <img src="https://user-images.githubusercontent.com/74657556/134861149-525d327e-a572-4b1f-b273-ac5bbebc2f84.png" align=center>
  </div>
  <div>
      <p align=center>[web.xml]</p>
  </div>
</div>
<div>
  <div>
      <img src="https://user-images.githubusercontent.com/74657556/134862063-265e82fc-652d-4ecd-8547-4ac02cfaebef.png" align=center>
  </div>
  <div>
      <p align=center>[root-context.xml]</p>
  </div>
</div>
<div>
  <div>
      <img src="https://user-images.githubusercontent.com/74657556/134862196-0b4bfe13-7658-49a5-bfb4-d42dfcd099ab.png" align=center>
  </div>
  <div>
      <p align=center>[security-context.xml]</p>
  </div>
</div>
<div>
  <div>
      <img src="https://user-images.githubusercontent.com/74657556/134862274-2aa6efed-1938-41f1-948e-7a3df3d10b36.png" align=center>
  </div>
  <div>
      <p align=center>[servlet-context.xml]</p>
  </div>
</div>
<div>
  <div>
      <img src="https://user-images.githubusercontent.com/74657556/134862352-f8c504b9-41e0-45d2-ad12-110dac455d7d.png" align=center>
  </div>
  <div>
      <p align=center>[pom.xml]</p>
  </div>
</div>
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
● 아래 사진은 FileUtil 클래스를 만들어서 게시판 첨부 파일 업로드 기능 구현한 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134754382-ece4c881-e675-428f-acdd-cfd174306cad.png" width="800" height="800"><br>
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
15). 해당 게시판 삭제<br>
● 아래 사진은 해당 게시판 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134469709-d75f017c-507b-446b-8132-0c221442ccb1.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134602245-a29b58f9-f298-49c9-a988-9b1117dd4072.png" width="550" height="200"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134602274-b4e27802-a30f-48b6-8641-c0ac608bfe61.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134602306-a2ea68e7-5362-4ef5-8928-4cf6969bfad8.png" width="400" height="200"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134602374-8ffc6cbc-e903-4e0f-a5f8-2147652426e8.png" width="400" height="50"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 삭제 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134602393-cbedc643-f228-4fd5-a614-2f021d0abde3.png" width="400" height="250"><br>
<br>
● 아래 사진은 FileUtil 클래스를 만들어 게시판 첨부파일 삭제 기능을 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134602539-5366c9d2-4aac-4d92-9655-57a78bc7be73.png" width="400" height="200"><br>
<br>
● 아래 사진은 해당 게시판 삭제 기능을 처리한 화면입니다.(게시판 목록 페이지로 리펙토링합니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134602463-d333f5dc-2b07-434b-a690-e927281b6525.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : deleteBoard(), deleteBoardFile()
<br>
● 사용자가  해당 게시물에 삭제을 누르면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 게시물 서비스를 처리하게 됩니다. 서비스는 해당 게시물의 첨부 파일가 있으면 첨부파일가 삭제하면서 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 삭제하여 게시판 목록에 리다이렉트를 합니다.
<br>
<br>
16). 해당 게시판 첨부 파일 다운로드<br>
● 아래 사진은 해당 게시판 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134469709-d75f017c-507b-446b-8132-0c221442ccb1.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 첨부 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134605302-f87b6595-1f6f-4ef6-a2b0-2a64b88a491c.png" width="500" height="200"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 첨부 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134605330-2aed330d-36ee-43b7-a730-0d3c80552adb.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 첨부 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134605358-5a18c700-d167-41ac-8d39-db96982c4873.png" width="400" height="100"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 첨부 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134605384-523af632-0be5-4092-bcd6-0e96297b79cc.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 첨부 다운로드 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134605719-64e40648-b274-4f40-9300-ea5b4a5f602e.png" width="400" height="50"><br>
<br>
● 아래 사진은 FileDownloadView 클래스를 만들어 파일 다운로드 기능을  메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134606933-0c8ce85a-e788-4eb4-a2f4-3c4610888368.png" width="700" height="600"><br>
<br>
● 아래 사진은 해당 해당 게시판 첨부 파일 다운로드 기능을 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134605953-947a7b5f-1602-4db7-9e21-978b701e5ca2.png" width="400" height="25"><br>
<br>
<설명><br>
● 매퍼 메서드 : selectBoardFile()
<br>
● 사용자가 해당 게시물에 첨부 파일을 클릭하면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 게시물 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 조회하여 해당 첨부파일의 정보를 가져와서 fileDownloadView, downloadFile 빈을 뷰에 담아 다운로드하게 됩니다.
<br>
<br>
17). 해당 게시판 댓글 등록<br>
● 아래 사진은 해당 게시판 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608023-ee58a787-e35a-40a4-af06-8e5704355cdd.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 댓글 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607289-1856ca98-a7d6-4ccf-8ec3-5fbc7fac76bd.png" width="400" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 댓글 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607216-d3eb5954-6d83-487a-8d4e-d78808523c83.png" width="400" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 댓글 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607407-33e79b2a-19a3-40a9-b0ad-6d4b70eed47a.png" width="400" height="150"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 댓글 등록 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607554-3d9a4704-0c33-42de-b6ad-c6b9a91d5c5a.png" width="500" height="50"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 댓글 등록 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607608-5811cf61-4dba-4366-b31e-c05b0f88311a.png" width="400" height="150"><br>
<br>
● 아래 사진은 해당 게시판 댓글 등록 기능을 처리한 화면입니다.(해당 게시판 상세보기 페이지로 리펙토링합니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134607661-c704d525-80b2-4f7f-b6cb-d702ac8074cc.png" width="400" height="200"><br>
● 아래 사진은 해당 게시판 댓글 수가 1만큼 증가하는 것을 나타나는 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607763-386d1bf7-1580-41fb-926f-f4d6b762c6c6.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : add(),upUpdateReplyCount()
<br>
● 사용자가 해당 게시판에서 댓글을 입력하여 등록을 누르면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 댓글 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 추가하여 해당 게시물 상세보기 페이지로 리다이렉트합니다. 그리고 해당 게시물의 댓글 수을 1만큼 증가합니다.
<br>
<br>
18). 해당 게시판 댓글 수정<br>
● 아래 사진은 해당 게시판 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607988-9e501f34-e570-429a-8791-822236ba23f8.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 댓글 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134607976-1c11fea9-7a1d-44c6-be3c-05daa9f22241.png" width="600" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 댓글 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608160-4dd16f00-85f7-4fcf-b3af-eca4a8814942.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 댓글 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608188-4c44724b-1f2b-4ab4-9cb8-9f7179d78a78.png" width="400" height="100"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 댓글 수정 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608219-c1be7493-6aac-475f-9b9e-7bc8847a9b5d.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 댓글 수정 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608239-1a7a75a1-75ae-435a-b56f-e25f07b1ef06.png" width="400" height="150"><br>
<br>
● 아래 사진은 해당 게시판 댓글 수정 기능을 처리한 화면입니다.(해당 게시판 상세보기 페이지로 리펙토링합니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134608266-ca39f67e-267a-4bcd-89c7-0ada43f8a7c1.png" width="400" height="200"><br>
<설명><br>
● 매퍼 메서드 : updateReply()
<br>
● 사용자가 해당 게시물에서 수정할 댓글을 입력하여 수정을 누르면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 댓글 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 수정하여 해당 게시물 상세보기 페이지로 리다이렉트합니다.
<br>
<br>
19). 해당 게시판 댓글 삭제<br>
● 아래 사진은 해당 게시판 상세보기를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608606-c71841df-7313-444b-b79c-a5ec3af28345.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 게시판 댓글 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134608619-ee7615e4-7145-45ac-9b09-5c8aaf5fb88d.png" width="600" height="200"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 게시판 댓글 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134614726-2c62f25b-2f99-46ae-a76f-1819c628e379.png" width="300" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 게시판 댓글 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134614749-93d726d0-65ed-4c99-a5c3-9f46e2242a9e.png" width="400" height="150"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 게시판 댓글 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134614777-58b655e7-7407-49f0-bb7d-57695e44ae3d.png" width="400" height="50"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 댓글 삭제 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134614925-58c645b3-560f-4037-8403-e45a8402c2ab.png" width="400" height="200"><br>
<br>
● 아래 사진은 해당 게시판 댓글 삭제 기능을 처리한 화면입니다.(해당 게시판 상세보기 페이지로 리펙토링합니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134615022-5769ed80-83fd-4829-87be-2f69f67285dd.png" width="400" height="200"><br>
● 아래 사진은 해당 게시판 댓글 수가 1만큼 감소하는 것을 나타나는 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134615077-9bbb4721-c6b7-4400-875e-17393fa82ba3.png" width="400" height="200"><br>
<설명><br>
● 매퍼 메서드 : deleteReply(),downUpdateReplyCount()
<br>
● 사용자가 해당 게시물에서 해당 댓글에 있는 삭제를 누르면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 댓글 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 삭제하여 해당 게시물 상세보기 페이지로 리다이렉트합니다. 그리고 해당 게시물 댓글 수가 1만큼 감소합니다.
<br>
<br>
20). 파일 업로드<br>
● 아래 사진은 메인 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134753987-69d3c42e-fb1c-4306-9eec-4f299a1af02c.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 파일 업로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755237-10775c3c-1ce9-41ae-a79a-c34d6d3e8a42.png" width="1000" height="400"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 파일 업로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755271-47471d81-e2b7-45bf-ac01-3a88964ee817.png" width="600" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 파일 업로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755309-32aee037-0c00-41ca-b0ab-2f69bdb5b299.png" width="600" height="400"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 파일 업로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134754045-9d7edd06-63bc-4b86-83f4-f055eb7aca7d.png" width="300" height="100"><br>
<br>
● 아래 사진은 xml에서 파일 업로드 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134754049-5b9dc589-6536-4a77-b08d-ea37c518cfd4.png" width="400" height="200"><br>
<br>
● 아래 사진은 FileUtil 클래스를 만들어서 파일 업로드 기능을 구현한 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755185-85f8dff6-e45d-4d77-acdf-f62e2b562061.png" width="800" height="800"><br>
<br>
● 아래 사진은 파일 업로드 기능을 처리한 화면입니다.(메인 페이지로 리다이렉트했습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134755346-2309b2fe-d184-4c3d-a695-260dbb35bec7.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 :  fileUpLoadProcess(),selectUserAuth(),getFileNameList(), getUploadUserList()
<br>
● 사용자가 메인 페이지에서 파일 업로드를 누르면 업로드한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 파일 서비스를 처리하게 되고 서비스는 parseFileList()를 통해 파일 업로드되면서 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 추가하여 메인 페이지로 리다이렉트합니다. 
<br>
<br>
22). 해당 파일 다운로드<br>
● 아래 사진은 메인 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755462-fca214cb-0544-4fcf-8a9d-3bd199536235.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 파일 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755474-0992967c-bd51-42b1-900d-5c4e7d691055.png" width="500" height="200"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 파일 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755484-3458bee6-5253-4563-a9a3-835077de4473.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 파일 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755487-e6c16cdf-ab0f-4557-8569-d1699ba1af11.png" width="400" height="100"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 파일 다운로드 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755502-06fb869e-0039-445d-a652-80f4665668c0.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 게시판 첨부 다운로드 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755507-14856194-1a60-49b0-b885-fa1804584f19.png" width="400" height="50"><br>
<br>
● 아래 사진은 FileDownloadView 클래스를 만들어 파일 다운로드 기능을 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134606933-0c8ce85a-e788-4eb4-a2f4-3c4610888368.png" width="700" height="600"><br>
<br>
● 아래 사진은 해당 파일 다운로드 기능을 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755537-36a22148-137a-4bf7-844f-ba7b791f4570.png" width="400" height="25"><br>
<br>
<설명><br>
● 매퍼 메서드 : selectFile()
<br>
● 사용자가 메인 페이지에서 해당 파일을 클릭하면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 파일 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 조회하여 해당 파일의 정보를 가져와서 fileDownloadView, downloadFile 빈을 뷰에 담아 다운로드하게 됩니다.
<br>
<br>
23). 해당 파일 삭제<br>
● 아래 사진은 메인 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755610-957b7ac7-a92f-471c-a8bf-a59ae4fe3d8c.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 파일 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755618-b11a0f28-f383-4275-ba1c-5e0212ec71b7.png" width="500" height="250"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 파일 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755626-a715f3c9-8489-45f8-a9d6-cf2f8cf6de03.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 파일 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755637-de9c5d71-5e0f-4c93-8300-219b06b76d01.png" width="400" height="50"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 파일 삭제 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755657-5db7c509-123c-43bf-b5f6-c557749b39c3.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 파일 삭제 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755663-6d39bb91-cb63-466f-af73-655c23ebabbd.png" width="400" height="100"><br>
<br>
● 아래 사진은 해당 파일 삭제 기능을 처리한 화면입니다.(메인 페이지로 리펙토링합니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134755691-e1280e7b-156f-4fe8-9fc0-2253ff0426d3.png" width="400" height="200"><br>
<br>
● 아래 사진은 해당 파일을 휴지통에 이동 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755719-15458615-1792-41c4-9155-22b484cb1c46.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : deleteYNUpdateFile()
<br>
● 사용자가 메인 페이지에서 해당 파일에 삭제를 클릭하면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 파일 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 deleteYN 열의 값을 ‘Y’로 수정하여 메인 페이지에 리다이렉트하고 해당 파일은 휴지통 페이지로 이동하게 됩니다.
<br>
<br>
24). 파일 검색<br>
● 아래 사진은 메인 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134755610-957b7ac7-a92f-471c-a8bf-a59ae4fe3d8c.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 파일 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134795459-55eecba3-c4e1-4135-9028-305e3ee8c852.png" width="500" height="250"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 파일 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134795467-4fcad2e4-a9c9-46fc-a9a2-ab9e0a989bac.png" width="300" height="50"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 파일 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134795474-3779b165-663c-48a4-ae5f-5c0f664323c5.png" width="400" height="200"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 파일 검색 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134795488-28614512-a227-4f3d-99df-0567d3d7f1be.png" width="400" height="50"><br>
<br>
● 아래 사진은 xml에서 파일 검색 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799392-4a89256e-a512-4540-beb7-1eff49f381f5.png" width="400" height="100"><br>
<br>
● 아래 사진은 파일 검색 기능을 처리한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799406-ff1e18dc-22b5-48f3-94fd-207bd711e48c.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : getKeyWordFileList(), getFileSize()
<br>
● 사용자가 메인 페이지에서 키워드를 입력하고 검색을 클릭하면 입력한 데이터를 가지고 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 파일 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 조회하여 해당 파일의 정보들을 목록으로 가져와서 메인 페이지에 입력한 키워드로 검색합니다.
<br>
<br>
25). 해당 파일 비우기<br>
● 아래 사진은 휴지통 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799532-100f946d-1f96-4036-8f94-0f6dddd759b8.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 파일 비우기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799542-86d1bd81-cbda-437d-b78b-5a0ef807a50d.png" width="300" height="100"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 파일 비우기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799571-6bc6d02a-8b52-4bf3-9403-cf1fd1f05f76.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 파일 비우기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799590-b00f18b6-3282-4f25-b770-e35ebf079a17.png" width="400" height="200"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 파일 비우기 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799602-bc7e6498-9901-4f11-ad5c-dc677f18c95e.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 파일 비우기 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799615-f0c69e9c-ce9f-4ada-ad07-60e60cc1bea7.png" width="300" height="100"><br>
<br>
● 아래 사진은 FileUtil 클래스를 만들어 해당 파일 삭제 기능을 메소드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134799710-16a7c74d-3f0c-4257-b53f-5c1276449fa0.png" width="400" height="200"><br>
<br>
● 아래 사진은 해당 파일 비우기 기능을 처리한 화면입니다.(휴지통 페이지로 리다이렉트했습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134799812-ba60aa6c-d67b-45b9-bb61-91ec47f7e5d6.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : deleteEmptyTrash()
<br>
● 사용자가 휴지통 페이지에서 해당 파일에 있는 비우기를 클릭하면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 파일 서비스를 처리하게 됩니다. 서비스는 isRemoveFile를 통해 해당 경로에서 파일을 삭제되고 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 데이터를 삭제하여 휴지통 페이지로 리다이렉트합니다.
<br>
<br>
26). 해당 파일 복구<br>
● 아래 사진은 휴지통 페이지를 스타일 적용한 화면입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134800440-8d4c2994-7822-4307-8eeb-36e4297539a9.png" width="400" height="200"><br>
<br>
● 아래 사진은 컨트룰러에서 해당 파일 복구 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134801565-1ca83901-d84f-48ec-aaa2-65330b6afb22.png" width="800" height="600"><br>
<br>
● 아래 사진은 서비스 인터페이스에서 해당 파일 복구 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134800538-76b8ddaa-ef97-483c-a059-013185cbba07.png" width="300" height="25"><br>
<br>
● 아래 사진은 서비스 인터페이스를 구현한 클래스에서 해당 파일 복구 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134800542-666d099f-0da4-4196-b242-2086bd9c65cb.png" width="300" height="100"><br>
<br>
● 아래 사진은 매퍼 인터페이스에서 해당 파일 복구 기능을 구현한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134800555-dabe64c5-95fa-47a3-a09e-51a1e44c4479.png" width="400" height="25"><br>
<br>
● 아래 사진은 xml에서 해당 파일 복구 기능을 구현하기 위한 코드입니다.<br>
<img src="https://user-images.githubusercontent.com/74657556/134800562-4aeddc27-9476-496a-b5d9-76d192a4bc6d.png" width="300" height="150"><br>
<br>
● 아래 사진은 해당 파일 복구 기능을 처리한 화면입니다.(메인 페이지로 리다이렉트했습니다.)<br>
<img src="https://user-images.githubusercontent.com/74657556/134800572-8e1019f6-e2db-4f85-8505-43b6c4ed3e33.png" width="400" height="200"><br>
<br>
<설명><br>
● 매퍼 메서드 : restore()
<br>
● 사용자가 휴지통 페이지에서 해당 파일에 있는 복구를 클릭하면 해당 URL 요청을 보냅니다. URL이 일치하는 컨트롤러에서 파일 서비스를 처리하게 됩니다. 서비스는 매퍼 클래스에게 DB접근을 위임합니다. 다음, mapper.xml를 이용하여 SQL 구문을 통해서 해당 테이블에 있는 deleteyn를 ‘N’로 수정하여 메인 페이지로 리다이렉트하면서 메인 페이지로 복구합니다.
<br>
<br>
