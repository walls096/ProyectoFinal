package com.walls.entidades;
// Generated 25-oct-2020 17:32:58 by Hibernate Tools 5.4.14.Final

import java.util.Date;

/**
 * Cita generated by hbm2java
 */
public class Cita implements java.io.Serializable {

	private int codCita;
	private Integer codCliente;
	private Integer codMascota;
	private Date fecha;
	private String tipoCita;
	private String observacion;

	public Cita() {
	}

	public Cita(int codCita) {
		this.codCita = codCita;
	}

	public Cita(int codCita, Integer codCliente, Integer codMascota, Date fecha, String tipoCita, String observacion) {
		this.codCita = codCita;
		this.codCliente = codCliente;
		this.codMascota = codMascota;
		this.fecha = fecha;
		this.tipoCita = tipoCita;
		this.observacion = observacion;
	}

	public int getCodCita() {
		return this.codCita;
	}

	public void setCodCita(int codCita) {
		this.codCita = codCita;
	}

	public Integer getCodCliente() {
		return this.codCliente;
	}

	public void setCodCliente(Integer codCliente) {
		this.codCliente = codCliente;
	}

	public Integer getCodMascota() {
		return this.codMascota;
	}

	public void setCodMascota(Integer codMascota) {
		this.codMascota = codMascota;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTipoCita() {
		return this.tipoCita;
	}

	public void setTipoCita(String tipoCita) {
		this.tipoCita = tipoCita;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

}