package arac.kiralama.uygulamasi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import arac.kiralama.uygulamasi.entities.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {

}
