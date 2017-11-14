package com.acception.locadorajogos

class Jogo {

    String nome
    Integer anoLancamento

    TipoPlataforma plataforma

    static hasMany = [solicitacoes : Solicitacao]

    static constraints = {
        nome nullable: false, blank: false
        anoLancamento nullable: false, min: 1940
        plataforma nullable: false
    }
}
