1. 로컬 개발 환경에 Tomcat 서버를 시작하면 Servlet Container의 초기화 과정이 진행된다. 현
재 소스 코드에서 초기화되는 과정에 대해 설명해라(WebServerLauncher의 시작 과정이 아니
라 clone한 프로젝트의 초기화 과정이다.). 설명은 clone 한 소스 코드의 README.md 파일
에 작성한다. README.md 파일은 마크다운 문법을 따른다. 마크다운 문법은
http://daringfireball.net/projects/markdown/syntax 에서 참조 가능하다.(힌트 : DB 초기화
를 담당하는 ContextLoaderListener 클래스와 Mapping 초기화를 담당하는
DispatcherServlet 클래스부터 분석을 시작한다.)





2. 로컬 개발 환경에 Tomcat 서버를 시작한 후 http://localhost:8080으로 접근하면 질문 목록
을 확인할 수 있다. http://localhost:8080으로 접근해서 질문 목록이 보이기까지 소스 코드의
호출 순서 및 흐름을 설명하라. 

먼저 해당 컨트롤러는 HomeController / 뷰는 index.jsp / 모델은 Question이 사용된다. 

index.jsp에서 question인자를 요청하면
서블릿 컨테이너가 이에 대한 경로를 보고 resp/req를 생성한다. 
loadofstartup = 1로 인해 dispatcher서블릿에 인자들이 들어옴.
requestmapping을 통해서 해당 컨트롤러를 연결해주고 그리고 해당 컨트롤러의 execute함수를 실행. 
그 컨트롤러는 homecontroller임.
얘는 dispatcher로 부터 resp/req 인자를 받아 index.jsp를 뷰로 하고, 데이터는 questions라는 키로
questionDao.findAll()함수를 불러옴. 
index.jsp를 어떻게 나오게 하냐면, 들어온 뷰의 값이 다시 dispatcher - service()함수를 통해 
modelandview - jstlview에서 render함수를 돌게한다. 
얘는 전달받은 데이터를 jsp로 전달한다. 
jstl은 questions 를 키로 하여 question객체를 조회해서 주어진 규칙에 맞춰 html을 작성한다. 
response 객체로 클라이언트로 보내면. 사용자는 질문 리스트를 볼 수 있음. 



3. 질문 목록은 정상적으로 동작하지만 질문하기 기능은 정상적으로 동작하지 않는다. 질문하기
기능을 구현한다. 질문 추가 로직은 QuestionDao 클래스의 insert method 활용 가능하다.
HttpServletRequest에서 값을 추출할 때는 ServletRequestUtils 클래스를 활용 가능하다. 질
문하기를 성공한 후 질문 목록 페이지(“/”)로 이동해야 한다.



4. 로그인하지 않은 사용자도 질문하기가 가능하다. 로그인한 사용자만 질문이 가능하도록 수정한
다. 또한 질문할 때 글쓴이를 입력하지 않고 로그인한 사용자 정보를 가져와 글쓴이 이름으로
등록한다.(힌트 : session.getAttribute(“user”)와 같이 Session에서 로그인 정보를 가져올 수
있다.)


5. 질문 목록에서 제목을 클릭하면 상세보기 화면으로 이동한다. 상세보기 화면에서 답변 목록이
정적인 HTML로 구현되어 있다. 답변 목록을 정적인 HTML이 아니라 데이터베이스에 저장되
어 있는 답변을 출력하도록 구현한다. 단, <%%>와 같이 스크립틀릿을 사용하지 않고 JSTL과
EL(expression language)만으로 구현해야 한다.


6. 자바 기반으로 웹 프로그래밍을 할 경우 한글이 깨진다. 한글이 깨지는 문제를 해결하기 위해
ServletFilter를 활요해 문제를 해결할 수 있다. core.web.filter.CharacterEncodingFilter에 어
노테이션 설정을 통해 한글 문제를 해결한다.(힌트 : WebFilter annotation)
이미 되어 있는 느낌..?!


7. next.web.qna package의 ShowController는 멀티 쓰레드 상황에서 문제가 발생할 가능성이
있는 코드이다. 멀티 쓰레드 상황에서 문제가 발생하지 않도록 수정한다. 멀티 쓰레드에서 문
제가 되는 이유를 README.md 파일에 작성한다.

잘 모르겠어요 패스.

8. 상세보기 화면에서 답변하기 기능은 정상적으로 동작한다. 단, 답변을 추가할 경우 댓글의 수
가 증가하지 않는다. 답변을 추가하는 시점에 질문(QUESTIONS 테이블)의 댓글 수
(countOfAnswer)도 1 증가해야 한다. 데이터베이스 접근 로직은 직접 구현해야 한다.


9. 상세보기 화면의 답변 목록에서 답변을 삭제해야 한다. 답변 삭제 또한 화면을 깜빡이지 않고
구현이 가능하도록 AJAX로 구현한다. js/scripts.js 파일의 답변 추가 로직을 참고해 답변 삭제
로직을 구현한다.


10. 질문 수정이 가능해야 한다. 질문 수정은 글쓴이와 로그인 사용자가 같은 경우에만 수정이 가
능하다.


11. Controller에서 접근하는 QuestionDao와 AnswerDao, DAO에서 데이터베이스 접근 로직을
구현할 때 사용하는 JdbcTemplate은 인스턴스를 여러 개 생성할 필요없다. 인스턴스를 하나
만 생성하도록 구현한다.(힌트 싱글톤 패턴)
Question..

12. 질문 삭제 기능을 구현한다. 질문 삭제가 가능한 경우는 다음과 같다. “답변이 없는 경우
삭제가 가능하다. 질문자와 답변자가 같은 경우 삭제가 가능하다. 질문자와 답변자가 다
른 경우 답변을 삭제할 수 없다”. 이 질문 삭제 기능은 일반 PC와 모바일 모두를 지원하
려고 한다. 삭제를 완료한 후 일반 PC의 웹 브라우저는 JspView를 활용해 목록 페이지
(“redirect:/”)로 이동하고, 모바일은 JsonView를 활용해 응답 결과를 JSON으로 전송하려고
한다. 이를 지원하려면 두 개의 Controller가 필요하다. 각 Controller를 구현해보면 많은
중복이 발생한다. 각 Controller에서 발생하는 중복을 제거한다.

