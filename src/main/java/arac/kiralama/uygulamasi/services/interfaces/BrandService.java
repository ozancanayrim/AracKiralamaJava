package arac.kiralama.uygulamasi.services.interfaces;

import java.util.List;

import arac.kiralama.uygulamasi.DTO.requests.CreateBrandRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateBrandRequest;
import arac.kiralama.uygulamasi.DTO.responses.BrandGetByIdResponse;
import arac.kiralama.uygulamasi.DTO.responses.GetAllBrandsResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAllBrands();

	void addBrand(CreateBrandRequest createBrandRequest);

	void deleteBrand(int id);

	BrandGetByIdResponse getBrand(int id);

	void updateBrand(int id, UpdateBrandRequest updateBrandRequest);

}
