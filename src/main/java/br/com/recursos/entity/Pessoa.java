package br.com.recursos.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "PESSOA")
public class Pessoa {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="pessoa_setor",
			joinColumns = {@JoinColumn(name = "id_pessoa")},
			inverseJoinColumns = {@JoinColumn(name = "id_setor")})
	private List<Setor> setorList;

	public Pessoa(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

}