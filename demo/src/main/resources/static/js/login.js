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
  let param = $(".frmLogin").serialize();
  $.post("/loginR", param, function (msg) {
    if (msg === "") {
      alert("로그인 되었어요.");
      window.location.replace("/");
    } else {
      alert(msg);
    }
  });
}