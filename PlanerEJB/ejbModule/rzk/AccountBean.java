package rzk;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.User;

/**
 * Session Bean implementation class AccountBean
 */
@Stateless
@LocalBean
public class AccountBean implements AccountBeanRemote {

	@PersistenceContext
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AccountBean() {
        // TODO Auto-generated constructor stub
    }
    
	

	@Override
	public boolean createAccount(String email, String password, String firstName, String lastName) {
		User user = new User();
		Query existsQuery = em.createNamedQuery("User.findByEmail");
		existsQuery.setParameter("email", email);
		
		if (existsQuery.getResultList().isEmpty()) {
				user.setEmail(email);
				user.setPassword(password);
				user.setFirstName(firstName);
				user.setLastName(lastName);
				em.persist(user);
				return true;
			}
		return false;
	}

}
