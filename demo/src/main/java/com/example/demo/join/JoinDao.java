/* Spring Framework를 사용하는 이유:
경량화와 모듈화: 필요한 기능만 선택적으로 사용 가능.
의존성 주입: 객체 간의 결합도를 낮추어 유지보수성 향상.
AOP(관점 지향 프로그래밍): 모듈 간의 결합도를 낮추고 재사용성을 높임.
트랜잭션 관리: 선언적 방식으로 트랜잭션을 관리하며 일관성 유지.
테스트 용이성: 코드의 테스트가 쉽고 JUnit과 통합 가능.
다양한 모듈과 확장성: 웹, 데이터 액세스, 보안 등 다양한 모듈 제공 및 외부 라이브러리와 통합 용이.
커뮤니티와 생태계: 활발한 커뮤니티와 다양한 프로젝트 지원으로 개발 생산성 향상. */

/* 동기식 (Synchronous):
동기식 모델에서는 한 작업이 수행 중일 때 다음 작업이 시작되지 않습니다.
각 작업은 이전 작업이 완료될 때까지 대기하며, 순차적으로 실행됩니다.
일반적으로 직관적이고 코드가 읽기 쉬우며 디버깅이 상대적으로 쉽습니다.
단점은 하나의 작업이 끝날 때까지 다음 작업이 시작되지 않기 때문에 전체 프로세스가 느려질 수 있습니다.

비동기식 (Asynchronous):
비동기식 모델에서는 한 작업이 수행 중일 때 다음 작업이 시작될 수 있습니다.
각 작업은 대기하지 않고 독립적으로 실행되며, 결과를 기다리지 않고 다음 작업을 시작할 수 있습니다.
주로 이벤트 기반 프로그래밍이나 비동기 I/O 작업에서 사용됩니다.
단점은 코드가 복잡해질 수 있고, 콜백 함수나 Promise 등을 사용하여 비동기 코드를 관리해야 합니다.
성능 면에서는 여러 작업을 병렬로 처리하여 일반적으로 빠를 수 있습니다.

예를 들어, 동기식으로 파일을 읽는 경우 프로그램은 파일을 읽을 때까지 다음 코드로 진행하지 않습니다. 반면에 비동기식으로 파일을 읽는 경우 파일 읽기 요청을 보내고, 파일이 읽혀지면 콜백 함수가 호출되어 다음 작업을 수행할 수 있습니다. */

/* HTTP에서의 GET과 POST는 두 가지 주요한 HTTP 메서드로, 서버에 데이터를 전송하는 방식에서 차이가 있습니다.

GET 메서드:
정보를 서버로 보내기 위해 사용됩니다.
데이터를 URL의 쿼리 문자열에 포함하여 전송합니다.
전송되는 데이터가 URL에 노출되므로 보안에 취약할 수 있습니다.
주로 데이터를 조회하고 요청하는 데 사용됩니다.
브라우저에서 주소 표시줄에 나타나는 쿼리 매개변수로 전달됩니다.
예: http://example.com/resource?param1=value1&param2=value2

POST 메서드:
정보를 서버로 보내기 위해 사용됩니다.
데이터를 HTTP 요청의 본문(body)에 포함하여 전송합니다.
전송되는 데이터가 URL에 노출되지 않아 GET보다 보안적으로 우수합니다.
주로 데이터를 생성하고 서버에 제출하는 데 사용됩니다.
브라우저에서는 주로 HTML 폼을 통해 전송됩니다.
POST /resource HTTP/1.1
Host: example.com
Content-Type: application/x-www-form-urlencoded

param1=value1&param2=value2

일반적으로, GET은 데이터를 요청하는 데 사용되며, POST는 데이터를 서버로 제출하는 데 사용됩니다. 간단한 데이터 조회나 검색과 같은 경우에는 GET을 사용하고, 로그인 정보 전송이나 파일 업로드와 같이 민감한 정보를 전송해야 할 때에는 POST를 사용하는 것이 일반적입니다.*/

/* ModelAndView는 Spring Framework에서 사용되는 클래스로, 컨트롤러가 처리한 결과 데이터와 뷰 정보를 함께 담아서 반환하는 데 사용됩니다. 주로 Spring MVC에서 사용되며, 클라이언트에게 응답을 생성할 때 필요한 데이터와 뷰 정보를 포함하는 객체입니다.

Model 객체:
ModelAndView에는 데이터를 담을 수 있는 Model 객체가 있습니다.
Model은 컨트롤러에서 뷰로 데이터를 전달하는 데 사용되는 객체입니다.
데이터는 키-값 쌍으로 저장되며, 뷰에서는 키를 사용하여 데이터에 접근합니다.

View 이름:
뷰의 이름(뷰 리졸버에서 해석 가능한)을 저장하는 데 사용됩니다.
뷰 리졸버는 이 이름을 기반으로 실제 뷰를 찾아 응답을 생성합니다.

응답 상태 및 헤더 설정:
HTTP 응답 상태 코드 및 헤더 정보를 설정할 수 있습니다. 

예시 코드:
@Controller
public class MyController {
  @RequestMapping("/example")
  public ModelAndView example() {
    ModelAndView modelAndView = new ModelAndView("exampleView"); // 뷰의 이름 설정
    modelAndView.addObject("message", "Hello, ModelAndView!"); // 데이터 추가
    return modelAndView;
  }
}
위의 코드에서 "exampleView"는 뷰 리졸버에서 실제 뷰로 매핑되는 뷰의 이름이고, "message"는 뷰로 전달되는 데이터의 키입니다.

이렇게 생성된 ModelAndView 객체는 컨트롤러 메서드에서 반환되면 Spring MVC는 이를 이용하여 응답을 생성하고 클라이언트에게 전송합니다.*/

package com.example.demo.join;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import com.example.demo.mybatis.MybaFactory;

/* @Component은 Spring 프레임워크에서 사용되는 어노테이션으로, 해당 클래스를 Spring IoC 컨테이너가 관리하는 빈(Bean)으로 등록하도록 지정하는 역할을 합니다.

간단하게 말하면, @Component 어노테이션을 사용하면 해당 클래스의 객체가 Spring IoC 컨테이너에 의해 생성되고 관리되며, 필요한 곳에서 주입(Dependency Injection)하여 사용할 수 있습니다. */
@Component
public class JoinDao {
    /* SqlSession은 MyBatis 프레임워크에서 데이터베이스와의 상호 작용을 담당하는 인터페이스입니다. MyBatis는 SQL 매핑을 사용하여 Java 객체와 SQL 문 사이의 매핑을 간편화하고, SqlSession은 이 매핑을 실행하며 결과를 반환합니다.

  간단하게 말하면, SqlSession은 데이터베이스와의 통신을 관리하고 SQL 쿼리를 실행하며, 결과를 받아오는 역할을 합니다. 이를 통해 Java 코드에서 SQL 쿼리를 실행하고 그 결과를 처리할 수 있습니다.

  보통 MyBatis에서는 SqlSessionFactory를 통해 SqlSession을 얻어오게 됩니다. SqlSessionFactory는 데이터베이스 연결 설정 등을 관리하고, SqlSession은 실제 SQL 쿼리를 실행하는 역할을 수행합니다. */
  SqlSession session;

    /* 이 코드는 JoinDao 클래스의 생성자에서 MyBatis의 SqlSessionFactory를 사용하여 SqlSession을 생성하는 부분입니다. 여기서 MybaFactory는 SqlSessionFactory를 생성하고 관리하는 역할을 하는 클래스일 것입니다. openSession() 메서드는 SqlSession을 열어서 반환합니다.

    간단히 말하면, JoinDao 객체가 생성될 때마다 데이터베이스와의 연결을 맺고 SQL 쿼리를 실행할 수 있는 SqlSession을 생성하는 코드입니다. 이렇게 생성된 SqlSession은 데이터베이스와의 상호 작용을 담당하며, SQL 쿼리를 실행하고 결과를 받아올 수 있게 해줍니다.

    예를 들어, JoinDao 객체가 생성될 때마다 해당 객체를 사용하여 데이터베이스와 통신할 수 있게 됩니다. */
  public JoinDao(){
    session = MybaFactory.getFactory().openSession();
  }

  /* 
  메서드 시그니처 (Method Signature):
  public String joinMemberR(JoinVo vo): 리턴 타입은 String이며, 매개변수로 JoinVo 타입인 vo를 받습니다.

  메서드 내용 (Method Content):
  String msg = "";: 메서드에서 사용할 문자열 변수 msg를 초기화합니다.
  int cnt = 0;: 데이터베이스 쿼리 결과로 영향을 받은 행의 수를 나타내는 정수형 변수 cnt를 초기화합니다.
  try { ... } catch(Exception ex) { ... }: 예외 처리 블록으로, 데이터베이스 관련 작업에서 예외가 발생할 경우를 처리합니다.
  cnt = session.insert("join.joinMember", vo);: MyBatis를 통해 데이터베이스에 새로운 회원 정보를 추가하는 쿼리를 실행합니다.
  if(cnt < 1) { ... }: 쿼리 실행 결과 행의 수가 1 미만이면 오류 메시지를 설정하고 예외를 발생시킵니다.
  session.commit();: 트랜잭션을 커밋하여 데이터베이스에 실제로 변경 사항을 적용합니다.
  catch(Exception ex) { ... }: 예외가 발생한 경우를 처리하는 블록으로, 예외 메시지를 설정하고 트랜잭션을 롤백합니다.

  리턴 값 (Return Value):
  return msg;: 메서드 실행 결과에 따라 설정된 메시지를 반환합니다. 성공 시 빈 문자열이 반환되며, 실패 시 오류 메시지가 반환됩니다.

  이 메서드는 회원 가입 정보를 데이터베이스에 저장하고, 트랜잭션을 관리하여 데이터베이스 작업의 일관성을 유지하고 있습니다. */
  public String joinMemberR(JoinVo vo){
    String msg = "";
    int cnt = 0;
    try{
      cnt = session.insert("join.joinMember", vo);
      if(cnt < 1){
        msg = "오류가 발생했어요";
         throw new Exception(msg);
      }
      session.commit();
    }catch(Exception ex){
      msg = ex.getMessage();
      session.rollback();
    }
    return msg;
  }
}
