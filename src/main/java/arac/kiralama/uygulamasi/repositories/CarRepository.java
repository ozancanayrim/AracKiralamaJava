package arac.kiralama.uygulamasi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import arac.kiralama.uygulamasi.entities.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
