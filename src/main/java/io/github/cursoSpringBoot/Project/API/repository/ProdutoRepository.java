package io.github.cursoSpringBoot.Project.API.repository;

import io.github.cursoSpringBoot.Project.API.modol.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
