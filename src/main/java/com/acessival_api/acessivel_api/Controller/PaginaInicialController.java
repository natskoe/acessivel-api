package com.acessival_api.acessivel_api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class PaginaInicialController {
    @GetMapping("/")
    public static String paginaInicial(Model model) {
        return "a";
    }
}
