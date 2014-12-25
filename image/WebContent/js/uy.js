// JavaScript Document

function colorfunction(){
	
var a1=$("#color1").val();
var a2=$("#color2").val();
var a3=$("#color3").val();

$("#area1").css("background-color",a1);
$("#area2").css("background-color",a2);
$("#area3").css("background-color",a3);



}


$(document).ready(function(e) {



$(".shiledactive").click(function(){
alert();

});

$(".flashactive").click(function(){
alert();
	
});



$(".regularscript").click(function(){

$(".regular").removeAttr("style");


	
});



$("#search").click(function(){

	var	txt=$("#textt").val();

	
	console.log("search text",txt);
	

});

$("#submit").click(function(e) {
    
	
	var f1=$("#uname").val();
	var f2=$("#upass").val();
	
	if(f1=='ok'&&f2=='ok'){
		
		var win = window.open("main.php","_self","location=no");
		
		/**
											+ JSON.stringify(dataItem),
											"_blank", "location=no");
		**/
		
		
		}
		else{
			alert("wrong password or username");
			$("#uname").val("");
			$("#upass").val("");
			
			}
	
	
});




});