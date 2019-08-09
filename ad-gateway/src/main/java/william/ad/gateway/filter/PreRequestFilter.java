package william.ad.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.*;

/**
 * <p>Zuul前置拦截器 </p>
 *
 * @author ZhangShenao
 * @date 2018年4月12日
 */
@Component
public class PreRequestFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //在请求上下文中记录请求开始时间
        RequestContext ctx = RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());
        return null;
    }
}
