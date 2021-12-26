//############### dashboard tabs control ####################
const tabs = Array.from(document.querySelectorAll(".dashboard_tab"));

const info_div = Array.from(document.querySelectorAll(".info_div"));

let i=0;
tabs.forEach((tab)=>{
	tab.blk = info_div[i++];
	tab.addEventListener('click',(e)=>{
	
		tabs.forEach((tab_)=>{ tab_.className = 'dashboard_tab inactive' });
		e.target.className = 'dashboard_tab active';
		tabs.forEach((tab_)=>{ tab_.blk.className = 'info_div hide'});
		e.target.blk.className = 'info_div show';
	});

});



//############### information part ##########################
const all_prod = document.querySelector('#all_products');

const seller_id_ = document.querySelector('#seller_id');

const blk1 = document.querySelector('#blk1');

const no_rec = document.querySelector('#no_rec');


const all_products = async ()=>{
	const url = 'all_product.do?';
	const query = `seller_id=${seller_id_.value}`;

	const response = await fetch(url+query);
	const data = await response.json();

	return data;
	
};

const showProducts = (products)=>{
	
	no_rec.style.display = 'none';
	
	if (products.length!=0)
	{	blk1.innerHTML = '';
		products.forEach((product)=>{
		
			blk1.innerHTML +=  `<div  class="info_">
									<div class="inr_left">
										<img src="product_img.do?product_id=${product.productId}" class="prod_img"/>
									</div> 
									<div class="inr_right">
										<a href="view_product.do?product_id=${product.productId}" id="product_nm"> ${product.productName}</a>
										<a href="delete_product.do?product_id=${product.productId}"><img src="static/images/del.png" id="del"></a>
										<a href="edit_product.do?product_id=${product.productId}"><img src="static/images/edit.png" id="edit"></a>
										
										<span class="price">Price: &nbsp;&nbsp;Rs.${product.price}</span>&nbsp;
										<span class="quantity">Quantity: &nbsp;&nbsp;${product.quantity}</span>
										<span class="discount">Discount: &nbsp;&nbsp;${product.discount}%</span>
									</div>
								</div>`;


			});
	}else{
			no_rec.style.display = 'block';
			console.log('display block ..........####');
	}
}

console.log(all_prod,'@@@@@@@@@@');
all_prod.addEventListener('click',()=>{
	
	all_products().then((data)=>{
		if (data=='session expired')
		{
			window.location= 'signin.jsp';
		}else{

			showProducts(data);
		}
		//console.log(data);
		
	})
	.catch((error)=>{
		console.log(error);
	});
});


all_products().then((data)=>{
		if (data=='session expired')
		{
			window.location= 'signin.jsp';
		}else{
			
			showProducts(data);
		
		}
	        
	})
	.catch((error)=>{
		console.log(error);
	});


