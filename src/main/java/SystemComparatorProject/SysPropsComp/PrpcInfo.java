package SystemComparatorProject.SysPropsComp;

public class PrpcInfo {
	
	public PrpcBuildInfo prpcBuildInfo;
	public String pegaTempDirectory;
	public int pegaTempDirectoryColor = -1; // for Display purposes.
	public PrpcInfo(PrpcBuildInfo prpcBuildInfo, String pegaTempDirectory) {
		super();
		this.prpcBuildInfo = prpcBuildInfo;
		this.pegaTempDirectory = pegaTempDirectory;
	}
	@Override
	public String toString() {
		return "PrpcInfo [prpcBuildInfo=" + prpcBuildInfo + ", pegaTempDirectory=" + pegaTempDirectory + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrpcInfo other = (PrpcInfo) obj;
		if (pegaTempDirectory == null) {
			if (other.pegaTempDirectory != null)
				return false;
		} else if (!pegaTempDirectory.equals(other.pegaTempDirectory))
			return false;
		if (prpcBuildInfo == null) {
			if (other.prpcBuildInfo != null)
				return false;
		} else if (!prpcBuildInfo.equals(other.prpcBuildInfo))
			return false;
		return true;
	}
	
	public void diff(PrpcInfo x,int color1,int color2){
		this.prpcBuildInfo.diff(x.prpcBuildInfo,color1,color2);
		if(this.pegaTempDirectory.equals(x.pegaTempDirectory)){
		//No-Op
		}else{
			this.pegaTempDirectoryColor = color1;
			x.pegaTempDirectoryColor = color2;
		}
	}
}
