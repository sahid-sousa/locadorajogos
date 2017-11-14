package com.acception.locadorajogos

enum TipoSolicitacao {
    AGUARDANDO("Aguardando"),
    LIBERADO("Liberado")

    String status

    TipoSolicitacao(String status) {
        this.status = status
    }

    String getKey(){
        return name()
    }
}