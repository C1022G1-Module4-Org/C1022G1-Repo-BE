function loadCustomers(append) {

    $.ajax({
        type: "GET",
        url: `http://localhost:8080/customer`,
        header: {
            "Content-type": "application/JSON",
        },
        success: function (data) {
            renderCustomers(data.content, append);
        },
        error: function (error) {
            console.log(error);
        }
    });
}


$(document).ready(function () {
    loadCustomers();
})

function renderCustomers(customers, append) {
    let element = "";

    for (let customer of customers) {
        element += `
  <div class="card col-sm-3" style="width: 18rem;">
  <img src="${customer.img}" class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">${customer.customer}</h5>
    <p class="card-text">${customers.dateOfBirth}</p>
    <p class="card-text">${customers.getCustomerType()}</p>
    <a href="#" class="btn btn-primary">Add</a>
  </div>
</div> 
         `;
    }

    if (append) {
        $("#listCustomer").append(element);
    } else {
        $("#listCustomer").html(element);
    }
}