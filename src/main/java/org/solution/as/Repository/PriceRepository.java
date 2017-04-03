package org.solution.as.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.solution.as.model.Price;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, BigInteger> {
	
	@Query("SELECT * from price WHERE id=?0")
	public Price getPriceById(BigInteger id);
	
	@Query("UPDATE price SET value=?1 WHERE id=?0 IF EXISTS")
	public boolean updatePriceById(BigInteger id, BigDecimal value);

}
