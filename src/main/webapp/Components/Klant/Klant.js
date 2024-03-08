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

            // Display the edit modal
            $('#editKlantModal').modal('show');

            // Set up a click event for the "Save Changes" button in the modal
            $('#saveChangesBtn').off('click').on('click', function () {
                // Call the function to save the changes
                saveChanges(klantID);
            });
        },
        error: function (xhr, status, error) {
            console.error('Error fetching Klant for edit:', error);
            // Display an error message on the page if needed
        }
    });
}

function saveChanges(klantID) {
    var updatedData = {
        gebruikersnaam: $('#editGebruikersnaam').val(),
        voornaam: $('#editVoornaam').val(),
        achternaam: $('#editAchternaam').val(),
        email: $('#editEmail').val(),
        adres: $('#editAdres').val()
    };

    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/klanten/update/' + klantID,
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedData),
        success: function (data) {
            fetchKlanten();
            $('#editKlantModal').modal('hide');
        },
        error: function (xhr, status, error) {
            console.error('Error updating Klant:', error);
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
