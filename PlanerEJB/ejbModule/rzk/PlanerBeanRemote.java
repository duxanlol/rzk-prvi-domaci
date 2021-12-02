package rzk;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;

import model.Event;
import model.EventType;
@Remote
public interface PlanerBeanRemote {

	public String login(String username, String password);
	public List<EventType> getTypes();
	boolean createEvent(String description, java.util.Date fromDate, java.util.Date toDate, Integer eventTypeID);
	public List<Event> searchEvents(Date fromDate);
	void destory();
}
