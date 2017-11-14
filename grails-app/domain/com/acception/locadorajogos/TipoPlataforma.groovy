package com.acception.locadorajogos

/**
 * Created by anne on 09/11/17.
 */
enum TipoPlataforma {
    X360("XBOX 360"),
    PS3 ("Playstation 3"),
    XONE("XBOX ONE"),
    WII ("Nintendo Wii")

    String nome

    TipoPlataforma(String nome) {
        this.nome = nome
    }

    String getKey(){
        return name()
    }
}