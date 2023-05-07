package ir.ghazale.Personalwebapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import ir.ghazale.Personalwebapi.model.Clients;
import ir.ghazale.Personalwebapi.model.dto.ClientsDto;
import ir.ghazale.Personalwebapi.service.ClientsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(
        name = "CRUD REST APIs for User Resource",
        description = "CRUD REST APIs - Create User, Update User, Get User, Get All Users, Delete User"
)
@RestController
@RequestMapping("api/clients")
@AllArgsConstructor
public class ClientsController
{
    private ClientsService clientsService;

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping()
    public ResponseEntity<ClientsDto> createUser(@Valid @RequestBody ClientsDto clientsDto){
        ClientsDto saved = clientsService.createUser(clientsDto);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get User By ID REST API",
            description = "Get User By ID REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<ClientsDto> getUserById(@PathVariable("id") Long id){
        ClientsDto clientsDto = clientsService.getUserById(id);
        return new ResponseEntity<>(clientsDto, HttpStatus.OK);
    }
    @Operation(
            summary = "Get All Users REST API",
            description = "Get All Users REST API is used to get a all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<ClientsDto>> getAllUsers(){
        List<ClientsDto> clientsDtoList = clientsService.getAllUsers();
        return new ResponseEntity<>(clientsDtoList, HttpStatus.OK);
    }
    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<ClientsDto> updateUser(@PathVariable("id") Long id,
                                              @RequestBody @Valid ClientsDto clientsDto){
        clientsDto.setClientId(id);
        ClientsDto updatedUser = clientsService.updateUser(clientsDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long id){
        clientsService.deleteUser(id);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }
}