package sr.qualogy.service;

import sr.qualogy.configuration.JPAConfiguration;
import sr.qualogy.repository.ProductenRepository;
import sr.qualogy.entity.Producten;
import java.util.List;

public class ProductenService {

    private final ProductenRepository productenRepository;

    public ProductenService() {
        this.productenRepository = new ProductenRepository(JPAConfiguration.getEntityManager());
    }

    public List<Producten> getAllProducts() {
        return productenRepository.getAllProducts();
    }

    public Producten getProductById(int productId) {
        return productenRepository.getProductById(productId);
    }

    public Producten saveProduct(Producten product) {
        return productenRepository.saveProduct(product);
    }

    public Producten updateProduct(Producten product) {
        return productenRepository.updateProduct(product);
    }

    public void deleteProduct(int productId) {
        productenRepository.deleteProduct(productId);
    }
}
