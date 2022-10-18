package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.dto.AlunoDTO;
import br.com.residencia.biblioteca.entity.Aluno;
import br.com.residencia.biblioteca.repository.AlunoRepository;

@Service
public class AlunoService {
	@Autowired
	AlunoRepository alunoRepository;
	
	public List<Aluno> getAllAlunos(){
		return alunoRepository.findAll();
	}
	
	public Aluno getAlunoById(Integer id) {
		//return alunoRepository.findById(id).get();
		return alunoRepository.findById(id).orElse(null);
	}
	
	public Aluno saveAluno(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	
	public Aluno updateAluno(Aluno aluno, Integer id) {
		/*Aluno alunoExistenteNoBanco = alunoRepository.findById(id).get();*/
		
		Aluno alunoExistenteNoBanco = getAlunoById(id);
		
		alunoExistenteNoBanco.setBairro(aluno.getBairro());
		alunoExistenteNoBanco.setCidade(aluno.getCidade());
		alunoExistenteNoBanco.setComplemento(aluno.getComplemento());
		alunoExistenteNoBanco.setCpf(aluno.getCpf());
		alunoExistenteNoBanco.setDataNascimento(aluno.getDataNascimento());
		alunoExistenteNoBanco.setEmprestimos(aluno.getEmprestimos());
		alunoExistenteNoBanco.setLogradouro(aluno.getLogradouro());
		alunoExistenteNoBanco.setNome(aluno.getNome());
		alunoExistenteNoBanco.setNumeroLogradouro(aluno.getNumeroLogradouro());
		
		return alunoRepository.save(alunoExistenteNoBanco);
	}
	
	public Aluno deleteAluno(Integer id) {
		alunoRepository.deleteById(id);
		return getAlunoById(id);
	}
	
	
	public AlunoDTO saveAlunoDTO(AlunoDTO alunoDTO) {
		Aluno aluno = toEntidade(alunoDTO);
		Aluno novoAluno = alunoRepository.save(aluno);

		AlunoDTO alunoAtualizadoDTO = toDTO(novoAluno);
		return alunoAtualizadoDTO;
	}
	
	public AlunoDTO updateAlunoDTO(AlunoDTO alunoDTO, Integer id) {
		Aluno alunoExistenteNoBanco = getAlunoById(id);
		AlunoDTO alunoAtualizadoDTO = new AlunoDTO();

		if (alunoExistenteNoBanco != null) {

			alunoExistenteNoBanco = toEntidade(alunoDTO);
			Aluno alunoAtualizado = alunoRepository.save(alunoExistenteNoBanco);

			alunoAtualizadoDTO = toDTO(alunoAtualizado);
		}
		return alunoAtualizadoDTO;
	}
	
	
	private Aluno toEntidade (AlunoDTO alunoDTO) {
		Aluno aluno = new Aluno();
		
		aluno.setBairro(alunoDTO.getBairro());
		aluno.setCidade(alunoDTO.getCidade());
		aluno.setComplemento(alunoDTO.getComplemento());
		aluno.setCpf(alunoDTO.getCpf());
		aluno.setDataNascimento(alunoDTO.getDataNascimento());
		aluno.setLogradouro(alunoDTO.getLogradouro());
		aluno.setNome(alunoDTO.getNome());
		aluno.setNumeroLogradouro(alunoDTO.getNumeroLogradouro());

		return aluno;
	}
	
	private AlunoDTO toDTO(Aluno aluno) {
		AlunoDTO alunoDTO = new AlunoDTO();
		
		alunoDTO.setBairro(aluno.getBairro());
		alunoDTO.setCidade(aluno.getCidade());
		alunoDTO.setComplemento(aluno.getComplemento());
		alunoDTO.setCpf(aluno.getCpf());
		alunoDTO.setDataNascimento(aluno.getDataNascimento());
		alunoDTO.setLogradouro(aluno.getLogradouro());
		alunoDTO.setNome(aluno.getNome());
		alunoDTO.setNumeroLogradouro(aluno.getNumeroLogradouro());

		return alunoDTO;
	}
	
}
