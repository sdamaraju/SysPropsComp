package SystemComparatorProject.SysPropsComp;

public class SystemProperties {
	
	public String osName;
	public String osArch;
	public String osVersion;
	public String javaVersion;
	public String javaVendor;
	public String javaVendorUrl;
	public String javaVMName;
	public String javaVMVersion;
	public String javaVMInfo;
	public String javaVMVendor;
	public String javaVMSpecVendor;
	public String javaSpecName;
	public String javaSpecificationVersion;
	public String javaSpecificationVendor;
	public String javaRuntimeName;
	public String javaRuntimeVersion;
	public String javaHome;
	public String javaUtilLoggingManager;
	public String javaIOTempDir;
	public int osNameColor = -1;
	public int javaVMInfoColor = -1;public int osArchColor = -1;public int osVersionColor = -1;public int javaVersionColor = -1;public int javaVendorColor = -1;public int javaVendorUrlColor = -1;public int javaVMNameColor = -1;public int javaVMVersionColor = -1;
	public int javaVMVendorColor = -1;public int javaVMSpecVendorColor = -1;public int javaSpecNameColor = -1;public int javaSpecificationVersionColor = -1;public int javaSpecificationVendorColor = -1;public int javaRuntimeNameColor = -1;
	public int javaRuntimeVersionColor = -1;public int javaHomeColor = -1;public int javaUtilLoggingManagerColor = -1;public int javaIOTempDirColor = -1;
	
	public SystemProperties(String osName, String osArch, String osVersion, String javaVersion, String javaVendor,
			String javaVendorUrl, String javaVMName, String javaVMVersion, String javaVMInfo, String javaVMVendor,
			String javaVMSpecVendor, String javaSpecName, String javaSpecificationVersion,
			String javaSpecificationVendor, String javaRuntimeName, String javaRuntimeVersion, String javaHome,
			String javaUtilLoggingManager, String javaIOTempDir) {
		super();
		this.osName = osName;
		this.osArch = osArch;
		this.osVersion = osVersion;
		this.javaVersion = javaVersion;
		this.javaVendor = javaVendor;
		this.javaVendorUrl = javaVendorUrl;
		this.javaVMName = javaVMName;
		this.javaVMVersion = javaVMVersion;
		this.javaVMInfo = javaVMInfo;
		this.javaVMVendor = javaVMVendor;
		this.javaVMSpecVendor = javaVMSpecVendor;
		this.javaSpecName = javaSpecName;
		this.javaSpecificationVersion = javaSpecificationVersion;
		this.javaSpecificationVendor = javaSpecificationVendor;
		this.javaRuntimeName = javaRuntimeName;
		this.javaRuntimeVersion = javaRuntimeVersion;
		this.javaHome = javaHome;
		this.javaUtilLoggingManager = javaUtilLoggingManager;
		this.javaIOTempDir = javaIOTempDir;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemProperties other = (SystemProperties) obj;
		if (javaHome == null) {
			if (other.javaHome != null)
				return false;
		} else if (!javaHome.equals(other.javaHome))
			return false;
		if (javaIOTempDir == null) {
			if (other.javaIOTempDir != null)
				return false;
		} else if (!javaIOTempDir.equals(other.javaIOTempDir))
			return false;
		if (javaRuntimeName == null) {
			if (other.javaRuntimeName != null)
				return false;
		} else if (!javaRuntimeName.equals(other.javaRuntimeName))
			return false;
		if (javaRuntimeVersion == null) {
			if (other.javaRuntimeVersion != null)
				return false;
		} else if (!javaRuntimeVersion.equals(other.javaRuntimeVersion))
			return false;
		if (javaSpecName == null) {
			if (other.javaSpecName != null)
				return false;
		} else if (!javaSpecName.equals(other.javaSpecName))
			return false;
		if (javaSpecificationVendor == null) {
			if (other.javaSpecificationVendor != null)
				return false;
		} else if (!javaSpecificationVendor.equals(other.javaSpecificationVendor))
			return false;
		if (javaSpecificationVersion == null) {
			if (other.javaSpecificationVersion != null)
				return false;
		} else if (!javaSpecificationVersion.equals(other.javaSpecificationVersion))
			return false;
		if (javaUtilLoggingManager == null) {
			if (other.javaUtilLoggingManager != null)
				return false;
		} else if (!javaUtilLoggingManager.equals(other.javaUtilLoggingManager))
			return false;
		if (javaVMInfo == null) {
			if (other.javaVMInfo != null)
				return false;
		} else if (!javaVMInfo.equals(other.javaVMInfo))
			return false;
		if (javaVMName == null) {
			if (other.javaVMName != null)
				return false;
		} else if (!javaVMName.equals(other.javaVMName))
			return false;
		if (javaVMSpecVendor == null) {
			if (other.javaVMSpecVendor != null)
				return false;
		} else if (!javaVMSpecVendor.equals(other.javaVMSpecVendor))
			return false;
		if (javaVMVendor == null) {
			if (other.javaVMVendor != null)
				return false;
		} else if (!javaVMVendor.equals(other.javaVMVendor))
			return false;
		if (javaVMVersion == null) {
			if (other.javaVMVersion != null)
				return false;
		} else if (!javaVMVersion.equals(other.javaVMVersion))
			return false;
		if (javaVendor == null) {
			if (other.javaVendor != null)
				return false;
		} else if (!javaVendor.equals(other.javaVendor))
			return false;
		if (javaVendorUrl == null) {
			if (other.javaVendorUrl != null)
				return false;
		} else if (!javaVendorUrl.equals(other.javaVendorUrl))
			return false;
		if (javaVersion == null) {
			if (other.javaVersion != null)
				return false;
		} else if (!javaVersion.equals(other.javaVersion))
			return false;
		if (osArch == null) {
			if (other.osArch != null)
				return false;
		} else if (!osArch.equals(other.osArch))
			return false;
		if (osName == null) {
			if (other.osName != null)
				return false;
		} else if (!osName.equals(other.osName))
			return false;
		if (osVersion == null) {
			if (other.osVersion != null)
				return false;
		} else if (!osVersion.equals(other.osVersion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SystemProperties [osName=" + osName + ", javaVersionColor=" + javaVersionColor+", osArch=" + osArch + ", osVersion=" + osVersion
				+ ", javaVersion=" + javaVersion + ", javaVendor=" + javaVendor + ", javaVendorUrl=" + javaVendorUrl
				+ ", javaVMName=" + javaVMName + ", javaVMVersion=" + javaVMVersion + ", javaVMInfo=" + javaVMInfo
				+ ", javaVMVendor=" + javaVMVendor + ", javaVMSpecVendor=" + javaVMSpecVendor + ", javaSpecName="
				+ javaSpecName + ", javaSpecificationVersion=" + javaSpecificationVersion + ", javaSpecificationVendor="
				+ javaSpecificationVendor + ", javaRuntimeName=" + javaRuntimeName + ", javaRuntimeVersion="
				+ javaRuntimeVersion + ", javaHome=" + javaHome + ", javaUtilLoggingManager=" + javaUtilLoggingManager
				+ ", javaIOTempDir=" + javaIOTempDir + ", osNameColor=" + osNameColor + ", javaVMInfoColor="
				+ javaVMInfoColor + ", osArchColor=" + osArchColor + ", osVersionColor=" + osVersionColor
				+ ", javaVersionColor=" + javaVersionColor + ", javaVendorColor=" + javaVendorColor
				+ ", javaVendorUrlColor=" + javaVendorUrlColor + ", javaVMNameColor=" + javaVMNameColor
				+ ", javaVMVersionColor=" + javaVMVersionColor + ", javaVMVendorColor=" + javaVMVendorColor
				+ ", javaVMSpecVendorColor=" + javaVMSpecVendorColor + ", javaSpecNameColor=" + javaSpecNameColor
				+ ", javaSpecificationVersionColor=" + javaSpecificationVersionColor + ", javaSpecificationVendorColor="
				+ javaSpecificationVendorColor + ", javaRuntimeNameColor=" + javaRuntimeNameColor
				+ ", javaRuntimeVersionColor=" + javaRuntimeVersionColor + ", javaHomeColor=" + javaHomeColor
				+ ", javaUtilLoggingManagerColor=" + javaUtilLoggingManagerColor + ", javaIOTempDirColor="
				+ javaIOTempDirColor + "]";
	}
	
	public void diff(SystemProperties x,int color1,int color2){
		if(!this.javaSpecificationVendor.equals(x.javaSpecificationVendor)){
			this.javaSpecificationVendorColor = color1;
			x.javaSpecificationVendorColor = color2;
		}
		if(!this.javaRuntimeName.equals(x.javaRuntimeName)){
			this.javaRuntimeNameColor = color1;
			x.javaRuntimeNameColor = color2;
		}
		if(!this.javaRuntimeVersion.equals(x.javaRuntimeVersion)){
			this.javaRuntimeVersionColor = color1;
			x.javaRuntimeVersionColor = color2;
		}
		if(!this.javaHome.equals(x.javaHome)){
			this.javaHomeColor = color1;
			x.javaHomeColor = color2;
		}
		if(!this.javaUtilLoggingManager.equals(x.javaUtilLoggingManager)){
			this.javaUtilLoggingManagerColor = color1;
			x.javaUtilLoggingManagerColor = color2;
		}
		if(!this.javaIOTempDir.equals(x.javaIOTempDir)){
			this.javaIOTempDirColor = color1;
			x.javaIOTempDirColor = color2;
		}
		if(!this.javaVMName.equals(x.javaVMName)){
			this.javaVMNameColor = color1;
			x.javaVMNameColor = color2;
		}
		if(!this.javaVMVersion.equals(x.javaVMVersion)){
			this.javaVMVersionColor = color1;
			x.javaVMVersionColor = color2;
		}
		if(!this.javaVMInfo.equals(x.javaVMInfo)){
			this.javaVMInfoColor = color1;
			x.javaVMInfoColor = color2;
		}
		if(!this.javaVMVendor.equals(x.javaVMVendor)){
			this.javaVMVendorColor = color1;
			x.javaVMVendorColor = color2;
		}
		if(!this.javaVMSpecVendor.equals(x.javaVMSpecVendor)){
			this.javaVMSpecVendorColor = color1;
			x.javaVMSpecVendorColor = color2;
		}
		if(!this.javaSpecName.equals(x.javaSpecName)){
			this.javaSpecNameColor = color1;
			x.javaSpecNameColor = color2;
		}
		if(!this.javaSpecificationVersion.equals(x.javaSpecificationVersion)){
			this.javaSpecificationVersionColor = color1;
			x.javaSpecificationVersionColor = color2;
		}
		if(!this.osName.equals(x.osName)){
			this.osNameColor = color1;
			x.osNameColor = color2;
		}
		if(!this.osArch.equals(x.osArch)){
			this.osArchColor = color1;
			x.osArchColor = color2;
		}
		if(!this.osVersion.equals(x.osVersion)){
			this.osVersionColor = color1;
			x.osVersionColor = color2;
		}
		if(!this.javaVersion.equals(x.javaVersion)){
			this.javaVersionColor = color1;
			x.javaVersionColor = color2;
		}
		if(!this.javaVendor.equals(x.javaVendor)){
			this.javaVendorColor = color1;
			x.javaVendorColor = color2;
		}
		if(!this.javaVendorUrl.equals(x.javaVendorUrl)){
			this.javaVendorUrlColor = color1;
			x.javaVendorUrlColor = color2;
		}
	}
	
}
