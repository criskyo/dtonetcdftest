package ucar.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ucar.ma2.Array;
import ucar.ma2.DataType;
import ucar.ma2.Index;
import ucar.ma2.InvalidRangeException;
import ucar.ma2.Range;
import ucar.nc2.Attribute;
import ucar.nc2.NetcdfFile;
import ucar.nc2.Variable;

public class VerVariablesyAtributos {

	
	public static void main(String[] args)  {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		   
			  
			  NetcdfFile file = NetcdfFile.open(filename);
			  
			
			  
			  
			  List<Variable> vars = file.getVariables();
			  System.out.println("Total de variables "+vars.size());
			  for( Variable var: vars){
				  try {
					
				
			    System.out.print("  Nombre: " + var.getName() + " (Tipo: " + var.getDataType().name() + ", Dimensiones: " + var.getDimensionsString() + ", Tamaño:");
			    int [] size = var.getShape();
			    for(int i=0; i<size.length;++i){
			      System.out.print(" " +size[i]);
			    }
			    System.out.println(")");
			    
			    System.out.println("ranges "+var.getRanges());
			    System.out.println("read "+var.read());
			    
			    /*Variable tmn = var;  //...; //Obtenemos la variable tmn
				// Toma los rangos de las variables, de solo lectura
				List<Range> ranges = var.getRanges();
				// Crea una estructura con los rangos leidos
				ArrayList<Range> newRanges = new ArrayList<Range>();
				newRanges.add(ranges.get(0));
				newRanges.add(ranges.get(1));
				newRanges.add(ranges.get(2));
				// Recorre todos los instantes de tiempo
				for (int tm = 0; tm < 120; ++tm) {
				  // Actualiza el rango de tiempo
				  newRanges.set(0, new Range(tm, tm));
				  // Lee los datos para cada instante de tiempo
				  Array arr = tmn.read(newRanges);
				  // Toma el índice del arreglo de datos
				  Index idx = arr.getIndex();
				  // Recorre todas las longitudes
				  for(int lat = 0; lat < 360; ++lat) {
				    for (int lon = 0; lon < 720; ++lon) {
				      idx.set(0, lat, lon); // tiempo, latitud, longitud
				      double val = arr.getDouble(idx);
				      // PROCESAMOS EL VALOR LEIDO
				      System.out.println("valor "+val);
				    }
				  }
				}*/
			    
			    System.out.println("/*/*/*/*/*/*/*/*/*/");
			    
				  } catch (Exception e) {
						// TODO: handle exception
					}
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
