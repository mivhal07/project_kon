package pl.coderslab.Dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.Entities.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductDao {
    @PersistenceContext
    EntityManager entityManager;

    public void addProduct(Product product) {
        entityManager.persist(product);
    }

    public List<Product> productList() {
        return entityManager.createQuery("select p from Product p").getResultList();
    }

    public Product findProductById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public void updateProduct(Product product){
        entityManager.merge(product);
    }


}
