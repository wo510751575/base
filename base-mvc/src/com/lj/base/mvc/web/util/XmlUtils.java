package com.lj.base.mvc.web.util;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import com.lj.base.core.util.StringUtils;

/**
 * 
 * 
 * 类说明：xml工具类
 *  
 * 
 * <p>
 * 详细描述：
 *   
 * @Company: 扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月14日
 */

public class XmlUtils {
    
    /** <一句话功能简述>
     * <功能详细描述>request转字符串
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String parseRequst(HttpServletRequest request){
        String body = "";
        try {
            ServletInputStream inputStream = request.getInputStream(); 
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while(true){
                String info = br.readLine();
                if(info == null){
                    break;
                }
                if(body == null || "".equals(body)){
                    body = info;
                }else{
                    body += info;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }            
        return body;
    }
    
    @SuppressWarnings("rawtypes")
	public static String parseXML(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if (null != v && !"".equals(v) && !"appkey".equals(k)) {
                sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 从request中获得参数Map，并返回可读的Map
     * 
     * @param request
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static SortedMap getParameterMap(HttpServletRequest request) {
        // 参数Map
        Map properties = request.getParameterMap();
        // 返回值Map
        SortedMap returnMap = new TreeMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value.trim());
        }
        return returnMap;
    }
    
    /**
     * 转XMLmap
     * @author  
     * @param xmlBytes
     * @param charset
     * @return
     * @throws Exception
     */
    public static Map<String, String> toMap(byte[] xmlBytes,String charset) throws Exception{
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
        source.setEncoding(charset);
        Document doc = reader.read(source);
        Map<String, String> params = XmlUtils.toMap(doc.getRootElement());
        return params;
    }
    
    /**
     * 转MAP
     * @author  
     * @param element
     * @return
     */
    @SuppressWarnings("unchecked")
	public static Map<String, String> toMap(Element element){
        Map<String, String> rest = new HashMap<String, String>();
        List<Element> els = element.elements();
        for(Element el : els){
            rest.put(el.getName().toLowerCase(), el.getTextTrim());
        }
        return rest;
    }
    
    /**
     * 签名拼最后
     * @param params
     * @return
     */
    public static String toXml(Map<String, Object> params,String sign){
        StringBuilder buf = new StringBuilder();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        buf.append("<xml>");
        for(String key : keys){
            buf.append("<").append(key).append(">");
            buf.append("<![CDATA[").append(params.get(key)).append("]]>");
            buf.append("</").append(key).append(">\n");
        }
        if(StringUtils.isNotEmpty(sign)) {
        	buf.append("<sign>");
            buf.append("<![CDATA[").append(sign).append("]]>");
            buf.append("</sign>").append("\n");
        }
        buf.append("</xml>");
        return buf.toString();
    }
    
}

