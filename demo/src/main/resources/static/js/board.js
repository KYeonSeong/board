function move(nowPage){
  let frm = document.frmBoard;
  frm.nowPage.value = nowPage;
  let param = $(frm).serialize();
  $("#board").load("/brdList", param);
}

function view(sno){
  let param = "sno=" + sno;
  $(".section").load("/brdView", param);
}



$(".btnList").on("click", function(){
  let param = $(".frmBoard").serialize();
  $(".section").load("/brdList", param);
})

$(".btnFind").on("click", function(){
  move(1);
})

$(".btnRegister").on("click", function(){
  let frm = document.frmBoard;
  let param = $(frm).serialize();
  let nal = new Date().toLocaleString();
  param += "&nal=" + nal;
  $(".section").load("/brdRegister", param);
})

$(".btnRegisterR").on("click", function(){
  let temp = document.frmBoard;
  temp.enctype = "multipart/form=data"
  let frm = new FormData(temp);

  $.ajax({
    type : "POST",
    url : "/brdRegisterR",
    contentType : false,
    processData : false,
    data : frm,
    success : function(msg){
      if(msg !="") alert(msg);
      $(".btnList").click();
    }
  })
})

$(".btnModify").on("click", function(){
  let param = $(".frmBoard").serialize();
  $(".section").load("/brdModify", param);
})

$(".btnModifyR").on("click", function(){
  let temp = document.frmBoard;
  temp.enctype = "multipart/form-data";
  let frm = new FormData(temp);

  $.ajax({
    type : "POST",
    url : "/brdModifyR",
    contentType : false,
    processData : false,
    data : frm,
    success : function(msg){
      if(msg != "") alert(msg);
      $(".btnList").click();
    }
  })
})

$(".btnDelete").click(function(){
  let param = $(".frmBoard").serialize();
  $.get("/brdDeleteR", param, function(msg){
    if(msg != "") alert(msg);
    $(".section").load("brdList", param);
  })
})

$(".btnRepl").on("click", function(){
  let param = $(".frmBoard").serialize();
  let nal = new Date().toLocaleString();
  param += "&nal=" + nal;
  $(".section").load("/brdRepl", param);
})

$(".btnReplR").on("click", function(){
  let temp = document.frmBoard;
  temp.enctype = "multipart/form-data";
  let frm = new FormData(temp);

  $.ajax({
    type : "POST",
    url : "/brdReplR",
    contentType : false,
    processData : false,
    data : frm,
    success : function(msg){
      if(msg != "") alert(msg);
      $(".btnList").click();
    }
  })
})