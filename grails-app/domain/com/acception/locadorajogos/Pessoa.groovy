package com.acception.locadorajogos

class Pessoa {

    String nome
    Integer idade
    User user
    static hasMany = [solicitacoes : Solicitacao]

    static constraints = {
        nome nullable: false, blank: false
        idade nullable: false, min: 12
        solicitacoes nullable: true
    }
}
