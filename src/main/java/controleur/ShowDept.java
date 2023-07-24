package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.DeptPair;
import service.DeptNumService;
import service.NumDeptMapper;

@WebServlet("/ShowDept")
public class ShowDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DeptNumService deptNumMapper;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// retrieving dept-num name value send by GET form request
		String deptNum = request.getParameter("dept-num");

		// retrieving deptName from deptArray
		NumDeptMapper deptMapper = new NumDeptMapper();
		String associatedDeptName = deptMapper.findDept(deptNum);
		System.out.println("deptMapperResult = " + associatedDeptName);

		// setting deptPair values and passing data to result.jsp view template
		System.out.println("Num de département = " + deptNum);
		DeptPair deptPair = new DeptPair(deptNum, associatedDeptName);
		request.setAttribute("key", deptPair);

		// managing errors
		String address = "";
		if (deptNum == "") {
			address = "/WEB-INF/results/missing-num.jsp";
		} else if (associatedDeptName != null) {
			address = "/WEB-INF/results/show-departement.jsp";
		} else {
			address = "/WEB-INF/results/missing-num.jsp";
		}

		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}
