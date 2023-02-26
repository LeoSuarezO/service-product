package self.leo.project.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import self.leo.project.product.entity.Category;
import self.leo.project.product.entity.Product;
import self.leo.project.product.repository.ProductRepository;

import java.util.Date;
import java.util.List;

public class ProductSrvcImpl implements ProductService{

    @Autowired
    private ProductRepository repository;
    @Override
    public List<Product> listAllProduct() {
        return repository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreateDate(new Date());
        return repository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productDB  = getProduct(product.getId());
        if (productDB == null) return null;
        productDB.setName(product.getName());
        productDB.setPrice(product.getPrice());
        productDB.setCategory(product.getCategory());
        productDB.setDescription(product.getDescription());
        return repository.save(productDB);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productDB  = getProduct(id);
        if (productDB == null) return null;
        productDB.setStatus("Deleted");
        return repository.save(productDB);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return repository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productDB  = getProduct(id);
        if (productDB == null) return null;
        Double stock = productDB.getStock() + quantity;
        return repository.save(productDB);
    }
}
