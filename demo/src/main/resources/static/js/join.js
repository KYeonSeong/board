$(".signUpMember").on("click", function(){
  let temp = document.frmMember;
  let frm = new FormData(temp);

  $.ajax({
    type : "POST",
    url : "/joinMemberR",
    contentType : false,
    processData : false,
    data : frm,
    success : function(msg){
      if(msg !== ""){
        alert(msg);
      }else{
        alert("회원가입이 완료되었어요");
        window.location.href = "/";
      }
    }
  })
})