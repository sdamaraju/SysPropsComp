package SystemComparatorProject.SysPropsComp;


public class PegaJMSInfo {
	
	public String jmsstatus;
	public String pegaJmsEnv;
	public String jmsBaseJNDIContext;
	public String jmsSBindings;
	public int jmsstatusColor = -1;int pegaJmsEnvColor = -1;int jmsBaseJNDIContextColor = -1;int jmsSBindingsColor = -1;
	
	public PegaJMSInfo(String jmsstatus, String pegaJmsEnv, String jmsBaseJNDIContext, String jmsSBindings) {
		super();
		this.jmsstatus = jmsstatus;
		this.pegaJmsEnv = pegaJmsEnv;
		this.jmsBaseJNDIContext = jmsBaseJNDIContext;
		this.jmsSBindings = jmsSBindings;
	}
	@Override
	public String toString() {
		return "PegaJMSInfo [jmsstatus=" + jmsstatus + ", pegaJmsEnv=" + pegaJmsEnv + ", jmsBaseJNDIContext="
				+ jmsBaseJNDIContext + ", jmsSBindings=" + jmsSBindings + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PegaJMSInfo other = (PegaJMSInfo) obj;
		if (jmsBaseJNDIContext == null) {
			if (other.jmsBaseJNDIContext != null)
				return false;
		} else if (!jmsBaseJNDIContext.equals(other.jmsBaseJNDIContext))
			return false;
		if (jmsSBindings == null) {
			if (other.jmsSBindings != null)
				return false;
		} else if (!jmsSBindings.equals(other.jmsSBindings))
			return false;
		if (jmsstatus == null) {
			if (other.jmsstatus != null)
				return false;
		} else if (!jmsstatus.equals(other.jmsstatus))
			return false;
		if (pegaJmsEnv == null) {
			if (other.pegaJmsEnv != null)
				return false;
		} else if (!pegaJmsEnv.equals(other.pegaJmsEnv))
			return false;
		return true;
	}
	
	public void diff(PegaJMSInfo x,int color1,int color2){
		if(!this.jmsstatus.equals(x.jmsstatus)){
			this.jmsstatusColor = color1;
			x.jmsstatusColor = color2;
		}
		if(!this.pegaJmsEnv.equals(x.pegaJmsEnv)){
			this.pegaJmsEnvColor = color1;
			x.pegaJmsEnvColor = color2;
		}
		if(!this.jmsBaseJNDIContext.equals(x.jmsBaseJNDIContext)){
			this.jmsBaseJNDIContextColor = color1;
			x.jmsBaseJNDIContextColor = color2;
		}
		if(!this.jmsSBindings.equals(x.jmsSBindings)){
			this.jmsSBindingsColor = color1;
			x.jmsSBindingsColor = color2;
		}
	}
	
}
