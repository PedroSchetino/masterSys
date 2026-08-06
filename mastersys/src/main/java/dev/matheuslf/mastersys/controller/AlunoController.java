package dev.matheuslf.mastersys.controller;

import dev.matheuslf.mastersys.dto.AlunoRequest;
import dev.matheuslf.mastersys.dto.AlunoResponse;
import dev.matheuslf.mastersys.service.AlunoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AlunoResponse cadastrar(@RequestBody AlunoRequest alunoRequest) {
        return alunoService.cadastrar(alunoRequest);
    }

    @GetMapping
    public Page<AlunoResponse> Listar(Pageable pageable) {
        return alunoService.listar(pageable);
    }

    @GetMapping("/{id}")
    public AlunoResponse buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorID(id);
    }

    @PutMapping("/{id}")
    public AlunoResponse atualizar(@PathVariable Long id, @RequestBody AlunoRequest alunoRequest) {
        return alunoService.atualizar(id, alunoRequest);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(Long id) {
        alunoService.excluir(id);
    }

}
