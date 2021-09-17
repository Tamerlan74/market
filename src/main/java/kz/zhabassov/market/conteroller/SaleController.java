package kz.zhabassov.market.conteroller;

import java.util.Set;
import kz.zhabassov.market.dto.SaleDto;
import kz.zhabassov.market.service.SaleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {

  private final SaleService saleService;

  public SaleController(SaleService saleService) {
    this.saleService = saleService;
  }

  @PostMapping(path = "/sale", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SaleDto> createProduct(@RequestBody SaleDto saleDto) {
    SaleDto createdSaleDto = saleService.createSale(saleDto);
    return ResponseEntity.ok(createdSaleDto);
  }

  @GetMapping(path = "/sale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<SaleDto> findSaleById(@PathVariable Integer id) {
    SaleDto foundSaleDto = saleService.findSaleById(id);
    return ResponseEntity.ok(foundSaleDto);
  }

  @GetMapping(path = "/sales", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Set<SaleDto>> findAllSales() {
    Set<SaleDto> foundSaleDtos = saleService.findAllSales();
    return ResponseEntity.ok(foundSaleDtos);
  }

  @DeleteMapping(path = "/sale")
  public ResponseEntity<String> deleteSale(@RequestBody SaleDto saleDto) {
    saleService.delete(saleDto);
    return ResponseEntity
        .ok(String.format("Sale with id = %s successfully deleted", saleDto.getId()));
  }
}
