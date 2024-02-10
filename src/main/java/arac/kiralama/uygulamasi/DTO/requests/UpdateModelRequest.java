package arac.kiralama.uygulamasi.DTO.requests;

import lombok.Data;

@Data
public class UpdateModelRequest {

	private int id;

	private String name;

	private int brandId;
}
