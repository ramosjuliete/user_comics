package com.zup.juliete_user_comics.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_comic", uniqueConstraints = { @UniqueConstraint(columnNames = "IBSN") })
public class Comic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //
	private Long comicId;
	@NotEmpty(message = "Nome é obrigatório!")
	private String title;
	@NotNull
	private Double price;
	@NotEmpty(message = "Autores são obrigatórios!")
	private String autors;
	@NotEmpty(message = "IBSN é obrigatório!")
	private String IBSN;
	private String description;
	private boolean active_discount = false;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_comic_user", joinColumns = @JoinColumn(name = "comic_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();

	

	public Comic() {

	}

	public Comic(Long comicId, @NotEmpty(message = "Nome é obrigatório!") String title, Double price,
			@NotEmpty(message = "Autores são obrigatórios!") String autors,
			@NotEmpty(message = "IBSN é obrigatório!") String iBSN, String description) {
		super();
		this.comicId = comicId;
		this.title = title;
		this.price = price;
		this.autors = autors;
		IBSN = iBSN;
		this.description = description;
	}

	public Long getComicId() {
		return comicId;
	}

	public void setComicId(Long comicId) {
		this.comicId = comicId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAutors() {
		return autors;
	}

	public void setAutors(String autors) {
		this.autors = autors;
	}

	public String getIBSN() {
		return IBSN;
	}

	public void setIBSN(String iBSN) {
		IBSN = iBSN;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public boolean isActive_discount() {
		return active_discount;
	}

	public void setActive_discount(boolean active_discount) {
		this.active_discount = active_discount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(comicId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comic other = (Comic) obj;
		return Objects.equals(comicId, other.comicId);
	}
}
