package sr.qualogy.repository;

//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import sr.qualogy.entity.Producten;
//
//import java.util.List;
//
//public class ProductenRepository {
//
//    private EntityManager entityManager;
//
//    public ProductenRepository(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public Producten saveProduct(Producten product) {
//        entityManager.getTransaction().begin();
//        entityManager.persist(product);
//        entityManager.getTransaction().commit();
//
//        return product;
//    }
//
//    public List<Producten> getAllProducts() {
//        String jpql = "SELECT p FROM Producten p";
//        TypedQuery<Producten> typedQuery = entityManager.createQuery(jpql, Producten.class);
//        return typedQuery.getResultList();
//    }
//
//    public Producten getProductById(int productId) {
//        return entityManager.find(Producten.class, productId);
//    }
//
//    public Producten updateProduct(Producten product) {
//        entityManager.getTransaction().begin();
//        Producten updatedProduct = entityManager.merge(product);
//        entityManager.getTransaction().commit();
//        return updatedProduct;
//    }
//
//    public void deleteProduct(int productId) {
//        Producten product = entityManager.find(Producten.class, productId);
//        if (product != null) {
//            entityManager.getTransaction().begin();
//            entityManager.remove(product);
//            entityManager.getTransaction().commit();
//        }
//    }
//}

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import sr.qualogy.entity.Producten;

import java.util.List;

public class ProductenRepository {

    private final EntityManager entityManager;

    public ProductenRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Producten saveProduct(Producten product) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(product);
            transaction.commit();
            return product;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Rethrow the exception after rollback
        }
    }

    public List<Producten> getAllProducts() {
        String jpql = "SELECT p FROM Producten p";
        TypedQuery<Producten> typedQuery = entityManager.createQuery(jpql, Producten.class);
        return typedQuery.getResultList();
    }

    public Producten getProductById(int productId) {
        return entityManager.find(Producten.class, productId);
    }

    public Producten updateProduct(Producten product) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Producten updatedProduct = entityManager.merge(product);
            transaction.commit();
            return updatedProduct;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void deleteProduct(int productId) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            Producten product = entityManager.find(Producten.class, productId);
            if (product != null) {
                entityManager.remove(product);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
