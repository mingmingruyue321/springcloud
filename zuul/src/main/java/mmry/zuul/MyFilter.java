package mmry.zuul;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
/**
 * zuul过滤器
 * @author mingmingruyue
 *
 */
@Component
public class MyFilter extends ZuulFilter{

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String name = request.getParameter("name");
        if(name==null||name.length()>5){
        	ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                HttpServletResponse response = ctx.getResponse();
                response.setCharacterEncoding("UTF-8");  
                response.setContentType("text/html; charset=UTF-8");
                response.getWriter().write("姓名不能为空且不能超过5位");
            }catch (Exception e){}
            return null;
        }
		return null;
	}
	/**
	 * 是否过滤
	 * 这里可以写逻辑判断，是否要过滤，本文true,永远过滤
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String name = request.getParameter("name");
        if(!"123456".equals(name)){
        	return true;
        }else{
        	return false;
        }
	}
	/**
	 * 过滤顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}
	/**
	 * 过滤类型
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
