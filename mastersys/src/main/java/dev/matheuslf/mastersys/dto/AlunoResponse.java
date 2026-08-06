package dev.matheuslf.mastersys.dto;

import dev.matheuslf.mastersys.domain.Aluno;

import java.time.LocalDateTime;

public record AlunoResponse(
        Long id,
        String nome,
        String data_nascimento,
        String sexo,
        String celular,
        String email,
        String cidade,
        String estado,
        LocalDateTime criadoEm
) {
    public static AlunoResponse fromEntity(Aluno aluno) {
        return new AlunoResponse(
                aluno.getId(),
                aluno.getNome(),
                aluno.getDataNascimento().toString(),
                aluno.getSexo(),
                aluno.getCelular(),
                aluno.getEmail(),
                aluno.getCidade(),
                aluno.getEstado(),
                aluno.getCriadoEm()
        );
    }
}
