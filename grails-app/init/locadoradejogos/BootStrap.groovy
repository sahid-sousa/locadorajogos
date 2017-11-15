package locadoradejogos


import com.acception.locadorajogos.Pessoa
import com.acception.locadorajogos.Role
import com.acception.locadorajogos.User
import com.acception.locadorajogos.UserRole

class BootStrap {


    def init = { servletContext ->
//        if (User.findByUsername("suporte.acception") == null) {
            Pessoa pessoa = new Pessoa()
            pessoa.nome = "Sahid"
            pessoa.idade = 26

            if (Role.findByAuthority("ROLE_SUPORTE") == null) {
                Role role = new Role()

                role.authority = "ROLE_SUPORTE"

                User user = new User()
                user.username = "suporte.acception"
                user.password = "123456"

                pessoa.user = user

                UserRole userRole = new UserRole()
                userRole.user = user.save()
                userRole.role = role.save()
                userRole.save()

                pessoa.save()
//
//            }


        }
    }
    def destroy = {
    }
}
