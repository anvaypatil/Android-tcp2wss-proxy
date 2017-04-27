package connect.vnc.android.websockify;

import org.jboss.netty.channel.Channel;

import java.net.InetSocketAddress;

public interface IProxyTargetResolver {
	
	public InetSocketAddress resolveTarget(Channel channel);

}
