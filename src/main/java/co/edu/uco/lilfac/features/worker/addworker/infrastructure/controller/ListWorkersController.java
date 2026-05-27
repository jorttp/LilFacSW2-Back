package co.edu.uco.lilfac.features.worker.addworker.infrastructure.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.lilfac.features.worker.addworker.application.inputport.dto.AddWorkerDTO;
import co.edu.uco.lilfac.infrastructure.persistance.repository.WorkerRepository;
import co.edu.uco.lilfac.infrastructure.persistance.repository.entity.WorkerEntity;

@RestController
@RequestMapping("/api/v1/workers")
public class ListWorkersController {

    private final WorkerRepository workerRepository;

    public ListWorkersController(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @GetMapping
    public ResponseEntity<List<AddWorkerDTO>> listWorkers() {
        List<AddWorkerDTO> workers = workerRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(workers);
    }

    private AddWorkerDTO toDto(WorkerEntity worker) {
        return new AddWorkerDTO(
                worker.getId(),
                worker.getName(),
                worker.getIdType(),
                worker.getIdNumber(),
                worker.getPhoneNumber(),
                worker.getMail(),
                worker.getAddress()
        );
    }
}
