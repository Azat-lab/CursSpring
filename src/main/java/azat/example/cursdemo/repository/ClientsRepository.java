package azat.example.cursdemo.repository;

import azat.example.cursdemo.models.Clients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Clients, Integer> {

}
