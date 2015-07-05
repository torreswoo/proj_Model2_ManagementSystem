// 회워 가입을 위해 form전체로 입력받는 내용을 check하는 함수 
function joinCheck(){
	
	var name = document.joinForm.name;
	if (name.value.length == 0) {
		alert("이름을 써주세요.");
		name.focus();
		return false;
	}
	
	
	var reid = document.joinForm.reid;
	if (reid.value.length == 0) {
		alert("아이디 중복체크를 해주세요! ");
		reid.focus();
		return false;
	}
	
	
	return true;
}



// id 중복체크를위해 사용 
function idCheck(){
	
	var userid = document.joinForm.userid;
	
	//제대로 id가 입력되었는지를 체크 
	if( userid.value.length == 0 ){
		alert("Enter the id!");
		userid.foucs();
		return false;		
	}
	
	//
	var url = "../idCheck.do?userid="+ userid.value; 
	window.open(url, "ID중복을 체크합니다.", "toolbar=yes, menubar=yes, resizable=yes, width=450, height=200");
	
	return true;
	
}
// id 중복체크후에 사용 
function idOk(){
	opener.joinForm.userid.value  =  "${userid}"  // "${useable_userid}";
	opener.joinForm.reid.value  =   "${userid}" // "${useable_userid}";
	self.close();  //window.close();	
	
}