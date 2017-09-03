package com.RestWS.params;

import java.io.File;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/users")
public class UserRestService {

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/param/{id}")
	public Response getUserById(@PathParam("id") String id) {

		return Response.status(200).entity("getUserById is called, id : " + id)
				.build();

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/param/{year}/{month}/{day}")
	public Response getUserHistory(@PathParam("year") int year,
			@PathParam("month") int month, @PathParam("day") int day) {

		String date = year + "/" + month + "/" + day;

		return Response.status(200)
				.entity("getUserHistory is called, year/month/day : " + date)
				.build();

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/param/query")
	public Response getUsers(@QueryParam("from") String from,
			@QueryParam("to") String to,
			@QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("/param/defaultquery")
	public Response getUsers1(
			@DefaultValue("Default Gaurav") @QueryParam("from") String from,
			@DefaultValue("Default Gaurav") @QueryParam("to") String to,
			@DefaultValue("Name Garg") @QueryParam("orderBy") List<String> orderBy) {

		return Response
				.status(200)
				.entity("getUsers is called, from : " + from + ", to : " + to
						+ ", orderBy" + orderBy.toString()).build();

	}

	@GET
	@Path("/param/Matrix/{year}")
	public Response getBooks(@PathParam("year") String year,
			@MatrixParam("author") String author,
			@MatrixParam("country") String country) {

		return Response
				.status(200)
				.entity("getBooks is called, year : " + year + ", author : "
						+ author + ", country : " + country).build();

	}

	@POST
	@Path("/param/add")
	public Response addUser(@FormParam("name") String name,
			@FormParam("age") int age) {

		return Response.status(200)
				.entity("addUser is called, name : " + name + ", age : " + age)
				.build();

	}

	// @HeaderParam Example
	@GET
	@Path("/httpheader/get")
	public Response addUser(@HeaderParam("user-agent") String userAgent) {

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent).build();

	}

	// @Context Example
	@GET
	@Path("/httpheader1/get")
	public Response addUser(@Context HttpHeaders headers) {

		String userAgent = headers.getRequestHeader("user-agent").get(0);

		return Response.status(200)
				.entity("addUser is called, userAgent : " + userAgent).build();

	}

	// Download Image example
	private static final String IMAGE_FILE_PATH = "D:\\Snaps\\17 sep 08\\DSC06799.jpg";

	@GET
	@Path("/media/image")
	@Produces("image/jpeg")
	public Response getImageFile() {

		File file = new File(IMAGE_FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=image_from_server.jpeg");
		return response.build();

	}

	// Download TEXT example
	
	private static final String TEXT_FILE_PATH = "D:\\Softwares\\jd-gui-0.3.5.windows\\readme.txt";

	@GET
	@Path("/media/text")
	@Produces("text/plain")
	public Response getTextFile() {

		File file = new File(TEXT_FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		//response.header("Content-Disposition",
			//	"attachment; filename=\"file_from_server.xml\"");
		response.header("Content-Disposition",
			"attachment; filename=Login Data");
		return response.build();

	}

	// Download PDF example
	private static final String PDF_FILE_PATH = "C:\\Users\\Gaurav\\Downloads\\INFOSYS_2012-2013.pdf";

	@GET
	@Path("/media/PDF")
	@Produces("application/pdf")
	public Response getPDFFile() {

		File file = new File(PDF_FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=KBB_from_server.pdf");
		return response.build();

	}

	// Download Excel example
	private static final String Excel_FILE_PATH = "C:\\Users\\Gaurav\\Downloads\\122182 _ Prepay _ Apr-15.xlsx";

	@GET
	@Path("/media/Excel")
	@Produces("application/vnd.ms-excel")
	public Response getExcelFile() {

		File file = new File(Excel_FILE_PATH);

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
				"attachment; filename=new-excel-file.xlsx");
		return response.build();

	}

}