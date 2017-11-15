package com.acception.locadorajogos

import grails.transaction.Transactional

@Transactional
class UserService {
    User save(User user, Role role) {
        user.save()
        UserRole.create(user, role)
        return user
    }
}
