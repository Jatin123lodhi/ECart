const cartIcon = document.querySelector('#img2');
const cartNo = document.querySelector('#cartNo');
const srh = document.querySelector('#srh');



//#######################################################
const search_key = document.querySelector('#search_key');
const blk1 = document.querySelector('#blk1');
const dashboard_info = document.querySelector('#dashboard_info');
const no_rec = document.querySelector('#no_rec');

srh.value = search_key.value;

const all_products = async ()=>{
	const url = 'search.do?';
	const query = `search_key=${search_key.value}`;

	const response = await fetch(url+query);
	const data = await response.json();

	return data;
	
};

const addToCart = async (productId)=>{
	const url = "add_to_cart.do?";
	const query = `product_id=${productId}`;
	const response = await fetch(url+query);
	const data = await response.json();
	return data;
}
/*
<a href="view_product.do?product_id=${product.productId}" id="product_nm"> ${product.productName}</a>
									<img class="act_btn addtocartbtn" data-atcb="${product.productId}" src="static/images/addtocart.png" id="del" > 
<img class="act_btn buynowbtn" data-bnb="${product.productId}" src="static/images/buy.png" id="edit">
<span class="quantity">Avaliable Quantity : ${product.quantity}</span>
<span class="discount">Discount : ${product.discount}</span>

*/

const showProducts = (products)=>{
	
	no_rec.style.display = 'none';
	console.log(products,'---products');
	document.querySelector('#allprods_ttl').innerHTML = 'Search Results for - '+search_key.value;
	if (products.length!=0)
	{	blk1.innerHTML = '';
		//dashboard_info.innerHTML = `<div id="allprods_ttl">Search Results for - '${search_key.value}' </div>`;
		 
		products.forEach((product)=>{
		
			blk1.innerHTML +=  `
								<div class="inr_left">
									<div>
										<a href="view_product.do?product_id=${product.productId}" id="product_nm">
											<img src="product_img.do?product_id=${product.productId}" class="prod_img"/>
										</a>
									</div>
									<div>
										<a href="view_product.do?product_id=${product.productId}" id="product_nm"> ${product.productName}</a>
									</div>
									<div>	
										<span class="price"> Rs. ${product.price}</span>&nbsp;
										
									</div>

								</div> 
								 
							 `;


			});
		const buynowbtn = Array.from(document.querySelectorAll('.buynowbtn'));
		const addtocartbtn = Array.from(document.querySelectorAll('.addtocartbtn'));

		addtocartbtn.forEach((atcb)=>{
			atcb.addEventListener('click',(e)=>{
				//console.log(e.target.getAttribute('data-atcb'),'$$$$$$$');
				let productId = e.target.getAttribute('data-atcb');
				addToCart(productId)
				.then((data)=>{
					console.log(data);
					cartNo.innerHTML = data.productCount;
				})
				.catch((err)=>{
					console.log(err);
				})
			});
		
		});
				
	}else{
			no_rec.style.display = 'block';
			console.log('display block ..........####');
	}
}



window.addEventListener('load',(e)=>{
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

})