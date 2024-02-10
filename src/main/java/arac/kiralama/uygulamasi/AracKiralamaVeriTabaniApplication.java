package arac.kiralama.uygulamasi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import arac.kiralama.uygulamasi.exceptions.BusinessException;
import arac.kiralama.uygulamasi.exceptions.ExceptionDetails;

@SpringBootApplication
@RestControllerAdvice
public class AracKiralamaVeriTabaniApplication {

	public static void main(String[] args) {
		SpringApplication.run(AracKiralamaVeriTabaniApplication.class, args);
	}

	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ExceptionDetails exceptionHandler(
			BusinessException businessException) {
		ExceptionDetails details = new ExceptionDetails();
		details.setMessage(businessException.getMessage());

		return details;
	}

}
