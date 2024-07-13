package com.example.demo;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.UsuarioDAO;
import com.example.demo.model.Usuario;
import org.springframework.web.bind.annotation.RequestParam;


@RestController //enrutador
public class UsuarioController {

    @CrossOrigin(origins = "*")
    @PostMapping("/addUser")
    public void addUser(@RequestBody Usuario us) {
        Usuario user=new Usuario(us.getNombre(), us.getApellido(), us.getEmail(), us.getPassword(), us.getFechaNacimiento(), us.getPais(), us.getTerminos());
        UsuarioDAO userDAO=new UsuarioDAO();
        userDAO.addUser(user);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/getUsers")
    public List<Usuario> getUsers() {
        UsuarioDAO userDAO=new UsuarioDAO();
        return userDAO.getUsers();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/deleteUser")
    public void deleteUser(@RequestParam("email") String email) {
        Usuario user=new Usuario(email);
        UsuarioDAO UserDAO=new UsuarioDAO();
        UserDAO.deleteUser(user);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody Usuario us) {
        Usuario user=new Usuario(us.getNombre(), us.getApellido(), us.getEmail(), us.getPassword(), us.getFechaNacimiento(), us.getPais(), us.getTerminos());;
        UsuarioDAO UserDAO=new UsuarioDAO();
        UserDAO.updateUser(user);
    }
    
}
