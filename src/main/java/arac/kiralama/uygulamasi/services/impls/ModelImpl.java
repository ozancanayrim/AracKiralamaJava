package arac.kiralama.uygulamasi.services.impls;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arac.kiralama.uygulamasi.DTO.requests.CreateModelRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateModelRequest;
import arac.kiralama.uygulamasi.DTO.responses.GetAllModelsResponse;
import arac.kiralama.uygulamasi.DTO.responses.ModelGetById;
import arac.kiralama.uygulamasi.entities.Brand;
import arac.kiralama.uygulamasi.entities.Model;
import arac.kiralama.uygulamasi.repositories.BrandRepository;
import arac.kiralama.uygulamasi.repositories.ModelRepository;
import arac.kiralama.uygulamasi.services.interfaces.ModelService;

@Service
public class ModelImpl implements ModelService {

	@Autowired
	private ModelRepository modelRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BrandRepository brandRepository;

	@Override
	public List<GetAllModelsResponse> getAllModels() {
		List<Model> getModels = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponse = getModels.stream().map(
				model -> modelMapper.map(model, GetAllModelsResponse.class))
				.toList();

		return modelsResponse;
	}

	@Override
	public ModelGetById getModel(int id) throws Exception {
		Optional<Model> getOptionalModel = modelRepository.findById(id);

		ModelGetById getModel;

		if (getOptionalModel.isPresent()) {
			getModel = modelMapper.map(getOptionalModel, ModelGetById.class);
		} else {
			throw new Exception("model not found");
		}

		return getModel;
	}

	@Override
	public void addModel(CreateModelRequest createModelRequest) {

		Model addModel = modelMapper.map(createModelRequest, Model.class);

		modelRepository.save(addModel);
	}

	@Override
	public void deleteModel(int id) {
		Optional<Model> getOptionalModel = modelRepository.findById(id);

		Model deleteModel = modelMapper.map(getOptionalModel, Model.class);

		modelRepository.delete(deleteModel);
	}

	@Override
	public void updateModel(int id, UpdateModelRequest updateModelRequest) {

		Optional<Model> optionalModel = modelRepository.findById(id);

		if (optionalModel.isPresent()) {
			Model updateModel = optionalModel.get();

			Brand getUpdatedBrand = brandRepository
					.findById(updateModelRequest.getBrandId()).orElseThrow();

			updateModel.setBrand(getUpdatedBrand);
			updateModel.setName(updateModelRequest.getName());

			modelRepository.save(updateModel);
		}

	}

}
