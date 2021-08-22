package ru.gb.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.domain.Product;
import ru.gb.repository.ProductRepository;
import ru.gb.service.ProductService;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Product getById(int id) {
    return productRepository.getById(id);
  }

  @Override
  public List<Product> getAll() {
    return productRepository.getAll();
  }
}
