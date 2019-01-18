package com.oxygen.shop.server.controller.user.company.product.pc;

import java.awt.Image;
import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oxygen.common.uuid.CommonUtils;
import com.oxygen.shop.rpc.service.impl.user.company.product.pc.photographDao;

import net.sf.json.JSONObject;
@Controller
public class photograph {
		@RequestMapping(value = "/add_photograph", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})// method = RequestMethod.POST,
		public String add_photograph(HttpServletRequest request,
				HttpServletResponse response){
			/*
			 * 1. 把表单数据封装到Book对象中
			 *   * 上传三步
			 */
			// 创建工厂
			DiskFileItemFactory factory = new DiskFileItemFactory(15 * 1024, new File("E:/temp"));
			// 得到解析器
			ServletFileUpload sfu = new ServletFileUpload(factory);
			// 设置单个文件大小为15KB
			//sfu.setFileSizeMax(20 * 1024);
			// 使用解析器去解析request对象，得到List<FileItem>
			try {
				List<FileItem> fileItemList = sfu.parseRequest(request);
				/*
				 * 	 把fileItemList中的数据封装到Book对象中
				 *   > 把所有的普通表单字段数据先封装到Map中
				 *   
				 *   > 再把map中的数据封装到Book对象中
				 */
				FileItem f0 = fileItemList.get(0);
				FileItem f1 = fileItemList.get(1);
				FileItem f2 = fileItemList.get(2);
				FileItem f3 = fileItemList.get(3);
				FileItem f4 = fileItemList.get(4);
				FileItem fi = fileItemList.get(5);
				
				/*System.out.println("普通表单项演示：" + f0.getFieldName() + "=" + f0.getString("UTF-8"));
				System.out.println("普通表单项演示：" + f1.getFieldName() + "=" + f1.getString("UTF-8"));
				System.out.println("普通表单项演示：" + f2.getFieldName() + "=" + f2.getString("UTF-8"));
				System.out.println("普通表单项演示：" + f3.getFieldName() + "=" + f3.getString("UTF-8"));
*/
				/*
				 * 1. 得到文件保存的路径
				 */
				/*String root = request.getSession().getServletContext().getRealPath(
						"/files/");*/
				/*
				 * 2. 生成二层目录 1). 得到文件名称 2). 得到hashCode 3). 转发成16进制 4). 获取前二个字符用来生成目录
				 */
				String filename = fi.getName();// 获取上传的文件名称
				if(!filename.toLowerCase().endsWith("jpg")) {
					request.setAttribute("msg", "您上传的图片不是JPG扩展名！");
					return null;
				}
				/*
				 * 处理文件名的绝对路径问题
				 */
				int index = filename.lastIndexOf("\\");
				if (index != -1) {
					filename = filename.substring(index + 1);
				}
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
				String diz="files/" +hex.charAt(0) + "/" + hex.charAt(1)+ "/" + savename.replace(" ", "")+".jpg";
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

				/*
				 * 5. 保存
				 */
				fi.write(destFile);
				
				JSONObject json = new JSONObject();
//				addressDao addressDao = new addressDao();
				json = photographDao.add_quotation(f0.getString("UTF-8"),f1.getString("UTF-8"),f2.getString("UTF-8"),f3.getString("UTF-8"),f4.getString("UTF-8"),diz);
				/*
				 * 校验图片的尺寸
				 */
				Image image = new ImageIcon(destFile.getAbsolutePath()).getImage();
				if(image.getWidth(null) > 200 || image.getHeight(null) > 200) {
					/*	destFile.delete();//删除这个文件！
					request.setAttribute("msg", "您上传的图片尺寸超出了200 * 200！");*/
					//return;
				}
				
				
				/*
				 * 5. 返回到图书列表
				 */
				/*request.getRequestDispatcher("/admin/AdminBookServlet?method=findAll")
						.forward(request, response);*/
			} catch (Exception e) { 
				if(e instanceof FileUploadBase.FileSizeLimitExceededException) {
					request.setAttribute("msg", "您上传的文件超出了15KB");
					//request.setAttribute("categoryList", categoryService.findAll());
					//request.getRequestDispatcher("/adminjsps/admin/book/add.jsp")
					//		.forward(request, response);
				}
				e.printStackTrace();
			}
			request.setAttribute("select_quotation",photographDao.select_quotation());		
			return "/jsp/photograph1/list.jsp";
		}
	}
			