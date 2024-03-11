function fetchBestellingen() {
    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/bestellingen/all',
        method: 'GET',
        dataType: 'json',
        success: function (data) {
            displayBestellingen(data);
        },
        error: function (xhr, status, error) {
            console.error('Error fetching Bestellingen:', error);
        }
    });
}

fetchBestellingen();

function deleteBestelling(bestellingID) {
    // Open the confirmation modal
    $('#confirmationModal').modal('show');

    // Handle click on the "Delete" button inside the modal
    $('#confirmDeleteBtn').off('click').on('click', function () {
        // Close the modal
        $('#confirmationModal').modal('hide');

        // Perform the actual deletion
        $.ajax({
            url: 'http://localhost:8080/cloud_war_exploded/api/bestellingen/delete/' + bestellingID,
            method: 'DELETE',
            success: function (data) {
                // Fetch and display updated Bestellingen data
                fetchBestellingen();
            },
            error: function (xhr, status, error) {
                console.error('Error deleting Bestelling:', error);
            }
        });
    });
}

function editBestelling(bestellingID) {
    // Fetch the existing Bestelling information
    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/bestellingen/' + bestellingID,
        method: 'GET',
        dataType: 'json',
        success: function (bestelling) {
            // Populate the form fields with existing information
            $('#editBestellingDatum').val(bestelling.bestelDatum);
            $('#editTotaalBedrag').val(bestelling.totaalBedrag);
            $('#editVerzendadres').val(bestelling.verzendadres);
            $('#editBetaalStatus').val(bestelling.betaalStatus);
            $('#editBestellingID').val(bestelling.bestellingID);

            // Display the edit modal
            $('#editBestellingModal').modal('show');

            // Set up a click event for the "Update" button in the modal
            $('#editBestellingModal').find('.modal-body button.btn-primary').off('click').on('click', function () {
                // Call the function to save the changes with the correct bestellingID
                saveChangesBestelling(bestelling.bestellingID);
            });

        },
        error: function (xhr, status, error) {
            console.error('Error fetching Bestelling for edit:', error);
            // Display an error message on the page if needed
        }
    });
}

// Inside your existing JavaScript code
function saveBestelling() {
    var newBestellingData = {
        klantID: $('#createKlantID').val(),
        bestelDatum: $('#createBestellingDatum').val(),
        totaalBedrag: $('#createTotaalBedrag').val(),
        verzendadres: $('#createVerzendadres').val(),
        betaalStatus: $('#createBetaalStatus').val()
    };

    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/bestellingen/save',
        method: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(newBestellingData),
        success: function (data) {
            console.log('Bestelling created successfully:', data);
            fetchBestellingen(); // Fetch and display updated Bestellingen data
            $('#createBestellingModal').modal('hide'); // Close the modal
        },
        error: function (xhr, status, error) {
            console.error('Error creating Bestelling:', error);
            console.log('XHR status:', xhr.status);
            console.log('XHR response:', xhr.responseText);
        }
    });
}

function saveChangesBestelling() {
    var updatedData = {
        // Adjust the properties based on your Bestellingen model
        // Include relevant form field values
    };

    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/bestellingen/update/' + $('#editBestellingID').val(),
        method: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(updatedData),
        success: function (data) {
            console.log('Update successful:', data);
            fetchBestellingen();
            $('#editBestellingModal').modal('hide');
        },
        error: function (xhr, status, error) {
            console.error('Error updating Bestelling:', error);
            console.log('XHR status:', xhr.status);
            console.log('XHR response:', xhr.responseText);
        }
    });
}

// Fetch Klanten and populate the dropdown
function fetchKlantenForDropdown() {
    $.ajax({
        url: 'http://localhost:8080/cloud_war_exploded/api/klanten/all',
        method: 'GET',
        dataType: 'json',
        success: function (klanten) {
            // Clear existing options
            $('#createKlantID').empty();

            // Add a default option
            $('#createKlantID').append('<option value="" disabled selected>Select Klant</option>');

            // Populate the dropdown with Klanten
            klanten.forEach(function (klant) {
                $('#createKlantID').append('<option value="' + klant.klantID + '">' + klant.gebruikersnaam + '</option>');
            });
        },
        error: function (xhr, status, error) {
            console.error('Error fetching Klanten for dropdown:', error);
        }
    });
}

// Call the function to fetch Klanten and populate the dropdown
fetchKlantenForDropdown();


function displayBestellingen(bestellingen) {
    var tableBody = $('#bestellingenTableBody');
    tableBody.empty();

    bestellingen.forEach(function (bestelling) {
        var row = '<tr>' +
            '<td>' + bestelling.bestellingID + '</td>' +
            '<td>' + bestelling.klant.klantID + '</td>' +
            '<td>' + bestelling.bestelDatum + '</td>' +
            '<td>' + bestelling.totaalBedrag + '</td>' +
            '<td>' + bestelling.verzendadres + '</td>' +
            '<td>' + bestelling.betaalStatus + '</td>' +
            '<td>' +
            '<button class="btn btn-warning btn-sm" onclick="editBestelling(' + bestelling.bestellingID + ')">Edit</button> ' +
            '<button class="btn btn-danger btn-sm" onclick="deleteBestelling(' + bestelling.bestellingID + ')">Delete</button>' +
            '</td>' +
            '</tr>';

        tableBody.append(row);
    });
}