package com.harjoitustyo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RuokaRepository extends CrudRepository<Ruoka, Long> {

		List<Ruoka> findByNimi(String nimi);
}
