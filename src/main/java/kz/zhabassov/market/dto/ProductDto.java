package kz.zhabassov.market.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.springframework.lang.NonNull;

public class ProductDto {

  private Integer id;
  @NonNull
  private String name;
  private Set<SaleDto> sales;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<SaleDto> getSales() {
    return sales;
  }

  public void setSales(Set<SaleDto> sales) {
    this.sales = sales;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ProductDto)) {
      return false;
    }
    ProductDto that = (ProductDto) o;
    return Objects.equals(getId(), that.getId()) && getName().equals(that.getName())
        && Objects.equals(getSales(), that.getSales());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getSales());
  }
}
