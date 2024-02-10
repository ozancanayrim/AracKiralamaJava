package arac.kiralama.uygulamasi.services.impls;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arac.kiralama.uygulamasi.DTO.requests.CreateCarRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateCarRequest;
import arac.kiralama.uygulamasi.DTO.responses.CarGetById;
import arac.kiralama.uygulamasi.DTO.responses.GetAllCarsResponse;
import arac.kiralama.uygulamasi.entities.Car;
import arac.kiralama.uygulamasi.entities.Model;
import arac.kiralama.uygulamasi.repositories.CarRepository;
import arac.kiralama.uygulamasi.repositories.ModelRepository;
import arac.kiralama.uygulamasi.services.interfaces.CarService;

@Service
public class CarImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ModelRepository modelRepository;

	@Override
	public List<GetAllCarsResponse> getAllCars() {

		List<Car> cars = carRepository.findAll();

		List<GetAllCarsResponse> getAllCarsResponses = cars.stream()
				.map(car -> modelMapper.map(car, GetAllCarsResponse.class))
				.toList();

		return getAllCarsResponses;
	}

	@Override
	public void addCar(CreateCarRequest createCarRequest) {
		Car addCar = modelMapper.map(createCarRequest, Car.class);

		carRepository.save(addCar);
	}

	@Override
	public CarGetById getCar(int id) {
		Optional<Car> getOptionalCar = carRepository.findById(id);

		CarGetById getCar = modelMapper.map(getOptionalCar, CarGetById.class);

		return getCar;
	}

	@Override
	public void deleteCar(int id) {
		Optional<Car> getOptionalCar = carRepository.findById(id);

		Car deletedModel = modelMapper.map(getOptionalCar, Car.class);

		carRepository.delete(deletedModel);
	}

	@Override
	public void updateCar(int id, UpdateCarRequest updateCarRequest) {

		Optional<Car> getOptionalCar = carRepository.findById(id);

		if (getOptionalCar.isPresent()) {
			Car updatedCar = getOptionalCar.get();

			Car updateRequest = modelMapper.map(updateCarRequest, Car.class);

			Model getModel = modelRepository
					.findById(updateCarRequest.getModelId()).orElseThrow();

			updatedCar.setDailyPrice(updateRequest.getDailyPrice());
			updatedCar.setState(updateRequest.getState());
			updatedCar.setModel(getModel);

			carRepository.save(updatedCar);
		}
	}

}
