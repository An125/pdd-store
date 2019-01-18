package com.pdd.shopMgr.webServer.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.csource.common.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.oxygen.common.util.FastDFSClient;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.shopMgr.api.service.StoreGoodsService;
import com.pdd.shopMgr.common.vo.GoodsVo;




/**
 * 
 * @作者： zhaoxin
 * @日期：2018年7月2日
 * @描述：文件上传下载
 */
@RestController
@RequestMapping("/shopMgr")
public class FastDFSController {
	private static final Logger LOG = Logger.getLogger(FastDFSController.class);
	
	@Autowired
	private StoreGoodsService storeGoodsService;
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月3日
	 * @描述：文件上传
	 * @param  id 商品id
	 */
	@PostMapping("/upload")
	public MsgReturn<Object> upload(String id,HttpServletRequest request,HttpServletResponse response) throws Exception {
		MsgReturn<Object> msg = new MsgReturn<Object>();
		// 创建文件上传 request 解析器
		CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		
		try {
			
			// 判断 request 是否是一个上传文件的 request
			if (resolver.isMultipart(request)) {
				 // 转换request
				MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
				//解析request，将结果放置在map中
				Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
				if (fileMap == null || fileMap.size() == 0) {
					LOG.info("上传文件为空！");
				} else if (fileMap.size() > 5) {
					LOG.info("上传文件数量超过 5 了！");
				} else {
					
					//获得map的迭代器，用作遍历map中的每一个键值对
					//Iterator<Entry<String, MultipartFile>> entrySetIterator 声明一个迭代器,迭代元素本身就是一个Entry键值对
					Iterator<Entry<String, MultipartFile>> entrySetIterator = fileMap.entrySet().iterator();
					Entry<String, MultipartFile> entry;

					while (entrySetIterator.hasNext()) {
						entry = entrySetIterator.next();
						LOG.info("entry.getKey() : " + entry.getKey() + " ; entry.getValue() : " + entry.getValue());
						LOG.info("文件大小：" + entry.getValue().getSize());
						LOG.info("entry.getValue().getOriginalFilename()：" + entry.getValue().getOriginalFilename());
						
						// 这里可以手动限制一下上传大小，当然 Spring-MVC 的 XML 配置文件里也可以有相应的配置
						if(1024 * 1024 * 3 < entry.getValue().getSize()){
							LOG.info("图片 " + entry.getValue().getOriginalFilename() + " 大小超过限制 (3MB)，上传操作终止。");
						}
						String fastDFS_Id = uploadFileByFastDFS(entry.getValue());
						
						// 访问 FastDFS 系统文件方式示例：http://192.168.1.251:8888/group1/M00/00/00/wKgB-1sq8gaAN4DmAAAAGUhejOQ591.txt，会弹出下载框下载。
						// URL前缀：http://192.168.1.251:8888/
						// FastDFS_Id样例格式如：group1/M00/00/00/wKgB-1sq8gaAN4DmAAAAGUhejOQ591.txt
						LOG.info("FastDFS_Id : " + fastDFS_Id);
						
						//存到数据库中
						GoodsVo vo = storeGoodsService.pictureUpload(id, fastDFS_Id);
						if(vo==null) {
							msg.failed("文件存储失败！");
						}else {
							msg.setReturnObj(vo.getPicUrl());
							msg.success("文件存储成功！");
						}
					}
				}
			} else {
				LOG.info("request is not Multipart ...");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
			msg.exception();
		}
		
		return msg;
	}
	
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月3日
	 * @描述：文件下载
	 */
	@RequestMapping("/download")
	public String download() {
		InputStream downloadFile = FastDFSClient.downloadFile("group1/M00/00/00/wKgB-1tSQoSAXYlXAAAX06rfhKc834.jpg");
		if(downloadFile==null) {
			LOG.info("--->下载失败！");
			return "error";
		}else {
			LOG.info("--->下载成功！");
			return "success";
		}
		
	}
	/**
	 * 
	 * @作者： zhaoxin
	 * @日期：2018年7月4日
	 * @描述：文件删除
	 */
	@RequestMapping("/delete")
	public String delete() {
		int result = FastDFSClient.deleteFile("group1/M00/00/00/wKgB-1tSRc-AaVrCAAAX06rfhKc499.jpg");
		if(result == 0) {
			LOG.info("--->删除成功！");
			return "success";
		}else {
			LOG.info("--->删除失败！");
			return "error";
		}
	}

	/**
	 * 用 fastDFS工具上传文件 
	 * @param file  
	 * @return
	 * @throws MyException 
	 * @throws IOException 
	 * 
	 * 接收方法：MultipartFile 接受文件并通过IO二进制流(MultipartFile.getInputStream())输入到FileOutStream保存文件，然后该干嘛就干嘛
	 * 参数接收:接受form表单name为file的参数
	 */
	private String uploadFileByFastDFS(MultipartFile file) throws IOException, MyException {
		return FastDFSClient.uploadFile(file.getBytes(), file.getOriginalFilename(), null);
	}
}
