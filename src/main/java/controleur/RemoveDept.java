package controleur;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class RemoveDept
 */
@WebServlet("/RemoveDept")
public class RemoveDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RemoveDept() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptNum = request.getParameter("dept-num");
		String deptName = request.getParameter("dept-nom");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String deptNum = request.getParameter("dept-num");
		String deptName = request.getParameter("dept-nom");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction txn = em.getTransaction();

		try {
			txn.begin();
			// Recherche de l'entité à supprimer dans la base de données en utilisant le nom
			// et le numéro
			javax.persistence.Query query = em
					.createQuery("SELECT d FROM DeptPair d WHERE d.deptNum = :deptNum AND d.deptName = :deptName");
			query.setParameter("deptNum", deptNum);
			query.setParameter("deptName", deptName);

			DeptPair deptPairKey = new DeptPair(deptNum, deptName);
			request.setAttribute("key", deptPairKey);

			List<DeptPair> deptPairs = query.getResultList();
			String address = "";

			if (!deptPairs.isEmpty()) {
				// Suppression de l'entité en utilisant remove() pour chaque élément trouvé (il
				// peut y en avoir plusieurs avec le même nom et numéro)
				for (DeptPair deptPair : deptPairs) {
					em.remove(deptPair);
					address = "/WEB-INF/results/show-departement.jsp";
				}
				System.out.println("Data removed from DB");
				System.out.println("Num de département = " + deptNum);
				System.out.println("Nom de département = " + deptName);
			} else {
				System.out.println("Data not found in the DB. Nothing to remove.");
				System.out.println("Num de département = " + deptNum);
				System.out.println("Nom de département = " + deptName);
				address = "/WEB-INF/results/no-correspondance.jsp";
			}

			request.getRequestDispatcher(address).forward(request, response);

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

	}
}