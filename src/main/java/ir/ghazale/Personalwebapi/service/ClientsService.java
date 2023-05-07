package ir.ghazale.Personalwebapi.service;

import ir.ghazale.Personalwebapi.model.dto.ClientsDto;

import java.util.List;

public interface ClientsService {
    ClientsDto createUser(ClientsDto clientsDto);
    ClientsDto getUserById(Long id);
    List<ClientsDto> getAllUsers();
    ClientsDto updateUser(ClientsDto clientsDto);
    void deleteUser(Long id);

    }
