package org.zkoss.zksandbox.model;

import java.util.*;

public class EntidadeLegal {

    private List<String> entidades = new ArrayList<String>();

    public EntidadeLegal(){
        this.entidades.add("Pessoa Singular");
        this.entidades.add("Organização");
    }

    public final List<String> getEntidades(){
        return this.entidades;
    }

}
