package ru.gb.repository;

import java.util.List;
import ru.gb.domain.Product;

public interface ProductRepository {

  Product getById(int id);

  List<Product> getAll();
}
