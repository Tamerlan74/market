package kz.zhabassov.market.conteroller;

import java.util.List;
import kz.zhabassov.market.dto.AddressDto;
import kz.zhabassov.market.service.AddressService;
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
public class AddressController {

  private final AddressService addressService;

  public AddressController(AddressService addressService) {
    this.addressService = addressService;
  }

  @PostMapping(path = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
    AddressDto createdAddressDto = addressService.createAddress(addressDto);
    return ResponseEntity.ok(createdAddressDto);
  }

  @GetMapping(path = "/address/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AddressDto> findAddressById(@PathVariable Integer id) {
    AddressDto foundAddressDto = addressService.findAddressById(id);
    return ResponseEntity.ok(foundAddressDto);
  }

  @GetMapping(path = "/addresses", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<AddressDto>> findAllAddresses() {
    List<AddressDto> foundAddressDtos = addressService.findAllAddresss();
    return ResponseEntity.ok(foundAddressDtos);
  }

  @PutMapping(path = "/address/{addressId}")
  public ResponseEntity<AddressDto> updateAddress(@RequestBody AddressDto addressDto) {
    AddressDto createdAddressDto = addressService.createAddress(addressDto);
    return ResponseEntity.ok(createdAddressDto);
  }

  @DeleteMapping(path = "/address")
  public ResponseEntity<String> deleteAddress(@RequestBody AddressDto addressDto) {
    addressService.delete(addressDto);
    return ResponseEntity
        .ok(String.format("Address with id = %s successfully deleted", addressDto.getId()));
  }
}
