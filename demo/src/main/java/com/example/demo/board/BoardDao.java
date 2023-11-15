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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.mybatis.MybaFactory;

/* @Component은 Spring 프레임워크에서 사용되는 어노테이션으로, 해당 클래스를 Spring IoC 컨테이너가 관리하는 빈(Bean)으로 등록하도록 지정하는 역할을 합니다.

간단하게 말하면, @Component 어노테이션을 사용하면 해당 클래스의 객체가 Spring IoC 컨테이너에 의해 생성되고 관리되며, 필요한 곳에서 주입(Dependency Injection)하여 사용할 수 있습니다. */
@Component
public class BoardDao {
  /* SqlSession은 MyBatis 프레임워크에서 데이터베이스와의 상호 작용을 담당하는 인터페이스입니다. MyBatis는 SQL 매핑을 사용하여 Java 객체와 SQL 문 사이의 매핑을 간편화하고, SqlSession은 이 매핑을 실행하며 결과를 반환합니다.

  간단하게 말하면, SqlSession은 데이터베이스와의 통신을 관리하고 SQL 쿼리를 실행하며, 결과를 받아오는 역할을 합니다. 이를 통해 Java 코드에서 SQL 쿼리를 실행하고 그 결과를 처리할 수 있습니다.

  보통 MyBatis에서는 SqlSessionFactory를 통해 SqlSession을 얻어오게 됩니다. SqlSessionFactory는 데이터베이스 연결 설정 등을 관리하고, SqlSession은 실제 SQL 쿼리를 실행하는 역할을 수행합니다. */
  SqlSession session;
  Page page;
  String uploadPath = "C:\\Users\\io098\\Desktop\\work-newJava\\demo\\src\\main\\resources\\static\\upload\\";

  /* 이 코드는 BoardDao 클래스의 생성자에서 MyBatis의 SqlSessionFactory를 사용하여 SqlSession을 생성하는 부분입니다. 여기서 MybaFactory는 SqlSessionFactory를 생성하고 관리하는 역할을 하는 클래스일 것입니다. openSession() 메서드는 SqlSession을 열어서 반환합니다.

  간단히 말하면, BoardDao 객체가 생성될 때마다 데이터베이스와의 연결을 맺고 SQL 쿼리를 실행할 수 있는 SqlSession을 생성하는 코드입니다. 이렇게 생성된 SqlSession은 데이터베이스와의 상호 작용을 담당하며, SQL 쿼리를 실행하고 결과를 받아올 수 있게 해줍니다.

  예를 들어, BoardDao 객체가 생성될 때마다 해당 객체를 사용하여 데이터베이스와 통신할 수 있게 됩니다. */
  public BoardDao(){
    session = MybaFactory.getFactory().openSession();
  }

  public BoardVo view(int sno){
    // 조회수 증가
    session.update("board.hitUpdate", sno);
  
    // sno에 해당하는 본문글 1건
    /* selectOne은 MyBatis에서 제공하는 메서드 중 하나로, SQL 매핑 파일(XML 파일)에서 지정된 SQL 쿼리를 실행하고 그 결과를 단일 객체로 반환하는 메서드입니다.

    보통 이 메서드는 단일 행을 조회하는 SQL 쿼리에 사용됩니다. 결과가 여러 행이 아닌 한 개의 행만을 기대할 때 사용합니다. 만약 결과가 없거나 여러 행이면 예외가 발생할 수 있습니다. */
    BoardVo vo = session.selectOne("board.view", sno);

    // 첨부 파일 목록
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
    /* selectList는 MyBatis에서 제공하는 메서드 중 하나로, SQL 매핑 파일(XML 파일)에서 지정된 SQL 쿼리를 실행하고 그 결과를 여러 개의 객체로 리스트로 반환하는 메서드입니다.

    selectList는 여러 행을 조회하는 SQL 쿼리에 주로 사용됩니다. 결과가 없을 경우에는 빈 리스트가 반환됩니다 */
    List<BoardAtt> attFiles = session.selectList("board.attFiles", sno);
    vo.setAttFiles(attFiles);
    return vo;
  }

  /* 이 코드는 MyBatis를 사용하여 데이터베이스에서 모든 게시물을 조회하는 메서드입니다.

  session.selectList("board.all"): MyBatis의 SqlSession 객체를 통해 "board.all"이라는 SQL 쿼리를 실행하고, 그 결과를 List<BoardVo> 형태로 받아옵니다. 이때 "board.all"은 MyBatis XML 매핑 파일에서 해당 쿼리를 찾는 경로입니다.
  return list;: 조회한 결과를 호출자에게 반환합니다. 이 메서드를 호출하면 데이터베이스에서 조회한 모든 게시물이 List<BoardVo> 형태로 반환됩니다. */
  public List<BoardVo> selectAll() {
    List<BoardVo> list = session.selectList("board.all");
    return list;
  }

  /* 이 코드는 페이징 처리를 포함한 게시물 목록을 조회하는 메서드입니다. 여러 기능을 수행하는 것으로 보이며, 주요 부분을 살펴보겠습니다.

  int totSize = getTotSize(page);: getTotSize 메서드를 호출하여 전체 게시물 수를 구합니다. 이 메서드에서는 전체 게시물 수를 계산하는 로직이 구현되어 있을 것입니다.
  page.setTotSize(totSize);: 구한 전체 게시물 수를 Page 객체에 설정합니다.
  page.pageCompute();: Page 객체에서 페이징에 필요한 계산을 수행합니다. 이 메서드에서는 전체 페이지 수, 시작 페이지, 끝 페이지 등을 계산할 것입니다.
  list = session.selectList("board.select", page);: MyBatis의 SqlSession을 사용하여 "board.select"라는 SQL 쿼리를 실행하고, 페이징 정보를 담은 Page 객체를 전달합니다. 이를 통해 특정 페이지에 해당하는 게시물 목록을 가져옵니다.
  return list;: 조회한 결과를 호출자에게 반환합니다. 이 메서드를 호출하면 페이징 처리된 게시물 목록이 List<BoardVo> 형태로 반환됩니다. */
  public List<BoardVo> select(Page page) {
    List<BoardVo> list = null;
    int totSize = getTotSize(page);
    page.setTotSize(totSize);
    page.pageCompute();
    this.page = page;

    list = session.selectList("board.select", page);

    return list;
  }

  /* 이 코드는 전체 게시물 수를 조회하는 메서드로 보입니다.

  session.selectOne("board.totSize", page): MyBatis의 SqlSession을 사용하여 "board.totSize"라는 SQL 쿼리를 실행하고, 페이징 정보를 담은 Page 객체를 전달합니다. 이를 통해 해당 페이징 정보에 대한 전체 게시물 수를 가져옵니다.
  int totSize = ...: 조회한 전체 게시물 수를 totSize 변수에 저장합니다.
  return totSize;: 조회한 전체 게시물 수를 반환합니다. */
  public int getTotSize(Page page){
    int totSize = session.selectOne("board.totSize", page);
    return totSize;
  }

  /* 이 코드는 Page 객체를 반환하는 메서드입니다.

  return this.page;: 현재 객체의 page 속성을 반환합니다.
  이 메서드를 호출하면 현재 객체의 page 속성이 반환되고, 이는 주로 페이지 처리와 관련된 정보를 담고 있는 Page 객체일 것입니다. 이러한 정보는 주로 컨트롤러나 뷰에서 페이지 처리를 위해 사용될 것입니다. */
  public Page getPage(){
    return this.page;
  }

  /* 이 코드는 게시물 등록을 처리하는 메서드로 보입니다. 주요한 부분을 살펴보겠습니다.

  int sno = session.selectOne("board.getSerial", "i");: "board.getSerial"이라는 SQL 쿼리를 실행하여 게시물의 일련번호(sno)를 가져옵니다. 이때 'i'라는 문자열이 전달되어 새로운 일련번호를 얻기 위한 것으로 추정됩니다.
  vo.setSno(sno);: 가져온 일련번호를 BoardVo 객체에 설정합니다.
  cnt = session.insert("board.register", vo);: "board.register"라는 SQL 쿼리를 실행하여 게시물 정보를 데이터베이스에 등록합니다.
  for(MultipartFile f : mul) {...}: 전달받은 파일 목록(List<MultipartFile> mul)을 순회하면서 파일을 저장하고, 해당 파일 정보를 BoardAtt 객체에 담아 리스트에 추가합니다.
  cnt = session.insert("board.attRegister", attFiles);: "board.attRegister"라는 SQL 쿼리를 실행하여 게시물에 첨부된 파일 정보를 데이터베이스에 등록합니다.
  session.commit();: 트랜잭션을 커밋합니다. 즉, 모든 작업이 성공했을 때 데이터베이스에 변경 내용을 반영합니다.
  catch(Exception ex) {...}: 예외가 발생한 경우 해당 예외를 처리합니다. 예외가 발생하면 롤백을 수행하고, 이미 저장된 파일들을 삭제합니다. */
  public String registerR(BoardVo vo, List<MultipartFile> mul){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> attFiles = new ArrayList<>(); 

    try{
      int sno = session.selectOne("board.getSerial", "i");
      vo.setSno(sno);
      cnt = session.insert("board.register", vo);
      if(cnt < 1){
        msg = "저장 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      for(MultipartFile f : mul){
        /* if (f.getOriginalFilename().equals("")) continue;: 만약 현재 순회 중인 파일(f)의 원본 파일 이름이 비어 있다면(즉, 파일이 첨부되지 않았다면), 루프를 다음 반복으로 건너뜁니다. 이 부분은 빈 파일이 있을 경우에 대한 예외 처리를 위한 것입니다.

        UUID uuid = UUID.randomUUID();: UUID 클래스를 사용하여 랜덤한 UUID(Universally Unique Identifier)를 생성합니다. 이 UUID는 파일명의 중복을 방지하기 위해 사용됩니다.

        String sysFile = String.format("%s-%s", uuid, f.getOriginalFilename());: 원본 파일 이름과 생성한 UUID를 조합하여 새로운 시스템 파일 이름을 생성합니다. 이 시스템 파일 이름은 서버에 저장될 파일의 이름으로 사용됩니다.

        File saveFile = new File(uploadPath + sysFile);: 서버에 저장될 파일의 경로와 이름을 가지고 있는 File 객체를 생성합니다.

        f.transferTo(saveFile);: MultipartFile에서 File로 파일을 복사합니다. 이는 업로드된 파일을 서버에 저장하는 과정입니다.

        BoardAtt att = new BoardAtt(sno, f.getOriginalFilename(), sysFile);: BoardAtt 객체를 생성하고, 게시물 번호(sno), 원본 파일 이름, 시스템 파일 이름을 설정합니다.

        attFiles.add(att);: 위에서 생성한 BoardAtt 객체를 리스트(attFiles)에 추가합니다. */
        if (f.getOriginalFilename().equals("")) continue;
        UUID uuid = UUID.randomUUID();
        String sysFile = String.format("%s-%s", uuid, f.getOriginalFilename());
        File saveFile = new File(uploadPath + sysFile);
        f.transferTo(saveFile);
        BoardAtt att = new BoardAtt(sno, f.getOriginalFilename(), sysFile);
        attFiles.add(att);
      }
      
      if(attFiles.size() > 0){
        cnt = session.insert("board.attRegister", attFiles);
        if(cnt != attFiles.size()){
          msg = "첨부 파일 저장 중 오류가 발생했어요";
          throw new Exception(msg);
        }
      }
      session.commit();
    }catch(Exception ex){
      msg = ex.getMessage();
      session.rollback();
      for(BoardAtt att : attFiles){
        /* File 클래스는 Java에서 파일 및 디렉토리의 경로명을 캡슐화하고 조작하기 위한 클래스입니다. File 클래스는 파일이나 디렉토리를 생성, 삭제, 읽기, 쓰기 등 다양한 파일 관련 작업을 수행할 수 있게 해줍니다.

        일반적으로 파일 및 디렉토리의 경로를 나타내는 데 사용되며, 이를 통해 파일 시스템에서 파일 및 디렉토리를 조작할 수 있습니다. */
        File delFile = new File(uploadPath + att.getSysFile());
        if(delFile.exists()) delFile.delete();
      }
    }
    
    return msg;
  }

  /* 이 코드는 게시판의 게시물을 수정하는 메서드로 보입니다. 주요 기능은 다음과 같습니다:

  게시물 정보 업데이트:
  session.update("board.update", vo);: MyBatis를 사용하여 게시물 정보를 업데이트합니다. vo는 BoardVo 객체로, 수정된 게시물의 정보가 담겨 있습니다.

  새로운 첨부 파일 저장:
  수정 중에 새로운 첨부 파일이 있다면 해당 파일들을 서버에 저장합니다.
  각 파일은 고유한 UUID를 사용하여 시스템 파일 이름을 생성하고, attFiles 리스트에 해당 파일 정보를 추가합니다.

  첨부 파일 정보 수정:
  새로운 첨부 파일이 있다면 해당 파일 정보를 board.attRegister 쿼리를 통해 데이터베이스에 저장합니다.

  기존 첨부 파일 삭제:
  수정된 게시물에 삭제 대상이 지정된 기존 첨부 파일이 있다면, 해당 파일 정보를 board.deleteAtt 쿼리를 통해 데이터베이스에서 삭제합니다.
  동시에 실제 서버의 파일도 삭제합니다.

  트랜잭션 관리:
  모든 작업이 예외 없이 완료되면 트랜잭션을 커밋합니다.
  작업 중 예외가 발생하면 트랜잭션을 롤백하고 예외 처리를 수행합니다. */
  public String modifyR(BoardVo vo, List<MultipartFile> mul){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> attFiles = new ArrayList<>();

    try{
      cnt = session.update("board.update", vo);
      if(cnt < 1){
        msg = "수정 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      for(MultipartFile f : mul){
        if(f.getOriginalFilename().equals("")) continue;
        UUID uuid = UUID.randomUUID();
        String sysFile = uuid.toString() + "-" + f.getOriginalFilename();
        File saveFile = new File(uploadPath + sysFile);
        f.transferTo(saveFile);
        BoardAtt att = new BoardAtt(vo.getSno(), f.getOriginalFilename(), sysFile);
        attFiles.add(att);
      }

      if(attFiles.size() > 0){
        cnt = session.insert("board.attRegister", attFiles);
        if(cnt != attFiles.size()){
          msg = "첨부 파일 정보 수정 중 오류가 발생했어요";
          throw new Exception(msg);
        }
      }

      if(vo.getDelFile() != null){
        cnt = session.delete("board.deleteAtt", vo.getDelFile());
        if(cnt != vo.getDelFile().length){
          msg = "첨부 파일 정보 삭제 중 오류가 발생했어요";
          throw new Exception(msg);
        }
        for(String f : vo.getDelFile()){
          File delFile = new File(uploadPath + f);
          if(delFile.exists()) delFile.delete();
        }
      }
      session.commit();
    }catch(Exception ex){
      session.rollback();
      for(BoardAtt att : attFiles){
        File f = new File(uploadPath + att.getSysFile());
        if(f.exists()) f.delete();
      }
    }
    return msg;
  }

  /* 이 코드는 게시물을 삭제하는 메서드로 보입니다. 주요 기능은 다음과 같습니다:

  댓글 체크:
  session.selectOne("board.checkRepl", vo);: 해당 게시물에 댓글이 있는지 확인합니다. 댓글이 있다면 삭제가 불가능하도록 예외를 발생시킵니다.

  게시물 삭제:
  session.delete("board.delete", vo.getSno());: MyBatis를 사용하여 게시물을 데이터베이스에서 삭제합니다. vo.getSno()는 삭제 대상 게시물의 일련번호입니다.

  삭제할 첨부 파일 정보 조회:
  delFileList = session.selectList("board.attFiles", vo.getSno());: 삭제할 게시물에 속한 첨부 파일 목록을 조회합니다.

  첨부 파일 정보 삭제:
  삭제할 첨부 파일이 있다면, 해당 파일들에 대한 정보를 board.deleteAtt 쿼리를 통해 데이터베이스에서 삭제합니다.
  동시에 실제 서버의 파일도 삭제합니다.

  트랜잭션 관리:
  모든 작업이 예외 없이 완료되면 트랜잭션을 커밋합니다.
  작업 중 예외가 발생하면 트랜잭션을 롤백하고 예외 처리를 수행합니다. */
  public String deleteR(BoardVo vo){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> delFileList = null;
    try{
      cnt = session.selectOne("board.checkRepl", vo);
      if(cnt > 0){
        msg = "댓글이 있어 삭제가 불가해요";
        throw new Exception(msg);
      }

      cnt = session.delete("board.delete", vo.getSno());
      if(cnt < 1){
        msg = "게시글 삭제 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      // 삭제할 파일 목록
      delFileList = session.selectList("board.attFiles", vo.getSno());

      String[] delFile = new String[delFileList.size()];
      for(int i=0; i < delFileList.size(); i++){
        BoardAtt att = delFileList.get(i);
        delFile[i] = att.getSysFile();
      }

      if(delFileList.size() > 0){ //첨부 파일이 있는 경우
        cnt = session.delete("board.deleteAtt", delFile);
        if(cnt != delFile.length){
          msg = "첨부 파일 정보 삭제 중 오류가 발생했어요";
          throw new Exception(msg);
        }

        // 첨부파일 삭제
        for(String f : delFile){
          File file = new File(uploadPath + f);
          if(file.exists()) file.delete();
        }
      }
      session.commit();
    }catch(Exception ex){
      msg = ex.getMessage();
      session.rollback();
    }
    return msg;
  }

  /* 이 코드는 댓글을 등록하는 메서드로 보입니다. 주요 기능은 다음과 같습니다:

  부모 댓글의 순서 조정:
  session.update("board.seqUp", vo);: 새로운 댓글이 등록되면서 해당 게시물의 기존 댓글들의 순서를 조정하기 위해 사용됩니다.

  댓글 저장:
  session.selectOne("board.getSerial", "i");: 새로운 댓글의 일련번호를 조회합니다.
  vo.setPSno(vo.getSno());: 부모 댓글의 일련번호를 현재 댓글의 PSno(부모일련번호)로 설정합니다.
  vo.setSno(sno);, vo.setSeq(vo.getSeq()+1);, vo.setDeep(vo.getDeep()+1);: 새로운 댓글의 일련번호, 순서, 깊이 등을 설정합니다.
  session.insert("board.repl", vo);: MyBatis를 사용하여 새로운 댓글을 데이터베이스에 저장합니다.

  파일 업로드 및 저장:
  댓글에 첨부된 파일이 있다면 해당 파일들을 업로드하고, 첨부 파일 정보를 board.attRegister 쿼리를 통해 데이터베이스에 저장합니다.

  트랜잭션 관리:
  모든 작업이 예외 없이 완료되면 트랜잭션을 커밋합니다.
  작업 중 예외가 발생하면 트랜잭션을 롤백하고 예외 처리를 수행합니다. */
  public String replR(BoardVo vo, List<MultipartFile> mul){
    String msg = "";
    int cnt = 0;
    List<BoardAtt> attFiles = new ArrayList<>();
    try{
      // 1. board 댓글 저장
      session.update("board.seqUp", vo);
      session.commit();

      int sno = session.selectOne("board.getSerial", "i");
      vo.setPSno(vo.getSno());
      vo.setSno(sno);
      vo.setSeq(vo.getSeq()+1);
      vo.setDeep(vo.getDeep()+1);
      cnt = session.insert("board.repl", vo);
      if(cnt < 1){
        msg = "댓글 저장 중 오류가 발생했어요";
        throw new Exception(msg);
      }

      // 2. 파일 업로드
      for(MultipartFile f : mul){
        if(f.getOriginalFilename().equals("")) continue;
        UUID uuid = UUID.randomUUID();
        String sysFile = uuid.toString() + "-" + f.getOriginalFilename();
        File saveFile = new File(uploadPath + sysFile);
        f.transferTo(saveFile);
        BoardAtt att = new BoardAtt(sno, f.getOriginalFilename(), sysFile);
        attFiles.add(att);
      }

      // 3. boardAtt 저장
      if(attFiles.size() > 0){
        cnt = session.insert("board.attRegister", attFiles);
        if(cnt != attFiles.size()){
          msg = "첨부파일 저장 중 오류가 발생했어요";
          throw new Exception(msg);
        }
      }
      session.commit();
    }catch(Exception ex){
      session.rollback();
      for(BoardAtt att : attFiles){
        File f = new File(uploadPath + att.getSysFile());
        if(f.exists()) f.delete();
      }
    }
    return msg;
  }
}
