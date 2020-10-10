package ucar.demo;

import java.io.IOException;
import java.util.List;

import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class VerVariables {
	
	public static void main(String[] args) {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		  
			  
			  NetcdfFile file = NetcdfFile.open(filename);
			 
			  
			  
			  List<Variable> vars = file.getVariables();
			  System.out.println("Total de variables "+vars.size());
			  for( Variable var: vars){
			    System.out.print("  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:");
			    int [] size = var.getShape();
			    for(int i=0; i<size.length;++i){
			      System.out.print(" " +size[i]);
			    }
			    System.out.println(")");
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
