package SystemComparatorProject.SysPropsComp;


import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ObjectConstructor {
// This class reads the XML files given and creates the necessary objects.
	
	
	
	public SystemInformation fileReader(File f1) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(f1);
		return getSysInfoUsingDocObject(doc);
	}
	
	public SystemInformation XMLStringReader(String XML) throws ParserConfigurationException, SAXException, IOException{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(new InputSource(new StringReader(XML)));
		return getSysInfoUsingDocObject(doc);
	}
		
		
	public SystemInformation getSysInfoUsingDocObject(Document doc){
		Element root = doc.getDocumentElement();
		NodeList list = root.getChildNodes();
		PrpcInfo prpcInfo = null;
		EnvironmentInfo envInfo = null;
		int rootChildIterator = 0;
		while(rootChildIterator < list.getLength()){
			if(list.item(rootChildIterator).getNodeName().equals("PRPC_Info")){
				Node prpcInfoNode = list.item(rootChildIterator);
				NodeList prpcInfoNodeList = prpcInfoNode.getChildNodes();
				PrpcBuildInfo buildInfoObject = null;
				String pegaTempDir = "";
				int prpcInfoNodeListIterator = 0;
				while(prpcInfoNodeListIterator < prpcInfoNodeList.getLength()){
					if(prpcInfoNodeList.item(prpcInfoNodeListIterator).getNodeName().equals("PRPC_BuildInfo")){
						Element prpcBuildInfo = (Element) prpcInfoNodeList.item(prpcInfoNodeListIterator);
						int prpcInfoNodeIterator=0;String buildName="",buildDate= "",buildMajorVersion = "",buildMinorVersion = "",label = "";
						while(prpcInfoNodeIterator<prpcBuildInfo.getChildNodes().getLength()){
							if(prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getNodeName().equals("BuildName")){
								buildName = prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getTextContent();
							}else if(prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getNodeName().equals("BuildDate")){
								buildDate = prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getTextContent();
							}else if(prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getNodeName().equals("BuildMajorVersion")){
								buildMajorVersion = prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getTextContent();	
							}else if(prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getNodeName().equals("BuildMinorVersion")){
								buildMinorVersion = prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getTextContent();	
							}else if(prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getNodeName().equals("Label")){
								label = prpcBuildInfo.getChildNodes().item(prpcInfoNodeIterator).getTextContent();	
							}
							prpcInfoNodeIterator++;
						} // PRPCBuildInfo Acquired !	
						buildInfoObject = new PrpcBuildInfo(buildName,buildDate,buildMajorVersion,buildMinorVersion,label);
					}else if(prpcInfoNodeList.item(prpcInfoNodeListIterator).getNodeName().equals("PegaTempDir")){
						pegaTempDir = prpcInfoNodeList.item(prpcInfoNodeListIterator).getTextContent();
					}
					prpcInfoNodeListIterator++;
 				}
				prpcInfo = new PrpcInfo(buildInfoObject,pegaTempDir); //prpcInfoObject Created ! 
			}else if(list.item(rootChildIterator).getNodeName().equals("EnvironmentInfo")){
				Node envInfoNode = list.item(rootChildIterator);
				NodeList envInfoNodeList = envInfoNode.getChildNodes();
				ServerInfo serverInfo = null;
				JvmInfo jvmInfo = null;
				PegaDBInfo pegaDBinfo = null;
				PegaJMSInfo pegaJmsInfo = null;
				int envInfoNodeListIterator = 0;
				while(envInfoNodeListIterator<envInfoNodeList.getLength()){
					if(envInfoNodeList.item(envInfoNodeListIterator).getNodeName().equals("Server_Info")){
						Element serverInfoNode = (Element) envInfoNodeList.item(envInfoNodeListIterator);
						int serverInfoListIterator=0;String serverinfo = "",serverHost = "",tempDir = ""; 
						while(serverInfoListIterator<serverInfoNode.getChildNodes().getLength()){
							if(serverInfoNode.getChildNodes().item(serverInfoListIterator).getNodeName().equals("ServerInfo")){
								serverinfo = serverInfoNode.getChildNodes().item(serverInfoListIterator).getTextContent();
							}else if(serverInfoNode.getChildNodes().item(serverInfoListIterator).getNodeName().equals("ServerHost")){
								serverHost = serverInfoNode.getChildNodes().item(serverInfoListIterator).getTextContent();
							}else if(serverInfoNode.getChildNodes().item(serverInfoListIterator).getNodeName().equals("javax.servlet.context.tempdir")){
								tempDir = serverInfoNode.getChildNodes().item(serverInfoListIterator).getTextContent();	
							}
							serverInfoListIterator++;
						}
						serverInfo = new ServerInfo(serverinfo,serverHost,tempDir);
					}else if(envInfoNodeList.item(envInfoNodeListIterator).getNodeName().equals("JVM_Info")){
						Node jvmInfoNode = (Element) envInfoNodeList.item(envInfoNodeListIterator);
						NodeList jvmInfoNodeList = jvmInfoNode.getChildNodes();
						RunTimeInfo rtInfo = null;
						SystemProperties sysPropsInfo = null;
						int jvmInfoListIterator=0;
						while (jvmInfoListIterator<jvmInfoNodeList.getLength()){
							if(jvmInfoNodeList.item(jvmInfoListIterator).getNodeName().equals("RuntimeInformation")){
								Node rtInfoNode = jvmInfoNodeList.item(jvmInfoListIterator);
								//System.out.println("RunTimeInfo");
								//Set the RunTime info Object with all its properties here.
								int rtListIterator=0;String totalHeapActual = "",totalHeapRecommanded="",maxHeapActual="",maxHeapRecommanded="",freeHeapActual="",freeHeapRecommanded="";
								while(rtListIterator<rtInfoNode.getChildNodes().getLength()){
									if(rtInfoNode.getChildNodes().item(rtListIterator).getNodeName().equals("TotalHeapMemory")){ // re-write this code using a separate method.
										Node totalHeapMemNode = rtInfoNode.getChildNodes().item(rtListIterator);
										Node actualtotalHeapMemNode = totalHeapMemNode.getChildNodes().item(1);
										totalHeapActual = actualtotalHeapMemNode.getChildNodes().item(1).getTextContent();
										Node recommandedtotalHeapMemNode = totalHeapMemNode.getChildNodes().item(3);
										totalHeapRecommanded = recommandedtotalHeapMemNode.getChildNodes().item(1).getTextContent();
									}else if(rtInfoNode.getChildNodes().item(rtListIterator).getNodeName().equals("MaxHeapMemory")){
										Node maxHeapMemNode = rtInfoNode.getChildNodes().item(rtListIterator);
										Node actualmaxHeapMemNode = maxHeapMemNode.getChildNodes().item(1);
										maxHeapActual = actualmaxHeapMemNode.getChildNodes().item(1).getTextContent();
										Node recommandedmaxHeapMemNode = maxHeapMemNode.getChildNodes().item(3);
										maxHeapRecommanded = recommandedmaxHeapMemNode.getChildNodes().item(1).getTextContent();
									}else if(rtInfoNode.getChildNodes().item(rtListIterator).getNodeName().equals("FreeHeapMemory")){
										Node freeHeapMemNode = rtInfoNode.getChildNodes().item(rtListIterator);
										Node actualfreeHeapMemNode = freeHeapMemNode.getChildNodes().item(1);
										freeHeapActual = actualfreeHeapMemNode.getChildNodes().item(1).getTextContent();
										Node recommandedfreeHeapMemNode = freeHeapMemNode.getChildNodes().item(3);
										freeHeapRecommanded = recommandedfreeHeapMemNode.getChildNodes().item(1).getTextContent();
									}
									rtListIterator++;
								}
								rtInfo = new RunTimeInfo(totalHeapActual,totalHeapRecommanded,maxHeapActual,maxHeapRecommanded,freeHeapActual,freeHeapRecommanded);
							}else if(jvmInfoNodeList.item(jvmInfoListIterator).getNodeName().equals("SystemProperties")){
								Node sysInfoNode = jvmInfoNodeList.item(jvmInfoListIterator);
								String osName="",osArch="",osVersion="",javaVersion="",javaVendor="",javaVendorUrl="",javaVMName="", javaVMVersion="", javaVMInfo="", javaVMVendor="", javaVMSpecVendor="", javaSpecName="",
								javaSpecificationVersion="", javaSpecificationVendor="", javaRuntimeName="", javaRuntimeVersion="", javaHome="", javaUtilLoggingManager="" ,javaIOTempDir="";
								int sysInfoNodeListIterator = 0;
								while(sysInfoNodeListIterator<sysInfoNode.getChildNodes().getLength()){
									if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("os.name")){
										osName = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("os.arch")){
										osArch = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("os.version")){
										osVersion = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.version")){
										javaVersion = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vendor")){
										javaVendor = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vendor.url")){
										javaVendorUrl = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vm.name")){
										javaVMName = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vm.version")){
										javaVMVersion = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vm.info")){
										javaVMInfo = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vm.vendor")){
										javaVMVendor = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.vm.specification.vendor")){
										javaVMSpecVendor = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.specification.name")){
										javaSpecName = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.specification.version")){
										javaSpecificationVersion = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.specification.vendor")){
										javaSpecificationVendor = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.runtime.name")){
										javaRuntimeName = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.runtime.version")){
										javaRuntimeVersion = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.home")){
										javaHome = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.util.logging.manager")){
										javaUtilLoggingManager = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}else if(sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getNodeName().equals("java.io.tmpdir")){
										javaIOTempDir = sysInfoNode.getChildNodes().item(sysInfoNodeListIterator).getTextContent();
									}
									sysInfoNodeListIterator++;
								}
								sysPropsInfo = new SystemProperties(osName,osArch,osVersion,javaVersion,javaVendor,javaVendorUrl,javaVMName,javaVMVersion,javaVMInfo,javaVMVendor,javaVMSpecVendor,javaSpecName,
										javaSpecificationVersion,javaSpecificationVendor,javaRuntimeName,javaRuntimeVersion,javaHome,javaUtilLoggingManager,javaIOTempDir);
							}
							
							jvmInfoListIterator++;
						}
						jvmInfo = new JvmInfo(rtInfo,sysPropsInfo);
					}else if(envInfoNodeList.item(envInfoNodeListIterator).getNodeName().equals("PegaDatabaseInformation")){
						Node pegaDBInfoNode = envInfoNodeList.item(envInfoNodeListIterator);
						NodeList pegaDBInfoNodeList = pegaDBInfoNode.getChildNodes();
						String verifyDbMessage="",dbName="",dbProductName="",dbProductVersion="",dbDriverName="",dbDriverVersion="",dbConnectUrl="",dbConnectUser="",dbSchemaName="",connectionType="",jndiName="";
						int pegaDBInfoListIterator = 0;
						while(pegaDBInfoListIterator<pegaDBInfoNode.getChildNodes().getLength()){
							if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("VerifyDbMsg")){
								verifyDbMessage = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DBName")){
								dbName = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();;
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DBProductName")){
								dbProductName = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DBProductVersion")){
								dbProductVersion = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();;
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DBDriverName")){
								dbDriverName = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DBDriverVersion")){
								dbDriverVersion = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();;
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DB_Connect_URL")){
								dbConnectUrl = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DB_ConnectUser")){
								dbConnectUser = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("DB_SchemaName")){
								dbSchemaName = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getTextContent();;
							}else if(pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator).getNodeName().equals("Connection")){ // try to re-write this part ! 
								Node connectionNode = pegaDBInfoNode.getChildNodes().item(pegaDBInfoListIterator);
								Node typeNode = connectionNode.getChildNodes().item(1);
								connectionType = typeNode.getTextContent();
								Node jndiNode = connectionNode.getChildNodes().item(3);
								jndiName = jndiNode.getTextContent();
							}
							pegaDBInfoListIterator++;
						}
						pegaDBinfo = new PegaDBInfo(verifyDbMessage,dbName,dbProductName,dbProductVersion,dbDriverName,dbDriverVersion,dbConnectUrl,dbConnectUser,dbSchemaName,connectionType,jndiName);
						}else if(envInfoNodeList.item(envInfoNodeListIterator).getNodeName().equals("PegaJMS")){
						Node pegaJmsInfoNode = envInfoNodeList.item(envInfoNodeListIterator);
						NodeList pegaJmsInfoNodeList = pegaJmsInfoNode.getChildNodes();
						String jmsStatus="",pegaJmsEnv="",jmsBaseJndiContext="",jndiJmsSbindings="";
						int pegaJmsInfoListIterator = 0;
						while(pegaJmsInfoListIterator<pegaJmsInfoNodeList.getLength()){
							if(pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getNodeName().equals("JMSStatus")){
								jmsStatus = pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getTextContent();
							}else if(pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getNodeName().equals("PegaJMS_Environment")){
								pegaJmsEnv = pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getTextContent();;
							}else if(pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getNodeName().equals("JMSBaseJNDIConext")){
								jmsBaseJndiContext = pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getTextContent();
							}else if(pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getNodeName().equals("JndiJmsSBindings")){
								jndiJmsSbindings = pegaJmsInfoNode.getChildNodes().item(pegaJmsInfoListIterator).getTextContent();;
							}
							pegaJmsInfoListIterator++;
						}
						pegaJmsInfo = new PegaJMSInfo(jmsStatus,pegaJmsEnv,jmsBaseJndiContext,jndiJmsSbindings);						
					}
					envInfoNodeListIterator++;
				}
				envInfo = new EnvironmentInfo(serverInfo,jvmInfo,pegaDBinfo,pegaJmsInfo);
			}
			rootChildIterator++;	
		}
		SystemInformation sysInfo = new SystemInformation(prpcInfo, envInfo);
		return (sysInfo);
	}
	
}
