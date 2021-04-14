$(document).ready(function () {
    // Fetch Users from API
    $.ajax({
        url: "http://localhost:8080/users",
        type: "GET",
        crossDomain: true,
        crossOrigin: true,
        success: function (data) {
            if (data.length > 0) {
                var tableHTML = `<table class="table">
                <thead class="thead-dark">
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Age</th>
                    <th scope="col">Address</th>
                    <th scope="col">Profession</th>
                  </tr>
                </thead>
                <tbody>`
                for (let i = 0; i < data.length; i++) {
                    tableHTML += "<tr>"
                    tableHTML += `<th scope='row'>${data[i].id}</th>`
                    tableHTML += `<td>${data[i].name}</td>`
                    tableHTML += `<td>${data[i].age}</td>`
                    tableHTML += `<td>${data[i].address}</td>`
                    tableHTML += `<td>${data[i].profession}</td>`
                    tableHTML += "</tr>"
                }
                tableHTML += "</tbody></table>"
                $(".usersWrapper").append(tableHTML)
            }
            else {
                var _html = `<p>No Users Found :(</p>`
                $(".usersWrapper").append(_html)
            }

        }
    })
})