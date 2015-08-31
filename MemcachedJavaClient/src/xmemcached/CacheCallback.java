package xmemcached;

import java.io.Serializable;

public interface CacheCallback {
	public String getKey();

	public Serializable getValue() throws Exception;
}
