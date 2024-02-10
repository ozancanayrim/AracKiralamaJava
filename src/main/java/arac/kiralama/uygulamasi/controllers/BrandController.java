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

import arac.kiralama.uygulamasi.DTO.requests.CreateBrandRequest;
import arac.kiralama.uygulamasi.DTO.requests.UpdateBrandRequest;
import arac.kiralama.uygulamasi.DTO.responses.BrandGetByIdResponse;
import arac.kiralama.uygulamasi.DTO.responses.GetAllBrandsResponse;
import arac.kiralama.uygulamasi.services.interfaces.BrandService;

@RestController
@RequestMapping("/api")
public class BrandController {

	@Autowired
	private BrandService brandService;

	@GetMapping("/getallbrands")
	public List<GetAllBrandsResponse> getAllBrands() {
		return brandService.getAllBrands();
	}

	@GetMapping("/getbrand/{id}")
	public BrandGetByIdResponse getBrand(@PathVariable int id) {
		return brandService.getBrand(id);
	}

	@PostMapping("/addbrand")
	public void addBrand(@RequestBody CreateBrandRequest createBrandRequest) {
		brandService.addBrand(createBrandRequest);
	}

	@DeleteMapping("/deletebrand/{id}")
	public void deleteBrand(@PathVariable int id) {
		brandService.deleteBrand(id);
	}

	@PutMapping("/updatebrand/{id}")
	public void updateBrand(@PathVariable int id,
			@RequestBody UpdateBrandRequest updateBrandRequest) {
		brandService.updateBrand(id, updateBrandRequest);
	}
}
