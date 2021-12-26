const srh_field = document.querySelector('#srh_field');

const srh_btn = document.querySelector('#srh');

srh_btn.addEventListener('click',(e)=>{
	
	window.location = `search_result.jsp?search=${srh_field.value}`;

});