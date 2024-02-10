package arac.kiralama.uygulamasi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arac.kiralama.uygulamasi.entities.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
	boolean existsByName(String name);
}
