package com.harjoitustyo.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface RavintolaRepository extends CrudRepository<Ravintola, Long> {

		List<Ravintola> findByRavintolaNimi(String ravintolaNimi);
}
