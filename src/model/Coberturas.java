/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Sandra
 */
public class Coberturas implements Serializable {
    private boolean oftalmologia;
    private boolean dental;
    private boolean fecundacionInVitro;

    public Coberturas() {
    }

    public Coberturas(boolean oftalmologia, boolean dental, boolean fecundacionInVitro) {
        this.oftalmologia = oftalmologia;
        this.dental = dental;
        this.fecundacionInVitro = fecundacionInVitro;
    }

    public boolean isOftalmologia() {
        return oftalmologia;
    }

    public void setOftalmologia(boolean oftalmologia) {
        this.oftalmologia = oftalmologia;
    }

    public boolean isDental() {
        return dental;
    }

    public void setDental(boolean dental) {
        this.dental = dental;
    }

    public boolean isFecundacionInVitro() {
        return fecundacionInVitro;
    }

    public void setFecundacionInVitro(boolean fecundacionInVitro) {
        this.fecundacionInVitro = fecundacionInVitro;
    }

    @Override
    public String toString() {
        return "Coberturas{" + "oftalmologia=" + oftalmologia + ", dental=" + dental + ", fecundacionInVitro=" + fecundacionInVitro + '}';
    }
    
    
}
