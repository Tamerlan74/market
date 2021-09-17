package kz.zhabassov.market.dto;

import java.util.Objects;

public class AddressDto {

  private Integer id;
  private String destination;
  private OrderDto order;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  public OrderDto getOrder() {
    return order;
  }

  public void setOrder(OrderDto order) {
    this.order = order;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AddressDto)) {
      return false;
    }
    AddressDto that = (AddressDto) o;
    return Objects.equals(getId(), that.getId()) && Objects
        .equals(getDestination(), that.getDestination()) && Objects
        .equals(getOrder(), that.getOrder());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getDestination(), getOrder());
  }
}
