package kz.zhabassov.market.service;

import java.util.Set;
import kz.zhabassov.market.dto.ProductDto;
import kz.zhabassov.market.entity.Product;
import kz.zhabassov.market.map.CycleAvoidingMappingContext;
import kz.zhabassov.market.map.ProductMapper;
import kz.zhabassov.market.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private final ProductRepository productRepository;
  private final ProductMapper productMapper;

  public ProductService(ProductRepository productRepository,
      ProductMapper productMapper) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
  }

  public ProductDto createProduct(ProductDto productDto) {
    Product product = productMapper
        .productDtoToProduct(productDto, new CycleAvoidingMappingContext());
    Product createdProduct = productRepository.save(product);
    return productMapper.productToProductDto(createdProduct, new CycleAvoidingMappingContext());
  }

  public ProductDto findProductById(Integer id) {
    Product foundProduct = productRepository.findById(id).orElse(new Product());
    return productMapper.productToProductDto(foundProduct, new CycleAvoidingMappingContext());
  }

  public Page<Product> findAllProducts(Pageable pageable) {
    Page<Product> foundProducts = productRepository.findAll(pageable);
    return foundProducts;
  }

  public void delete(ProductDto productDto) {
    Product product = productMapper
        .productDtoToProduct(productDto, new CycleAvoidingMappingContext());
    productRepository.delete(product);
  }
}
