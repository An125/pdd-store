package com.oxygen.shop.server.controller.user.loginRegister;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.common.uuid.CommonUtils;
import com.oxygen.shop.rpc.service.impl.user.loginRegister.PictureUploadDao;

import net.sf.json.JSONObject;


@Controller
public class PictureUpload {
	//照片上传
	@RequestMapping(value = "/pictureupload",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})// method = RequestMethod.POST,
	@ResponseBody
	public String add_photograph(HttpServletRequest request,
			HttpServletResponse response){
		String mobile = String.valueOf(request.getParameter("mobile")); // 手机号
		String user_id = String.valueOf(request.getParameter("user_id")); // id
		/*
		 * 1. 把表单数据封装到Book对象中
		 *   * 上传三步
		 */
		
		/*try {
			ServletInputStream in = request.getInputStream();
			String s = IOUtils.toString(in);
			System.out.println(s);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		JSONObject json = new JSONObject();
		// 创建工厂
		DiskFileItemFactory factory = new DiskFileItemFactory(15 * 1024, new File("E:/temp"));
		// 得到解析器	
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 设置单个文件大小为15KB
		//sfu.setFileSizeMax(20 * 1024);
		// 使用解析器去解析request对象，得到List<FileItem>
		String diz= "NO";
		
		try {
			/*ServletInputStream in = request.getInputStream();
			String s = IOUtils.toString(in);
			System.out.println(s);*/	
			List<FileItem> fileItemList = sfu.parseRequest(request);
			/*
			 * 	 把fileItemList中的数据封装到Book对象中
			 *   > 把所有的普通表单字段数据先封装到Map中
			 *   
			 *   > 再把map中的数据封装到Book对象中
			 */
			 
			FileItem f0 = fileItemList.get(0);
			String filename = f0.getName()+".jpg";// 获取上传的文件名称
			
			/*
			 * 给文件名称添加uuid前缀，处理文件同名问题
			 */
			String savename = CommonUtils.uuid();

			/*
			 * 1. 得到hashCode
			 */
			int hCode = filename.hashCode();
			String hex = Integer.toHexString(hCode);
			 
			/*
			 * 2. 获取hex的前两个字母，与root连接在一起，生成一个完整的路径
			 */
			File dirFile = new File("E:/files/"+hex.charAt(0) + "/" + hex.charAt(1));
			diz="files/" +hex.charAt(0) + "/" + hex.charAt(1)+ "/" + savename.replace(" ", "")+".jpg";
			System.out.println(diz);
			/*
			 * 3. 创建目录链
			 */
			dirFile.mkdirs();

			/*
			 * 4. 创建目录文件
			 */
			File destFile = new File(dirFile, savename.replace(" ", "")+".jpg");
			//destFile.mkdir();
			System.out.println(diz);
			PictureUploadDao.insertDiz(diz,user_id);
			 
			/*
			 * 5. 保存
			 */
			f0.write(destFile);
			/*String a = f0.getString("UTF-8");
			System.out.println(a);*/
		} catch (Exception e) { 
				e.printStackTrace();
				
		}
		
		json.put("root", diz);
		return json.toString();
		//return diz;
		}	
}
