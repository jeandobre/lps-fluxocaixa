package br.com.fluxocaixa.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CR")
public class CartaoCredito extends Conta {

	private static final long serialVersionUID = -475504752251734204L;

}
