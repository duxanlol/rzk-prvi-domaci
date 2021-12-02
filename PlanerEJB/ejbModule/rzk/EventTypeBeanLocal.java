package rzk;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;
import model.EventType;
@Local
public interface EventTypeBeanLocal {

	
	public List<EventType> getTypes();
	
	
}
