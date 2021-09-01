package ru.gb.repository.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Product;
import ru.gb.exception.ProductNotFoundException;
import ru.gb.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

  @Getter
  private final List<Product> products = new ArrayList<>();

  public ProductRepositoryImpl() {
    for (int i = 0; i < 5; i++) {
      products.add(buildProduct(i));
    }
  }

  @Override
  public Product getById(int id) {
    return products.stream()
        .filter(product -> product.getId() == id)
        .findFirst()
        .orElseThrow(() -> new ProductNotFoundException(String.format("Product by id %s not found", id)));
  }

  @Override
  public List<Product> getAll() {
    return products;
  }

  private Product buildProduct(int id) {
    Product product = new Product();
    product.setId(id);
    product.setCost(new Random().nextInt(100));
    product.setTitle(String.format("Product %d", id));

    return product;
  }
}
