package ir.ghazale.Personalwebapi.model.mapper;

import ir.ghazale.Personalwebapi.model.Clients;
import ir.ghazale.Personalwebapi.model.dto.ClientsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    MapStructMapper MAPPER = Mappers.getMapper(MapStructMapper.class);

    ClientsDto mapToClientsDto(Clients clients);

    List<ClientsDto> mapToClientsDtoList(List<Clients> clients);

    Clients mapToClients(ClientsDto clientsDto);
}