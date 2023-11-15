// 클래스가 "signUpMember"인 요소가 클릭되었을 때, 아래에 정의된 함수가 실행
// 회원가입 버튼이 클릭되었을 때 회원가입 기능을 수행하도록 이벤트를 연결하는 역할
$(".signUpMember").on("click", function(){
  // HTML 문서에서 frmMember라는 이름을 가진 form 요소를 가져와서 FormData 객체를 생성  
  let temp = document.frmMember;
  // FormData는 폼 데이터를 쉽게 다룰 수 있게 하는 객체로, 이를 사용하여 폼 데이터를 간편하게 전송할 수 있음
  let frm = new FormData(temp);
  
  //  jQuery의 $.ajax 메서드를 사용하여 비동기적으로 서버에 데이터를 전송
  $.ajax({
    // POST 방식으로 서버에 데이터를 전송
    type : "POST", 
    // 데이터를 전송할 서버의 엔드포인트 URL을 지정
    url : "/joinMemberR",
    // 데이터가 FormData 형식이므로, 컨텐츠 타입을 false로 설정하여 jQuery가 자동으로 컨텐츠 타입을 설정하지 않도록 함 
    contentType : false, 
    // 데이터 처리를 jQuery에게 맡기지 않고, 직접 처리하도록 설정
    processData : false, 
    // 전송할 데이터로서, 앞에서 생성한 FormData 객체를 사용
    data : frm,
    // 서버로부터 응답이 성공적으로 받아졌을 때 실행되는 콜백 함수
    success : function(msg){
      // 서버에서 받은 메시지가 비어있지 않으면(회원가입 실패 시), 해당 메시지를 경고창으로 표시, 그렇지 않으면(회원가입 성공 시), "회원가입이 완료 되었어요!" 알림을 띄우고 홈페이지로 리디렉션
      if(msg !=""){
        alert(msg);
      }else{
        alert("회원가입이 완료 되었어요!");
        window.location.href = "/";
      }
    }
  })
})