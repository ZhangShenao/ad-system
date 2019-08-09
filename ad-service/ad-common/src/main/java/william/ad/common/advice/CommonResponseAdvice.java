package william.ad.common.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import william.ad.common.annotation.IngoreResponseAdvice;
import william.ad.common.vo.CommonResponse;

/**
 * @Description 统一响应拦截器
 * @Author ZhangShenao
 * @Date 2019/8/9 下午5:50
 */
@RestControllerAdvice
public class CommonResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //如果在类上或者方法上标记了@IngoreResponseAdvice注解,则不进行响应的拦截
        if (methodParameter.getDeclaringClass().isAnnotationPresent(IngoreResponseAdvice.class)) {
            return false;
        }
        if (methodParameter.getMethod() != null && methodParameter.getMethod().isAnnotationPresent(IngoreResponseAdvice.class)) {
            return false;
        }
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //封装统一响应
        if (o == null){
            return CommonResponse.success();
        }
        if (o instanceof CommonResponse){
            return o;
        }
        return CommonResponse.success(o);
    }
}
