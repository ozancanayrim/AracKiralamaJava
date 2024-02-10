package arac.kiralama.uygulamasi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import arac.kiralama.uygulamasi.DTO.requests.CreateCarRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateCarRequest;
import arac.kiralama.uygulamasi.DTO.responses.CarGetById;
import arac.kiralama.uygulamasi.DTO.responses.GetAllCarsResponse;
import arac.kiralama.uygulamasi.services.interfaces.CarService;

@RestController
@RequestMapping("/api")
public class CarController {

	@Autowired
	private CarService carService;

	@GetMapping("/getallcars")
	List<GetAllCarsResponse> getAllCars() {
		return carService.getAllCars();
	}

	@GetMapping("/getcar/{id}")
	public CarGetById getCar(@PathVariable int id) {
		return carService.getCar(id);
	}

	@PostMapping("/addcar")
	public void addCar(@RequestBody CreateCarRequest createCarRequest) {
		carService.addCar(createCarRequest);
	}

	@DeleteMapping("/deletecar/{id}")
	public void deleteCar(@PathVariable int id) {
		carService.deleteCar(id);
	}

	@PutMapping("/updatecar/{id}")
	public void updateCar(@PathVariable int id,
			@RequestBody UpdateCarRequest updateCarRequest) {
		carService.updateCar(id, updateCarRequest);
	}
}
