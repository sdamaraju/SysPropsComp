package SystemComparatorProject.SysPropsComp;

public class SystemInformationDifferentiator {
	//Colors 0=Black 1=Blue 2=Green 3=Yellow
	public SystemInformation[] differentiate (SystemInformation [] allEnvironments){
		int temp = allEnvironments.length;
		int [] colors = new int[temp];
		for(int i=0;i<colors.length;i++){
			colors[i]=i;
		}
		for(int i=0;i<temp;i++){
				for(int j=i+1;j<temp;j++){
					allEnvironments[i].diff(allEnvironments[j],colors[i],colors[j]);
				}
		}
		return allEnvironments;
	}
}
