package SystemComparatorProject.SysPropsComp;

public class SystemInformation {
	
	 public PrpcInfo prpcInfo;
	 public EnvironmentInfo envInfo;
	 
	public SystemInformation(PrpcInfo prpcInfo, EnvironmentInfo envInfo) {
		super();
		this.prpcInfo = prpcInfo;
		this.envInfo = envInfo;
	}

	@Override
	public String toString() {
		return "SystemInformation [prpcInfo=" + prpcInfo + "\n envInfo=" + envInfo + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemInformation other = (SystemInformation) obj;
		if (envInfo == null) {
			if (other.envInfo != null)
				return false;
		} else if (!envInfo.equals(other.envInfo))
			return false;
		if (prpcInfo == null) {
			if (other.prpcInfo != null)
				return false;
		} else if (!prpcInfo.equals(other.prpcInfo))
			return false;
		return true;
	}
	
	public void diff(SystemInformation x,int color1,int color2){
		this.prpcInfo.diff(x.prpcInfo,color1,color2);
		this.envInfo.diff(x.envInfo,color1,color2);
	}
	
	
	

}
