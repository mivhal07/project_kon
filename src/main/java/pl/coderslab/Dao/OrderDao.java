package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class OrderDao {
    @PersistenceContext
    EntityManager entityManager;
//tego prawdopodobnie nie dokończę, bo kombinuję, ale czasu na pewno nie starczy

    public void addProductToOrder(Product product) {
        entityManager.persist(product.getId());
    }
}
