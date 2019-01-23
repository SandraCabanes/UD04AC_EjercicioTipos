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
public class Nif implements Serializable{
    private String nif;

    public Nif() {
    }

    public Nif(String nif) {
        this.nif = nif;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    @Override
    public String toString() {
        return "Nif{" + "nif=" + nif + '}';
    }
    
}
