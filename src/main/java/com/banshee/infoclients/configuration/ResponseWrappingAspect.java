package com.banshee.infoclients.configuration;

import com.banshee.infoclients.dto.CustomResponseDto;
import com.banshee.infoclients.exception.ApplicationException;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.NestedRuntimeException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * The type Response wrapping aspect.
 */
@Aspect
@Component
public class ResponseWrappingAspect {
    /**
     * Wrap response response entity.
     * Clase donde se centraliza toda la logica de respuestas a travéz de un CustomResponseDto
     * Consideraciones, las clases que exponen los servicios deben estar marcada con @RestController y retornar en todos sus metodos tipo object
     *
     * @param joinPoint the join point
     * @return the response entity
     */
    @Around("within(@org.springframework.web.bind.annotation.RestController *)")
    public ResponseEntity<?> wrapResponse(ProceedingJoinPoint joinPoint) {
        CustomResponseDto<Object> customResponseDto = CustomResponseDto.builder().build();
        Object value = null;
        try {
            value = joinPoint.proceed();
            if (value != null) {
                customResponseDto.setResponse(value);
                customResponseDto.setMessage(HttpStatus.OK.getReasonPhrase());
                customResponseDto.setStatus(HttpStatus.OK.value());
                return new ResponseEntity<Object>(customResponseDto, HttpStatus.OK);
            } else {
                customResponseDto.setError("Objeto nulo");
                return new ResponseEntity<Object>(customResponseDto, HttpStatus.NOT_FOUND);
            }
        } catch (Throwable e) {
            System.out.println("error en la clase " + e.getStackTrace()[0].getFileName() + " con metodo " + e.getStackTrace()[0].getMethodName());
            if (e instanceof MethodArgumentNotValidException
                || e instanceof MissingServletRequestPartException
                || e instanceof MissingServletRequestPartException
                || e instanceof MissingServletRequestParameterException
                || e instanceof TypeMismatchException
                || e instanceof MethodArgumentTypeMismatchException
            ) {
                customResponseDto.setError(e.getCause().toString());
                customResponseDto.setStatus(HttpStatus.BAD_REQUEST.value());
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.BAD_REQUEST);
            } else if (e instanceof NoHandlerFoundException) {
                customResponseDto.setError(e.getCause().toString());
                customResponseDto.setStatus(HttpStatus.NOT_FOUND.value());
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.NOT_FOUND);
            } else if (e instanceof HttpRequestMethodNotSupportedException) {
                customResponseDto.setError(e.getCause().toString());
                customResponseDto.setStatus(HttpStatus.METHOD_NOT_ALLOWED.value());
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.METHOD_NOT_ALLOWED);
            } else if (e instanceof HttpMediaTypeNotSupportedException) {
                customResponseDto.setError(e.getCause().toString());
                customResponseDto.setStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.UNSUPPORTED_MEDIA_TYPE);
            } else if (e instanceof TimeoutException
                || e instanceof NestedRuntimeException) {
                customResponseDto.setError(e.getCause().toString());
                customResponseDto.setStatus(HttpStatus.GATEWAY_TIMEOUT.value());
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.GATEWAY_TIMEOUT);
            } else if (e instanceof DataAccessException || e instanceof IOException || e instanceof RuntimeException || e instanceof NullPointerException) {
                customResponseDto.setError(e.getMessage());
                customResponseDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
            } else if (e instanceof ApplicationException) {
                customResponseDto.setError(e.getCause().toString());
                customResponseDto.setMessage(e.getMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.OK);

            } else {
                customResponseDto.setError(e.getMessage());
                customResponseDto.setStatus(88888888);
                customResponseDto.setPath(e.getLocalizedMessage());
                return new ResponseEntity<>(customResponseDto, HttpStatus.BAD_REQUEST);
            }
        }
    }
}
