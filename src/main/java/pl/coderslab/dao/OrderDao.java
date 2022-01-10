package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.entities.Order;
import pl.coderslab.entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addProductToOrder(Product product) {
        entityManager.persist(product.getId());
    }

    public void save(Order order) {
        entityManager.persist(order);
    }

    public Order findOrderById(Long id) {
        return entityManager.find(Order.class, id);
    }

    public void edit(Order order) {
        entityManager.merge(order);
    }

    public void delete(Order order) {
        entityManager.remove(entityManager.contains(order) ?
                order : entityManager.merge(order));
    }
}
