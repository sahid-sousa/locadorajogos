package com.acception.locadorajogos

class Solicitacao {

    Pessoa pessoa
    Jogo jogo
    Integer tempo
    TipoSolicitacao solicitacao = TipoSolicitacao.AGUARDANDO


    static constraints = {
        pessoa nullable: false
        jogo nullable: false
        tempo nullable: false, min: 30
    }
}
