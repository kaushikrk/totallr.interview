$(document).ready(function () {

    // Submit Button Click Event
    $("#button").click(function () {

        // Clear out the response area
        $("#response").empty()

        // Form field values
        var name = $("#name").val();
        var age = $("#age").val();
        var address = $("#address").val();
        var profession = $("#profession").val();

        var sendObj = {
            "name": name,
            "age": age,
            "address": address,
            "profession": profession
        }

        // Sending data to Server
        $.ajax({
            url: "http://localhost:8080/users",
            type: "POST",
            data: JSON.stringify(sendObj),
            contentType: "application/json",
            success: function (data, textStatus) {
                // Show Success Alert
                var _html = `<div class="alert alert-success alert-dismissible">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Success!</strong> ${data}
              </div>`
                $("#response").append(_html)
            },
            error: function (params) {
                // Show Error Alert
                var _html = `<div class="alert alert-danger alert-dismissible">
                <button type="button" class="close" data-dismiss="alert">&times;</button>
                <strong>Error!</strong> ${params.responseJSON.message}
              </div>`
                $("#response").append(_html)
            }
        })


    })
});


