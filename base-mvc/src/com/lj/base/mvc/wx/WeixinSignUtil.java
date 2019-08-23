package com.lj.base.mvc.wx;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lj.base.mvc.wx.aes.AesException;

/**
 * 类说明：微信签名。
 * <p>
 * 
 * @Company: 深圳扬恩科技有限公司
 * @author lhy
 * 
 *         CreateDate: 2017年9月7日
 */
public class WeixinSignUtil {
	
	//打log用
    private static Logger logger = LoggerFactory.getLogger(WeixinSignUtil.class);
	/**
	 * 构造参数。
	 *
	 * @param params 参数
	 * @param encode 是否URLEncoder转码
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String createGetReqParam(Map<String, String> params, boolean encode)
			throws UnsupportedEncodingException {
		Set<String> keysSet = params.keySet();
		Object[] keys = keysSet.toArray();
		Arrays.sort(keys);
		StringBuffer temp = new StringBuffer();
		boolean first = true;
		for (Object key : keys) {
			if (first) {
				first = false;
			} else {
				temp.append("&");
			}
			temp.append(key).append("=");
			Object value = params.get(key);
			String valueString = "";
			if (null != value) {
				valueString = value.toString();
			}
			if (encode) {
				temp.append(URLEncoder.encode(valueString, "UTF-8"));
			} else {
				temp.append(valueString);
			}
		}
		return temp.toString();
	}

	  /**
     * 公众号生成签名
     *
     * @param map
     * @return
     */
    public static String getSign(Map<String, Object> map,WeixinConfigDto config) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != "") {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        String result = sb.toString();
        result += "key=" +config.getApiKey();
        logger.info("Sign Before MD5:{}",result);
        result = WxMD5Util.MD5Encode(result, "UTF-8").toUpperCase();
        return result;
    }
    
    /**
     * 获取 SHA-1 签名
     * @param map
     * @return
     */
    public static String getSha1Sign(Map<String, Object> map) {
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() != "") {
                list.add(entry.getKey() + "=" + entry.getValue() + "&");
            }
        }
        int size = list.size();
        String[] arrayToSort = list.toArray(new String[size]);
        Arrays.sort(arrayToSort, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(arrayToSort[i]);
        }
        sb.deleteCharAt(sb.length() - 1);
        String result = sb.toString();
        result = SHA1(result);
        return result;
    }



    public static String inputStream2String(InputStream in) throws IOException {
        if (in == null){
            return "";
        }
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1; ) {
            out.append(new String(b, 0, n, "UTF-8"));
        }
        return out.toString();
    }

    /**
     * SHA1加密
     *
     * @param decript
     * @return
     */
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public static String createRandomNumber(int length) {
        String str = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(36);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
    
    
    /**
     * 验证Token
     * @param msgSignature 签名串，对应URL参数的signature
     * @param timeStamp 时间戳，对应URL参数的timestamp
     * @param nonce 随机串，对应URL参数的nonce
     *
     * @return 是否为安全签名
     * @throws AesException 执行失败，请查看该异常的错误码和具体的错误信息
     */
    public static boolean verifyUrl(String msgSignature, String timeStamp, String nonce)throws AesException {
    	boolean flag = SignUtil.checkSignature(msgSignature, timeStamp, nonce);
        if (!flag) {
            throw new AesException(AesException.ValidateSignatureError);
        }
        return true;
    }
}
