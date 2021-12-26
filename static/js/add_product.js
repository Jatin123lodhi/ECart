const form = document.forms;
//so form will be An HTMLCollection object listing all of the document's forms.

const step = document.querySelectorAll('.step_box');


const li_node = document.querySelectorAll("li");//querySelectorAll returns the node list obj
const steps_li = Array.from(li_node);

const product_title = Array.from(document.querySelectorAll(".product_title"));


const product_id_field = document.querySelector("#product_id");
const tbody = document.querySelector("#tbody_part");
const add_btn = document.querySelector("#add");
const add_btn8 = document.querySelector("#add_btn");
const upload_field_box = document.querySelector("#upload_filed_box");

//############ product pic adding row and cell ###################3
let n=1;
add_btn8.addEventListener('click',()=>{
	
	let nrow8 = upload_field_box.insertRow(n++);

	let inrow = nrow8.insertCell(0);
	inrow.innerHTML = `${n}. <input type= 'file' name= 'product_pic_${n}' class='input_file'>`;
	
	//inrow.innerHTML = `${n}.`;

	//inrow = nrow8.insertCell(1);
	//inrow.className = 'button';
	
	//let fup = document.createElement('input');
	//fup.type = 'file';
	//fup.name = `product_pic_${n}`;
	//fup.className = 'button';

	//inrow.append(fup);

	
});


//############ 7 thead js #################################
let row = 1;
add_btn.addEventListener('click',()=>{

	const nrow  = tbody.insertRow(row++);
	const cell1 = nrow.insertCell(0);
	const cell2 = nrow.insertCell(1);
	const cell3 = nrow.insertCell(2);
	
	cell1.innerHTML = `${row}.`;	
	const input_field = document.createElement("input");
	input_field.className = 'col2';
	//cell2.innerHTML = input_field;                                   cheack karenge difference 
	cell2.append(input_field);
	cell3.innerHTML = '<textarea rows="3" cols="22" class="col3" ></textarea>';

});
//########################################################


//############### +++++++++++++++++++++ #######################
const saveProductNextStep = async (request) => {	

	const response = await fetch(request);
	const data = await response.json();

	return data;
};

//##################### 7. Product Point table #################
form[6].addEventListener('submit',(e)=>{
	e.preventDefault();
	const url = 'save_product_points.do?';

	const p_ttls = Array.from(document.querySelectorAll('.col2'));
	const p_txts = Array.from(document.querySelectorAll('.col3'));

	let query = '';
	let i = 0;
	p_ttls.forEach((ttl)=>{
		if (i==0)
		{
			query += `p_ttl=${encodeURIComponent(ttl.value)}`;
			console.log(query);
		}else{
			query += `&p_ttl=${encodeURIComponent(ttl.value)}`;
			console.log(query);
		}
		i++;
	});

	p_txts.forEach((txt)=>{
		query += `&p_txt=${txt.value}`;
		console.log(query);
	});





	
	saveProductNextStep(url+query).then((data)=>{
		if (data.resp==1)
		{
			step[6].parentElement.classList.add('hide');	
			step[6].parentElement.children[0].classList.add('hide');	
			step[6].classList.add('hide');	
			step[7].classList.remove('hide');
			steps_li[7].className = 'sel';
		}else if(data.resp==0){
		
		}else{
			window.location = 'signin.do';
		}
	}).catch((err)=>{
	
		console.log(err);
	
	});

});



//##################### 6. Payment Details #####################
form[5].addEventListener('submit',(e)=>{
	e.preventDefault();
	
	const url = 'save_payment_details.do?';
	const query = `payment_details=${encodeURIComponent(form[5].payment_details.value)}`;

	saveProductNextStep(url+query)
		.then((data)=>{
			if(data.resp==1){
				step[5].parentElement.classList.add('hide');	
				step[5].parentElement.children[0].classList.add('hide');	
				step[5].classList.add('hide');	
				step[6].classList.remove('hide');	
				steps_li[6].className = 'sel';
			}else if(data.resp==0){
			
			}else{
				window.location = 'signin.do';
			}
		})
		.catch((err)=>{
			console.log(err);
		});
});
//##################### 5. Shipment Details #####################
form[4].addEventListener('submit',(e)=>{
	e.preventDefault();

	const url = 'save_shipment_details.do?';
	const query = `shipment_details=${encodeURIComponent(form[4].shipment_details.value)}`;
	
	saveProductNextStep(url+query)
		.then((data)=>{
			if(data.resp===1){
				step[4].parentElement.classList.add('hide');	
				step[4].parentElement.children[0].classList.add('hide');	
				step[4].classList.add('hide');	
				step[5].classList.remove('hide');	
				steps_li[5].className = 'sel';
			}else if(data.resp===0){
			
			}else{
				window.location = 'signin.do';
			}
		}).catch((err)=>{
			console.log(err);
		});
});



//##################### 4. Returning Policy #####################
form[3].addEventListener('submit',(e)=>{
	e.preventDefault();
	
	const url = 'save_returning_policy.do?';
	const query = `returning_policy=${encodeURIComponent(form[3].returning_policy.value)}`;

	saveProductNextStep(url+query)
		.then((data)=>{
			if(data.resp===1){
				step[3].parentElement.classList.add('hide');	
				step[3].parentElement.children[0].classList.add('hide');	
				step[3].classList.add('hide');	
				step[4].classList.remove('hide');
				
				steps_li[4].className = 'sel';
			}else if(data.resp===0){
			
			}else{
				window.location = 'signin.do';
			}
		}).catch((err)=>{
			console.log(err);
		});
});
//####### 3. Save Warranty #################;

form[2].addEventListener('submit',(e)=>{
	e.preventDefault();
	const url = "save_warranty.do?";
	
	const query = `warranty=${encodeURIComponent(form[2].warranty.value)}&product_id=${product_id_field.value}`;
	saveProductNextStep(url+query)
		.then((data)=>{
			if(data.resp===1){
				step[2].parentElement.classList.add('hide');	
				step[2].parentElement.children[0].classList.add('hide');	
				step[2].classList.add('hide');	
				step[3].classList.remove('hide');	
				steps_li[3].className = 'sel';
				
			}else if(data.resp===0){
			
			}else{
				window.location = 'signin.do';
			}
		}).catch((err)=>{
			console.log(err);
		});
});





//######################## 2. Save Description ######################

form[1].addEventListener('submit',(e)=>{
	e.preventDefault();
	const url = "save_description.do?";
	
	const query = `description=${encodeURIComponent(form[1].description.value)}&product_id=${product_id_field.value}`;
	saveProductNextStep(url+query)
	.then((data)=>{
		if (data.resp==-1)
		{
			window.location = 'signin.do';	
		}else{
			step[1].parentElement.classList.add('hide');	
			step[1].parentElement.children[0].classList.add('hide');	
			step[1].classList.add('hide');	
			step[2].classList.remove('hide');
			steps_li[2].className = "sel";
		}
	
	}).catch((err)=>{
		console.log(err);
	});
});



//############################ 1. Save Product #######################

form[0].addEventListener('submit',(e)=>{
	e.preventDefault();
	console.log('****');
	const url = 'add_new_product.do?';
	const query = `category_id=${form[0].category_id.value}&product_name=${encodeURIComponent(form[0].product_name.value)}&quantity=${form[0].quantity.value}&price=${form[0].price.value}&discount=${form[0].discount.value}`;
	saveProductNextStep(url+query)
		.then((data)=>{
		if(data.resp==0){
				window.location = 'signin.do';				
		}else{
			if(data.productId){					
				product_id_field.value = data.productId; 
				
				step[0].parentElement.classList.add('hide');	
				step[0].classList.add('hide');	
				step[1].classList.remove('hide');

				steps_li[1].className = 'sel';

				product_title.forEach((title)=>{
					title.innerHTML = data.productName;
				});
			}
		}
	}).catch((err)=>{
			console.log(err);
		});
		
});

 
 
  