package SystemComparatorProject.SysPropsComp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

@SpringBootApplication
@RestController
public class SysPropsCompApplication {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		SpringApplication.run(SysPropsCompApplication.class, args);	
	}
	
	@RequestMapping(value = "/compareSystemProperties", method = RequestMethod.POST)
	public @ResponseBody String[] compareSystemProperties(@RequestBody XMLData fileData) throws ParserConfigurationException, SAXException, IOException{
		String fd1= (fileData.getFileData1());
		String fd2= (fileData.getFileData2());
		String fd3= (fileData.getFileData3());
		ObjectConstructor c = new ObjectConstructor();
		SystemInformation array[] = new SystemInformation[3];
		array[0] = c.XMLStringReader(fd1);
		array[1] = c.XMLStringReader(fd2);
		array[2] = c.XMLStringReader(fd3);
		SystemInformationDifferentiator differentiator = new SystemInformationDifferentiator();
		differentiator.differentiate(array);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		String jsonObject1 = mapper.writeValueAsString(array[0]);
		String jsonObject2 = mapper.writeValueAsString(array[1]);
		String jsonObject3 = mapper.writeValueAsString(array[2]);
		System.out.println(jsonObject1);
		System.out.println(jsonObject2);
		System.out.println(jsonObject3);
		String [] results = {jsonObject1,jsonObject2,jsonObject3};
		return results;
	}
	
	@RequestMapping(value = "/compareSystemPropertiesUsingString", method = RequestMethod.POST)
	public @ResponseBody String[] compareSystemPropertiesUsingString(@RequestBody XMLData fileData) throws ParserConfigurationException, SAXException, IOException{
		String allFiles = fileData.getFileData1();
		String eachFile[] = allFiles.split("#####");
		System.out.println("Files split by ####");
		ObjectConstructor c = new ObjectConstructor();
		SystemInformation array[] = new SystemInformation[eachFile.length];
		System.out.println("Removing top 2 lines from eachfile.");
		for(int i=0;i<eachFile.length;i++){
			System.out.println(eachFile[i]);
			eachFile[i]= eachFile[i].substring(eachFile[i].indexOf(System.getProperty("line.separator"))+1); // removing the first 2 lines.
			eachFile[i]= eachFile[i].substring(eachFile[i].indexOf(System.getProperty("line.separator"))+1);
			//System.out.println("&&&&&&&&&&&&&&&&&&&&&& " + i);
			//System.out.println(eachFile[i]);
			
			
			array[i] = c.XMLStringReader(eachFile[i]);
			array[i].toString();
		}
		SystemInformationDifferentiator differentiator = new SystemInformationDifferentiator();
		differentiator.differentiate(array);
		ObjectMapper mapper = new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		String jsonObject[] = new String[eachFile.length];
		for(int i=0;i<eachFile.length;i++){
			jsonObject[i]=mapper.writeValueAsString(array[i]);
			System.out.println("Results");
			System.out.println(jsonObject[i]);
		}
		return jsonObject;
	}
}
