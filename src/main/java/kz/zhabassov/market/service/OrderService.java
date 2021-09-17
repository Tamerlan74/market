package kz.zhabassov.market.service;

import java.util.List;
import kz.zhabassov.market.dto.OrderDto;
import kz.zhabassov.market.entity.Order;
import kz.zhabassov.market.map.CycleAvoidingMappingContext;
import kz.zhabassov.market.map.OrderMapper;
import kz.zhabassov.market.repository.OrderRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  private final OrderRepository orderRepository;

  private final OrderMapper orderMapper;

  public OrderService(OrderRepository orderRepository,
      OrderMapper orderMapper) {
    this.orderRepository = orderRepository;
    this.orderMapper = orderMapper;
  }

  public OrderDto createOrder(OrderDto orderDto) {
    Order order = orderMapper.orderDtoToOrder(orderDto, new CycleAvoidingMappingContext());
    Order createdOrder = orderRepository.save(order);
    return orderMapper.orderToOrderDto(createdOrder, new CycleAvoidingMappingContext());
  }

  public OrderDto findOrderById(Integer id) {
    Order foundOrder = orderRepository.findById(id).orElse(new Order());
    return orderMapper.orderToOrderDto(foundOrder, new CycleAvoidingMappingContext());
  }

  public List<OrderDto> findAllOrders() {
    List<Order> foundOrders = Streamable.of(orderRepository.findAll()).toList();
    return orderMapper.ordersToOrdersDtos(foundOrders, new CycleAvoidingMappingContext());
  }

  public void delete(OrderDto orderDto) {
    Order order = orderMapper
        .orderDtoToOrder(orderDto, new CycleAvoidingMappingContext());
    orderRepository.delete(order);
  }
}
