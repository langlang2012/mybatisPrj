package org.chen.mybatis.po;

public class AppLogDeviceStat implements java.io.Serializable{

	private Integer id;
	private String day; //日期,如2017-07-07
	private int total;   //全部安装： 所有设备总量
	private int new_devices;   //新增安装： 统计每日上报的新设备
	private int launch_devices;   //启动设备个数：每日新老设备启动个数
	private int launch_times;   //设备启动次数：每日新老设备启动次数
	private int silent_devices;   //沉默设备： 30天内未启动过的设备个数
	private int sleep_devices;   //沉睡设备：大于30天，小于60天内未启动过的设备个数
	private int lost_devices;   //流失设备：大于60天未启动过的设备个数

	private long create_time;   //创建时间
	private String create_by;   //创建者，管理操作，存字符串，用户操作存 user_id
	private int deleted;   //逻辑删除标识,1删除,0非删除

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getNew_devices() {
		return new_devices;
	}

	public void setNew_devices(int new_devices) {
		this.new_devices = new_devices;
	}

	public int getLaunch_devices() {
		return launch_devices;
	}

	public void setLaunch_devices(int launch_devices) {
		this.launch_devices = launch_devices;
	}

	public int getLaunch_times() {
		return launch_times;
	}

	public void setLaunch_times(int launch_times) {
		this.launch_times = launch_times;
	}

	public int getSilent_devices() {
		return silent_devices;
	}

	public void setSilent_devices(int silent_devices) {
		this.silent_devices = silent_devices;
	}

	public int getSleep_devices() {
		return sleep_devices;
	}

	public void setSleep_devices(int sleep_devices) {
		this.sleep_devices = sleep_devices;
	}

	public int getLost_devices() {
		return lost_devices;
	}

	public void setLost_devices(int lost_devices) {
		this.lost_devices = lost_devices;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
}
	
	

	
	





