package arac.kiralama.uygulamasi.services.impls;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arac.kiralama.uygulamasi.DTO.requests.CreateBrandRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateBrandRequest;
import arac.kiralama.uygulamasi.DTO.responses.BrandGetByIdResponse;
import arac.kiralama.uygulamasi.DTO.responses.GetAllBrandsResponse;
import arac.kiralama.uygulamasi.entities.Brand;
import arac.kiralama.uygulamasi.repositories.BrandRepository;
import arac.kiralama.uygulamasi.rules.BrandServiceRules;
import arac.kiralama.uygulamasi.services.interfaces.BrandService;

@Service
public class BrandImpl implements BrandService {

	@Autowired
	private BrandRepository brandRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BrandServiceRules brandServiceRules;

	@Override
	public List<GetAllBrandsResponse> getAllBrands() {

		List<Brand> getBrands = brandRepository.findAll();

		List<GetAllBrandsResponse> brandsResponse = getBrands.stream().map(
				brand -> modelMapper.map(brand, GetAllBrandsResponse.class))
				.toList(); // Java 9 veya daha yeni bir surum ise .toList();

		/*
		 * Java 8 ve oncesi var ise .collect(Collectors.toList()
		 * 
		 * List<GetAllBrandsResponse> brands = getBrands.stream().map( brand ->
		 * modelMapper.map(brand, GetAllBrandsResponse.class))
		 * .collect(Collectors.toList());
		 */

		return brandsResponse;
	}

	@Override
	public void addBrand(CreateBrandRequest createBrandRequest) {

		brandServiceRules.checkExistsBrandName(createBrandRequest.getName());

		Brand brand = modelMapper.map(createBrandRequest, Brand.class);

		// default modelMapper loose(esnek) donusum olarak davranir.

		brandRepository.save(brand);
	}

	@Override
	public BrandGetByIdResponse getBrand(int id) {

		Optional<Brand> brand = brandRepository.findById(id);

		BrandGetByIdResponse getBrand = modelMapper.map(brand,
				BrandGetByIdResponse.class);
		return getBrand;
	}

	@Override
	public void deleteBrand(int id) {
		Optional<Brand> getBrand = brandRepository.findById(id);

		Brand deletedBrand = modelMapper.map(getBrand, Brand.class);

		brandRepository.delete(deletedBrand);
	}

	@Override
	public void updateBrand(int id, UpdateBrandRequest updateBrandRequest) {

		Optional<Brand> optionalBrand = brandRepository.findById(id);

		if (optionalBrand.isPresent()) {
			Brand existingBrand = optionalBrand.get();

			Brand updatedBrand = modelMapper.map(updateBrandRequest,
					Brand.class);

			existingBrand.setName(updatedBrand.getName());

			brandRepository.save(existingBrand);
		}

	}

}
