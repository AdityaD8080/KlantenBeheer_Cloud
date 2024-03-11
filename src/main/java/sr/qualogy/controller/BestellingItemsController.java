package sr.qualogy.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.qualogy.entity.BestellingItems;
import sr.qualogy.service.BestellingItemsService;


import java.util.List;

@Path("/bestellingitems")
public class BestellingItemsController {

    private final BestellingItemsService bestellingItemsService;

    public BestellingItemsController() {
        this.bestellingItemsService = new BestellingItemsService();
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World";
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<BestellingItems> getAllBestellingItems() {
        return bestellingItemsService.getAllBestellingItems();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public BestellingItems getBestellingItemById(@PathParam("id") int bestellingItemId) {
        return bestellingItemsService.getBestellingItemById(bestellingItemId);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBestellingItem(BestellingItems bestellingItem) {
        BestellingItems savedBestellingItem = bestellingItemsService.saveBestellingItem(bestellingItem);
        return Response.ok(savedBestellingItem, MediaType.APPLICATION_JSON_TYPE).build();
    }



    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBestellingItem(BestellingItems bestellingItem) {
        BestellingItems updatedBestellingItem = bestellingItemsService.updateBestellingItem(bestellingItem);
        return Response.ok(updatedBestellingItem, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteBestellingItem(@PathParam("id") int bestellingItemId) {
        bestellingItemsService.deleteBestellingItem(bestellingItemId);
    }
}
