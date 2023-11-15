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

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot 애플리케이션을 정의하는 데 사용되는 어노테이션
// 이 어노테이션은 여러 다른 어노테이션들을 포함하고 있어서 애플리케이션을 구성하고 실행하는 데 필요한 많은 설정을 자동으로 처리
@SpringBootApplication
public class DemoApplication {

	// Java 애플리케이션의 진입점인 main 메서드를 정의, 이 메서드는 프로그램이 시작될 때 호출되는 메서드로, 여기서 Spring Boot 애플리케이션을 실행
	public static void main(String[] args) {
		// Spring Boot 애플리케이션을 실행하는 메서드
		// DemoApplication.class: 실행할 애플리케이션의 메인 클래스를 나타냅니다. 여기서는 DemoApplication 클래스가 메인 클래스로 지정되어 애플리케이션이 실행됨
		// args: 명령행 인자를 전달, 이 부분은 필요에 따라 커맨드 라인에서 전달되는 인자들을 애플리케이션에 전달하는 역할을 한다.
		SpringApplication.run(DemoApplication.class, args);
	}

}

// 이 코드는 Spring Boot 애플리케이션의 실행을 위한 핵심적인 부분을 담고 있다. main 메서드를 실행하면 Spring Boot가 내장된 웹 서버를 시작하고, 애플리케이션을 구동한다.