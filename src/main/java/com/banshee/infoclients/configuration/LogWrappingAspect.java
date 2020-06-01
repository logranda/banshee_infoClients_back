package com.banshee.infoclients.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * The type Log wrapping aspect.
 * clase para llevar el log de las clases anotadas con @Service y @RestController
 */
@Slf4j
@Aspect
@Component
public class LogWrappingAspect {
    /**
     * Any controller pointcut.
     * Mapea el @RestController.
     */
    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void anyControllerPointcut() {
    }

    /**
     * Any service pointcut.
     * Mapea el @Service.
     */
    @Pointcut("within(@org.springframework.stereotype.Service *)")
    public void anyServicePointcut() {
    }

    /**
     * Any method pointcut.
     * Se encarga de escuchar todos los metodos de las clases.
     */
    @Pointcut("execution(* *(..))")
    public void anyMethodPointcut() {
    }

    /**
     * Wrap response before.
     * Mapea el log apenas inicia el método
     *
     * @param joinPoint the join point
     */
    @Before(value = "(anyControllerPointcut() || anyServicePointcut()) && anyMethodPointcut()")
    @Order(1)
    public void wrapResponseBefore(JoinPoint joinPoint) {
        log.debug("Ingresa al método " + joinPoint.getSignature().getName() + " de la clase " + joinPoint.getTarget().getClass().getSimpleName());
        log.info("Ingresa al método " + joinPoint.getSignature().getName() + " de la clase " + joinPoint.getTarget().getClass().getSimpleName());
    }

    /**
     * Wrap response.
     * Mapea el log despues de que finaliza el método
     *
     * @param joinPoint the join point
     * @param response  the response
     */
    @AfterReturning(
            value = "(anyControllerPointcut() || anyServicePointcut()) && anyMethodPointcut()",
            returning = "response")
    @Order(2)
    public void wrapResponse(JoinPoint joinPoint, Object response) {
        if(joinPoint != null && response != null){
            log.debug(
                    "Termina el método " + joinPoint.getSignature().getName() + " de la clase " + joinPoint.getTarget().getClass().getSimpleName() + " y responde el sigueinte objeto "
                            + response.toString());
            log.info("Termina el método " + joinPoint.getSignature().getName() + " de la clase " + joinPoint.getTarget().getClass().getSimpleName() + " y responde el sigueinte objeto "
                    + response.toString());
        }
    }

    /**
     * Wrap exception.
     * Mapea el log si hay una excepcion.
     *
     * @param joinPoint the join point
     * @param error     the error
     */
    @AfterThrowing(
            value = "(anyControllerPointcut() || anyServicePointcut()) && anyMethodPointcut()",
            throwing = "error")
    @Order(3)
    public void wrapException(JoinPoint joinPoint, Exception error) {
        log.error("Error en " + joinPoint.getSignature().getName() + " de la clase " + joinPoint.getTarget().getClass().getSimpleName() + "\nMensaje: " + error.getMessage()
                + "\nCausa: " + error.getCause());
    }
}
