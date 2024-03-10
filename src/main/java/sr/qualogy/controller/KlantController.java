package sr.qualogy.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.qualogy.entity.Klant;
import sr.qualogy.service.KlantService;
import sr.qualogy.repository.KlantRepository;
import sr.qualogy.repository.KlantRepositoryRP;

import java.util.List;

@Path("/klanten")
public class KlantController {

    private final KlantService klantService;

    public KlantController() {
        this.klantService = new KlantService();
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
    public List<Klant> getAllKlanten() {
        return klantService.getAllKlanten();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Klant getKlantById(@PathParam("id") int klantId) {
        return klantService.getKlantById(klantId);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveKlant(Klant klant) {
        Klant savedKlant = klantService.saveKlant(klant);
        return Response.ok(savedKlant, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateKlant(Klant klant) {
        Klant updatedKlant = klantService.updateKlant(klant);
        return Response.ok(updatedKlant, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateKlantById(@PathParam("id") int klantId, Klant updatedKlant) {
        Klant result = klantService.updateKlantById(klantId, updatedKlant);
        return Response.ok(result, MediaType.APPLICATION_JSON_TYPE).build();
    }


    @DELETE
    @Path("/delete/{id}")
    public void deleteKlant(@PathParam("id") int klantId) {
        klantService.deleteKlant(klantId);
    }
}
