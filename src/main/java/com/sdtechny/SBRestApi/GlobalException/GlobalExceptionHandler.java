
package com.sdtechny.SBRestApi.GlobalException;

import com.sdtechny.SBRestApi.ExceptionHandler.EmpNameFieldException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EmpNameFieldException.class)
   public ResponseEntity<String> EmpNmaeMissingExceptionHandler(EmpNameFieldException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getErrMsg());
}
}
