package org.stockapp.web_services.resources;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.MatrixParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.PathSegment;

@Path("demo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class DemoResource {
	
	/**
	 * MatrixParam annotation:
	 * An alternative to QueryParam.
	 * 
	 * In this case the uri could be like this:
	 * ==> "/demo/annotation;param1=value1;param2=value2"
	 * 
	 * This is more powerful than QueryParam because 
	 * it can be placed in the middle but for that we need
	 * "PathSegment" to get access.	 
	 * 
	 * In that case the uri could be like this:
	 * ==> "/demo/annotation;param1=value1;param2=value2/others;param3=value=3"
	 **/
	@GET
	@Path("annotation")
	public String getMatrixParams(@MatrixParam("param1") String param1, @MatrixParam("param2") String param2) {
		return "the first param is param1 :" + param1 + " and the second is param2: "+ param2;
	}
	
	@GET
	@Path("{var1:annotation}/{var2:others}")
	public String getMatrixParamsInTheMiddle(@PathParam("var1") PathSegment ps1, @PathParam("var2") PathSegment ps2) {
		return "the " +ps1.getPath() + " parameters are " + ps1.getMatrixParameters() 
				+ " and the "+ ps2.getPath() + " parameters are " + ps2.getMatrixParameters();
	}
	
	/**
	 * Get List of Matrix parameters in the uri 
	 **/
	@GET
	@Path("{var:.+}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getListOfMatrixParam(@PathParam("var") List<PathSegment> ps) {
		 String temp = "";
	        for (PathSegment pathSegment : ps) {
	         temp+= String.format("Path: %s, Matrix Params %s<br/>", pathSegment.getPath(),
	                 pathSegment.getMatrixParameters());
	        }

	        String info = String.format("resource testList.<br/> Matrix Param List:<br/> %s<br/>", temp);
	        return info;
	}
	
	
	
	
	
}
