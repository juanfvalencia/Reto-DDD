package com.sofka.curriculum.generics;

import co.com.sofka.domain.generic.Identity;

public class HojaDeVidaId extends Identity {

    public HojaDeVidaId(){
    }

    public HojaDeVidaId(String uuid){
        super(uuid);
    }

    public static HojaDeVidaId of(String uuid) {
        return new HojaDeVidaId(uuid);
    }
}
