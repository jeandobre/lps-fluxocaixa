package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ATRASADO")
public class Atrasado extends NaoRealizado {
	
}

