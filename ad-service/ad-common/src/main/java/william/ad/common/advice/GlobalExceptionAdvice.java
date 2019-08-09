package william.ad.common.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import william.ad.common.exception.AdException;
import william.ad.common.vo.CommonResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description 全局异常拦截器
 * @Author ZhangShenao
 * @Date 2019/8/9 下午6:01
 */
@RestControllerAdvice
public class GlobalExceptionAdvice {
    @ExceptionHandler(value = AdException.class)
    public CommonResponse handlerAdException(HttpServletRequest req, AdException ex) {
        return CommonResponse.error(ex.getMessage(),ex.getMessage());
    }
}
