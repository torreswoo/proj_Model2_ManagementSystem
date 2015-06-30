function joinCheck(){
	
	var name = document.joinForm.name;
	if (name.value.length == 0) {
		alert("이름을 써주세요.");
		name.focus();
		return false;
	}
	return true;
}

