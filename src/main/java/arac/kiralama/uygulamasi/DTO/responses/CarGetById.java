package arac.kiralama.uygulamasi.DTO.responses;

import lombok.Data;

@Data
public class CarGetById {

	private int id;

	private double dailyPrice;

	private int state;

	private String modelName;
}
