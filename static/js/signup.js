const username_err = document.querySelector('.username_err');
const email_err = document.querySelector('.email_err');
const password = document.querySelector('.password_err');
const repassword = document.querySelector('.repassword_err');

const uname_err = document.querySelector('.userNm_err');
const eml_err = document.querySelector('.eml_err');
const pass_err = document.querySelector('.pass_err');
const repass_err = document.querySelector('.repass_err');

const unm = document.querySelector('.unm');
const eml = document.querySelector('.eml');
const pwd = document.querySelector('.pwd');
const rpwd = document.querySelector('.rpwd');
if (username_err.innerHTML!='')
{	
	console.log(username_err.innerHTML,'###########');
	uname_err.className = 'show userNm_err';
	unm.className = 'unm error input';

}

if(email_err.innerHTML!='')
{
	eml_err.className = 'show eml_err';
	eml.className = 'eml error input';
}
if (password.innerHTML!='')
{
	pass_err.className = 'show pass_err';
	pwd.className = 'pwd error input';
}
if (repassword.innerHTML!='')
{
	repass_err.className = 'show repass_err';
	rpwd.className = 'rpwd error input';
}
//#######################################################
unm.addEventListener('focus',(e)=>{
	unm.className = 'unm input';
	uname_err.className = 'hide userNm_err';
});
eml.addEventListener('focus',(e)=>{
	eml.className = 'eml input';
	eml_err.className = 'hide eml_err';
});
pwd.addEventListener('focus',(e)=>{
	pwd.className = 'pwd input';
	rpwd.className = 'rpwd input';
	pass_err.className = 'hide pass_err';
	repass_err.className = 'hide repass_err';
})
rpwd.addEventListener('focus',()=>{
	pwd.className = 'pwd input';
	rpwd.className = 'rpwd input';
	pass_err.className = 'hide pass_err';
	repass_err.className = 'hide repass_err';
})