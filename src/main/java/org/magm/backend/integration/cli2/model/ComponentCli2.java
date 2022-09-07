package org.magm.backend.integration.cli2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cli2_components")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComponentCli2 implements Serializable{

	private static final long serialVersionUID = 5695618110757822325L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(length = 100, unique = true)
	private String component;
}

