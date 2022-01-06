package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.Identity;

public class HojaDeVidaId extends Identity {

    public HojaDeVidaId(){
    }

    public HojaDeVidaId(String value){
        super(value);
    }

    public static HojaDeVidaId of(String value) {
        return new HojaDeVidaId(value);
    }
}
