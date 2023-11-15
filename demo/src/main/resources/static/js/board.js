// move 함수는 페이지 이동을 처리합니다. 현재 페이지 정보를 갱신하고, 해당 정보를 사용하여 "/brdList" 페이지를 AJAX로 로드하여 게시판의 목록을 갱신
function move(nowPage){
  let frm = document.frmBoard;
  frm.nowPage.value = nowPage;
  let param = $(frm).serialize();
  $("#board").load("/brdList", param);
}

// view 함수는 특정 게시물의 상세 내용을 보여주는 동작을 처리
// 게시물 번호(sno)를 전달하고, "/brdView" 페이지를 해당 게시물에 대한 정보로 로드
function view(sno){
  let param = "sno=" + sno;
  $(".section").load("/brdView", param);
}

// 클래스가 "btnList"인 요소가 클릭되었을 때, 현재 검색 및 페이지 정보를 포함한 폼 데이터를 사용하여 "/brdList" 페이지를 AJAX로 로드하여 게시판의 목록을 갱신
$(".btnList").on("click", function(){
  let param = $(".frmBoard").serialize();
  $(".section").load("/brdList", param);
})

// 클래스가 "btnFind"인 요소가 클릭되었을 때, move 함수를 호출하여 첫 페이지의 검색 결과를 표시
$(".btnFind").on("click", function(){
  move(1);
})

// 클래스가 "btnRegister"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnRegister").on("click", function(){
  //  HTML 문서에서 frmBoard라는 이름을 가진 폼 요소를 가져와서 변수 frm에 할당
  let frm = document.frmBoard;
  // jQuery의 serialize 메서드를 사용하여 폼 데이터를 URL-encoded 문자열로 직렬화
  // 이렇게 함으로써 폼 데이터를 서버에 쉽게 전송할 수 있음
  let param = $(frm).serialize();
  // 재 날짜와 시간 정보를 가져와서 toLocaleString 메서드를 사용하여 문자열로 변환
  let nal = new Date().toLocaleString();
  // 앞서 생성한 URL-encoded 문자열에 추가적으로 "nal"이라는 파라미터를 생성하고, 그 값을 현재 날짜 및 시간 문자열로 설정
  param += "&nal=" + nal;
  // 클래스가 "section"인 요소 안에 "/brdRegister" 페이지를 AJAX를 통해 로드
  // 이때 앞서 생성한 URL-encoded 문자열이 쿼리 파라미터로 전달되어 서버에 전달
  $(".section").load("/brdRegister", param);
})

// 클래스가 "btnRegisterR"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnRegisterR").on("click", function(){
  // HTML 문서에서 frmBoard라는 이름을 가진 폼 요소를 가져와서 변수 temp에 할당
  let temp = document.frmBoard;
  // 폼 요소의 enctype 속성을 "multipart/form-data"로 설정
  // 이는 파일 업로드를 위해 필요한 설정 중 하나
  temp.enctype = "multipart/form=data"
  // FormData 객체를 생성하여 폼 데이터를 담고, 이 객체는 파일 업로드를 지원하며 여기에 폼 데이터가 담긴다
  let frm = new FormData(temp);
  
  // jQuery를 사용하여 AJAX 요청을 정의
  $.ajax({
    //  HTTP 요청 메서드를 POST로 설정
    type : "POST",
    // 요청을 보낼 서버의 엔드포인트를 지정
    url : "/brdRegisterR",
    // 데이터 타입을 자동으로 설정하지 않도록 함
    contentType : false,
    // 데이터 처리를 jQuery에 맡기지 않고 직접 처리하도록 함
    processData : false,
    // 폼 데이터가 담긴 FormData 객체를 요청 데이터로 설정
    data : frm,
    // 서버 요청이 성공하면 실행되는 콜백 함수
    success : function(msg){
      // 서버에서 반환된 메시지가 비어있지 않으면 알림을 띄움
      if(msg !="") alert(msg);
      // "btnList" 클래스가 있는 요소가 클릭되도록 시뮬레이트하여, 게시판 목록 페이지를 로드
      $(".btnList").click();
    }
  })
})

// 클래스가 "btnModify"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnModify").on("click", function(){
  // 현재 문서에서 "frmBoard" 클래스를 가진 폼 요소의 데이터를 가져와서, URL-encoded 문자열로 직렬화
  let param = $(".frmBoard").serialize();
  // 클래스가 "section"인 요소 안에 "/brdModify" 페이지를 AJAX를 통해 로드
  // 앞서 가져온 폼 데이터가 쿼리 파라미터로 전달되어, 수정할 게시물의 정보를 서버에 전달
  $(".section").load("/brdModify", param);
})

// 클래스가 "btnModifyR"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnModifyR").on("click", function(){
  //  HTML 문서에서 frmBoard라는 이름을 가진 폼 요소를 가져와서 변수 temp에 할당
  let temp = document.frmBoard;
  // 폼 요소의 enctype 속성을 "multipart/form-data"로 설정
  // 이는 파일 업로드를 위해 필요한 설정 중 하나
  temp.enctype = "multipart/form-data";
  // FormData 객체를 생성하여 폼 데이터를 담고, 이 객체는 파일 업로드를 지원하며 여기에 폼 데이터가 담긴다
  let frm = new FormData(temp);

  // jQuery를 사용하여 AJAX 요청을 정의
  $.ajax({
    //  HTTP 요청 메서드를 POST로 설정
    type : "POST",
    // 요청을 보낼 서버의 엔드포인트를 지정
    url : "/brdModifyR",
    // 데이터 타입을 자동으로 설정하지 않도록 함
    contentType : false,
    // 데이터 처리를 jQuery에 맡기지 않고 직접 처리하도록 함
    processData : false,
    // 폼 데이터가 담긴 FormData 객체를 요청 데이터로 설정
    data : frm,
    // 서버 요청이 성공하면 실행되는 콜백 함수
    success : function(msg){
      // 서버에서 반환된 메시지가 비어있지 않으면 알림을 표시
      if(msg != "") alert(msg);
      // "btnList" 클래스가 있는 요소가 클릭되도록 시뮬레이트하여, 게시판 목록 페이지를 로드
      $(".btnList").click();
    }
  })
})

// 클래스가 "btnDelete"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnDelete").click(function(){
  // 현재 문서에서 "frmBoard" 클래스를 가진 폼 요소의 데이터를 가져와서, URL-encoded 문자열로 직렬화
  let param = $(".frmBoard").serialize();
  // jQuery를 사용하여 GET 요청을 보냄
  // url : "/brdDeleteR": 요청을 보낼 서버의 엔드포인트를 지정
  // data : param, 폼 데이터가 담긴 직렬화된 문자열을 요청 데이터로 설정
  // function : 서버에서 응답이 도착하면 실행되는 콜백 함수
  $.get("/brdDeleteR", param, function(msg){
    // 서버에서 반환된 메시지가 비어있으면 (삭제가 성공했다면) 아래 내용을 실행
    if(msg === ""){
      alert("삭제가 완료되었습니다.");
      //  "section" 클래스가 있는 요소 안에 "/brdList" 페이지를 AJAX를 통해 로드, 이를 통해 게시물 목록 페이지를 갱신
      $(".section").load("brdList", param);
      // 서버에서 반환된 메시지가 비어있지 않고, 삭제에 실패했다면 아래 내용을 실행
    } else if (msg != "") {
      alert(msg);
      // 서버 응답이 비어 있지 않지만, 삭제 실패 메시지도 아닌 경우 (예상치 못한 오류 등) 아래 내용을 실행
    } else {
      alert("오류가 발생했습니다.");
    }
  })
})

// 클래스가 "btnRepl"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnRepl").on("click", function(){
  // 현재 문서에서 "frmBoard" 클래스를 가진 폼 요소의 데이터를 가져와서, URL-encoded 문자열로 직렬
  let param = $(".frmBoard").serialize();
  // 현재 날짜와 시간을 나타내는 문자열을 생성
  let nal = new Date().toLocaleString();
  // 이전에 가져온 폼 데이터에 새로운 파라미터를 추가, 이 경우 현재 날짜와 시간 정보가 "nal"이라는 파라미터로 추가
  param += "&nal=" + nal;
  // "section" 클래스가 있는 요소 안에 "/brdRepl" 페이지를 AJAX를 통해 로드
  //  이때 앞서 생성한 폼 데이터와 추가된 날짜와 시간 정보가 쿼리 파라미터로 전달되어, 답글 작성 페이지로 이동
  $(".section").load("/brdRepl", param);
})

// 클래스가 "btnReplR"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
$(".btnReplR").on("click", function(){
  // HTML 문서에서 frmBoard라는 이름을 가진 폼 요소를 가져와서 변수 temp에 할당
  let temp = document.frmBoard;
  // 폼 요소의 enctype 속성을 "multipart/form-data"로 설정, 이는 파일 업로드를 위해 필요한 설정 중 하나
  temp.enctype = "multipart/form-data";
  // FormData 객체를 생성하여 폼 데이터를 담고, 이 객체는 파일 업로드를 지원하며 여기에 폼 데이터가 담긴다.
  let frm = new FormData(temp);

  // jQuery를 사용하여 AJAX 요청을 정의
  $.ajax({
    // HTTP 요청 메서드를 POST로 설정
    type : "POST",
    // 요청을 보낼 서버의 엔드포인트를 지정
    url : "/brdReplR",
    // 데이터 타입을 자동으로 설정하지 않도록 함
    contentType : false,
    // 데이터 처리를 jQuery에 맡기지 않고 직접 처리하도록 함
    processData : false,
    // 폼 데이터가 담긴 FormData 객체를 요청 데이터로 설정
    data : frm,
    // 서버 요청이 성공하면 실행되는 콜백 함수
    success : function(msg){
      // 서버에서 반환된 메시지가 비어있지 않으면 알림을 표시
      if(msg != "") alert(msg);
      // "btnList" 클래스가 있는 요소가 클릭되도록 시뮬레이트하여, 게시판 목록 페이지를 로드
      $(".btnList").click();
    }
  })
})