package org.example.vistula_java_project_task_2.product.support;

import org.example.vistula_java_project_task_2.product.support.exception.ProductNotFoundException;

import java.util.function.Supplier;

public class ProductExceptionSupplier {
    public static Supplier<ProductNotFoundException> productNotFound(Long id) {
        return () -> new ProductNotFoundException(id);
    }
}
