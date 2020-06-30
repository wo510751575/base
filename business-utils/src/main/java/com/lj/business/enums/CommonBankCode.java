package com.lj.business.enums;

/**
 * Copyright &copy; 2017-2020  All rights reserved.
 *
 * Licensed under the 深圳市扬恩科技 License, Version 1.0 (the "License");
 * 
 */

/**
 * 
 * 
 * 类说明：通用银行编码
 *  
 * 
 * <p>
 * 详细描述：遵循通用的四位数字银行编码，以B开头，text对应系统内部的英文编码，与{@link BankCode}一一对应
 *   
 * @Company: 扬恩科技有限公司
 * @author 彭阳
 *   
 * CreateDate: 2017年7月1日
 */
public enum CommonBankCode {
	
	B0100("PSBC"), //邮储银行
	B0102("ICBC"), //工商银行
	B0103("ABC"),  //中国农业银行
	B0104("BOC"),  //中国银行
	B0105("CCB"),  //中国建设银行
	B0301("BOCM"), //交通银行
	B0302("CITIC"),//中信银行
	B0303("CEB"),  //光大银行
	B0304("HXB"),  //华夏银行
	B0305("CMBC"), //民生银行
	B0306("CGB"),  //广发银行股份有限公司
	B0307("SDB"),  //深圳发展银行
	B0308("CMB"),  //招商银行
	B0309("CIB"),  //兴业银行
	B0310("SPDB"), //浦东发展银行
	B0311("EBCL"), //恒丰银行
	B0313("LYCB"), //临沂商业银行
	B0316("CZSB"), //浙商银行
	B0317("BOHC"), //渤海银行
	B0319("CTSH"), //花旗银行(中国)有限公司
	B0320("BEAI"), //东亚银行中国有限公司
	B0321("HSBC"), //汇丰银(中国)有限公司
	B0322("SCB"),  //渣打银行中国有限公司
	B0324("DBSC"), //星展银行
	B0326("HSSH"), //恒生银行
	B0327("WB"),   //友利银行(中国)有限公司
	B0328("SHBC"), //新韩银行
	B0329("HNBK"), //韩亚银行（中国）
	B0330("OCBS"), //华侨银行（中国）
	B0331("WHBC"), //永亨银行（中国）有限公司
	B0332("NCBC"), //南洋商业银行（中国）
	B0333("SG"),   //法国兴业银行（中国）
	B0334("UOBS"), //大华银行（中国）
	B0335("DSSZ"), //大新银行（中国）
	B0336("IBK"),  //企业银行（中国）
	B0401("BKSH"), //上海银行
	B0402("XMB"),  //厦门银行股份有限公司
	B0403("BOB"),  //北京银行
	B0405("FJHXB"),//福建海峡银行股份有限公司
	B0406("JLB"),  //吉林银行
	B0407("ZJCB"), //镇江市商业银行
	B0408("BONB"), //宁波银行
	B0410("PAB"),  //平安银行
	B4828("PAPAY"),//平安付
	B0411("JZCB"), //焦作市商业银行
	B0412("WZB"),  //温州银行
	B0413("BOGZ"), //广州银行股份有限公司
	B0414("HKB"),  //汉口银行
	B0416("LJB"),  //龙江银行股份有限公司
	B0417("SJB"),  //盛京银行
	B0418("BOLY"), //洛阳银行
	B0419("LYB"),  //辽阳银行股份有限公司
	B0420("DLB"),  //大连银行
	B0421("SZCB"), //苏州市商业银行
	B0422("BOHB"), //河北银行股份有限公司
	B0423("HZCCB"),//杭州商业银行
	B0424("NJB"),  //南京银行
	B0425("DGCB"), //东莞市商业银行
	B0426("JHB"),  //金华银行股份有限公司
	B0427("UQCB"), //乌鲁木齐市商业银行
	B0428("SXB"),  //绍兴银行股份有限公司
	B0429("CDCCB"),//成都商业银行
	B0430("FSB"),  //抚顺银行股份有限公司
	B0432("YCCCB"),//宜昌市商业银行
	B0433("HLDCB"),//葫芦岛市商业银行
	B0434("TJCB"), //天津市商业银行
	B0435("ZZB"),  //郑州银行股份有限公司
	B0436("NXB"),  //宁夏银行
	B0437("ZHHRB"),//珠海华润银行股份有限公司
	B0438("QSB"),  //齐商银行
	B0439("BOJZ"), //锦州银行股份有限公司
	B0440("HSHB"), //徽商银行
	B0441("CQB"),  //重庆银行
	B0442("HRBB"), //哈尔滨银行
	B0443("GYB"),  //贵阳银行股份有限公司
	B0444("XAB"),  //西安银行股份有限公司
	B0445("WXCB"), //无锡市商业银行
	B0446("DDB"),  //丹东银行股份有限公司
	B0447("BOLZ"), //兰州银行
	B0448("BONC"), //南昌银行
	B0449("JSB"),  //晋商银行
	B0450("QDB"),  //青岛银行
	B0451("JLCB"), //吉林市商业银行
	B0452("NTCB"), //南通商业银行
	B0454("JJB"),  //九江银行股份有限公司
	B0456("ASB"),  //鞍山银行
	B0457("QHDCB"),//秦皇岛市商业银行
	B0458("QHB"),  //青海银行
	B0459("TZB"),  //台州银行
	B0460("YCCB"), //盐城商行
	B0461("CSB"),  //长沙银行股份有限公司
	B0463("GZB"),  //赣州银行股份有限公司
	B0464("QZB"),  //泉州银行
	B0465("YKCB"), //营口市商业银行
	B0466("KMCB"), //昆明商业银行
	B0467("FXB"),  //阜新银行股份有限公司
	B0470("JXCB"), //嘉兴市商业银行
	B0472("LFB"),  //廊坊银行
	B0473("TLCB"), //泰隆城市信用社
	B0474("IMB"),  //内蒙古银行
	B0475("HZCB"), //湖州市商业银行
	B0476("CZB"),  //沧州银行
	B0478("NNCB"), //南宁市商业银行
	B0479("BSB"),  //包商银行
	B0480("LYGCB"),//连云港市商业银行
	B0481("WHCB"), //威海商业银行
	B0483("PZHCB"),//攀枝花市商业银行
	B0485("MYCB"), //绵阳市商业银行
	B0486("LZCB"), //泸州市商业银行
	B0487("DTCB"), 	//大同市商业银行
	B0488("SMXB"), 	//三门峡银行
	B0489("GDNYB"),	//广东南粤银行
	B0490("ZJKCB"),	//张家口市商业银行
	B0491("GLCB"), 	//桂林市商业银行
	B0492("LJB"),  	//龙江银行
	B0493("JSCJCB"),//江苏长江商业银行
	B0494("XZCB"),  //徐州市商业银行
	B0495("LZB"),   //柳州银行股份有限公司
	B0496("NCCB"),  //南充市商业银行
	B0497("LWB"),   //莱芜银行
	B0498("BODY"),  //德阳银行
	B0499("TSCB"),  //唐山市商业银行
	B0500("LPSCB"), //六盘水商行
	B0502("QJCB"),  //曲靖市商业银行
	B0503("JCB"),   //晋城银行股份有限公司
	B0505("DGCB"),  //东莞商行
	B0506("WZB"),   //温州银行
	B0507("HKB"),   //汉口银行
	B0508("BOJS"),  //江苏银行
	B0510("PAB"),   //平安银行股份有限公司
	B0512("CZCB"),  //长治市商业银行
	B0513("CDCB"),  //承德市商业银行
	B0515("DZB"),   //德州银行
	B0516("ZYCB"),  //遵义市商业银行
	B0517("HDCB"),  //邯郸市商业银行
	B0519("ASCB"),  //安顺市商业银行
	B0521("BOJS"),  //江苏银行
	B0523("PLCB"),  //平凉市商业银行
	B0524("YXCB"),  //玉溪市商业银行
	B0525("ZJMTCB"),//浙江民泰商业银行
	B0526("SRCCB"), //上饶市商业银行
	B0527("DYB"),   //东营银行
	B0528("TACB"),  //泰安市商业银行
	B0530("ZJCZCB"),//浙江稠州商业银行
	B0531("BOWH"),  //乌海银行股份有限公司
	B0532("ZGCB"),  //自贡市商业银行
	B0533("LJB"),   //龙江银行股份有限公司
	B0534("EEDSB"), //鄂尔多斯银行
	B0535("HBB"),   //鹤壁银行
	B0536("XCCB"),  //许昌市商业银行
	B0537("JNB"),   //济宁银行股份有限公司
	B0539("TLB"),   //铁岭银行
	B0540("LSCB"),  //乐山市商业银行
	B0541("CAB"),   //长安银行
	B0542("CQSXB"), //重庆三峡银行
	B0543("SZSB"),  //石嘴山银行
	B0544("PJCB"),  //盘锦市商业银行
	B0547("KLB"),   //昆仑银行股份有限公司
	B0548("PDSB"),  //平顶山银行股份有限公司
	B0549("CYB"),   //朝阳银行
	B0550("NBDHB"), //宁波东海银行
	B0551("SNCB"),  //遂宁市商业银行
	B0552("BDB"),   //保定银行
	B0554("XTB"),   //邢台银行股份有限公司
	B0555("LSZCB"), //凉山州商业银行
	B0556("LHCB"),  //漯河商行
	B0557("DZCB"),  //达州市商业银行
	B0558("XXCB"),  //新乡市商业银行
	B0559("JZB"),   //晋中市商业银行
	B0560("ZMDCB"), //驻马店市商业银行
	B0561("HSCB"),  //衡水市商业银行
	B0562("ZKB"),   //周口银行
	B0563("YQCB"),  //阳泉市商业银行
	B0564("YBCB"),  //宜宾市商业银行
	B0565("KELCB"), //库尔勒市商业银行
	B0566("YACB"),  //雅安市商业银行
	B0567("SQCB"),  //商丘商行
	B0568("AYB"),   //安阳银行
	B0569("XYB"),   //信阳银行
	B0570("HRXJB"), //华融湘江银行
	B0572("YKYHB"), //营口沿海银行
	B0573("JDZCB"), //景德镇商业银行
	B0575("HBBCL"), //湖北银行
	B0577("XJHHB"), //新疆汇和银行
	B0578("GDHXB"), //广东华兴银行
	B0579("PYB"),   //濮阳银行
	B0610("PAB"),   //平安银行股份有限公司
	B0804("SJB"),   //盛京银行
	B1401("SHRCC"), //上海农信
	B1402("KSRCC"), //昆山农信社
	B1403("CSRCB"), //常熟市农村商业银行
	B1404("SZRCB"), //深圳农村商业银行
	B1405("GZRCB"), //广州农村商业银行
	B1407("NHRCB"), //广东南海农村商业银行
	B1408("SDRCB"), //佛山顺德农村商业银行
	B1409("KMRCC"), //昆明农联社
	B1410("HBRCC"), //湖北农信
	B1411("XZRCC"), //徐州市郊农村信用合作联社
	B1412("JYRCB"), //江阴市农村商业银行
	B1413("CQRCB"), //重庆农村商业银行
	B1414("SDRCC"), //山东省农村信用社联合社
	B1415("DGRCB"), //东莞农村商业银行
	B1416("ZJGRCB"),//张家港农村商业银行
	B1417("FJRCC"), //福建省农村信用社联合社
	B1418("BJRCB"), //北京农村商业银行
	B1419("TJRCB"), //天津农村商业银行
	B1420("YZRCB"), //宁波鄞州农村合作银行
	B1421("SSRCC"), //佛山市三水区农村信用合作社
	B1422("CDRCB"), //成都农村商业银行
	B1424("JSRCC"), //江苏省农村信用社联合社
	B1425("XHRCC"), //江门新会农村商业银行
	B1428("WJRCB"), //吴江农商行
	B1429("ZJRCC"), //浙江省农村信用社联合社
	B1430("SZB"),   //苏州银行股份有限公司
	B1431("ZHRCB"), //珠海农村商业银行
	B1433("TCRCB"), //太仓农村商业银行
	B1434("YDRCC"), //尧都区农村信用合作社联社
	B1436("GZRCC"), //贵州省农村信用社联合社
	B1437("WXRCB"), //无锡农村商业银行
	B1438("HNRCC"), //湖南省农村信用社联合社
	B1439("JXRCC"), //江西农信联合社
	B1440("HNRCU"), //河南省农村信用社联合社
	B1441("RCCOHB"),//河北省农村信用社联合社
	B1442("SXRCCU"),//陕西省农村信用社联合社
	B1443("GXRCC"), //广西农村信用社联合社
	B1444("WWERCC"),//新疆维吾尔自治区农村信用社联合
	B1445("JLRCC"), //吉林农信联合社
	B1446("HHRCB"), //黄河农村商业银行
	B1447("AHRCC"), //安徽省农村信用社联合社
	B1448("HNB"),   //海南省农村信用社联合社
	B1449("QHRCC"), //青海省农村信用社联合社
	B1450("GDRCC"), //广东省农村信用社联合社
	B1451("IMLRCC"),//内蒙古自治区农村信用社联合式
	B1452("SCRCC"), //四川省农村信用社联合社
	B1453("GSRCC"), //甘肃省农村信用社联合社
	B1454("LNRCC"), //辽宁省农村信用社联合社
	B1455("SXRCU"), //山西省农村信用社联合社
	B1456("BHRCB"), //天津滨海农村商业银行
	B1457("HLJRCC"),//黑龙江省农村信用社联合社
	B1459("WHRCB"), //武汉农村商业银行
	B1460("JNRCB"), //江南农村商业银行
	B1500("DYJYXMRB"),//大邑交银兴民村镇银行
	B1501("JYWJRB"),  //湖北嘉鱼吴江村镇银行
	B1502("XTBNSRB"), //湖北仙桃北农商村镇银行
	B1503("SNRB"),    //海口苏南村镇银行
	B1504("JOSSRB"),  //福建建瓯石狮村镇银行
	B1505("ESCNSRB"), //恩施常农商村镇银行
	B1508("CXURB"),   //浙江长兴联合村镇银行
	B1510("PHGYRB"),  //浙江平湖工银村镇银行
	B1511("MYHFRB"),  //北京密云汇丰村镇银行
	B1512("SYDWRB"),  //江苏沭阳东吴村镇银行
	B1513("CQRCB"),   //重庆农村商业银行
	B1514("DSMYRB"),  //鄂尔多斯市东胜蒙银村镇银行
	B1515("ZSXLRB"),  //中山小榄村镇银行
	B1517("HJMTRB"),  //江苏邗江民泰村镇银行
	B1518("DTXHRB"),  //安徽当涂新华村镇银行
	B1519("GCZYDFRB"),//谷城中银富登村镇银行
	B1520("SYYZRB"),  //北京顺义银座村镇银行
	B1521("BQRXRB"),  //拜泉融兴村镇银行
	B1526("NYRB"),    //南阳村镇银行
	B1527("SJMSRB"),  //上海松江民生村镇银行
	B1528("HSRB"),    //浙江建德湖商村镇银行
	B1530("YCRXCB"),  //晋中市榆次融信村镇银行
	B1533("BSCB"),    //宝生村镇银行
	B1535("GZHDCZRB"),//广州花都稠州村镇银行
	B1538("QHGMRB"),  //琼海国民村镇银行
	B1540("HSZJRB"),  //鹤山珠江村镇银行
	B1543("DWKSYRB"), //大武口石银村镇银行
	B1548("KSLCCB"),  //昆山鹿城村镇银行
	B1551("DYLSCB"),  //东营莱商村镇银行
	B1553("GZZCCJRB"),//广州增城长江村镇银行
	B1558("CSXSRB"), //长沙星沙沪农商村镇银行
	B2502("BEA"),    //东亚银行有限公司
	B2503("CB"),     //花旗银行有限公司
	B2504("DSB"),    //大新银行有限公司
	B2506("WHB"),    //永亨银行
	B2507("CCBA"),   //中国建设银行亚洲股份有限公司
	B2508("DBS"),    //星展银行香港有限公司
	B2509("SHCB"),   //上海商业银行
	B2510("WLB"),    //永隆银行有限公司
	B2512("HSBC"),   //香港上海汇丰银行有限公司
	B2513("HSBC"),   //香港上海汇丰银行有限公司
	B2514("HSB"),    //恒生银行有限公司
	B2515("HSB"),    //恒生银行
	B2516("CITICI"), //中信嘉华银行有限公司
	B2517("CHB"),    //创兴银行有限公司
	B2518("BOCCC"),  //中银信用卡(国际)有限公司
	B2519("BOCHK"),  //中国银行（香港）
	B2520("NCB"),    //南洋商业银行
	B2521("CBCL"),   //集友银行
	B2523("AEON"),   //EON信贷财务亚洲有限公司
	B2525("BTF"),    //澳门大丰银行
	B2526("AEON"),   //EON信贷财务亚洲有限公司
	B2527("CCBMC"),  //中国建设银行澳门股份有限公司
	B2528("SCBHK"),  //渣打银行香港有限公司
	B2529("CYS"),    //中国银盛
	B2530("CYS"),    //中国银盛
	B2533("CCBA"),   //中国建设银行（亚洲）
	B2622("LIBL"),   //澳门国际银行
	B2623("BNU"),    //大西洋银行股份有限公司
	B2632("BCM"),    //澳门商业银行
	B2647("ICBCM"),  //中国工商银行（澳门）
	B4798("BOCHK"),  //中国银行香港有限公司
	B4808("EPC"),    //中银通商务支付有限公司
	B4810("EPC"),    //中银通商务支付有限公司
	B4826("YSEPAY"), //银盛支付
	B6100("PSBCCC"), //中国邮政储蓄银行信用卡中心
	B6302("CITICCC"),//中信银行信用卡中心
	B6303("CEB"),   //中国光大银行
	B6304("HXB"),   //华夏银行
	B6310("SPDBCC"),//浦发银行信用卡中心
	B6320("BEAI"),  //东亚银行(中国)有限公司
	B6332("NCB"),   //南洋商业银行
	B6403("BOB"),   //北京银行
	B6408("BONB"),  //宁波银行
	B6409("QLB"),   //齐鲁银行股份有限公司
	B6413("BOGZ"),  //广州银行股份有限公司
	B6416("LJB"),   //龙江银行股份有限公司
	B6422("BOHB"),  //河北银行股份有限公司
	B6423("HZCCB"), //杭州市商业银行
	B6424("NJB"),   //南京银行
	B6429("CDCCB"), //成都市商业银行
	B6431("LSB"),   //临商银行
	B6437("ZHHRB"), //珠海华润银行
	B6438("QSB"),   //齐商银行
	B6439("BOJZ"),  //锦州银行
	B6440("HSHB"),  //徽商银行
	B6441("CQB"),   //重庆银行股份有限公司
	B6442("HRBCB"), //哈尔滨商行
	B6443("GYB"),   //贵阳银行股份有限公司
	B6447("BOLZ"),  //兰州银行
	B6448("BONC"),  //南昌银行
	B6450("QDB"),   //青岛银行
	B6454("JJB"),   //九江银行股份有限公司
	B6455("RZB"),   //日照银行
	B6458("QHB"),   //青海银行
	B6462("WFB"),   //潍坊银行
	B6463("GZB"),   //赣州银行股份有限公司
	B6466("FDB"),   //富滇银行
	B6473("ZJTLCB"),//浙江泰隆商业银行
	B6474("IMB"),   //内蒙古银行
	B6475("HZB"),   //湖州银行
	B6478("GXBBGB"),//广西北部湾银行
	B6481("WHCB"),  //威海市商业银行
	B6489("GDNYB"), //广东南粤银行
	B6491("GLB"),   //桂林银行
	B6492("LJB"),   //龙江银行股份有限公司
	B6501("SRCB"),  //上海农村商业银行
	B6505("GZRCB"), //广州农村商业银行
	B6508("SDRCB"), //佛山顺德农村商业银行
	B6509("YNRCC"), //云南省农村信用社
	B6513("BOCD"),  //承德银行
	B6515("DZB"),   //德州银行
	B6517("FJRCC"), //福建省农村信用社联合社
	B6519("TJRCB"), //天津农村商业银行
	B6522("CDRCB"), //成都农村商业银行股份有限公司
	B6524("JSRCC"), //江苏省农村信用社联合社
	B6526("SRB"),   //上饶银行
	B6527("DYB"),   //东营银行
	B6534("YDRCC"), //临汾市尧都区农村信用合作联社
	B6537("WXRCB"), //无锡农村商业银行
	B6538("HNRCC"), //湖南农村信用社联合社
	B6539("JXRCC"), //江西省农村信用社联合社
	B6547("AHRCC"), //安徽省农村信用社
	B6554("XTB"),   //邢台银行
	B6567("SQCB"),  //商丘市商业银行
	B6570("HRXJB"); //华融湘江银行
	
	private String text;
	
	private CommonBankCode(String text) {
		this.text = text;
	}
	
	public String getText(){
		return this.text;
	}
	
	/**
	 * 
	 *
	 * 方法说明：得到银行通用编码（四位数字）
	 *
	 * @author 彭阳
	 *   
	 * CreateDate: 2017-06-10
	 * 
	 * @return
	 */
	public String getCode() {
		return this.name().substring(1);
	}
}