package com.zup.juliete_user_comics.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.zup.juliete_user_comics.View;

@Entity
@Table(name="tb_user", uniqueConstraints = {@UniqueConstraint(columnNames = "email"),@UniqueConstraint(columnNames = "CPF")})
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//atributos básicos com as restrições para o BD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(View.Base.class)
	private Long id;
	
	@JsonView(View.Base.class)
	@NotEmpty(message="{name.not.blank}")
	private String name;
	
	@JsonView(View.Base.class)
	@NotEmpty(message="{email.not.blank}")
	@Email(message="{email.not.valid}")
	private String email;
	
	@JsonView(View.Base.class)
	@NotEmpty(message="{CPF.not.blank}")
	@org.hibernate.validator.constraints.br.CPF(message="{CPF.not.valid}")
	private String CPF;
	
	@JsonView(View.Base.class)
	@NotEmpty(message="{birthDate.not.blank}")
	private String birthDate;
	
	//associação entre usuário e quadrinhos
	@ManyToMany(mappedBy = "users")
	private Set<Comic> comics = new HashSet<>();
	
	public User() {
		
	}

	public User(Long id, @NotEmpty(message = "{name.not.blank}") String name,
			@NotEmpty(message = "{email.not.blank}") @Email(message = "{email.not.valid}") String email,
			@NotEmpty(message = "{CPF.not.blank}") String cPF,
			@NotEmpty(message = "{birthDate.not.blank}") String birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		CPF = cPF;
		this.birthDate = birthDate;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public Set<Comic> getComics() {
		return comics;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
