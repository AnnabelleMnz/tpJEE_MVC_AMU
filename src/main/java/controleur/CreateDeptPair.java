package controleur;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.DeptPair;
import service.DeptNumService;
import service.NumDeptMapper;

@WebServlet("/CreateDeptPair")
public class CreateDeptPair extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CreateDeptPair() {
		super();
	}

	private DeptNumService deptNumMapper = new NumDeptMapper();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// retrieving dept-num name value send by POST form request
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
			address = "/WEB-INF/results/unknown-num.jsp";
		}

		request.getRequestDispatcher(address).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptNum = request.getParameter("dept-num");
		String deptName = request.getParameter("dept-nom");

		System.out.println("Num de département = " + deptNum);
		System.out.println("Num de département = " + deptName);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		// retrieving dept-num name value send by POST form request

		System.out.println("Before persist condition");
		if (deptNum != "" || deptName != "") {
			try {
				txn.begin();

				DeptPair deptPair = new DeptPair(deptNum, deptName);
				em.persist(deptPair);

				txn.commit();
			} catch (Exception e) {
				if (txn != null) {
					txn.rollback();
				}
				e.printStackTrace();
			} finally {
				if (em != null) {
					em.close();
				}
				if (emf != null) {
					emf.close();
				}
			}

			System.out.println("Data persisted to DB");
			System.out.println("Num de département = " + deptNum);
			System.out.println("Num de département = " + deptName);
		} else {
			System.out.println("data not persisted to the DB");
			System.out.println("Num de département = " + deptNum);
			System.out.println("Num de département = " + deptName);
		}

	}
}