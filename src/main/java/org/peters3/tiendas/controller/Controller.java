package org.peters3.tiendas.controller;

import org.peters3.tiendas.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class Controller {

    @PostMapping(value = "controller")
    public String welcome()
    {
        return "Código 404";
    }

    @GetMapping(value = "login")
    public String testLogin() {
    return "Get Usado";
    }

    @PostMapping(value = "login")
    public String Login() {
    return "Login POST recibido";
    }

}
