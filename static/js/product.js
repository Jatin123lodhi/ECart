//########## for pics from database   ###############################
const productId = document.querySelector("#productId");

const getProductPics = async ()=>{
	const url = 'all_product_pics.do?';
	const query = `product_id=${productId.value}`;

	const response = await fetch(url+query);
	const data = await response.json();
	
	return data;
}
const sidePics = document.querySelector("#side_pics");
const focus_pic = document.querySelector('#focus_pic');
const showProductPics = (pics)=>{
	sidePics.innerHTML = '';
	let i = 0;
	pics.forEach((pic)=>{
		const path = 'WEB-INF/uploads/';
		//console.log(path+pic.productPic);

		if (i==0)
		{
			focus_pic.innerHTML  = `<img class='focus_pic_img' src="product_pic.do?product_pic=${pic.productPic}" />`;
			
		}
		i++;
		//sidePics.innerHTML += `<div class="side_pics"><img src="product_pic.do?product_pic=${pic.productPic}" /> </div>`
		sidePics.innerHTML += `<img class='side_pic_img' src="product_pic.do?product_pic=${pic.productPic}"  />` 
	});

	const small_pics = Array.from(document.querySelectorAll("#side_pics img"));
	const focus_img = document.querySelector("#focus_pic img");
	small_pics.forEach((pic)=>{
		pic.addEventListener('click',(e)=>{
			focus_img.src = e.target.src;
		
		});
	});

}
const prod_point_tbl = document.querySelector("#prod_point_tbl");


const getProductPoints = async ()=>{
	const url = "get_product_points.do?";
	const query = `product_id=${productId.value}`;
	
	const response = await fetch(url+query);
	const data = await response.json();
	
	return data;
}

const showProductPoints = (prodcutPoints)=>{
	let i = 0;
	prodcutPoints.forEach((prod_pt)=>{
		let row = prod_point_tbl.insertRow(i++);
		let cell1 = row.insertCell(0);
		let cell2 = row.insertCell(1);
		cell1.innerHTML = prod_pt.pointHeader;
		cell2.innerHTML = prod_pt.pointValue;
		
	});

}
window.addEventListener('load',()=>{
	getProductPics()
	.then((data)=>{
		showProductPics(data);
	}).catch((error)=>{
		console.log(error,'$$$$$$$$$$$$$$$$');
	});
	
	getProductPoints()
	.then((data)=>{
		showProductPoints(data);
	})
	.catch((err)=>{
		console.log(err);
	});
});



//################# For DETAIL TAB #################################

const tabs = Array.from(document.querySelectorAll('.tabs'));

const odtl = Array.from(document.querySelectorAll('.odtl'));

let i = 0;
tabs.forEach((tab)=>{
	
	tab.tmp = odtl[i++];
	
	tab.addEventListener('click',(e)=>{
		
		tabs.forEach((tab2)=>{tab2.className = 'tabs';});
		e.target.className = 'tabs change_clr';

		odtl.forEach((tab2)=>{ tab2.className = 'odtl hide';});
		e.target.tmp.className = 'odtl show';
		console.log(e.target.tmp);

	});
});