package azat.example.cursdemo.repository;

import azat.example.cursdemo.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientsRepository extends CrudRepository<Client, Integer> {

}
