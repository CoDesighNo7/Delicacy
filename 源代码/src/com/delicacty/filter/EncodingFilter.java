package com.delicacty.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

@WebFilter(
        filterName = "EncodingFilter",
        urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name="encoding",value="UTF-8")
        })
public class EncodingFilter implements Filter{
	private FilterConfig config;
	@Override
	public void destroy() {
        config=null;
	}
	class MyRequest extends HttpServletRequestWrapper{
        public String encoding=config.getInitParameter("encoding");
        public String getParameter(String param){
            String value=null;
            try {
                super.setCharacterEncoding(encoding);
                value=super.getParameter(param);
                if(super.getMethod().equalsIgnoreCase("GET")){
                    if(value!=null){
                        value=new String(value.getBytes("iso8859-1"),encoding);
                    }
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return value;
        }
        public MyRequest(HttpServletRequest request) {
            super(request);
        }
    }
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String encoding=config.getInitParameter("encoding");
        request.setCharacterEncoding(encoding);
        HttpServletRequest hrequest= (HttpServletRequest) request;
        HttpSession session=hrequest.getSession(true);
        chain.doFilter(new MyRequest((HttpServletRequest)request), response);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
        this.config=filterConfig;
	}
	
}
