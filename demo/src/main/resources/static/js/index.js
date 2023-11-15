// 클래스가 "menuHome"인 요소가 클릭되었을 때, 현재 창의 위치를 홈페이지("/")로 이동
$(".menuHome").on("click", function(){
    location.href="/";
})

// 클래스가 "menuBoard"인 요소가 클릭되었을 때, 클래스가 "section"인 요소 안에 "/brdList" 페이지의 내용을 AJAX를 통해 로드, 이를 통해 게시판 목록 페이지를 현재 페이지에 동적으로 로드
$(".menuBoard").on("click", function(){
    $(".section").load("/brdList");
})

// 클래스가 "Login"인 요소가 클릭되었을 때, 로그인 페이지("/login")로 이동
$(".Login").on("click", function(){
    location.href = "/login";
})

// 클래스가 "Logout"인 요소가 클릭되었을 때, 서버에 로그아웃 요청을 보냄
$(".Logout").on("click", function(){
  // 서버에서 응답을 받으면 현재 창의 위치를 홈페이지("/")로 이동
  $.get("/logoutR", null, function(msg){
    location.href = "/";
  })
})

// 클래스가 "signUpBtn"인 요소가 클릭되었을 때, 회원가입 페이지("/joinMemberShip")로 이동
$(".signUpBtn").on("click", function(){
  location.href = "/joinMemberShip";
})
