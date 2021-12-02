package rzk;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Event;
import model.EventType;
import model.User;

/**
 * Session Bean implementation class PlanerBean
 */
@Stateful
@LocalBean
public class PlanerBean implements PlanerBeanRemote {

	int userId;
	User user;

	@PersistenceContext
	EntityManager em;

	@EJB
	private EventTypeBean etb;

	/**
	 * Default constructor.
	 */
	public PlanerBean() {
	}

	@Override
	public String login(String username, String password) {
		Query q = em.createQuery("SELECT u FROM User u WHERE u.email LIKE :user AND u.password LIKE :pass");
		q.setParameter("user", username);
		q.setParameter("pass", password);
		List<User> users = q.getResultList();
		System.out.println(users.size());
		if (!users.isEmpty()) {
			try {

				user = users.get(0);
				userId = users.get(0).getId();

				return users.get(0).getEmail();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return "";
	}

	@Override
	public List<EventType> getTypes() {
		System.out.println("PRINTING TYPES!!!!!!!");
		System.out.println(etb.getTypes());
		return etb.getTypes();
	}

	@Override
	public boolean createEvent(String description, java.util.Date fromDate, java.util.Date toDate,
			Integer eventTypeID) {

		if (!description.isBlank() && fromDate != null && toDate != null && eventTypeID != null) {
			EventType eventType = etb.getEventTypeById(eventTypeID);
			if (eventType != null) {
				try {
					Event event = new Event();
					event.setDescription(description);
					event.setEventType(eventType);
					event.setFromDate(fromDate);
					event.setToDate(toDate);
					event.setUser(user);
					em.persist(event);
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}

		}
		return false;
	}

	public List<Event> searchEvents(Date fromDate) {
		Query eventsQuery = em.createNamedQuery("Event.findByDateAndUser");
		eventsQuery.setParameter("fromDate", fromDate);
		eventsQuery.setParameter("userID", this.user.getId());
		List<Event> events = eventsQuery.getResultList();

		System.out.println("Trazio evente, ima ih " + events.size());
		System.out.println("UserID je " + user.getId());
		return events;

	}
	
	@Remove 
	public void destory() {
		System.out.println("Destroying.");
	}


}
