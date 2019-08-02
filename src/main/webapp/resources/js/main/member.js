var signup = {
    init : function () {
        var _this = this;
		$('#btn_find_zip').on('click', function(){//우편번호찾기
			find_addr();	
		});

		$('#reg_member').on('click', function () {
			if(check_field()){
				_this.save();
			}
		});
    },
    save : function () {
    	
        var data = {
            username: $('#username').val()
        };

		//아이디 중복체크 
        $.ajax({
            type: 'POST',
            url: '/getUser',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function(result) {
            if(result==true){	//회원가입
				dataFormat();
				$("#userForm").submit();
			}else{	//중복건 존재시
				alert("중복된 아이디가 있습니다.");
				return false;
			}
        }).fail(function (error) {
        	alert("에러발생! 관리자에게 문의하세요.");
		});		
    }
};

signup.init();

//밸리데이션 체크
function check_field(){	
	if($("#username").val()==""){
		alert("아이디를 입력해주세요.");
		$("#username").focus();
		return false;	
	}
	if($("#user_nm").val()==""){
		alert("이름을 입력해주세요.");
		$("#user_nm").focus();
		return false;
	}
	if($("#password").val()==""){
		alert("비밀번호를 입력해주세요.");
		$("#password").focus();
		return false;
	}
	if($("#password_re").val()==""){
		alert("비밀번호 확인을 입력해주세요.");
		$("#password_re").focus();
		return false;
	}
	if($("#password").val()!=$("#password_re").val()){
		alert("비밀번호가 서로 다릅니다. 비밀번호를 확인해주세요.");
		$("#password_re").focus();
		return false;
	}
	if(!$("#check_agree").is(":checked")){
		alert("개인정보 수집·이용에 동의해주세요.");
		$("#check_agree").focus();
		return false;
	}
	return true;
}

//다음우편번호찾기 API
function find_addr(){
	new daum.Postcode({
		oncomplete: function(data) {
			var fullAddr = ''; // 최종 주소
			var extraAddr = ''; // 나머지 주소
	
			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				fullAddr = data.roadAddress;
	
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				fullAddr = data.jibunAddress;
			}
	
			// 사용자가 선택한 주소가 도로명 타입일때 조합한다.
			if(data.userSelectedType === 'R'){
				//법정동명이 있을 경우 추가한다.
				if(data.bname !== ''){
					extraAddr += data.bname;
				}
				// 건물명이 있을 경우 추가한다.
				if(data.buildingName !== ''){
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
				}
				// 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
				fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
			}
			$('#user_zip').val(data.zonecode);
			$('#sub_addr1').val(fullAddr);                
			$('#sub_addr2').focus();
		}
	}).open();
}

//회원가입 위한 데이터 formating
function dataFormat(){
	//주소
	$("#user_addr").val($("#sub_addr1").val() +" "+ $("#sub_addr2").val());
	//연락처
	$("#user_phone").val(return_num($("#user_phone").val()));
}
