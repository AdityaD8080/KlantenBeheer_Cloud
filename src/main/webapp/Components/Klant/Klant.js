function fetchKlanten() {
    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/klanten/all',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            displayKlanten(data);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching Klanten:', error);
        }
    });
}

fetchKlanten();

function deleteKlant(klantID) {
    // Open the confirmation modal
    $('#confirmationModal').modal('show');

    // Handle click on the "Delete" button inside the modal
    $('#confirmDeleteBtn').off('click').on('click', function () {
        // Close the modal
        $('#confirmationModal').modal('hide');

        // Perform the actual deletion
        $.ajax({
            url: 'http://localhost:8080/cloud_war_exploded/api/klanten/delete/' + klantID,
            method: 'DELETE',
            success: function (data) {
                // Fetch and display updated Klanten data
                fetchKlanten();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting Klant:', error);
            }
        });
    });
}

function editKlant(klantID) {
    // Fetch the existing Klant information
    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/klanten/' + klantID,
        method: 'GET',
        dataType: 'json',
        success: function (klant) {
            // Populate the form fields with existing information
            $('#editGebruikersnaam').val(klant.gebruikersnaam);
            $('#editVoornaam').val(klant.voornaam);
            $('#editAchternaam').val(klant.achternaam);
            $('#editEmail').val(klant.email);
            $('#editAdres').val(klant.adres);
            $('#editKlantID').val(klant.klantID);

            // Display the edit modal
            $('#editKlantModal').modal('show');

            // Set up a click event for the "Update" button in the modal
            $('#editKlantModal').find('.modal-body button.btn-primary').off('click').on('click', function () {
                // Call the function to save the changes with the correct klantID
                saveChanges(klant.klantID);
            });

        },
        error: function (xhr, status, error) {
            console.error('Error fetching Klant for edit:', error);
            // Display an error message on the page if needed
        }
    });
}

// Inside your existing JavaScript code
function saveKlant() {
    var newKlantData = {
        gebruikersnaam: $('#createGebruikersnaam').val(),
        voornaam: $('#createVoornaam').val(),
        achternaam: $('#createAchternaam').val(),
        email: $('#createEmail').val(),
        adres: $('#createAdres').val()
    };

    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/klanten/save',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(newKlantData),
        success: function (data) {
            console.log('Klant created successfully:', data);
            fetchKlanten(); // Fetch and display updated Klanten data
            $('#createKlantModal').modal('hide'); // Close the modal
        },
        error: function (xhr, status, error) {
            console.error('Error creating Klant:', error);
            console.log('XHR status:', xhr.status);
            console.log('XHR response:', xhr.responseText);
        }
    });
}

// ...


function saveChanges() {
    var updatedData = {
        klantID: $('#editKlantID').val(), // Include the klantID
        gebruikersnaam: $('#editGebruikersnaam').val(),
        voornaam: $('#editVoornaam').val(),
        achternaam: $('#editAchternaam').val(),
        email: $('#editEmail').val(),
        adres: $('#editAdres').val()
    };

    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/klanten/update/' + $('#editKlantID').val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedData),
        success: function (data) {
            console.log('Update successful:', data);
            fetchKlanten();
            $('#editKlantModal').modal('hide');
        },
        error: function (xhr, status, error) {
            console.error('Error updating Klant:', error);
            console.log('XHR status:', xhr.status);
            console.log('XHR response:', xhr.responseText);
        }
    });
}


function displayKlanten(klanten) {
    var tableBody = $('#klantenTableBody');
    tableBody.empty();

    klanten.forEach(function (klant) {
        var row = '<tr>' +
            '<td>' + klant.klantID + '</td>' +
            '<td>' + klant.gebruikersnaam + '</td>' +
            '<td>' + klant.voornaam + '</td>' +
            '<td>' + klant.achternaam + '</td>' +
            '<td>' + klant.email + '</td>' +
            '<td>' + klant.adres + '</td>' +
            '<td>' +
            '<button class="btn btn-warning btn-sm" onclick="editKlant(' + klant.klantID + ')">Edit</button> ' +
            '<button class="btn btn-danger btn-sm" onclick="deleteKlant(' + klant.klantID + ')">Delete</button>' +
            '</td>' +
            '</tr>';

        tableBody.append(row);
    });
}
