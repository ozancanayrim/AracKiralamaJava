package arac.kiralama.uygulamasi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "daily_price")
	private double dailyPrice;

	@Column(name = "state")
	private int state; // 1 available , 2 rented, 3 maintenance

	@ManyToOne
	@JoinColumn(name = "model_id")
	private Model model;
}
