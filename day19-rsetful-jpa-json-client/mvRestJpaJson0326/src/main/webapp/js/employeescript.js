
function emp_result(data){
	if(data){
		alert('employee added');
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

function start(){
   $("#btnAdd").click(addEmployee);	
}
$(document).ready(start);