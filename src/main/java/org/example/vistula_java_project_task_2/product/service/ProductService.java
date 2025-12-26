package org.example.vistula_java_project_task_2.product.service;

import org.example.vistula_java_project_task_2.product.api.request.ProductRequest;
import org.example.vistula_java_project_task_2.product.api.request.UpdateProductRequest;
import org.example.vistula_java_project_task_2.product.api.response.ProductResponse;
import org.example.vistula_java_project_task_2.product.domain.Product;
import org.example.vistula_java_project_task_2.product.repository.ProductRepository;
import org.example.vistula_java_project_task_2.product.support.ProductMapper;
import org.example.vistula_java_project_task_2.product.support.exception.ProductExceptionSupplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductResponse create(ProductRequest productRequest) {
        Product product = productRepository.save(productMapper.toProduct(productRequest));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse find(Long id) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        return productMapper.toProductResponse(product);
    }

    public ProductResponse update(Long id, UpdateProductRequest updateProductRequest) {
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.save(productMapper.toProduct(product, updateProductRequest));
        return productMapper.toProductResponse(product);
    }

    public List <ProductResponse> findAll() {
        return productRepository.findAll().stream().map(productMapper::toProductResponse).collect(Collectors.toList());
    }

    public void delete(Long id){
        Product product = productRepository.findById(id).orElseThrow(ProductExceptionSupplier.productNotFound(id));
        productRepository.deleteById(product.getId());
    }
}
