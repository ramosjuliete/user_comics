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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_comic", uniqueConstraints = { @UniqueConstraint(columnNames = "IBSN") })
public class Comic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // por enquanto deixar como auto-incremento
	private Long comicId;

	@NotEmpty(message = "Nome é obrigatório!")
	private String title;

	// @NotBlank(message = "Preço é obrigatório!") {pesquisar como é para verificar
	// atributo Double}
	private Double price;

	@NotEmpty(message = "Autores são obrigatórios!")
	private String autors;

	@NotEmpty(message = "IBSN é obrigatório!")
	private String IBSN;

	private String description;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_comic_user", joinColumns = @JoinColumn(name = "comic_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();

	private boolean active_discount = false;

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

	public Comic calculateDiscount(String day, Comic c) {

		switch (day) {
		case "SEG":
			if (c.getIBSN().endsWith("0") || c.getIBSN().endsWith("1")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "TER":
			if (c.getIBSN().endsWith("2") || c.getIBSN().endsWith("3")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "QUA":
			if (c.getIBSN().endsWith("4") || c.getIBSN().endsWith("5")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "QUI":
			if (c.getIBSN().endsWith("6") || c.getIBSN().endsWith("7")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		case "SEX":
			if (c.getIBSN().endsWith("8") || c.getIBSN().endsWith("9")) {
				c.setPrice(c.getPrice() * 0.1);
				c.setActive_discount(true);
				return c;
			}
			break;
		default:
			return c;
		}

		return c;
	}

}
