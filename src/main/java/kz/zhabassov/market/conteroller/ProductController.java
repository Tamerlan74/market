package kz.zhabassov.market.conteroller;

import kz.zhabassov.market.dto.ProductDto;
import kz.zhabassov.market.entity.Product;
import kz.zhabassov.market.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
    ProductDto createdProductDto = productService.createProduct(productDto);
    return ResponseEntity.ok(createdProductDto);
  }

  @GetMapping(path = "/product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ProductDto> findProductById(@PathVariable Integer id) {
    ProductDto foundProductDto = productService.findProductById(id);
    return ResponseEntity.ok(foundProductDto);
  }

  @GetMapping(path = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Page<Product>> findAllProducts(
      @PageableDefault(sort = {"id"}, direction = Direction.DESC, size = 2) Pageable pageable) {
    Page<Product> foundProductDtos = productService.findAllProducts(pageable);
    return ResponseEntity.ok(foundProductDtos);
  }

  @DeleteMapping(path = "/product")
  public ResponseEntity<String> deleteProduct(@RequestBody ProductDto productDto) {
    productService.delete(productDto);
    return ResponseEntity
        .ok(String.format("Product with id = %s successfully deleted", productDto.getId()));
  }
}
