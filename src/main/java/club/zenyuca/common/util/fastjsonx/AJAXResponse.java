package club.zenyuca.common.util.fastjsonx;

import java.util.ArrayList;
import java.util.List;

import club.zenyuca.common.pojo.User;

/**
 * 服务层数据处理结果的描述对象<br>
 * <br>
 * 调用一个业务层的方法，那么在处理过程中必定有多种状态，<br>
 * 而这些状态是调用者所需要的。<br>
 * 当然调用者有时也很需要处理完后返回的数据，<br>
 * 所以可以想到，处理的状态和返回的数据都是需要的。<br>
 * 因而将之存放在一个称之为JSONData对象中，<br>
 * 最后再将这个对象放回给调用者，那么调用者可以得到所有想要的数据。<br>
 * 继而供调用者灵活使用。<br>
 * 
 * <br>
 * <br>
 * 作者： caoyu <br>
 * 时间： 2015年6月8日 下午6:08:13 <br>
 * 版本： 0.0.1
 */
public class AJAXResponse<T> {
	/** 返回的数据 */
	private T data;
	/** 状态码 */
	private String status;
	/** 处理中的文字描述 */
	private String msg;
	
	/** true 保留 filter 中的字段，false 则相反  */
	boolean keep = true;
	/** 过滤的字段 */
	private String[] filter;
	
	public AJAXResponse(T data, String... filter) {
		super();
		this.data = data;
		this.filter = filter;
	}

	public AJAXResponse() {
		super();
	}

	/**
	 * 如果方法有数据返回，那么通过此方法获得。
	 * 
	 * <br>
	 * <br>
	 * 作者： caoyu <br>
	 * 时间： 2015年6月9日 上午9:46:02
	 * 
	 * @return 返回的数据。
	 */
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * 设置处理过程中的状态。
	 * 
	 * <br>
	 * <br>
	 * 作者： caoyu <br>
	 * 时间： 2015年6月9日 上午9:47:04
	 * 
	 * @return 处理的状态。
	 */
	
	public String getMsg() {
		return msg;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public boolean isKeep() {
		return keep;
	}

	public void setKeep(boolean keep) {
		this.keep = keep;
	}

	public String[] getFilter() {
		return filter;
	}

	public void setFilter(String... filter) {
		this.filter = filter;
	}

	/**
	 * 如果需要将此对象格式化成json数据，<br>
	 * 那么又需要有选择性的格式化放回数据（某个对象）中的某些数据，<br>
	 * 这样就可以使用此方法完成。<br>
	 * 
	 * <br>
	 * <br>
	 * 作者： caoyu <br>
	 * 时间： 2015年6月9日 上午9:50:11
	 * 
	 * @param keeped
	 *            true：格式化提供的属性；false：除了提供的属性都格式化。
	 * @param propertyNames
	 *            提供的属性列表
	 * @return 已过滤属性的JSONData对象。<br>
	 *         此时再对此JSONData对象进行json格式化，<br>
	 *         即可得到过滤属性值的json数据。
	 */
	public AJAXResponse<Object> dataFilter(final boolean keeped, final String... propertyNames) {
		AJAXResponse<Object> response = new AJAXResponse<Object>();
		response.setData(JSONUtil.toJSON(this.data, keeped, propertyNames));
		response.setMsg(this.msg);
		response.setStatus(this.status);
		return response;
	}
	
	@Override
	public String toString() {
		if (this.filter == null || this.filter.length == 0) {
			return JSONUtil.toJSONString(this, false, "keep", "filter");
		} else {
			return JSONUtil.toJSONString(this.dataFilter(this.keep, this.filter), false, "keep", "filter");
		}
	}

	public static void main(String[] args) {
		User user = new User();
		user.setUserLoginname("yuca");
		user.setUserLoginpass("yuca");
		
		AJAXResponse<User> ajaxResponse = new AJAXResponse<User>(user, "userLoginname", "userLoginpass");
		System.out.println(ajaxResponse.toString());
		
		List<User> list = new ArrayList<User>();
		
		user = new User();
		user.setUserLoginname("jack");
		user.setUserLoginpass("jack");
		list.add(user);

		user = new User();
		user.setUserLoginname("bob");
		user.setUserLoginpass("bob");
		list.add(user);
		
		AJAXResponse<List<User>> ajaxResponse2 = new AJAXResponse<List<User>>(list, "userLoginname", "userLoginpass");
		System.out.println(ajaxResponse2.toString());
	}
}
