package com.zup.juliete_user_comics.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="tb_user", uniqueConstraints = {@UniqueConstraint(columnNames = "email"),@UniqueConstraint(columnNames = "CPF")})
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//atributos básicos com as restrições para o BD
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome é obrigatório!")
	private String name;
	
	@NotBlank(message = "E-mail é obrigatório!")
	@Email(message = "E-mail Inválido!")
    @Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank(message = "CPF é obrigatório!")
	@CPF(message = "Invalid CPF")
    @Column(unique = true, nullable = false)
	private String CPF;
	
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	@NotBlank(message = "Data de nascimento é obrigatório!")
	private String birthDate;
	
	public User() {
		
	}

	public User(Long id, @NotBlank(message = "Nome é obrigatório!") String name,
			@NotBlank(message = "E-mail é obrigatório!") @Email(message = "E-mail Inválido!") String email,
			@NotBlank(message = "CPF é obrigatório!") @org.hibernate.validator.constraints.br.CPF(message = "Invalid CPF") String cPF,
			@NotBlank(message = "Data de nascimento é obrigatório!") String birthDate) {
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
