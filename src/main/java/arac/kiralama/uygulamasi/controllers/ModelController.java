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

import arac.kiralama.uygulamasi.DTO.requests.CreateModelRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateModelRequest;
import arac.kiralama.uygulamasi.DTO.responses.GetAllModelsResponse;
import arac.kiralama.uygulamasi.DTO.responses.ModelGetById;
import arac.kiralama.uygulamasi.services.interfaces.ModelService;

@RestController
@RequestMapping("/api")
public class ModelController {

	@Autowired
	ModelService modelService;

	@GetMapping("/getallmodels")
	List<GetAllModelsResponse> getAllModels() {
		return modelService.getAllModels();
	}

	@GetMapping("/getmodel/{id}")
	public ModelGetById getModel(@PathVariable int id) throws Exception {
		return modelService.getModel(id);
	}

	@PostMapping("/addmodel")
	public void addModel(@RequestBody CreateModelRequest createModelRequest) {
		modelService.addModel(createModelRequest);
	}

	@DeleteMapping("/deletemodel/{id}")
	public void deleteModel(@PathVariable int id) {
		modelService.deleteModel(id);
	}

	@PutMapping("/updatemodel/{id}")
	public void updateModel(@PathVariable int id,
			@RequestBody UpdateModelRequest updateModelRequest) {
		modelService.updateModel(id, updateModelRequest);
	}

}
