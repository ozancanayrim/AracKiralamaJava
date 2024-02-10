package arac.kiralama.uygulamasi.DTO.requests;

import lombok.Data;

@Data
public class UpdateCarRequest {

	private double dailyPrice;

	private int state;

	private int modelId;
}
