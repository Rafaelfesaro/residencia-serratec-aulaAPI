package br.com.residencia.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.residencia.biblioteca.entity.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>

{

}
