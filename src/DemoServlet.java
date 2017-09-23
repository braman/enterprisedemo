import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {
    
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		System.out.println("Running init inside DemoServlet only once!");
    }

	@Override 
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String name = req.getParameter("name");
        System.out.println("name is : " + name);
    }

	@Override
	public void destroy() {
		super.destroy();
		
		System.out.println("Calling destroy method of DemoServlet only in the end!");
	}
	
	
}
