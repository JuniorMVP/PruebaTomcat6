/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.PruebaTomcat6.facade;

import co.PruebaTomcat6.entity.Empleados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import co.PruebaTomcat6.entity.Empleados_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import co.PruebaTomcat6.entity.RegistroTransacciones;
import java.util.Collection;

/**
 *
 * @author junior
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "PruebaTomcat6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    public boolean isRegistroTransaccionesCollectionEmpty(Empleados entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleados> empleados = cq.from(Empleados.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleados, entity), cb.isNotEmpty(empleados.get(Empleados_.registroTransaccionesCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<RegistroTransacciones> findRegistroTransaccionesCollection(Empleados entity) {
        Empleados mergedEntity = this.getMergedEntity(entity);
        Collection<RegistroTransacciones> registroTransaccionesCollection = mergedEntity.getRegistroTransaccionesCollection();
        registroTransaccionesCollection.size();
        return registroTransaccionesCollection;
    }
    
}
