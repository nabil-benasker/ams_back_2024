package com.sipacademy.backend_ams.repositories;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sipacademy.backend_ams.entities.Provider;

@Repository
public interface ProviderRepository extends CrudRepository<Provider, Long> {

}
