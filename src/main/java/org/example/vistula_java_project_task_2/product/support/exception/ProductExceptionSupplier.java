package org.example.vistula_java_project_task_2.product.support.exception;

import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class ProductExceptionSupplier {

    public static Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}