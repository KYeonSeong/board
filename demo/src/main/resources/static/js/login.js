// 클래스가 "loginBtns"인 요소가 클릭되면 loginUser 함수가 호출
// 로그인 버튼이 클릭되었을 때 로그인 기능을 수행하도록 이벤트를 연결하는 역할
$(".loginBtns").on("click", function () {
  loginUser();
});

// 엔터 키로 로그인 가능하도록 처리
$(".frmLogin").on("keydown", function (event) {
  if (event.keyCode === 13) { // Enter 키의 keyCode는 13
    loginUser();
  }
});

// 실제 로그인 기능을 수행하는 함수
function loginUser() {
  // "frmLogin" 클래스를 가진 폼 안의 모든 입력 필드의 값을 가져와서 URL-encoded 문자열로 변환
  let param = $(".frmLogin").serialize();
  // POST 요청을 사용하여 "/loginR" 엔드포인트에 데이터를 전송
  // 전송한 데이터는 폼에 입력된 값들이며, 서버에서 처리 결과를 받아오면 콜백 함수가 실행
  $.post("/loginR", param, function (msg) /* 서버에서 받은 응답을 처리하는 콜백 함수*/ {
    // 서버에서 받은 메시지가 비어있으면(즉, 로그인이 성공하면) "로그인 되었어요." 알림을 띄우고 홈페이지로 리디렉션
    // 그렇지 않으면 서버에서 받은 메시지(로그인 실패 원인)를 알림
    if (msg === "") {
      alert("로그인 되었어요.");
      window.location.replace("/");
    } else {
      alert(msg);
    }
  });
}