package com.oxygen.common.baseController;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;

/**
 * 基类的 Response controller。
 * @author: Wu.Liang
 * @createDate: 2015-6-3
 */
public class BaseResponseController {
	/**
	 * 把一个object对象以json格式打回客户端，默认格式为application/json
	 * 
	 * @param object
	 * @param response
	 * @throws IOException
	 * @author Wu.Liang
	 */
	public void renderJSON(Object object, HttpServletResponse response) throws IOException {
		String json = "";
		PrintWriter pw = null;
		try {
			json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			response.setContentType("application/json;charset=UTF-8");
			pw = response.getWriter();
			pw.write(json);
			pw.flush();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

	/**
	 * 把一个object对象以json格式打回客户端，contentType格式自己传入
	 * 
	 * @param object
	 * @param response
	 * @param format
	 * @throws IOException
	 * @author Wu.Liang
	 */
	public void renderJSON(Object object, HttpServletResponse response, String format) throws IOException {
		String json = "";
		PrintWriter pw = null;
		try {
			json = JSON.toJSONStringWithDateFormat(object, "yyyy-MM-dd HH:mm:ss");
			response.setContentType(format);
			pw = response.getWriter();
			pw.write(json);
			pw.flush();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}
	}

}
