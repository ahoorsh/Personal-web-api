package ir.ghazale.Personalwebapi.service;

import ir.ghazale.Personalwebapi.model.Clients;
import ir.ghazale.Personalwebapi.model.dto.ClientsDto;
import ir.ghazale.Personalwebapi.model.mapper.MapStructMapper;
import ir.ghazale.Personalwebapi.repository.ClientsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientsServiceImp implements ClientsService {

    private ClientsRepository clientsRepository;

    @Override
    public ClientsDto createUser(ClientsDto clientsDto) {
        Clients clients = MapStructMapper.MAPPER.mapToClients(clientsDto);

        Clients saved = clientsRepository.save(clients);

        ClientsDto savedDto = MapStructMapper.MAPPER.mapToClientsDto(saved);

        return savedDto;
    }

    @Override
    public ClientsDto getUserById(Long id) {
        Clients clients = clientsRepository.findById(id).get();
        //return UserMapper.mapToUserDto(user);
        //return modelMapper.map(user, UserDto.class);
        return MapStructMapper.MAPPER.mapToClientsDto(clients);
    }

    @Override
    public List<ClientsDto> getAllUsers() {
        List<Clients> clients = clientsRepository.findAll();
        return clients.stream().map(MapStructMapper.MAPPER::mapToClientsDto)
                .collect(Collectors.toList());
//        return clients.stream().map((user) -> MapStructMapper.MAPPER.mapToClientsDto(user))

    }

    @Override
    public ClientsDto updateUser(ClientsDto clientsDto) {

        Clients existingUser = clientsRepository.findById(clientsDto.getClientId()).get();

        existingUser.setFirstname(clientsDto.getFirstname());
        existingUser.setLastname(clientsDto.getLastname());
        existingUser.setGender(clientsDto.getGender());
        existingUser.setPassword(clientsDto.getPassword());
        existingUser.setUsername(clientsDto.getUsername());
        existingUser.setPhoneNumber(clientsDto.getPhoneNumber());
        Clients updatedUser = clientsRepository.save(existingUser);
        return MapStructMapper.MAPPER.mapToClientsDto(updatedUser);
    }
    @Override
    public void deleteUser(Long id) {

        clientsRepository.deleteById(id);
    }
}