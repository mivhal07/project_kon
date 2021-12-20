package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RoleDao {
    @PersistenceContext
    EntityManager entityManager;

    public void createRole(Role role){
        entityManager.persist(role);
    }

    public List<Role> getAllRoles() {
        return entityManager.createQuery("select  b from Role b").getResultList();
    }

    public Query getAdmin(){
        return entityManager.createQuery("select r from Role r where r.name='ROLE_ADMIN'");
    }

    public Query getUser(){
        return entityManager.createQuery("select r from Role r where r.name='ROLE_USER'");
    }
}
