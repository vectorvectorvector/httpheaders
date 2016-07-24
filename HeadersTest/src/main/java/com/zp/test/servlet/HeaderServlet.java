package com.zp.test.servlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Value("#{properties['welcome']}")
	String val;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HeaderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("doGet:<br/>");
		GetHeaders(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("doPost:<br/>"/*+locale+"<br/>"*/);
		HashMap<String, String>headers=(HashMap<String, String>) GetHeaders(request, response);
//		Locale locale = request.getLocale();
		Enumeration<Locale> locales = request.getLocales();
        while(locales.hasMoreElements()){
            Locale temp = locales.nextElement();
            response.getWriter().append("Locales = " + temp+"<br/> ");
        }
//		String clientLanguage=headers.get("accept-language");
//        if (clientLanguage.equals("zh-cn") ) {
//        	request.setCharacterEncoding("GBK");
//        	response.setContentType("text/html; charset=GBK");
//        }
//        else if ( clientLanguage.equals("zh-tw") ) {
//        	request.setCharacterEncoding("BIG5");
//        	response.setContentType("text/html; charset=BIG5");
//        }
//        else {
//        	request.setCharacterEncoding("ISO-8859-1");
//        	response.setContentType("text/html; charset=ISO-8859-1");
//        }
        ResourceBundle lang=ResourceBundle.getBundle("com.zp.test.servlet.lang_zh_CN",Locale.SIMPLIFIED_CHINESE);
        response.getWriter().append(lang.getString("welcome")+"<br/>");
//        response.getWriter().append(lang.getString(val)+"<br/>");
	}
	
	public Map<String, String> GetHeaders(HttpServletRequest request,HttpServletResponse response) throws IOException {
	    Map<String, String> map = new HashMap<String, String>();
	    Enumeration headerNames = request.getHeaderNames();
	    while (headerNames.hasMoreElements()) {
	        String key = (String) headerNames.nextElement();
	        String value = request.getHeader(key);
	        map.put(key, value);
	        response.getWriter().append(key+" : "+value+"<br/>");
	    }
	    return map;
	}
}
