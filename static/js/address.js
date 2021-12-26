const city = document.querySelector("#city");
const srch_res = document.querySelector("#srch_res");
const city_id = document.querySelector('#city_id');

city.addEventListener('keyup',()=>{
	let skey = city.value;
	if(skey!=''){
		getCities("city_search.do?skey="+skey).then((data)=>{
			console.log(data);
			srch_res.innerHTML = '';
			for (i=0;i<data.length ;i++ )
			{
				let dv = document.createElement('div');
				dv.setAttribute("class","cities");
				dv.setAttribute("id",data[i].cityId);
				dv.innerHTML = data[i].city;
				srch_res.append(dv);
			}
			srch_res.style.display = 'block';
			const srch_res_divs = document.querySelectorAll('.cities');

			srch_res_divs.forEach((srch_res_div)=>{
				srch_res_div.onclick = ()=>{
					console.log(city,'----',srch_res_div.innerHTML); 
					city.value = srch_res_div.innerHTML;
					city_id.value = srch_res_div.id;
				};
			});	
		}).catch((err)=>{
			console.log(err,'~~~');
		
		});
	}
	

});

city.addEventListener('focusout', () => {
  setTimeout(()=>{
	srch_res.style.display = 'none';
  },500);
});
 


const  getCities = async (url)=>{
	const response = await fetch(url);
	if (response.status!=200)
	{
		throw new Error("No data found.... ");
	}
	//console.log(response,' response - #############');
	const data = await response.json();
	console.log(data,'data - *********');
	return data;
}
/*
window.scroll({
  top: 200,
  behavior: 'smooth'
});*/

//so here we have sent the ajax request using  async and fetch 