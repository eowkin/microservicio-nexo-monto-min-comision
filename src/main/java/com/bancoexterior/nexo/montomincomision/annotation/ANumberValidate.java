package com.bancoexterior.nexo.montomincomision.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.bancoexterior.nexo.montomincomision.config.Codigos.Annotation;

@Documented
@Constraint(validatedBy = NumberValidate.class)
@Target( { METHOD, FIELD ,ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface ANumberValidate {
    String message() default Annotation.NUMBERDEFAULT;
    double min () default Double.MIN_VALUE;
    double max () default Double.MAX_VALUE;
    int decimales () default Integer.MAX_VALUE;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}