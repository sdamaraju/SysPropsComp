package SystemComparatorProject.SysPropsComp;

public class ServerInfo {
	public String serverInfo;
	public String serverHost;
	public String servletContextTempDir;
	public int serverInfoColor = -1;
	public int serverHostColor = -1;
	public int servletContextTempDirColor = -1;
	
	public ServerInfo(String serverInfo, String serverHost, String servletContextTempDir) {
		super();
		this.serverInfo = serverInfo;
		this.serverHost = serverHost;
		this.servletContextTempDir = servletContextTempDir;
	}
	
	@Override
	public String toString() {
		return "ServerInfo [serverInfo=" + serverInfo + ", serverHost=" + serverHost + ", servletContextTempDir="
				+ servletContextTempDir + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerInfo other = (ServerInfo) obj;
		if (serverHost == null) {
			if (other.serverHost != null)
				return false;
		} else if (!serverHost.equals(other.serverHost))
			return false;
		if (serverInfo == null) {
			if (other.serverInfo != null)
				return false;
		} else if (!serverInfo.equals(other.serverInfo))
			return false;
		if (servletContextTempDir == null) {
			if (other.servletContextTempDir != null)
				return false;
		} else if (!servletContextTempDir.equals(other.servletContextTempDir))
			return false;
		return true;
	}
	
	public void diff(ServerInfo x,int color1,int color2){
		if(!this.serverInfo.equals(x.serverInfo)){
			this.serverInfoColor = color1;
			x.serverInfoColor = color2;
		}
		if(!this.serverHost.equals(x.serverHost)){
			this.serverHostColor = color1;
			x.serverHostColor = color2;
		}
		if(!this.servletContextTempDir.equals(x.servletContextTempDir)){
			this.servletContextTempDirColor = color1;
			x.servletContextTempDirColor = color2;
		}
	}
}
