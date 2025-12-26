package org.example.vistula_java_project_task_2.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.example.vistula_java_project_task_2.product.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}