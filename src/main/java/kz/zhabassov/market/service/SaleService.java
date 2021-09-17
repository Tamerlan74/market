package kz.zhabassov.market.service;

import java.util.Set;
import kz.zhabassov.market.dto.SaleDto;
import kz.zhabassov.market.entity.Sale;
import kz.zhabassov.market.map.CycleAvoidingMappingContext;
import kz.zhabassov.market.map.SaleMapper;
import kz.zhabassov.market.repository.SaleRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

  private final SaleRepository saleRepository;

  private final SaleMapper saleMapper;

  public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
    this.saleRepository = saleRepository;
    this.saleMapper = saleMapper;
  }

  public SaleDto createSale(SaleDto saleDto) {
    Sale sale = saleMapper.saleDtoToSale(saleDto, new CycleAvoidingMappingContext());
    Sale createdSale = saleRepository.save(sale);
    return saleMapper.saleToSaleDto(createdSale, new CycleAvoidingMappingContext());
  }

  public SaleDto findSaleById(Integer id) {
    Sale foundSale = saleRepository.findById(id).orElse(new Sale());
    return saleMapper.saleToSaleDto(foundSale, new CycleAvoidingMappingContext());
  }

  public Set<SaleDto> findAllSales() {
    Set<Sale> foundSales = Streamable.of(saleRepository.findAll()).toSet();
    return saleMapper.salesToSaleDtos(foundSales, new CycleAvoidingMappingContext());
  }

  public void delete(SaleDto saleDto) {
    Sale sale = saleMapper
        .saleDtoToSale(saleDto, new CycleAvoidingMappingContext());
    saleRepository.delete(sale);
  }
}
