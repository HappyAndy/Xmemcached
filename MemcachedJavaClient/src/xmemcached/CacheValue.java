package xmemcached;

import java.io.Serializable;
import java.util.Date;

/** 
 * 保存到缓存中的实体. 
 * @author linwei 
 * 
 */
public class CacheValue implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 
	 * 缓存的内容 
	 */
	private Serializable object;

	/** 
	 * 缓存的创建时间 
	 */
	private Date createDate;

	public CacheValue(Serializable object, Date createDate) {
		this.object = object;
		this.createDate = createDate;
	}

	public Serializable getObject() {
		return this.object;
	}

	public void setObject(Serializable object) {
		this.object = object;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CacheValue other = (CacheValue) obj;
		if (createDate == null) {
			if (other.createDate != null)
				return false;
		} else if (!createDate.equals(other.createDate))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		return true;
	}

	// @Override
	// public String toString() {
	// StringBuilder builder = new StringBuilder();
	// builder.append("CacheValue [object=");
	// builder.append(this.object);
	// builder.append(", createDate=");
	// builder.append(DateFormatUtils.format(this.createDate,
	// "yyyy-MM-dd hh:mm:ss"));
	// builder.append("]");
	// return builder.toString();
	// }
}