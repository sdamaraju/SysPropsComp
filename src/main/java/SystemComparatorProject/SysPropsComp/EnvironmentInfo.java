package SystemComparatorProject.SysPropsComp;

public class EnvironmentInfo {
	public ServerInfo serverInfo;
	public JvmInfo jvmInfo;
	public PegaDBInfo pegaDbInfo;
	public PegaJMSInfo pegaJmsInfo;
	
	public EnvironmentInfo(ServerInfo serverInfo, JvmInfo jvmInfo, PegaDBInfo pegaDbInfo, PegaJMSInfo pegaJmsInfo) {
		super();
		this.serverInfo = serverInfo;
		this.jvmInfo = jvmInfo;
		this.pegaDbInfo = pegaDbInfo;
		this.pegaJmsInfo = pegaJmsInfo;
	}
	
	@Override
	public String toString() {
		return "EnvironmentInfo \n [serverInfo=" + serverInfo + "\n jvmInfo=" + jvmInfo + "\n pegaDbInfo=" + pegaDbInfo
				+ "\n pegaJmsInfo=" + pegaJmsInfo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EnvironmentInfo other = (EnvironmentInfo) obj;
		if (jvmInfo == null) {
			if (other.jvmInfo != null)
				return false;
		} else if (!jvmInfo.equals(other.jvmInfo))
			return false;
		if (pegaDbInfo == null) {
			if (other.pegaDbInfo != null)
				return false;
		} else if (!pegaDbInfo.equals(other.pegaDbInfo))
			return false;
		if (pegaJmsInfo == null) {
			if (other.pegaJmsInfo != null)
				return false;
		} else if (!pegaJmsInfo.equals(other.pegaJmsInfo))
			return false;
		if (serverInfo == null) {
			if (other.serverInfo != null)
				return false;
		} else if (!serverInfo.equals(other.serverInfo))
			return false;
		return true;
	}
	
	
	public void diff(EnvironmentInfo x,int color1,int color2){
		this.serverInfo.diff(x.serverInfo,color1,color2);
		this.jvmInfo.diff(x.jvmInfo,color1,color2);
		this.pegaDbInfo.diff(x.pegaDbInfo,color1,color2);
		this.pegaJmsInfo.diff(x.pegaJmsInfo,color1,color2);
	}
	
}
