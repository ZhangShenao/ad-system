package william.ad.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import javax.servlet.http.HttpServletRequest;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * <p>Zuul后置拦截器 </p>
 *
 * @author ZhangShenao
 * @date 2018年4月12日
 */
public class LogFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //从请求上下文中获取请求开始时间,并打印处理耗时
        RequestContext ctx = RequestContext.getCurrentContext();
        long startTime = (long) ctx.get("startTime");
        HttpServletRequest request = ctx.getRequest();
        String uri = request.getRequestURI();
        System.err.println(String.format("uri: %s, 耗时: %s", uri, (System.currentTimeMillis() - startTime)));
        return null;
    }
}
