package arac.kiralama.uygulamasi.DTO.responses;

import lombok.Data;

@Data
public class GetAllCarsResponse {

	private int id;

	private double dailyPrice;

	private int state;

	private String modelName;
}
