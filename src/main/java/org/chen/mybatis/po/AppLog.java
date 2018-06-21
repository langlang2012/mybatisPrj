package org.chen.mybatis.po;

public class AppLog implements java.io.Serializable{

	private Long id;       //
	private String device_id;       //设备唯一标识：android的imei,ios的uuid
	private String model;       //手机机型
	private Integer os;       //手机操作系统类型，1 android, 2 ios
	private String os_sdk;       //手机操作系统版本
	private String ch;       //渠道
	private String net;       //网络
	private Integer vc;       //APP客户端版本号
	private Integer city_code;       //城市
	private Long user_id;       //app用户 id
	private Integer log_type;       //日志类型，1APP启动，2APP注册，3APP登录，4请求通知
	private String create_date;       //日志记录日期,如2017-07-07
	private Long create_time;       //日志记录时间
	private Integer deleted;       //逻辑删除标识,1删除,0非删除

	/**
	 * 扩展字段
	 */
	private Long active_time;       //设备激活时间（设备的最大create_time）

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getOs() {
		return os;
	}

	public void setOs(Integer os) {
		this.os = os;
	}

	public String getOs_sdk() {
		return os_sdk;
	}

	public void setOs_sdk(String os_sdk) {
		this.os_sdk = os_sdk;
	}

	public String getCh() {
		return ch;
	}

	public void setCh(String ch) {
		this.ch = ch;
	}

	public String getNet() {
		return net;
	}

	public void setNet(String net) {
		this.net = net;
	}

	public Integer getVc() {
		return vc;
	}

	public void setVc(Integer vc) {
		this.vc = vc;
	}

	public Integer getCity_code() {
		return city_code;
	}

	public void setCity_code(Integer city_code) {
		this.city_code = city_code;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Integer getLog_type() {
		return log_type;
	}

	public void setLog_type(Integer log_type) {
		this.log_type = log_type;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public Long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public Long getActive_time() {
		return active_time;
	}

	public void setActive_time(Long active_time) {
		this.active_time = active_time;
	}
}
	
	

	
	





