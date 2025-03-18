package org.peters3.tiendas.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
