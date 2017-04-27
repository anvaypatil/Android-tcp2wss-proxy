package connect.vnc.android.websockify;

import org.jboss.netty.channel.Channel;

import java.net.InetSocketAddress;

public class StaticTargetResolver implements IProxyTargetResolver {
	
	private InetSocketAddress targetAddress; 
	
	public StaticTargetResolver ( String targetHost, int targetPort )
	{
		targetAddress = new InetSocketAddress ( targetHost, targetPort );
	}

	public InetSocketAddress resolveTarget(Channel channel) {
		return targetAddress;
	}

}
