package org.magm.backend.integration.cli2.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.magm.backend.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cli2_products")
@PrimaryKeyJoinColumn(name = "id_product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCli2 extends Product{

	private static final long serialVersionUID = 2516446617276638458L;

	@Column(nullable = false)
	private Date expirationDate;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "cli2_product_component", 
		joinColumns = { @JoinColumn(name = "id_product", referencedColumnName = "id_product") }, 
		inverseJoinColumns = {	@JoinColumn(name = "id_component", referencedColumnName = "id") })
	private Set<ComponentCli2> components;

}

