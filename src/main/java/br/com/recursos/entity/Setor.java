package br.com.recursos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "SETOR")
public class Setor {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name = "career")
	private String career;

	@Column(name = "departament")
	private String departament;

	public Setor(Long id, String career, String departament) {
		this.id = id;
		this.career = career;
		this.departament = departament;
	}


}