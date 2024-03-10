package sr.qualogy.controller;

//import jakarta.ws.rs.*;
//import jakarta.ws.rs.core.MediaType;
//import jakarta.ws.rs.core.Response;
//import sr.qualogy.entity.Producten;
//import sr.qualogy.service.ProductenService;
//
//import java.util.List;
//
//@Path("/producten")
//public class ProductenController {
//
//    private final ProductenService productenService;
//
//    public ProductenController() {
//        this.productenService = new ProductenService();
//    }
//
//    @GET
//    @Path("/hello")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String helloWorld() {
//        return "Hello World";
//    }
//
//    @GET
//    @Path("/all")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Producten> getAllProducts() {
//        return productenService.getAllProducts();
//    }
//
//    @GET
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Producten getProductById(@PathParam("id") int productId) {
//        return productenService.getProductById(productId);
//    }
//
//    @POST
//    @Path("/save")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response saveProduct(Producten product) {
//        Producten savedProduct = productenService.saveProduct(product);
//        return Response.ok(savedProduct, MediaType.APPLICATION_JSON_TYPE).build();
//    }
//
//    @PUT
//    @Path("/update")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response updateProduct(Producten product) {
//        Producten updatedProduct = productenService.updateProduct(product);
//        return Response.ok(updatedProduct, MediaType.APPLICATION_JSON_TYPE).build();
//    }
//
//    @DELETE
//    @Path("/delete/{id}")
//    public void deleteProduct(@PathParam("id") int productId) {
//        productenService.deleteProduct(productId);
//    }
//}


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import sr.qualogy.entity.Producten;
import sr.qualogy.service.ProductenService;

import java.util.List;

@Path("/producten")
public class ProductenController {

    // Use getInstance() to get the singleton instance of ProductenService
    private final ProductenService productenService = ProductenService.getInstance();

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello World";
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Producten> getAllProducts() {
        return productenService.getAllProducts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Producten getProductById(@PathParam("id") int productId) {
        return productenService.getProductById(productId);
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveProduct(Producten product) {
        Producten savedProduct = productenService.saveProduct(product);
        return Response.ok(savedProduct, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateProduct(Producten product) {
        Producten updatedProduct = productenService.updateProduct(product);
        return Response.ok(updatedProduct, MediaType.APPLICATION_JSON_TYPE).build();
    }

    @DELETE
    @Path("/delete/{id}")
    public void deleteProduct(@PathParam("id") int productId) {
        productenService.deleteProduct(productId);
    }
}
