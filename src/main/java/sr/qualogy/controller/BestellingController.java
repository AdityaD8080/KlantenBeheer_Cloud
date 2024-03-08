package sr.qualogy.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.qualogy.entity.Bestellingen;
import sr.qualogy.service.BestellingService;

import java.util.List;

@Path("/bestellingen")
public class BestellingController {

    private final BestellingService bestellingService;

    public BestellingController() {
        this.bestellingService = new BestellingService();
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
    public List<Bestellingen> getAllBestellingen() {
        return bestellingService.getAllBestellingen();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bestellingen getBestellingById(@PathParam("id") int bestellingId) {
        return bestellingService.getBestellingById(bestellingId);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveBestelling(Bestellingen bestelling) {
        Bestellingen savedBestelling = bestellingService.saveBestelling(bestelling);
        return Response.ok(savedBestelling, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBestelling(Bestellingen bestelling) {
        Bestellingen updatedBestelling = bestellingService.updateBestelling(bestelling);
        return Response.ok(updatedBestelling, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteBestelling(@PathParam("id") int bestellingId) {
        bestellingService.deleteBestelling(bestellingId);
    }
}
