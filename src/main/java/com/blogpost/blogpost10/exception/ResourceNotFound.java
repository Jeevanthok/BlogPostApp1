package com.blogpost.blogpost10.exception;

import lombok.Data;

import java.util.UUID;
@Data
public class ResourceNotFound extends RuntimeException {
    String resourcename;
    String filedName;
    int fieldValue;

    public ResourceNotFound(String resourcename, String filedName, int fieldValue) {
        super(String.format("User not found %s with field %s and %s",resourcename,filedName,fieldValue));
        this.resourcename = resourcename;
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }
}
