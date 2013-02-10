package travelbook

import grails.plugins.springsecurity.SpringSecurityService
import org.springframework.dao.DataIntegrityViolationException

class TravelController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(long id) {
		User userInstance = User.findById(id)
        [userInstance: userInstance, travelInstanceList: Travel.list(params), travelInstanceTotal: Travel.count()]
    }

    def create() {
        [travelInstance: new Travel(params)]
    }

    def save() {
        def travelInstance = new Travel(params)
        if (!travelInstance.save(flush: true)) {
            render(view: "create", model: [travelInstance: travelInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'travel.label', default: 'Travel'), travelInstance.id])
        redirect(action: "show", id: travelInstance.id)
    }

    def show(Long id) {
        def travelInstance = Travel.get(id)
        if (!travelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'travel.label', default: 'Travel'), id])
            redirect(action: "list")
            return
        }

        [travelInstance: travelInstance]
    }

    def edit(Long id) {
        def travelInstance = Travel.get(id)
        if (!travelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'travel.label', default: 'Travel'), id])
            redirect(action: "list")
            return
        }

        [travelInstance: travelInstance]
    }

    def update(Long id, Long version) {
        def travelInstance = Travel.get(id)
        if (!travelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'travel.label', default: 'Travel'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (travelInstance.version > version) {
                travelInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'travel.label', default: 'Travel')] as Object[],
                          "Another user has updated this Travel while you were editing")
                render(view: "edit", model: [travelInstance: travelInstance])
                return
            }
        }

        travelInstance.properties = params

        if (!travelInstance.save(flush: true)) {
            render(view: "edit", model: [travelInstance: travelInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'travel.label', default: 'Travel'), travelInstance.id])
        redirect(action: "show", id: travelInstance.id)
    }

    def delete(Long id) {
        def travelInstance = Travel.get(id)
        if (!travelInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'travel.label', default: 'Travel'), id])
            redirect(action: "list")
            return
        }

        try {
            travelInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'travel.label', default: 'Travel'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'travel.label', default: 'Travel'), id])
            redirect(action: "show", id: id)
        }
    }
}
