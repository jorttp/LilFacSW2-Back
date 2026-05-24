package co.edu.uco.lilfac.features.worker.addworker.infrastructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.lilfac.infrastructure.config.ParametersConfig;

@RestController
@RequestMapping("/api/v1/parametros")
public class ParametersController {

    private final ParametersConfig parametros;

    public ParametersController(ParametersConfig parametros) {
        this.parametros = parametros;
    }

    @GetMapping
    public ParametersConfig getParametros() {
        return parametros;
    }
}