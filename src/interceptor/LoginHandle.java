package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandle implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// 调用之后执行
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//调用之前执行
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//所有的业务在这执行 
		// reurn ture 表示放行请求        
		//return flase 表示拦截请求
		/**
		 * 获取请求路径
		 * 获取当前用户登录
		 * 判断是否有session存在，如果存在则放行请求
		 * 不存在则拦截请求到登录页面
		 */
		System.out.println("所有的业务在这里进行");
		return true;
	}
	
}
