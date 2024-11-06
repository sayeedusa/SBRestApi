/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sdtechny.SBRestApi.ExceptionHandler;

/**
 *
 * @author Ruhit
 */
public class EmpNameFieldException extends RuntimeException{
    private String errMsg;

    public EmpNameFieldException() {
    }

    public EmpNameFieldException(String message) {
        this.errMsg=message;
     
    }
 
    
    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

  
    
}
