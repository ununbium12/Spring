package aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(2)
public class CacheAspect {

    private Map<Long, Object> cache = new HashMap<>();

//    @Pointcut("execution(public * chapter06..*(long))")
//    public void cacheTarget(){}
//
//    @Around("cacheTarget()")
    @Around("execution(public * chapter06..*(long))")
    public Object excute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long num = (Long) proceedingJoinPoint.getArgs()[0];
        if(cache.containsKey(num)) {
            System.out.printf("CacheAspect: Cache에서 구함 [%d]\n", num);
            return cache.get(num);
        }
        Object result = proceedingJoinPoint.proceed();
        cache.put(num, result);
        System.out.printf("CacheAspect: Cache에 추가 [%d]\n", num);
        return result;
    }
}
