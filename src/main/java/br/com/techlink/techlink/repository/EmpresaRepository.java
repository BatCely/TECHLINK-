package br.com.techlink.techlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.techlink.techlink.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}


