function emp_result(data){
	if(data){
		//alert('employee added');
		getAllEmployee();
	}
}

function addEmployee(){
	//alert("add employee");
	var obj={};
	obj.employeeNumber=parseInt($("#employeeNumber").val());
	obj.firstName=$("#firstName").val();
	obj.lastName=$("#lastName").val();
	obj.email=$("#email").val();
	obj.officeCode=$("#officeCode").val();
	obj.extension=$("#extension").val();
	obj.reportsTo=parseInt($("#report").val());
	obj.jobTitle=$("#title").val();
	$.ajax({
	        method: 'POST',
	        url: 'http://localhost:8080/mvjpars0326/api/employees', //設定資料的網址
			contentType:'application/json',               
	        dataType: "json", //設定回傳的資料格式  
			data:JSON.stringify(obj) , 
	        statusCode: { //依不同StatusCode執行不同邏輯                        
	            201: function (res, stausText, xhr) {
	                alert("201-Location=" + 
	                    //透過res取出Response Header
	                    res.getResponseHeader("Location"));
	            },
	            204: function () {
	                alert("employee add Failed!");
	            },
	            304: function () {
	                alert("Data Not Modified!");
	            },
	            500: function (xhr, statusText, err) {
	                alert(xhr.responseText);
	            }
	        },

	        success: emp_result //設定當Ajax要求成功時所要執行的函式
	    });
}
function onSuccess(data){
    $("#employeeTB").empty();
      $("#employeeTB").attr("border", "1");
      //建立表格的第㇐列
      var firstRow = $("<tr><th>員工編號</th><th>員工名字</th><th>員工姓氏</th><th>員工分機</th><th>電子郵件</th><th>辦公室代號</th><th>員工主管</th><th>員工職稱</th><th>資料異動</th></tr>");
      $("#employeeTB").append(firstRow);
      //將取得的資料㇐㇐建立為表格的每㇐列      
      $.each(data, function (i) {
        var row = $("<tr></tr>");
        var td1 = $("<td></td>").text(this.employeeNumber).appendTo(row);
        var td2 = $("<td></td>").text(this.firstName).appendTo(row);
        var td3 = $("<td></td>").text(this.lastName).appendTo(row);
        var td4 = $("<td></td>").text(this.extension).appendTo(row);
        var td5 = $("<td></td>").text(this.email).appendTo(row);        
		var td6 = $("<td></td>").text(this.officeCode).appendTo(row);
		var td7 = $("<td></td>").text(this.reportsTo).appendTo(row);
		var td8 = $("<td></td>").text(this.jobTitle).appendTo(row);
        var td9 = $("<td></td>").html("<button onclick=updateEmp(this)>修改</button><button  onclick=deleteEmp(this)>刪除</button>").appendTo(row);
        $("#employeeTB").append(row);
      });

}
function deleteEmp(btn){
	
	var currentRow=$(btn).closest("tr");    
	var no=currentRow.find("td:eq(0)").text();
	var answer=confirm('delete employee '+no);
	if(!answer) return;      
		$.ajax({
			     method: 'DELETE',
			     url: "http://localhost:8080/mvjpars0326/api/employees/userno/"+no,	//設定資料的網址
			     dataType: "json",	//設定回傳的資料格式
			     statusCode: { //依不同StatusCode執行不同邏輯                    
					           
					             204: function () {
					                 alert("no employee deleted!");
					             },
					             304: function () {
					                 alert("Data Not Modified!");
					             },
					             500: function (xhr, statusText, err) {
					                 alert(xhr.responseText);
					             }
					         },
			      success: showEmployee	//設定當Ajax要求成功時所要執行的函式
    });
	
}
function updateEmp(btn) {
    var currentRow=$(btn).closest("tr");    
    var no=currentRow.find("td:eq(0)").text();      
	$.ajax({
		     method: 'GET',
		     url: "http://localhost:8080/mvjpars0326/api/employees/"+no,	//設定資料的網址
		     dataType: "json",	//設定回傳的資料格式
		     statusCode: { //依不同StatusCode執行不同邏輯                    
				           
				             204: function () {
				                 alert("no employee!");
				             },
				             304: function () {
				                 alert("Data Not Modified!");
				             },
				             500: function (xhr, statusText, err) {
				                 alert(xhr.responseText);
				             }
				         },
		      success: showEmployee	//設定當Ajax要求成功時所要執行的函式
		    });
}
function showEmployee(data){
	if(data){
		$("#employeeNumber").val(data.employeeNumber);
	    $("#firstName").val(data.firstName);
		$("#lastName").val(data.lastName);
		$("#email").val(data.email);
		$("#officeCode").val(data.officeCode);
		$("#extension").val(data.extension);
		$("#report").val(data.reportsTo);
	    $("#title").val(data.jobTitle);
	}else
	  alert('No Employee Data');
}
function getAllEmployee(){
	$.ajax({
	         method: 'GET',
	         url: "http://localhost:8080/mvjpars0326/api/employees",	//設定資料的網址
	         dataType: "json",	//設定回傳的資料格式
			 statusCode: { //依不同StatusCode執行不同邏輯                    
			           
			             204: function () {
			                 alert("no employee!");
			             },
			             304: function () {
			                 alert("Data Not Modified!");
			             },
			             500: function (xhr, statusText, err) {
			                 alert(xhr.responseText);
			             }
			         },
	         success: onSuccess	//設定當Ajax要求成功時所要執行的函式
	      });
}
function updateEmployee(){
	var obj={};
		obj.employeeNumber=parseInt($("#employeeNumber").val());
		obj.firstName=$("#firstName").val();
		obj.lastName=$("#lastName").val();
		obj.email=$("#email").val();
		obj.officeCode=$("#officeCode").val();
		obj.extension=$("#extension").val();
		obj.reportsTo=parseInt($("#report").val());
		obj.jobTitle=$("#title").val();
		$.ajax({
		        method: 'PUT',
		        url: 'http://localhost:8080/mvjpars0326/api/employees/userno/'+obj.employeeNumber, //設定資料的網址
				contentType:'application/json',               
		        dataType: "json", //設定回傳的資料格式  
				data:JSON.stringify(obj) , 
		        statusCode: { //依不同StatusCode執行不同邏輯                        
		            201: function (res, stausText, xhr) {
		                alert("201-Location=" + 
		                    //透過res取出Response Header
		                    res.getResponseHeader("Location"));
		            },
		            204: function () {
		                alert("employee Update Failed!");
		            },
		            304: function () {
		                alert("Data Not Modified!");
		            },
		            500: function (xhr, statusText, err) {
		                alert(xhr.responseText);
		            }
		        },

		        success: update_result //設定當Ajax要求成功時所要執行的函式
		    });
}
function update_result(data){
	if(data){
		getAllEmployee();
	}else{
		alert('No Employee Data Updated');
	}
}
function start(){
   $("#btnAdd").click(addEmployee);
   $("#btnQuery").click(getAllEmployee);
   $("#btnEdit").click(updateEmployee);		
}
$(document).ready(start);