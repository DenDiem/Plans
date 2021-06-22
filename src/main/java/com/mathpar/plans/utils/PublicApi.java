package com.mathpar.plans.utils;

import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Анотація, яка додає в URL частину “/api”, використовується в контролерах
 * @author Семенюк Христина
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@RequestMapping("/api")
public @interface PublicApi {
}
