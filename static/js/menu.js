const srh_field = document.querySelector('#srh');

const srh_btn = document.querySelector('#srh_btn');
srh_btn.addEventListener('click',(e)=>{
	//console.log(`${srh_field.value}`,'####################');
	window.location = `search_result.jsp?search=${srh_field.value}`;

});