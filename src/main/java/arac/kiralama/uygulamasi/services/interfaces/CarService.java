package arac.kiralama.uygulamasi.services.interfaces;

import java.util.List;

import arac.kiralama.uygulamasi.DTO.requests.CreateCarRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateCarRequest;
import arac.kiralama.uygulamasi.DTO.responses.CarGetById;
import arac.kiralama.uygulamasi.DTO.responses.GetAllCarsResponse;

public interface CarService {

	List<GetAllCarsResponse> getAllCars();

	CarGetById getCar(int id);

	void addCar(CreateCarRequest createCarRequest);

	void deleteCar(int id);

	void updateCar(int id, UpdateCarRequest updateCarRequest);
}
