/**
 * 
 */

	function grid_to_excel(selector,type,worksheetname){
		//var data;
		//var thead=[];
		var data;
		var thead=[];
		var field=[];
		
		if(type=="class"){
			data=$("."+selector+"").getKendoGrid().dataSource.data().toJSON();
			col=$("."+selector+"").getKendoGrid().columns;
			
			for(var i=0;i<col.length;i++){
				 thead[i]=col[i].title;
				 field[i]=col[i].field;
			}
			
		}if(type=="id"){
			data=$("#"+selector+"").getKendoGrid().dataSource.data().toJSON();
			col=$("#"+selector+"").getKendoGrid().columns;
			for(var i=0;i<col.length;i++){
				 thead[i]=col[i].title;
				 field[i]=col[i].field;
			}		
		}
		var html="";
		var thead_th="";
		for(var i=0;i< thead.length;i++){
			thead_th+="<th>"+ thead[i]+"</th>";
			
		}
		var thead_d="<thead><tr>"+thead_th+"</tr></thead>";
		console.log(thead_d);
		var tr="";
		var td=[];
		var colll=[];
		for(var i=0;i<data.length;i++){
		 // console.log(data[i]);
			tr="<tr>";
		 for(var j=0;j<field.length;j++){
			// console.log("....field",data[i][field[j]]);
			 td[j]="<td>"+data[i][field[j]]+"</td>";
			 
		 }
		 var df="";
		 for(var k=0;k<td.length;k++){
			 df+=td[k];
			 
		 }
		 
		colll[i]=tr+df+"</tr>";
		//console.log(colll);
		 
		}
		
		 var dff="";
		 for(var k=0;k<colll.length;k++){
			 dff+=colll[k];
			 
		 }
       
		
		html="<table id='test'>"+thead_d+"<tbody>"+dff+"</tbody></table>";
		
		console.log("table html ",html);
		
		
		
		var uri = 'data:application/vnd.ms-excel;base64,';
		
		template = '<html xmlns:o="urn:schemas-microsoft-com:office:office" '
				+ ' xmlns:x="urn:schemas-microsoft-com:office:excel" '
				+ ' xmlns="http://www.w3.org/TR/REC-html40"><head> '
				+ ' <!--[if gte mso 9]><xml><x:ExcelWorkbook> '
				+ ' <x:ExcelWorksheets><x:ExcelWorksheet><x:Name>   '
				+ ' {worksheet}</x:Name><x:WorksheetOptions><x:DisplayGridlines/> '
				+ ' </x:WorksheetOptions></x:ExcelWorksheet></x:ExcelWorksheets>  '
				+ '  </x:ExcelWorkbook></xml><![endif]--></head> '
				+ '  <body><table>{table}</table></body></html>';
		
		 function base64(s) {
			return window.btoa(unescape(encodeURIComponent(s)))
		}
		
		function format(s, c) {
			return s.replace(/{(\w+)}/g, function(m, p) {
				return c[p];
			})
		}
			
			var ctx = {
				worksheet : name || 'Worksheet',
				table : html//datasource --> table 
			}
			console.log("url ", uri + base64(format(template, ctx)));
		//	window.location.href = uri + base64(format(template, ctx))
		
	}