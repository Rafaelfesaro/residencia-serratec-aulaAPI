package br.com.residencia.biblioteca.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.residencia.biblioteca.entity.Livro;
import br.com.residencia.biblioteca.repository.LivroRepository;


@Service
public class LivroService {
	

LivroRepository livroRepository;
	
	public List<Livro> getAllLivros(){
		return livroRepository.findAll();
	}
	
	public Livro getLivroById(Integer id) {
		return livroRepository.findById(id).get();
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	
	public Livro updateLivro(Livro livro, Integer id) {
		
		Livro livroExistenteNoBanco = getLivroById(id);
		
//		livroExistenteNoBanco.setCodigoLivro(livro.getCodigoLivro());
		livroExistenteNoBanco.setNomeLivro(livro.getNomeLivro());
		livroExistenteNoBanco.setNomeAutor(livro.getNomeAutor());
		livroExistenteNoBanco.setDataLancamento(livro.getDataLancamento());
		livroExistenteNoBanco.setCodigoIsbn(livro.getCodigoIsbn());
//		livroExistenteNoBanco.setEditora(Editora);
//		livroExistenteNoBanco.setEmprestimo(Emprestimo);
		
		return livroRepository.save(livroExistenteNoBanco);
	}
	
	public Livro deleteLivro(Integer id) {
		livroRepository.deleteById(id);
		return getLivroById(id);
	}
	
	

}
