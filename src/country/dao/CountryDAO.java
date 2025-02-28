package country.dao;

import country.model.Country;

import java.util.List;

public interface CountryDAO {
	Country getByCode(String code);
	void save(Country country);
	List<Country> getALl();
	boolean exist(String code);
	void delete(Country country);
	void update(Country country);
}
