var table =
    $('#guestTable').DataTable({
      "ajax":  {"url":"/api/guest","dataSrc":""},
      "columns": [
          { "data": "guestNumber" },
          { "data": "name" },
          {"data": "surname"},
          { "data": "address" },
          { "data": "zipcode" },
          { "data": "city" },
          { "data": "country" },
          { "data": "phone" },
          { "data": "email" }
        ],
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            }
        ],
        "order": [[0, 'desc']],
       "pageLength": 10,
         "bLengthChange": false,
         "language": {
             "info": "Showing guests _START_ to _END_ of _TOTAL_ "
             }
    } );


function handleAddGuest(){
    var obj = {
        name:       $("#name").val(),
        surname:    $("#surname").val(),
        address:    $("#address").val(),
        zipcode:    $("#zipcode").val(),
        city:       $("#city").val(),
        country:    $("#country").val(),
        phone:      $("#phone").val(),
        email:      $("#email").val()
    }

    $.ajax({
        url: "/api/guest/",
        type: "POST",
        data: JSON.stringify(obj),
        contentType: "application/json; charset=utf-8",
        success: function(result) {
            console.log(result);

            // toggle
            $("#guestModal").modal('toggle');

            // add to DataTable
              var table = $('#guestTable').DataTable();
              var rowNode = table
                  .row.add( result )
                  .draw()
                  .node();

            // Highlight row (timeout)
            $(rowNode).addClass('table-success');
              setTimeout(function() {
                  $(rowNode).removeClass('table-success');
              },3000);
    },
        error: function(err) {
        console.log(err);
        alert("Error while adding guest: " + err);
    }
    });
}


// Show modal for updating guest
$('#guestTable tbody').on('click', 'tr', function () {
    var data = table.row(this).data();
    console.log(data);
    showGuestModal('modify', data);
});

// Show modal for adding guests
$('#addGuestButton').on('click', function () {
    showGuestModal('add');
});

function showGuestModal(format, data) {
    // Populates inputfields and buttons based on format (String)
    // data id optional.
    switch (format) {
        case 'modify':

            // populate form
            $.each(data, function (key, value) {
                $('#addGuest').find("input[id='" + key + "']").val(value);
            });
            // initialize title and buttons
            $('#modalLabel').html('Edit guest "' + data['name'] + ' ' + data ['surname'] + '"');
            $('#guestDeleteButton').show();
            $('#guestSaveButton').show();
            $('#guestAddButton').hide();
            break;

        default:
            // empty form
            $(':input', '#addGuest')
                .not(':button, :submit, :reset')
                .val('');

            // initialize title and buttons
            $('#modalLabel').html('Add new guest');
            $('#guestDeleteButton').hide();
            $('#guestSaveButton').hide();
            $('#guestAddButton').show();
            break;
    }

    // show modal
    $("#guestModal").modal('toggle');
}

