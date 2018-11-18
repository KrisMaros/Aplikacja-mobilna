/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import web.Grocerie1;

/**
 *
 * @author Krzychu-x
 */
@Stateless
@Path("web.grocerie1")
public class Grocerie1FacadeREST extends AbstractFacade<Grocerie1> {

    @PersistenceContext(unitName = "AndroidRestfulServerPU")
    private EntityManager em;

    public Grocerie1FacadeREST() {
        super(Grocerie1.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_FORM_URLENCODED})
    public void create(Grocerie1 entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Grocerie1 entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Grocerie1 find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Path("all")
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Grocerie1> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Grocerie1> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
