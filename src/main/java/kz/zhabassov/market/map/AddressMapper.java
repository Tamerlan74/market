package kz.zhabassov.market.map;

import java.util.List;
import kz.zhabassov.market.dto.AddressDto;
import kz.zhabassov.market.entity.Address;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = OrderMapper.class)
public interface AddressMapper {

  OrderMapper ORDER_MAPPER = Mappers.getMapper(OrderMapper.class);

  Address addressDtoToAddress(AddressDto addressDto, @Context CycleAvoidingMappingContext context);

  AddressDto addressToAddressDto(Address address, @Context CycleAvoidingMappingContext context);

  List<Address> addressDtosToAddresses(List<AddressDto> addressDtos, @Context CycleAvoidingMappingContext context);

  List<AddressDto> addressesToAddressDtos(List<Address> addresses, @Context CycleAvoidingMappingContext context);

}
