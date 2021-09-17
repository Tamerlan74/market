package kz.zhabassov.market.dto;

import java.util.List;
import java.util.Objects;

public class OrderDto {

  private Integer id;

  private List<ProductDto> products;

  private AddressDto address;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<ProductDto> getProducts() {
    return products;
  }

  public void setProducts(List<ProductDto> products) {
    this.products = products;
  }

  public AddressDto getAddress() {
    return address;
  }

  public void setAddress(AddressDto address) {
    this.address = address;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof OrderDto)) {
      return false;
    }
    OrderDto orderDto = (OrderDto) o;
    return Objects.equals(getId(), orderDto.getId()) && Objects
        .equals(getProducts(), orderDto.getProducts()) && Objects
        .equals(getAddress(), orderDto.getAddress());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getProducts(), getAddress());
  }
}
