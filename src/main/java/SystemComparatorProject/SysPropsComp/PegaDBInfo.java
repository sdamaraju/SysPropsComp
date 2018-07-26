package SystemComparatorProject.SysPropsComp;


public class PegaDBInfo {
	public String verifyDbMessage;
	public String dbName;
	public String dbProductName;
	public String dbProductVersion;
	public String dbDriverName;
	public String dbDriverVersion;
	public String dbConnectUrl;
	public String dbConnectUser;
	public String dbSchemaName;
	public String connectionType;
	public String jndiName;
	public int verifyDbMessageColor = -1;public int dbNameColor = -1;public int dbProductNameColor = -1;public int dbProductVersionColor = -1;public int dbDriverNameColor = -1;public int dbDriverVersionColor = -1;
	public int dbConnectUrlColor = -1;public int dbConnectUserColor = -1;public int dbSchemaNameColor = -1;public int connectionTypeColor = -1;public int jndiNameColor = -1;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PegaDBInfo other = (PegaDBInfo) obj;
		if (connectionType == null) {
			if (other.connectionType != null)
				return false;
		} else if (!connectionType.equals(other.connectionType))
			return false;
		if (dbConnectUrl == null) {
			if (other.dbConnectUrl != null)
				return false;
		} else if (!dbConnectUrl.equals(other.dbConnectUrl))
			return false;
		if (dbConnectUser == null) {
			if (other.dbConnectUser != null)
				return false;
		} else if (!dbConnectUser.equals(other.dbConnectUser))
			return false;
		if (dbDriverName == null) {
			if (other.dbDriverName != null)
				return false;
		} else if (!dbDriverName.equals(other.dbDriverName))
			return false;
		if (dbDriverVersion == null) {
			if (other.dbDriverVersion != null)
				return false;
		} else if (!dbDriverVersion.equals(other.dbDriverVersion))
			return false;
		if (dbName == null) {
			if (other.dbName != null)
				return false;
		} else if (!dbName.equals(other.dbName))
			return false;
		if (dbProductName == null) {
			if (other.dbProductName != null)
				return false;
		} else if (!dbProductName.equals(other.dbProductName))
			return false;
		if (dbProductVersion == null) {
			if (other.dbProductVersion != null)
				return false;
		} else if (!dbProductVersion.equals(other.dbProductVersion))
			return false;
		if (dbSchemaName == null) {
			if (other.dbSchemaName != null)
				return false;
		} else if (!dbSchemaName.equals(other.dbSchemaName))
			return false;
		if (jndiName == null) {
			if (other.jndiName != null)
				return false;
		} else if (!jndiName.equals(other.jndiName))
			return false;
		if (verifyDbMessage == null) {
			if (other.verifyDbMessage != null)
				return false;
		} else if (!verifyDbMessage.equals(other.verifyDbMessage))
			return false;
		return true;
	}
	public PegaDBInfo(String verifyDbMessage, String dbName, String dbProductName, String dbProductVersion,
			String dbDriverName, String dbDriverVersion, String dbConnectUrl, String dbConnectUser, String dbSchemaName,
			String connectionType, String jndiName) {
		super();
		this.verifyDbMessage = verifyDbMessage;
		this.dbName = dbName;
		this.dbProductName = dbProductName;
		this.dbProductVersion = dbProductVersion;
		this.dbDriverName = dbDriverName;
		this.dbDriverVersion = dbDriverVersion;
		this.dbConnectUrl = dbConnectUrl;
		this.dbConnectUser = dbConnectUser;
		this.dbSchemaName = dbSchemaName;
		this.connectionType = connectionType;
		this.jndiName = jndiName;
	}
	@Override
	public String toString() {
		return "PegaDBInfo [verifyDbMessage=" + verifyDbMessage + ", dbName=" + dbName + ", dbProductName="
				+ dbProductName + ", dbProductVersion=" + dbProductVersion + ", dbDriverName=" + dbDriverName
				+ ", dbDriverVersion=" + dbDriverVersion + ", dbConnectUrl=" + dbConnectUrl + ", dbConnectUser="
				+ dbConnectUser + ", dbSchemaName=" + dbSchemaName + ", connectionType=" + connectionType
				+ ", jndiName=" + jndiName + "]";
	}
	
	public void diff(PegaDBInfo x,int color1,int color2){
		if(!this.verifyDbMessage.equals(x.verifyDbMessage)){
			this.verifyDbMessageColor = color1;
			x.verifyDbMessageColor = color2;
		}
		if(!this.dbName.equals(x.dbName)){
			this.dbNameColor = color1;
			x.dbNameColor = color2;
		}
		if(!this.dbProductName.equals(x.dbProductName)){
			this.dbProductNameColor = color1;
			x.dbProductNameColor = color2;
		}
		if(!this.dbProductVersion.equals(x.dbProductVersion)){
			this.dbProductVersionColor = color1;
			x.dbProductVersionColor = color2;
		}
		if(!this.dbDriverName.equals(x.dbDriverName)){
			this.dbDriverNameColor = color1;
			x.dbDriverNameColor = color2;
		}
		if(!this.dbDriverVersion.equals(x.dbDriverVersion)){
			this.dbDriverVersionColor = color1;
			x.dbDriverVersionColor = color2;
		}
		if(!this.dbConnectUrl.equals(x.dbConnectUrl)){
			this.dbConnectUrlColor = color1;
			x.dbConnectUrlColor = color2;
		}
		if(!this.dbConnectUser.equals(x.dbConnectUser)){
			this.dbConnectUserColor = color1;
			x.dbConnectUserColor = color2;
		}
		if(!this.dbSchemaName.equals(x.dbSchemaName)){
			this.dbSchemaNameColor = color1;
			x.dbSchemaNameColor = color2;
		}
		if(!this.connectionType.equals(x.connectionType)){
			this.connectionTypeColor = color1;
			x.connectionTypeColor = color2;
		}
		if(!this.jndiName.equals(x.jndiName)){
			this.jndiNameColor = color1;
			x.jndiNameColor = color2;
		}
	}
}
