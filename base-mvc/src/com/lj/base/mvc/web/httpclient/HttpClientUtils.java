package com.lj.base.mvc.web.httpclient;
/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lj.base.core.util.StringUtils;
import com.lj.base.exception.TsfaRuntimeException;
/**
 * 
 * 
 * 类说明：
 *  
 * 
 * <p>
 * 详细描述：对httpclient包的封装简化,直接进行get/post请求处理（注意，不考虑session）
 *   
 * @Company: 扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public class HttpClientUtils {
	
	/** The Constant DEFAULT_ENCODING. */
	private static final String DEFAULT_ENCODING = "UTF-8";
	
	/**
	 * *
	 * 根据url请求获取web内容
	 * 注意，url参数要经过urlEncode编码.
	 *
	 * @param url the url
	 * @return the from web
	 */
	public static String getFromWeb(String url) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpGet httpget = new HttpGet(url);
		try {
			HttpResponse httpresponse = httpclient.execute(httpget);
			return StringUtils.stream2String(
					httpresponse.getEntity().getContent(),
					httpresponse.getEntity().getContentEncoding()==null?DEFAULT_ENCODING:httpresponse.getEntity().getContentEncoding().getValue()
                   );
			
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			throw new TsfaRuntimeException("tsfa-mvc-getFromWeb","getFromWeb error:"+e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new TsfaRuntimeException("tsfa-mvc-getFromWeb","getFromWeb error:"+e);
		}

	}
	
	/**
	 * *
	 * POST提交(UTF-8).
	 *
	 * @param url the url
	 * @param params the params
	 * @return the string
	 */
	public  static String postToWeb(String url,Map<String,String> params){
		return postToWeb(url,DEFAULT_ENCODING,params);
	}
	
	
	/**
	 * 方法说明：POST提交.
	 *
	 * @param url the url
	 * @param enc the enc
	 * @param params the params
	 * @param responseEnc 返回编码
	 * @return the string
	 * 
	 * @author 彭阳 
	 * CreateDate: 2017年7月1日
	 */
	public static String postToWeb(String url,String enc, Map<String,String>  params,String responseEnc){
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(url); 
			
			HttpEntity entity = new UrlEncodedFormEntity(convertMapToPostParams(params),enc);
			httppost.setEntity(entity);
			HttpResponse httpresponse = httpclient.execute(httppost);
			return StringUtils.stream2String(
					httpresponse.getEntity().getContent(),
					httpresponse.getEntity().getContentEncoding()==null?responseEnc:httpresponse.getEntity().getContentEncoding().getValue()
                   );
			
		} catch (ClientProtocolException e) {
			
			throw new TsfaRuntimeException("tsfa-mvc-getFromWeb","getFromWeb error:"+e);
		} catch (IOException e) {
			throw new TsfaRuntimeException("tsfa-mvc-getFromWeb","getFromWeb error:"+e);
		}catch (Exception e) {
			throw new TsfaRuntimeException("tsfa-mvc-getFromWeb","getFromWeb error:"+e);
		}
	}
	
	/**
	 * *
	 * POST提交.
	 *
	 * @param url the url
	 * @param enc the enc
	 * @param params the params
	 * @return the string
	 */
	public static String postToWeb(String url,String enc, Map<String,String>  params) { 
		return postToWeb(url,DEFAULT_ENCODING,params,DEFAULT_ENCODING);
		

	}
	
	/**
	 * Convert map to post params.
	 *
	 * @param params the params
	 * @return the list< name value pair>
	 */
	private static List<NameValuePair> convertMapToPostParams(Map<String,String> params){
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		for(String key : params.keySet()){ 
			formparams.add(new BasicNameValuePair(key, params.get(key))); 
		}
		return formparams;
	}
	
	/**
	 * *
	 * 对字符串进行http url编码(UTF-8).
	 *
	 * @param str the str
	 * @return the string
	 */
	public static String urlEncode(String str){
		try {
			return URLEncoder.encode(str, DEFAULT_ENCODING);
		} catch (UnsupportedEncodingException e) {
			
			throw new TsfaRuntimeException("tsfa-mvc-urlEncode","urlencode error:"+e);
		}
	}
	
	/**
	 * *
	 * 对字符串进行http url编码(enc).
	 *
	 * @param str the str
	 * @param enc the enc
	 * @return the string
	 */
	public static String urlEncode(String str,String enc){
		try {
			return URLEncoder.encode(str, enc);
		} catch (UnsupportedEncodingException e) {
			
			throw new TsfaRuntimeException("tsfa-mvc-urlEncode","urlencode"+" "+enc+"  error:"+e);
		}
	}
	
	/**
	 * 方法说明：获取客户端IP.
	 *
	 * @param request the request
	 * @return the ip address
	 * @author 彭阳
	 * 
	 * CreateDate: 2017年7月1日
	 */
	public static String getIpAddress(HttpServletRequest request) { 
        String ip = request.getHeader("x-forwarded-for"); 
        if(StringUtils.isNullOrEmpty(ip) || ip.equalsIgnoreCase("unknown")) { 
            ip = request.getHeader("X-Forwarded-For"); 
        } 
        if(StringUtils.isNullOrEmpty(ip) || ip.equalsIgnoreCase("unknown")) { 
        	ip = request.getHeader("Proxy-Client-IP"); 
        } 
        if(StringUtils.isNullOrEmpty(ip) || ip.equalsIgnoreCase("unknown")) { 
            ip = request.getHeader("WL-Proxy-Client-IP"); 
        } 
        if(StringUtils.isNullOrEmpty(ip) || ip.equalsIgnoreCase("unknown")) { 
            ip = request.getHeader("HTTP_CLIENT_IP"); 
        } 
        if(StringUtils.isNullOrEmpty(ip) || ip.equalsIgnoreCase("unknown")) { 
            ip = request.getHeader("HTTP_X_FORWARDED_FOR"); 
        } 
        if(StringUtils.isNullOrEmpty(ip) || ip.equalsIgnoreCase("unknown")) { 
            ip = request.getRemoteAddr(); 
        } 
        if(StringUtils.isNotEmpty(ip) && ip.indexOf(",") > 0) { 
        	String[] ips = ip.split(",");
			for (int i = 0; i < ips.length; i++) {
				if(null != ips[i] && !"unknown".equalsIgnoreCase(ips[i])){
					ip = ips[i];
					break;
				}
			}
        } 
        return ip; 
    } 
	
	
	private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
	// 请求超时时间(毫秒) 5秒
	public static RequestConfig requestConfig;

	// 响应超时时间(毫秒) 60秒
	public static int HTTP_RESPONSE_TIMEOUT = 60 * 1000;

	// httpClient字符编码
	public static String encoding = "UTF-8";

	public static RequestConfig getRequestConfig() {
		return RequestConfig.custom().setConnectTimeout(5 * 1000).setConnectionRequestTimeout(HTTP_RESPONSE_TIMEOUT)
				.build();
	}

	public static void setRequestConfig(RequestConfig requestConfig) {
		HttpClientUtils.requestConfig = requestConfig;
	}
	


	/**
	 * httpPost
	 *
	 * @param url       路径
	 * @param jsonParam 参数
	 * @param token     header里面Authorization的值
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam, String token) {
		return httpPost(url, jsonParam, false, token);
	}

	/**
	 * post请求
	 *
	 * @param url            url地址
	 * @param jsonParam      参数
	 * @param noNeedResponse 不需要返回结果
	 * @param token          header里面Authorization的值
	 * @return
	 */
	public static JSONObject httpPost(String url, JSONObject jsonParam, boolean noNeedResponse, String token) {
		// post请求返回结果
		JSONObject jsonResult = null;
		CloseableHttpClient client = getHttpClient();
		HttpPost method = new HttpPost(url);
		try {
			if (null != jsonParam) {
				// 解决中文乱码问题
				StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
				entity.setContentEncoding("UTF-8");
				entity.setContentType("application/json");
				method.setEntity(entity);
			}
			if (null != token) {
				method.setHeader("Authorization", "Bearer " + token);
			}

			CloseableHttpResponse result = client.execute(method);
			url = URLDecoder.decode(url, "UTF-8");
			/** 请求发送成功，并得到响应 **/
			if (result.getStatusLine().getStatusCode() == 200) {
				String str = "";
				try {
					/** 读取服务器返回过来的json字符串数据 **/
					str = EntityUtils.toString(result.getEntity());
					if (noNeedResponse) {
						return null;
					}
					/** 把json字符串转换成json对象 **/
					jsonResult = JSONObject.parseObject(str);
				} catch (Exception e) {
					logger.error("post请求提交失败:" + url);
					logger.error("");
				} finally {
					result.close();
				}
			}
		} catch (IOException e) {
			logger.error("post请求提交失败:" + url, e);
		} finally {
			try {
				closeHttpClient(client);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return jsonResult;
	}

	/**
	 * 发送get请求
	 *
	 * @param url 路径
	 * @return
	 */
	public static String httpGet(String url) {
		// get请求返回结果
//        JSONObject jsonResult = null;
		String strResult = null;
		CloseableHttpClient client = getHttpClient();
		try {
			// 发送get请求
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			/** 请求发送成功，并得到响应 **/
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				InputStream instreams = entity.getContent();
				strResult = convertStreamToString(instreams);
				logger.info("get strResult:" + strResult);
				/** 把json字符串转换成json对象 **/
//                jsonResult = JSONObject.parseObject(strResult);
//                url = URLDecoder.decode(url, "UTF-8");
			} else {
				logger.error("get请求提交失败:" + url);
			}
		} catch (IOException e) {
			logger.error("get请求提交失败:" + url, e);
			throw new RuntimeException("get网络请求异常。url：" + url, e);
		} finally {
			try {
				closeHttpClient(client);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return strResult;
	}

	public static void main(String[] args) {

		JSONObject jsonResult = JSONObject.parseObject(
				"{\"privilege\":[ \"PRIVILEGE1\" ,\"PRIVILEGE2\" ],   \"errcode\":40029,\"errmsg\":\"invalid code\"} ");
		System.out.println(jsonResult.getString("privilege"));
		String ps = jsonResult.getString("privilege");
		JSONArray p = JSONObject.parseArray(ps);
		System.out.println(p.get(0).toString());
	}

	public static String convertStreamToString(InputStream is) {
		StringBuilder sb1 = new StringBuilder();
		byte[] bytes = new byte[4096];
		int size = 0;

		try {
			while ((size = is.read(bytes)) > 0) {
				String str = new String(bytes, 0, size, "UTF-8");
				sb1.append(str);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb1.toString();
	}

	private static CloseableHttpClient getHttpClient() {
		return HttpClients.createDefault();
	}

	private static void closeHttpClient(CloseableHttpClient client) throws IOException {
		if (client != null) {
			client.close();
		}
	}

	/**
	 * https请求加证书
	 * @param key		证书类型
	 * @param ssLfile	证书路径
	 * @param mchId		商户ID
	 * @return
	 */
	public static CloseableHttpClient getSSLClientFile(String key, String ssLfile,String mchId) {
		FileInputStream inputStream = null;
		KeyStore keyStore = null;
		try {
			// ssl类型
			keyStore = KeyStore.getInstance(key);
			// ssl文件
			inputStream = new FileInputStream(new File(ssLfile));
			// 设置ssl密码
			keyStore.load(inputStream, mchId.toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | CertificateException | IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		SSLContext sslContext = null;
		try {
			sslContext = SSLContexts.custom().loadKeyMaterial(keyStore, mchId.toCharArray()).build();
		} catch (UnrecoverableKeyException | NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
			e.printStackTrace();
		}

		SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(sslContext, new String[] { "TLSv1" }, null,
				SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
		return HttpClients.custom().setSSLSocketFactory(factory).build();
	}

	/**
	 * 封装发送请求的方法
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public static String sendPost(String url, String data, CloseableHttpClient closeableHttpClient)
			throws UnsupportedEncodingException {

		CloseableHttpClient client = closeableHttpClient;
		HttpPost httpPost = new HttpPost(URLDecoder.decode(url, encoding));
		httpPost.addHeader("Connection", "keep-alive");
		httpPost.addHeader("Accept", "*/*");
		httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		httpPost.addHeader("Host", "api.mch.weixin.qq.com");
		httpPost.addHeader("X-Requested-With", "XMLHttpRequest");
		httpPost.addHeader("Cache-Control", "max-age=0");
		httpPost.addHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0) ");
		httpPost.setConfig(HttpClientUtils.getRequestConfig());// 设置超时时间
		CloseableHttpResponse response = null;

		// 参数放入
		StringEntity entity = new StringEntity(data, encoding);
		entity.setContentEncoding(encoding);
		entity.setContentType("application/xml");
		httpPost.setEntity(entity);

		try {
			response = client.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity httpEntity = (HttpEntity) response.getEntity();
				if (response != null) {
					return EntityUtils.toString(httpEntity, encoding);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
