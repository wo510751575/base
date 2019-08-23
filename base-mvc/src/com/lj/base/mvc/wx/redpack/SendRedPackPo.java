package com.lj.base.mvc.wx.redpack;

/**
 * 发送公众号红包参数Dto
 * 
 * @author wo510
 *
 */
public class SendRedPackPo {
	/**
	 * 随机字符串
	 */
	private String nonce_str;
	/**
	 * 签名
	 */
	private String sign;
	/**
	 * 商户订单号
	 */
	private String mch_billno;
	/**
	 * 商户号
	 */
	private String mch_id;
	/**
	 * 公众账号appid
	 */
	private String wxappid;
	/**
	 * 商户名称
	 */
	private String send_name;
	/**
	 * 用户openid
	 */
	private String re_openid;
	/**
	 * 付款金额
	 * 付款金额，单位分
	 */
	private String total_amount;
	/**
	 * 红包发放总人数
	 */
	private String total_num;
	/**
	 * 红包祝福语
	 */
	private String wishing;
	/**
	 * Ip地址
	 * 调用接口的机器Ip地址
	 */
	private String client_ip;
	/**
	 * 活动名称
	 */
	private String act_name;
	/**
	 * 备注
	 * 不必填
	 */
	private String remark;
	/**
	 * 发放红包使用场景，红包金额大于200或者小于1元时必传
	 * PRODUCT_1:商品促销 
	 * PRODUCT_2:抽奖 
	 * PRODUCT_3:虚拟物品兑奖  
	 * PRODUCT_4:企业内部福利 
	 * PRODUCT_5:渠道分润 
	 * PRODUCT_6:保险回馈 
	 * PRODUCT_7:彩票派奖 
	 * PRODUCT_8:税务刮奖
	 */
	private String scene_id;

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonceStr) {
		nonce_str = nonceStr;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMch_billno() {
		return mch_billno;
	}

	public void setMch_billno(String mchBillno) {
		mch_billno = mchBillno;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mchId) {
		mch_id = mchId;
	}

	public String getWxappid() {
		return wxappid;
	}

	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String sendName) {
		send_name = sendName;
	}

	public String getRe_openid() {
		return re_openid;
	}

	public void setRe_openid(String reOpenid) {
		re_openid = reOpenid;
	}

	public String getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(String totalAmount) {
		total_amount = totalAmount;
	}

	public String getTotal_num() {
		return total_num;
	}

	public void setTotal_num(String totalNum) {
		total_num = totalNum;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String clientIp) {
		client_ip = clientIp;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String actName) {
		act_name = actName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getScene_id() {
		return scene_id;
	}

	public void setScene_id(String scene_id) {
		this.scene_id = scene_id;
	}

}
