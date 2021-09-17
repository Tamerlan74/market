package kz.zhabassov.market.service;

import java.util.List;
import kz.zhabassov.market.dto.AddressDto;
import kz.zhabassov.market.entity.Address;
import kz.zhabassov.market.map.AddressMapper;
import kz.zhabassov.market.map.CycleAvoidingMappingContext;
import kz.zhabassov.market.repository.AddressRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

  private final AddressRepository addressRepository;

  private final AddressMapper addressMapper;

  public AddressService(AddressRepository addressRepository,
      AddressMapper addressMapper) {
    this.addressRepository = addressRepository;
    this.addressMapper = addressMapper;
  }

  public AddressDto createAddress(AddressDto addressDto) {
    Address address = addressMapper
        .addressDtoToAddress(addressDto, new CycleAvoidingMappingContext());
    Address createdAddress = addressRepository.save(address);
    return addressMapper.addressToAddressDto(createdAddress, new CycleAvoidingMappingContext());
  }

  public AddressDto findAddressById(Integer id) {
    Address foundAddress = addressRepository.findById(id).orElse(new Address());
    return addressMapper.addressToAddressDto(foundAddress, new CycleAvoidingMappingContext());
  }

  public List<AddressDto> findAllAddresss() {
    List<Address> foundAddresss = Streamable.of(addressRepository.findAll()).toList();
    return addressMapper.addressesToAddressDtos(foundAddresss, new CycleAvoidingMappingContext());
  }

  public void delete(AddressDto addressDto) {
    Address address = addressMapper
        .addressDtoToAddress(addressDto, new CycleAvoidingMappingContext());
    addressRepository.delete(address);
  }
}
