package rzk;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Event;
import model.EventType;
import model.User;


/**
 * Session Bean implementation class EventTypeBean
 */
@Singleton
@LocalBean
public class EventTypeBean implements EventTypeBeanLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;

	
	HashMap<Integer, EventType> types;
	
    public EventTypeBean() {
    	types = new HashMap<Integer, EventType>();
    }
    
    public List<EventType> getTypes(){
    	return populateTypes();
    }
    
    public EventType getEventTypeById(int id) {
    	return types.get(id);
    }
    
    private List<EventType> populateTypes() {
    		Query q = em.createNamedQuery("EventType.findAll");
    		List<EventType> eventTypes = q.getResultList();
    		for (EventType et : eventTypes) {
    			types.put(et.getId(), et);
    		}
    		System.out.println(eventTypes.size());
    		try {
    			return eventTypes;
    		}catch (Exception e) {
    			e.printStackTrace();
    		}
    		return null;
    	}
    

}
