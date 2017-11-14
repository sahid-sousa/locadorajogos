package com.acception.locadorajogos

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class JogoServiceSpec extends Specification {

    JogoService jogoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Jogo(...).save(flush: true, failOnError: true)
        //new Jogo(...).save(flush: true, failOnError: true)
        //Jogo jogo = new Jogo(...).save(flush: true, failOnError: true)
        //new Jogo(...).save(flush: true, failOnError: true)
        //new Jogo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //jogo.id
    }

    void "test get"() {
        setupData()

        expect:
        jogoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Jogo> jogoList = jogoService.list(max: 2, offset: 2)

        then:
        jogoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        jogoService.count() == 5
    }

    void "test delete"() {
        Long jogoId = setupData()

        expect:
        jogoService.count() == 5

        when:
        jogoService.delete(jogoId)
        sessionFactory.currentSession.flush()

        then:
        jogoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Jogo jogo = new Jogo()
        jogoService.save(jogo)

        then:
        jogo.id != null
    }
}
