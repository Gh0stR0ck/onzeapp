$("#addroomform").submit(function(e){
    e.preventDefault();

    var json = {
        name : $("input[name=roomname]").val(),
        number : $("input[name=roomnumber]").val(),
        capacity : $("input[name=roomcapacity]").val()
    };

    //JSON.stringify(json)

    console.log(json);

    $.ajax({
      method: "POST",
      url: "/api/room/",
      contentType: "application/json",
      data: JSON.stringify(json),
      success: function(result) {
        PrintResult(result);
      }
    });

});

$("#getroomform").submit(function(e){
    e.preventDefault();

    $.ajax({
      method: "GET",
      url: "/api/room/"+ $("input[name=getroomnumber]").val() + "/",
      contentType: "application/json",
      success: function( result ) {
        PrintSingleResult(result);
      }
    });

});

$("#deleteroomform").submit(function(e){
    e.preventDefault();

    $.ajax({
      method: "DELETE",
      url: "/api/room/"+ $("input[name=delroomnumber]").val() + "/",
      contentType: "application/json",
      success: function( result ) {
        PrintResult(result);
      }
    });

});

$("#getallroomsform").submit(function(e){
    e.preventDefault();

    $.ajax({
      method: "GET",
      url: "/api/room/",
      contentType: "application/json",
      success: function( result ) {
        PrintResult(result);
      }
    });

});


$("#updateroomform").submit(function(e){
    e.preventDefault();

    var json = {
        name : $("input[name=updateroomname]").val(),
        number : $("input[name=updateroomnumber]").val(),
        capacity : $("input[name=updateroomcapacity]").val()
    };

    //JSON.stringify(json)

    $.ajax({
      method: "PUT",
      url: "/api/room/",
      contentType: "application/json",
      data: JSON.stringify( json),
      success: function( result ) {
        PrintResult(result);
      }
    });

});


function PrintResult(result){
    $("#result").html(JSON.stringify(result));

    var resultTable = "<table class='table-rooms table table-striped'>";
    resultTable += "<thead><tr><th>Kamer naam</th><th>Kamer nummer</th><th>Slaap plekken</th></tr></thead>";
    resultTable += "<tbody>";

    $.each(result, function(key,value){
        resultTable += "<tr>";

        $.each(value, function(key2,value2){
                resultTable += "<td>"+value2+" </td>";
        });

        resultTable += "</tr>";
    });

    resultTable += "</tr></tbody></table>";

    $("#result").html(resultTable);
}

function PrintSingleResult(result){
    $("#result").html(result);
}