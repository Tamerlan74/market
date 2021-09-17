package kz.zhabassov.market.map;

import java.util.List;
import kz.zhabassov.market.dto.OrderDto;
import kz.zhabassov.market.entity.Order;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface OrderMapper {

  ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

  Order orderDtoToOrder(OrderDto orderDto, @Context CycleAvoidingMappingContext context);

  OrderDto orderToOrderDto(Order order, @Context CycleAvoidingMappingContext context);

  List<Order> orderDtosToOrders(List<OrderDto> orderDtos, @Context CycleAvoidingMappingContext context);

  List<OrderDto> ordersToOrdersDtos(List<Order> orders, @Context CycleAvoidingMappingContext context);
}
