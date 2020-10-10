package ucar.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ucar.ma2.DataType;
import ucar.nc2.Attribute;
import ucar.nc2.Dimension;
import ucar.nc2.Group;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;
import ucar.nc2.dataset.CoordinateSystem;
import ucar.nc2.dataset.NetcdfDataset;
 

public class ReadNetcdf {
	
	
	
	
	
	public static void main(String[] args) {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		   /* ncfile = NetcdfFile.open(filename);
		    System.out.println("dimensions "+ncfile.getDimensions() );
		    System.out.println("atrubutes "+ncfile.getGlobalAttributes() );
		    System.out.println("filetype "+ncfile.getFileTypeVersion() );
		    System.out.println("id "+ncfile.getId() );
		    System.out.println("location "+ncfile.getLocation() );
		    System.out.println("title "+ncfile.getTitle() );
		    System.out.println("variables "+ncfile.getVariables() );
		    System.out.println("fioletypeid "+ncfile.getFileTypeId() );
		    System.out.println("detaillinfo"+ncfile.getDetailInfo() );
		    System.out.println("cachenames "+ncfile.getCacheName() );*/
/*
		 // Abre el archivo NetCDF
		    NetcdfFile file = NetcdfFile.open(filename);
		    NetcdfDataset fileDataSet = new NetcdfDataset(file);

		    // Inicializa las estructuras para almacenar los ejes coordenados
		   // datas = new ArrayList<CoordinateSystem>();

		    // Obtiene todos los sistemas de coordenadas
		    List<CoordinateSystem> coordSystems = fileDataSet.getCoordinateSystems();
		    
		    System.out.println("coordSystems " +coordSystems.toString());
		    */
			  
			  NetcdfFile file = NetcdfFile.open(filename);
			  
			// Obtenemos todas las variables del archivo NetCDF
			 // List<Variable> vars = file.getVariables();
			  
			 // System.out.println("variables "+ vars.toString());
			// Recorre todas las variables para encontrar las asociadas al sistema de coordenadas
			 /* for (Variable var : vars) {
			    // Verifica si la variable está asociada al sistema de coordenadas                
			    if (System.isCoordinateSystemFor(var)) {
			      System.out.println();
			    }
			  }*/
			  
			  
			  List<Variable> vars = file.getVariables();
			  System.out.println("Total de variables "+vars.size());
			  for( Variable var: vars){
			    System.out.print("  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:");
			    int [] size = var.getShape();
			    for(int i=0; i<size.length;++i){
			      System.out.print(" " +size[i]);
			    }
			    System.out.println(")");
			    
			    List<Attribute> attrs = var.getAttributes();
				  System.out.println("Total de atributos "+attrs.size());
				  for (Attribute attr: attrs){
				    System.out.print("  Nombre: " + attr.getName() + " (Tipo: " + attr.getDataType().name() + ", Valor: ");
				    if(attr.getDataType()==DataType.DOUBLE)
				      System.out.println(attr.getNumericValue()+")");
				    else
				      System.out.println(attr.getStringValue()+")");
				  }
			    
			    System.out.println("/*/*/*/*/*/*/*/*/*/");
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
