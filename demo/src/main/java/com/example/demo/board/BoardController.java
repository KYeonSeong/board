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

package com.example.demo.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// @RestController는 Spring에서 사용되는 어노테이션으로, 해당 클래스가 RESTful 웹 서비스의 컨트롤러임을 표시합니다. 컨트롤러 메소드의 반환값이 HTTP 응답으로 직접 전송되며, 주로 JSON 또는 XML 형식으로 변환되어 클라이언트에게 제공됩니다.
@RestController
public class BoardController {
  // 이 어노테이션은 상위 클래스나 인터페이스의 메서드를 오버라이드하는 것을 명시
	// @Override 어노테이션은 메소드가 상위 클래스나 인터페이스의 메소드를 정확하게 오버라이드하고 있는지를 체크하는 용도로 사용
	// 코드에서 해당 어노테이션이 붙으면 해당 메소드가 부모 클래스나 인터페이스에서 상속된 메소드를 오버라이드한다는 것을 나타냄
  @Autowired
  BoardDao dao;

  // @RequestMapping은 Spring 프레임워크에서 HTTP 요청을 처리하는 메소드에 부착되는 어노테이션 중 하나입니다. 이 어노테이션은 특정 URL 패턴과 HTTP 메소드에 대한 매핑을 지정하여 요청을 어떻게 처리할지를 정의합니다. 간단히 말하면, @RequestMapping을 사용하면 특정 URL로 들어오는 요청을 특정 메소드에서 처리할 수 있습니다.
  @RequestMapping("/brdList")
  public ModelAndView brdList(Page page){
    ModelAndView mv = new ModelAndView();

    /* List는 Java에서 제공하는 컬렉션 프레임워크의 하나로, 동적인 크기를 갖는 배열을 나타냅니다. 리스트는 요소(element)의 순서를 유지하며, 중복된 요소를 허용합니다. Java에서 java.util 패키지에 속해 있습니다.

    간단한 특징:

    순서 유지:
    리스트에 추가된 순서대로 요소가 유지됩니다.
    인덱스(index)로 요소에 접근할 수 있습니다.

    크기 동적 조절:
    리스트는 동적으로 크기를 조절할 수 있습니다.
    요소를 추가하거나 제거할 때 리스트의 크기가 자동으로 조절됩니다.

    중복 허용:
    하나의 리스트에 동일한 요소가 중복해서 포함될 수 있습니다. */
    List<BoardVo> list = dao.select(page);
    page = dao.getPage();
    /* addObject는 Spring Framework의 ModelAndView 클래스에서 제공하는 메서드 중 하나로, 뷰에 전달할 데이터를 추가하는 데 사용됩니다. 이 메서드를 통해 전달된 데이터는 뷰에서 사용될 수 있습니다.

    간단히 말하면, addObject 메서드는 키-값 쌍으로 데이터를 추가하는 역할을 합니다. 이 데이터는 뷰에 전달되어 클라이언트에게 응답으로 보내집니다. */
    mv.addObject("list", list);
    mv.addObject("page", page);
    /* setViewName은 Spring MVC의 ModelAndView 객체에서 사용되는 메서드 중 하나입니다. ModelAndView은 모델 데이터와 뷰의 이름을 함께 갖는 객체로, Spring MVC에서 컨트롤러 메서드의 처리 결과를 나타내는 데 사용됩니다.

    setViewName 메서드는 ModelAndView 객체에서 뷰의 이름을 설정하는 데 사용됩니다. 즉, 클라이언트에게 보여줄 뷰의 이름을 지정하는 역할을 합니다. */
    mv.setViewName("/board/list");

    return mv;
  }

  @RequestMapping("/brdView")
  public ModelAndView view(int sno, Page page){
    ModelAndView mv = new ModelAndView();
    BoardVo vo = dao.view(sno);

    mv.addObject("vo", vo);
    mv.addObject("page", page);
    mv.setViewName("/board/view");

    return mv;
  }

  @RequestMapping("/brdRegister")
  public ModelAndView register(Page page){
    ModelAndView mv = new ModelAndView();

    mv.addObject("page", page);
    mv.setViewName("/board/register");

    return mv;
  }

  // method=RequestMethod.POST는 Spring MVC에서 해당 컨트롤러 메서드가 POST 요청만을 처리하도록 지정하는 어노테이션 속성입니다. 이는 클라이언트가 서버로 데이터를 전송할 때 주로 사용되는 HTTP POST 메서드에 대한 요청만을 이 메서드가 처리한다는 것을 나타냅니다.
  @RequestMapping(value="/brdRegisterR", method=RequestMethod.POST)
  // @RequestParam은 Spring MVC에서 사용되는 어노테이션으로, HTTP 요청의 파라미터 값을 메서드의 매개변수에 바인딩하는 역할을 합니다.
  // @ModelAttribute는 Spring MVC에서 사용되는 어노테이션으로, 메서드의 매개변수로 받은 객체를 자동으로 모델에 추가하여 View에 전달하는 역할을 합니다.
  public String registerR(@RequestParam("attFile") List<MultipartFile> mul, @ModelAttribute BoardVo vo, @ModelAttribute Page page){
    String msg = "";
    msg = dao.registerR(vo, mul);

    return msg;
  }
  
  @RequestMapping("/brdModify")
  public ModelAndView modify(int sno, Page page){
    ModelAndView mv = new ModelAndView();
    mv.setViewName("/board/modify");
    BoardVo vo = dao.view(sno);
    mv.addObject("vo", vo);
    mv.addObject("page", page);
    return mv;
  }

  @RequestMapping("/brdModifyR")
  public String modifyR(@RequestParam("attFile") List<MultipartFile> mul, @ModelAttribute BoardVo vo, @ModelAttribute Page page){
    String msg = "";
    msg = dao.modifyR(vo, mul);
    return msg;
  }

  @RequestMapping("/brdDeleteR")
  public String deleteR(BoardVo vo){
    String msg = "";
    msg = dao.deleteR(vo);
    return msg;
  }

  @RequestMapping("/brdRepl")
  public ModelAndView repl(Page page, BoardVo vo){
    ModelAndView mv = new ModelAndView();
    mv.addObject("vo", vo);
    mv.addObject("page", page);
    mv.setViewName("/board/repl");
    return mv;
  }

  @RequestMapping(value="/brdReplR", method=RequestMethod.POST)
  public String replR(@RequestParam("attFile") List<MultipartFile> mul, @ModelAttribute BoardVo vo, @ModelAttribute Page page){
    String msg = "";
    msg = dao.replR(vo, mul);
    return msg;
  }
}
  

