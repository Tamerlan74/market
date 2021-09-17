package kz.zhabassov.market.map;

import java.util.Set;
import kz.zhabassov.market.dto.SaleDto;
import kz.zhabassov.market.entity.Sale;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface SaleMapper {

  ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

  Sale saleDtoToSale(SaleDto saleDto, @Context CycleAvoidingMappingContext context);

  SaleDto saleToSaleDto(Sale sale, @Context CycleAvoidingMappingContext context);

  Set<Sale> saleDtosToSales(Set<SaleDto> saleDtos, @Context CycleAvoidingMappingContext context);

  Set<SaleDto> salesToSaleDtos(Set<Sale> sales, @Context CycleAvoidingMappingContext context);

}
