package SystemComparatorProject.SysPropsComp;

public class JvmInfo {
	
	public RunTimeInfo rtInfo;
	public SystemProperties sysProps;
	
	public JvmInfo(RunTimeInfo rtInfo, SystemProperties sysProps) {
		super();
		this.rtInfo = rtInfo;
		this.sysProps = sysProps;
	}

	@Override
	public String toString() {
		return "JvmInfo \n [rtInfo=" + rtInfo + "\n sysProps=" + sysProps + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JvmInfo other = (JvmInfo) obj;
		if (rtInfo == null) {
			if (other.rtInfo != null)
				return false;
		} else if (!rtInfo.equals(other.rtInfo))
			return false;
		if (sysProps == null) {
			if (other.sysProps != null)
				return false;
		} else if (!sysProps.equals(other.sysProps))
			return false;
		return true;
	}
	
	public void diff(JvmInfo x,int color1,int color2){
		this.rtInfo.diff(x.rtInfo,color1,color2);
		this.sysProps.diff(x.sysProps,color1,color2);
	}

}
