package byma.com.ar.challenge.aspect;

import byma.com.ar.challenge.annotations.ExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

    @Around("@annotation(executionTime)") // Cambia el nombre del parámetro para que sea más claro
    public Object logExecutionTime(ProceedingJoinPoint joinPoint, ExecutionTime executionTime) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTimeMillis = System.currentTimeMillis() - start;

        logger.info("Método {} ejecutado en {} ms", joinPoint.getSignature(), executionTimeMillis);
        return proceed;
    }
}
