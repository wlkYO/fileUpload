package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginHandle implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// ����֮��ִ��
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//����֮ǰִ��
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//���е�ҵ������ִ�� 
		// reurn ture ��ʾ��������        
		//return flase ��ʾ��������
		/**
		 * ��ȡ����·��
		 * ��ȡ��ǰ�û���¼
		 * �ж��Ƿ���session���ڣ�����������������
		 * ���������������󵽵�¼ҳ��
		 */
		System.out.println("���е�ҵ�����������");
		return true;
	}
	
}
