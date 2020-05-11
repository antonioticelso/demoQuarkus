package com.github.antonioticelso.demoQuarkus;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.quarkus.hibernat.orm.panache.PanacheEntityBase;


@Entity
@Table(name = "PRODUTO")
public class Produto extends PanacheEntityBase {

    public String nome;
    public BigDecimal valor;

    @CreationTimestamp
    public Date dataCriacao;

    @UpdateTimestamp
    public Date dataAtualizacao;

	public void persist() {
	}

	public static Optional<Produto> findByIdOptional(Long id) {
	}

	public static Object count() {
		return null;
	}

}


