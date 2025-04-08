package com.scaler.productservicespk.controllerAdvices;

import com.scaler.productservicespk.dtos.ProductNotFoundExceptionDto;
import com.scaler.productservicespk.exceptions.ProductNotFoundException;
import com.scaler.productservicespk.models.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlers {

    @ExceptionHandler(ProductNotFoundException.class)
    private ResponseEntity<ProductNotFoundExceptionDto>  handleProductNotFoundException(){
        ProductNotFoundExceptionDto dto = new ProductNotFoundExceptionDto();
        dto.setMessage("Product not found with this id");
        dto.setResolution("please provide a valid id");

    return new ResponseEntity<>(
            dto,
            HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> handleRuntimeException(){
        return new ResponseEntity<>(
                "Its a runtime exception",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    private ResponseEntity<String> handleArrayIndexOutOfBoundException(){
        return new ResponseEntity<>("Array out of bound", HttpStatus.BAD_REQUEST);
    }

}
