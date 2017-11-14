package com.acception.locadorajogos

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class JogoController {

    JogoService jogoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond jogoService.list(params), model:[jogoCount: jogoService.count()]
    }

    def show(Long id) {
        respond jogoService.get(id)
    }

    def create() {
        respond new Jogo(params)
    }

    def save(Jogo jogo) {
        if (jogo == null) {
            notFound()
            return
        }

        try {
            jogoService.save(jogo)
        } catch (ValidationException e) {
            respond jogo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'jogo.label', default: 'Jogo'), jogo.id])
                redirect jogo
            }
            '*' { respond jogo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond jogoService.get(id)
    }

    def update(Jogo jogo) {
        if (jogo == null) {
            notFound()
            return
        }

        try {
            jogoService.save(jogo)
        } catch (ValidationException e) {
            respond jogo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'jogo.label', default: 'Jogo'), jogo.id])
                redirect jogo
            }
            '*'{ respond jogo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        jogoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'jogo.label', default: 'Jogo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'jogo.label', default: 'Jogo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
