package arac.kiralama.uygulamasi.services.interfaces;

import java.util.List;

import arac.kiralama.uygulamasi.DTO.requests.CreateModelRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateModelRequest;
import arac.kiralama.uygulamasi.DTO.responses.GetAllModelsResponse;
import arac.kiralama.uygulamasi.DTO.responses.ModelGetById;

public interface ModelService {

	List<GetAllModelsResponse> getAllModels();

	ModelGetById getModel(int id) throws Exception;

	void addModel(CreateModelRequest createModelRequest);

	void deleteModel(int id);

	void updateModel(int id, UpdateModelRequest updateModelRequest);

}
