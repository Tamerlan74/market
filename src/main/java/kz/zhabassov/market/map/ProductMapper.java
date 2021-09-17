package kz.zhabassov.market.map;

import java.util.Set;
import kz.zhabassov.market.dto.ProductDto;
import kz.zhabassov.market.entity.Product;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = SaleMapper.class)
public interface ProductMapper {

  SaleMapper SALE_MAPPER = Mappers.getMapper(SaleMapper.class);

  Product productDtoToProduct(ProductDto productDto, @Context CycleAvoidingMappingContext context);

  ProductDto productToProductDto(Product product, @Context CycleAvoidingMappingContext context);

  Set<Product> productDtosToProducts(Set<ProductDto> productDtos, @Context CycleAvoidingMappingContext context);

  Set<ProductDto> productsToProductsDtos(Set<Product> products, @Context CycleAvoidingMappingContext context);

}
