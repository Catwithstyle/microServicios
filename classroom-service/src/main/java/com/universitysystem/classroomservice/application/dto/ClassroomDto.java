package com.universitysystem.classroomservice.application.dto;

import lombok.*;


@Builder
public class ClassroomDto {
    private Long id;
    private String code;
    private Integer capacity;
    private String type;

    public ClassroomDto() {
    }

    public ClassroomDto(Long id, String code, Integer capacity, String type) {
        this.id = id;
        this.code = code;
        this.capacity = capacity;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
