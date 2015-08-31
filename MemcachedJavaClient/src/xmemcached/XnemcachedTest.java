


package xmemcached;

import java.io.IOException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.utils.AddrUtil;

public class XnemcachedTest {
public static void main(String[] args) {

		MemcachedClientBuilder builder = new XMemcachedClientBuilder(
				AddrUtil.getAddresses("localhost:11211"));
		builder.addAuthInfo(AddrUtil.getOneAddress("localhost:11211"),
				AuthInfo.typical("cacheuser", "123456"));
		// Must use binary protocol
		builder.setCommandFactory(new BinaryCommandFactory());
		try {
			MemcachedClient client = builder.build();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
