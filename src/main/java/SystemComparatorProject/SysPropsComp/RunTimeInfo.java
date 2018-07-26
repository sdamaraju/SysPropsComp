package SystemComparatorProject.SysPropsComp;


public class RunTimeInfo {
	public String totalHeapMemoryActual;
	public String totalHeapMemoryRecommended;
	public String maxHeapMemoryActual;
	public String maxHeapMemoryRecommended;
	public String freeHeapMemoryActual;
	public String freeHeapMemoryRecommended;
	public int totalHeapMemoryActualColor = -1;
	public int totalHeapMemoryRecommendedColor = -1;
	public int maxHeapMemoryActualColor = -1;
	public int maxHeapMemoryRecommendedColor = -1;
	public int freeHeapMemoryActualColor = -1;
	public int freeHeapMemoryRecommendedColor = -1;
	public RunTimeInfo(String totalHeapMemoryActual, String totalHeapMemoryRecommended, String maxHeapMemoryActual,
			String maxHeapMemoryRecommended, String freeHeapMemoryActual, String freeHeapMemoryRecommended) {
		super();
		this.totalHeapMemoryActual = totalHeapMemoryActual;
		this.totalHeapMemoryRecommended = totalHeapMemoryRecommended;
		this.maxHeapMemoryActual = maxHeapMemoryActual;
		this.maxHeapMemoryRecommended = maxHeapMemoryRecommended;
		this.freeHeapMemoryActual = freeHeapMemoryActual;
		this.freeHeapMemoryRecommended = freeHeapMemoryRecommended;
	}



	@Override
	public String toString() {
		return "RunTimeInfo [totalHeapMemoryActual=" + totalHeapMemoryActual + ", totalHeapMemoryRecommended="
				+ totalHeapMemoryRecommended + ", maxHeapMemoryActual=" + maxHeapMemoryActual
				+ ", maxlHeapMemoryRecommended=" + maxHeapMemoryRecommended + ", freeHeapMemoryActual="
				+ freeHeapMemoryActual + ", freeHeapMemoryRecommended=" + freeHeapMemoryRecommended + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RunTimeInfo other = (RunTimeInfo) obj;
		if (freeHeapMemoryActual == null) {
			if (other.freeHeapMemoryActual != null)
				return false;
		} else if (!freeHeapMemoryActual.equals(other.freeHeapMemoryActual))
			return false;
		if (freeHeapMemoryRecommended == null) {
			if (other.freeHeapMemoryRecommended != null)
				return false;
		} else if (!freeHeapMemoryRecommended.equals(other.freeHeapMemoryRecommended))
			return false;
		if (maxHeapMemoryActual == null) {
			if (other.maxHeapMemoryActual != null)
				return false;
		} else if (!maxHeapMemoryActual.equals(other.maxHeapMemoryActual))
			return false;
		if (maxHeapMemoryRecommended == null) {
			if (other.maxHeapMemoryRecommended != null)
				return false;
		} else if (!maxHeapMemoryRecommended.equals(other.maxHeapMemoryRecommended))
			return false;
		if (totalHeapMemoryActual == null) {
			if (other.totalHeapMemoryActual != null)
				return false;
		} else if (!totalHeapMemoryActual.equals(other.totalHeapMemoryActual))
			return false;
		if (totalHeapMemoryRecommended == null) {
			if (other.totalHeapMemoryRecommended != null)
				return false;
		} else if (!totalHeapMemoryRecommended.equals(other.totalHeapMemoryRecommended))
			return false;
		return true;
	}
	
	public void diff(RunTimeInfo x,int color1,int color2){
		if(!this.totalHeapMemoryActual.equals(x.totalHeapMemoryActual)){
			this.totalHeapMemoryActualColor = color1;
			x.totalHeapMemoryActualColor = color2;
		}
		if(!this.totalHeapMemoryRecommended.equals(x.totalHeapMemoryRecommended)){
			this.totalHeapMemoryRecommendedColor = color1;
			x.totalHeapMemoryRecommendedColor = color2;
		}
		if(!this.maxHeapMemoryActual.equals(x.maxHeapMemoryActual)){
			this.maxHeapMemoryActualColor = color1;
			x.maxHeapMemoryActualColor = color2;
		}
		if(!this.maxHeapMemoryRecommended.equals(x.maxHeapMemoryRecommended)){
			this.maxHeapMemoryRecommendedColor = color1;
			x.maxHeapMemoryRecommendedColor = color2;
		}
		if(!this.freeHeapMemoryActual.equals(x.freeHeapMemoryActual)){
			this.freeHeapMemoryActualColor = color1;
			x.freeHeapMemoryActualColor = color2;
		}
		if(!this.freeHeapMemoryRecommended.equals(x.freeHeapMemoryRecommended)){
			this.freeHeapMemoryRecommendedColor = color1;
			x.freeHeapMemoryRecommendedColor = color2;
		}
	}
	
}
