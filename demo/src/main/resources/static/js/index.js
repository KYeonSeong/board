
$(".menuHome").on("click", function(){
    location.href="/";
})
  
$(".menuBoard").on("click", function(){
    $(".section").load("/brdList");
})

$(".Login").on("click", function(){
    location.href = "/login";
})

$(".Logout").on("click", function(){
  $.get("/logoutR", null, function(msg){
    location.href = "/";
  })
})

$(".signUpBtn").on("click", function(){
  location.href = "/joinMemberShip";
})
