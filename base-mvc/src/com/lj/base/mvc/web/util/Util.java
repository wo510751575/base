package com.lj.base.mvc.web.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.lj.base.core.util.StringUtils;
import com.thoughtworks.xstream.XStream;

 /**
  * 公用
  * <p>
  *   
  * @Company: 深圳扬恩科技有限公司
  * @author lhy
  *   
  * CreateDate: 2017年9月8日
  */
public class Util {

    /**
     * 通过反射的方式遍历对象的属性和属性值，方便调试
     *
     * @param o 要遍历的对象
     * @throws Exception
     */
    public static void reflect(Object o) throws Exception {
        Class cls = o.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0, len = fields.length; i < len; i++) {
            Field f = fields[i];
            f.setAccessible(true);
//            Util.log(f.getName() + " -> " + f.get(o));
        }
    }

    public static byte[] readInput(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len;
        byte[] buffer = new byte[1024];
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
        out.close();
        in.close();
        return out.toByteArray();
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int i;
        while ((i = is.read()) != -1) {
            baos.write(i);
        }
        return baos.toString();
    }


    public static InputStream getStringStream(String sInputString) throws UnsupportedEncodingException {
        ByteArrayInputStream tInputStringStream = null;
        if (sInputString != null && !sInputString.trim().equals("")) {
            tInputStringStream = new ByteArrayInputStream(sInputString.getBytes("UTF-8"));
        }
        return tInputStringStream;
    }

    public static Object getObjectFromXML(String xml, Class tClass) {
        //将从API返回的XML数据映射到Java对象
        XStream xStreamForResponseData = new XStream();
        xStreamForResponseData.alias("xml", tClass);
//        xStreamForResponseData.ignoreUnknownElements();//暂时忽略掉一些新增的字段
        return xStreamForResponseData.fromXML(xml);
    }

    public static String getStringFromMap(Map<String, Object> map, String key, String defaultValue) {
        if (StringUtils.isEmpty(key)) {
            return defaultValue;
        }
        String result = (String) map.get(key);
        if (result == null) {
            return defaultValue;
        } else {
            return result;
        }
    }

    public static int getIntFromMap(Map<String, Object> map, String key) {
        if (StringUtils.isEmpty(key)) {
            return 0;
        }
        if (map.get(key) == null) {
            return 0;
        }
        return Integer.parseInt((String) map.get(key));
    }

    /**
     * 打log接口
     *
     * @param log 要打印的log字符串
     * @return 返回log
     */
    public static String log(Object log) {
        return log.toString();
    }

    /**
     * 读取本地的xml数据，一般用来自测用
     *
     * @param localPath 本地xml文件路径
     * @return 读到的xml字符串
     */
    public static String getLocalXMLString(String localPath) throws IOException {
        return Util.inputStreamToString(Util.class.getResourceAsStream(localPath));
    }
 
    /**
	 * 根据商户ID生成订单号
	 * 商户订单号（每个订单号必须唯一）
		组成： mch_id+yyyymmdd+10 位一天
		内丌能重复的数字。
		接口根据商户订单号支持重入， 如出现
		超时可再调用。
	 * @param mchId
	 * @return
	 */
    public static String getMchBillno(String mchId) {
		String today = new SimpleDateFormat("yyyyMMdd").format(new Date());
		String code = createCode(10);
		return mchId+today+code;
	}
    
    /**
	 * 生成6位或10位随机数 param codeLength(多少位)
	 * 
	 * @return
	 */
    public static String createCode(int codeLength) {
		String code = "";
		for (int i = 0; i < codeLength; i++) {
			code += (int) (Math.random() * 9);
		}
		return code;
	}
}

