package example.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldServlet
 */
public class HelloWorldServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init() {
    	System.out.println("Inside init()");
    }
    
    @Override
    public void destroy() {
    	System.out.println("Inside destroy()");
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// When client makes a request to this servlet, this method will get called
		
		response.setContentType("text/html");//Setting the MIME type as HTML
		//obtaining the writer associated with 'response' to send the response
		
		PrintWriter out=response.getWriter();
		out.println("<body bgcolor=purple><h1 style='color:red;font-size:80px;text-align:center;'>Hello World from Rohan</h1>");
	}

}
