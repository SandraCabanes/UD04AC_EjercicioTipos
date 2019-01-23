/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Sandra
 */
public class AsistenciaMedica implements Serializable{
    private int idAsistenciaMedica;
    private Seguro seguro;
    private String breveDescripcion;
    private String lugar;
    private String explicacion;
    private TipoAsistencia tipoAsistencia;
    private Date fecha;
    private Date hora;
    private BigDecimal importe;

    public AsistenciaMedica() {
    }

    public AsistenciaMedica(Seguro seguro, String breveDescripcion, String lugar, String explicacion, TipoAsistencia tipoAsistencia, Date fecha, Date hora, BigDecimal importe) {
        this.seguro = seguro;
        this.breveDescripcion = breveDescripcion;
        this.lugar = lugar;
        this.explicacion = explicacion;
        this.tipoAsistencia = tipoAsistencia;
        this.fecha = fecha;
        this.hora = hora;
        this.importe = importe;
    }

    public int getIdAsistenciaMedica() {
        return idAsistenciaMedica;
    }

    public void setIdAsistenciaMedica(int idAsistenciaMedica) {
        this.idAsistenciaMedica = idAsistenciaMedica;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    public String getBreveDescripcion() {
        return breveDescripcion;
    }

    public void setBreveDescripcion(String breveDescripcion) {
        this.breveDescripcion = breveDescripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public TipoAsistencia getTipoAsistencia() {
        return tipoAsistencia;
    }

    public void setTipoAsistencia(TipoAsistencia tipoAsistencia) {
        this.tipoAsistencia = tipoAsistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "AsistenciaMedica{" + "idAsistenciaMedica=" + idAsistenciaMedica + ", seguro=" + seguro + ", breveDescripcion=" + breveDescripcion + ", lugar=" + lugar + ", explicacion=" + explicacion + ", tipoAsistencia=" + tipoAsistencia + ", fecha=" + fecha + ", hora=" + hora + ", importe=" + importe + '}';
    }
    
    
}
