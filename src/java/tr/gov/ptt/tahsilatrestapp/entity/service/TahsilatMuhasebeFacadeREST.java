/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.tahsilatrestapp.entity.service;

import java.math.BigDecimal;
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
import tr.gov.ptt.tahsilatrestapp.entity.TahsilatMuhasebe;

/**
 *
 * @author Administrator
 */
@Stateless
@Path("tr.gov.ptt.tahsilatrestapp.entity.tahsilatmuhasebe")
public class TahsilatMuhasebeFacadeREST extends AbstractFacade<TahsilatMuhasebe> {
    @PersistenceContext(unitName = "TahsilatRessAppPU")
    private EntityManager em;

    public TahsilatMuhasebeFacadeREST() {
        super(TahsilatMuhasebe.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(TahsilatMuhasebe entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") BigDecimal id, TahsilatMuhasebe entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") BigDecimal id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public TahsilatMuhasebe find(@PathParam("id") BigDecimal id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<TahsilatMuhasebe> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<TahsilatMuhasebe> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
