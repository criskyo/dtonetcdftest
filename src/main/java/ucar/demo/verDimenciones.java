package ucar.demo;

import java.io.IOException;
import java.util.List;

import ucar.nc2.Dimension;
import ucar.nc2.NetcdfFile;

public class verDimenciones {
	
	
	public static void main(String[] args) {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		   /***
		    * 
		    * obtener todas las dimensiones de un archivo NetCDF ejecutamos el siguiente fragmento de código:
		    * 
		    */
			  
			  NetcdfFile file = NetcdfFile.open(filename);
			  
			
			  
			  
			  List<Dimension> dims =file.getDimensions();
			  System.out.println("Total de dimensiones: "+dims.size());
			  for (Dimension dim : dims){
			    System.out.println("  Nombre: " + dim.getName() + " ( Tamaño: " + dim.getLength()+")");
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
