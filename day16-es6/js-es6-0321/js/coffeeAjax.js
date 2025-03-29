function addCoffee(){
    var name=$("#cofName").val();
    var id=$("#supId").val();
    var price=$("#price").val();
    var sales=$("#sales").val();
    var total=$("#total").val();

    var obj = {
        cofName: name,
        supId: id,
        price: price,
        sales: sales,
        total: total
    };

    $.ajax({
        method: 'POST',
        url: "http://localhost:8080/mvrestful0321/api/coffees",
        contentType: "application/json",
        dataType: "json",
        data: JSON.stringify(obj),
        statusCode: {
            204: function() {
                alert("Insert coffee " + name + " failed");
            }
        },
        success: onAddResult
    });
}

function onAddResult(data){
    if(data){
        alert(data.cofName + ' inserted');
        getAllCoffees();
    }
}

function getAllCoffees(){
    $.ajax({
        url: "http://localhost:8080/mvrestful0321/api/coffees",
        method: "GET",
        dataType: "json",
        success: function(data){
            var html = "<h3>所有咖啡清單</h3><ul>";
            $.each(data, function(i, item){
                html += "<li>" + item.cofName + " - NT$" + item.price + "</li>";
            });
            html += "</ul>";
            $("#coffeeList").html(html);
        }
    });
}

