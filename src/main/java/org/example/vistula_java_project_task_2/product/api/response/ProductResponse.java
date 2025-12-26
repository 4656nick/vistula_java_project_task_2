package org.example.vistula_java_project_task_2.product.api.response;

public class ProductResponse {

    private final Long id;
    private final String name;

    public ProductResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() { return id; }

    public String getName() { return name; }


}