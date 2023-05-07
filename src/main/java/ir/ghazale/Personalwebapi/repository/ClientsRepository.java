package ir.ghazale.Personalwebapi.repository;

import ir.ghazale.Personalwebapi.model.Clients;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//repository that extends CrudRepository
public interface ClientsRepository extends CrudRepository<Clients, Long>
{
    List<Clients> findAll();

}