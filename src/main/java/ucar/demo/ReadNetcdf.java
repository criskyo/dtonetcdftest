package ucar.demo;

import java.io.IOException;

import ucar.nc2.NetcdfFile;
 

public class ReadNetcdf {
	
	
	
	
	
	public static void main(String[] args) {
		String filename = "/home/bg-d-cortiz/Descargas/outN.1";
		  NetcdfFile ncfile = null;
		  try {
		    ncfile = NetcdfFile.open(filename);
		    System.out.println("dimensions "+ncfile.getDimensions() );
		    System.out.println("atrubutes "+ncfile.getGlobalAttributes() );
		    System.out.println("filetype "+ncfile.getFileTypeVersion() );
		    System.out.println("id "+ncfile.getId() );
		    System.out.println("location "+ncfile.getLocation() );
		    System.out.println("title "+ncfile.getTitle() );
		    System.out.println("variables "+ncfile.getVariables() );
		    System.out.println("fioletypeid "+ncfile.getFileTypeId() );
		    System.out.println("detaillinfo"+ncfile.getDetailInfo() );
		    System.out.println("cachenames "+ncfile.getCacheName() );
		    ncfile.getDetailInfo(f.(elevationAngle), randomin,ranmax );
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
