package SystemComparatorProject.SysPropsComp;

public class PrpcBuildInfo {
	
	public String buildName;
	public String buildDate;
	public String buildMajorVersion;
	public String buildMinorVersion;
	public String label;
	public int buildNameColor = -1;
	public int buildDateColor= -1;
	public int buildMajorVersionColor= -1;
	public int buildMinorVersionColor= -1;
	public int labelColor= -1;
	
	public String getBuildName() {
		return buildName;
	}
	
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	
	public String getBuildDate() {
		return buildDate;
	}
	
	public void setBuildDate(String buildDate) {
		this.buildDate = buildDate;
	}
	
	public String getBuildMajorVersion() {
		return buildMajorVersion;
	}
	
	public void setBuildMajorVersion(String buildMajorVersion) {
		this.buildMajorVersion = buildMajorVersion;
	}
	
	public String getBuildMinorVersion() {
		return buildMinorVersion;
	}
	
	public void setBuildMinorVersion(String buildMinorVersion) {
		this.buildMinorVersion = buildMinorVersion;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	@Override
	public String toString() {
		return "PrpcBuildInfo [buildName=" + buildName + ", buildDate=" + buildDate + ", buildMajorVersion="
				+ buildMajorVersion + ", buildMinorVersion=" + buildMinorVersion + ", label=" + label + "]";
	}

	public PrpcBuildInfo(String buildName, String buildDate, String buildMajorVersion, String buildMinorVersion,
			String label) {
		super();
		this.buildName = buildName;
		this.buildDate = buildDate;
		this.buildMajorVersion = buildMajorVersion;
		this.buildMinorVersion = buildMinorVersion;
		this.label = label;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrpcBuildInfo other = (PrpcBuildInfo) obj;
		if (buildDate == null) {
			if (other.buildDate != null)
				return false;
		} else if (!buildDate.equals(other.buildDate))
			return false;
		if (buildMajorVersion == null) {
			if (other.buildMajorVersion != null)
				return false;
		} else if (!buildMajorVersion.equals(other.buildMajorVersion))
			return false;
		if (buildMinorVersion == null) {
			if (other.buildMinorVersion != null)
				return false;
		} else if (!buildMinorVersion.equals(other.buildMinorVersion))
			return false;
		if (buildName == null) {
			if (other.buildName != null)
				return false;
		} else if (!buildName.equals(other.buildName))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	public void diff(PrpcBuildInfo x,int color1,int color2){
		if(!this.buildName.equals(x.buildName)){
			this.buildNameColor = color1;
			x.buildNameColor = color2;
		}
		if(!this.buildDate.equals(x.buildDate)){
			this.buildDateColor = color1;
			x.buildDateColor = color2;
		}
		if(!this.buildMajorVersion.equals(x.buildMajorVersion)){
			this.buildMajorVersionColor = color1;
			x.buildMajorVersionColor = color2;
		}
		if(!this.buildMinorVersion.equals(x.buildMinorVersion)){
			this.buildMinorVersionColor = color1;
			x.buildMinorVersionColor = color2;
		}
		if(!this.label.equals(x.label)){
			this.labelColor = color1;
			x.labelColor = color2;
		}
	}
	
}
