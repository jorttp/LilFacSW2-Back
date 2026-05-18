package co.edu.uco.lilfac.features.worker.addworker.infrastructure.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.lilfac.features.worker.addworker.application.inputport.AddWorkerInputPort;
import co.edu.uco.lilfac.features.worker.addworker.application.inputport.dto.AddWorkerDTO;

@RestController
@RequestMapping("/api/v1/workers")
public class AddWorkerController {

    private final AddWorkerInputPort inputPort;

    public AddWorkerController(AddWorkerInputPort inputPort) {
        this.inputPort = inputPort;
    }

    @PostMapping
    public ResponseEntity<Void> addWorker(@RequestBody AddWorkerDTO dto) {
        inputPort.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
