package william.ad.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 跳过统一响应的拦截
 * @Author ZhangShenao
 * @Date 2019/8/9 下午5:53
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface IngoreResponseAdvice {
}
