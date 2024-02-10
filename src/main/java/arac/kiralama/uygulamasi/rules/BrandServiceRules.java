package arac.kiralama.uygulamasi.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import arac.kiralama.uygulamasi.exceptions.BusinessException;
import arac.kiralama.uygulamasi.repositories.BrandRepository;

@Service
public class BrandServiceRules {

	@Autowired
	private BrandRepository brandRepository;

	public void checkExistsBrandName(String name) {
		if (brandRepository.existsByName(name)) {
			throw new BusinessException("Brand already exists");
		}
	}
}
