/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springboot.app1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author pepeGuapo
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductoNoEncontradoException extends Exception{
    
     public ProductoNoEncontradoException(String mensaje) {
        super(mensaje);
    }
    
}
