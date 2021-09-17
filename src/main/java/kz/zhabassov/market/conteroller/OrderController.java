package kz.zhabassov.market.conteroller;

import java.util.List;
import kz.zhabassov.market.dto.OrderDto;
import kz.zhabassov.market.dto.OrderDto;
import kz.zhabassov.market.service.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping(path = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
    OrderDto createdOrderDto = orderService.createOrder(orderDto);
    return ResponseEntity.ok(createdOrderDto);
  }

  @GetMapping(path = "/order/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<OrderDto> findOrderById(@PathVariable Integer id) {
    OrderDto foundOrderDto = orderService.findOrderById(id);
    return ResponseEntity.ok(foundOrderDto);
  }

  @GetMapping(path = "/orders", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<OrderDto>> findAllOrders() {
    List<OrderDto> foundOrderDtos = orderService.findAllOrders();
    return ResponseEntity.ok(foundOrderDtos);
  }

  @PutMapping(path = "order/{orderId}")
  public ResponseEntity<OrderDto> updateOrder(@RequestBody OrderDto orderDto){
    OrderDto createdOrderDto = orderService.createOrder(orderDto);
    return ResponseEntity.ok(createdOrderDto);
  }

  @DeleteMapping(path = "/order")
  public ResponseEntity<String> deleteOrder(@RequestBody OrderDto orderDto) {
    orderService.delete(orderDto);
    return ResponseEntity
        .ok(String.format("Order with id = %s successfully deleted", orderDto.getId()));
  }
}
