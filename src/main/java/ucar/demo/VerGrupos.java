package ucar.demo;

import java.io.IOException;
import java.util.List;

import ucar.nc2.Group;
import ucar.nc2.NetcdfFile;

public class VerGrupos {
	

	
	
	public static void main(String[] args) {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		   
			  /***
			   * 
			   * Para acceder a los grupos de un archivo NetCDF podemos ejecutar el siguiente fragmento de código:
			   */
			  
			  NetcdfFile file = NetcdfFile.open(filename);
			  
			
			  
			  
			  List<Group> groups=file.getRootGroup().getGroups();
			  System.out.println("Total de grupos: "+groups.size());
			  for(Group group : groups){
			    System.out.println("  Nombre: " + group.getNameAndAttributes());
			  }
			  
		    
		    
		  } catch (IOException ioe) {
		    System.out.println("trying to open " + filename+ ioe);
		  } finally { 
		    if (null != ncfile) try {
		      ncfile.close();
		    } catch (IOException ioe) {
		    	System.out.println("trying to close " + filename+ ioe);
		    }
		  }
	}

}
