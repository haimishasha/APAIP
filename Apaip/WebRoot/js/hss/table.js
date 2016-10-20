$("#total-choose").change(function(){
	if(this.checked){
		//alert("checked");
		$("input[type='checkbox']").attr("checked", true);
	}else{
		//alert("unchecked");
		$("input[type='checkbox']").removeAttr("checked", true);
	}
	
});


