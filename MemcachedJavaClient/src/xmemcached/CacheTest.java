package xmemcached;

import java.io.Serializable;
import java.util.Date;

import xmemcached.XMMemcCacheProvider.Config;

public class CacheTest {

	private final static String servers = "127.0.0.1:8080";

	public static void main(String[] args) throws Exception {
//		 addCache();
		getCache();
	}

	private static void addCache() throws Exception {

		Config config = new Config();
		config.setServers(servers);
		XMMemcCacheProvider xmMemcCacheProvider = new XMMemcCacheProvider(config);

		CacheTemplate cacheTemplate = new CacheTemplate(xmMemcCacheProvider);

		cacheTemplate.execute(new CacheCallback() {

			@Override
			public String getKey() {
				return "alanlin";
			}

			@Override
			public Serializable getValue() throws Exception {
				return "testlin" + new Date();
			}
		});

		System.err.println("addCache over.");
	}

	private static void getCache() throws Exception {

		Config config = new Config();
		config.setServers(servers);
		XMMemcCacheProvider xmMemcCacheProvider = new XMMemcCacheProvider(config);

		CacheTemplate cacheTemplate = new CacheTemplate(xmMemcCacheProvider);
		CacheValue cacheValue = cacheTemplate.getCache("alanlin");
		System.err.println("value is " + cacheValue.getObject());
		System.err.println("getCache over.");
	}

}
