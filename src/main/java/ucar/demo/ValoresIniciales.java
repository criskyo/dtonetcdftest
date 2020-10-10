package ucar.demo;

import java.io.IOException;
import java.util.List;

import ucar.ma2.DataType;
import ucar.nc2.Attribute;
import ucar.nc2.NetcdfFile;

public class ValoresIniciales {
	

	
	public static void main(String[] args) {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		
			  
			  /**
			   * Para acceder a los atributos generales declarados cuando se creó el archivo NetCDF ejecutamos el siguiente fragmento de código
			   */
			  
			  NetcdfFile file = NetcdfFile.open(filename);
			  
			  List<Attribute> attrs = file.getGlobalAttributes();
			  System.out.println("Total de atributos "+attrs.size());
			  for (Attribute attr: attrs){
			    System.out.print("  Nombre: " + attr.getName() + " (Tipo: " + attr.getDataType().name() + ", Valor: ");
			    if(attr.getDataType()==DataType.DOUBLE)
			      System.out.println(attr.getNumericValue()+")");
			    else
			      System.out.println(attr.getStringValue()+")");
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
