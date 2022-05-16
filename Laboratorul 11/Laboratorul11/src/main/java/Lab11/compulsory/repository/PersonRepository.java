package Lab11.compulsory.repository;

import Lab11.compulsory.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>
{
}