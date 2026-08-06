package dev.matheuslf.mastersys.service;

import dev.matheuslf.mastersys.domain.Aluno;
import dev.matheuslf.mastersys.dto.AlunoRequest;
import dev.matheuslf.mastersys.dto.AlunoResponse;
import dev.matheuslf.mastersys.repository.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    public final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    // C
    public AlunoResponse cadastrar(AlunoRequest request) {
        if (request.email() != null && alunoRepository.existsByEmail(request.email())) {
            throw new RuntimeException("Já existe um aluno cadastrado neste email");
        }

        Aluno aluno = request.toEntity();
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoSalvo);
    }

    // R
    public Page<AlunoResponse> listar(Pageable pageable) {
        return alunoRepository.findAll(pageable).map(AlunoResponse::fromEntity);
    }

    public AlunoResponse buscarPorID(Long id) {
        Aluno aluno = buscarEntidadePorID(id);
        return AlunoResponse.fromEntity(aluno);
    }

    // U
    public AlunoResponse atualizar(Long id, AlunoRequest request) {
        Aluno aluno = buscarEntidadePorID(id);
        request.preencher(aluno);
        Aluno alunoAtualizado = alunoRepository.save(aluno);
        return AlunoResponse.fromEntity(alunoAtualizado);
    }

    // D
    public void excluir(Long id) {
        Aluno aluno = buscarEntidadePorID(id);
        alunoRepository.delete(aluno);
    }

    private Aluno buscarEntidadePorID(Long id) {
        return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }

}
