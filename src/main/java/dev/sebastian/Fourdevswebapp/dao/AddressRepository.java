package dev.sebastian.Fourdevswebapp.dao;

import dev.sebastian.Fourdevswebapp.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Integer>
{
}
