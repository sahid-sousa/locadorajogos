package com.acception.locadorajogos

import grails.gorm.services.Service

@Service(Jogo)
interface JogoService {

    Jogo get(Serializable id)

    List<Jogo> list(Map args)

    Long count()

    void delete(Serializable id)

    Jogo save(Jogo jogo)

}