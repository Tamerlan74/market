package kz.zhabassov.market.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class SaleDto {

  private Integer id;
  private Integer rate;
  private Set<ProductDto> products;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getRate() {
    return rate;
  }

  public void setRate(Integer rate) {
    this.rate = rate;
  }

  public Set<ProductDto> getProducts() {
    return products;
  }

  public void setProducts(Set<ProductDto> products) {
    this.products = products;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SaleDto)) {
      return false;
    }
    SaleDto saleDto = (SaleDto) o;
    return Objects.equals(getId(), saleDto.getId()) && Objects
        .equals(getRate(), saleDto.getRate()) && Objects
        .equals(getProducts(), saleDto.getProducts());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getRate(), getProducts());
  }
}
