package mainpackage.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;
import mainpackage.customer.PermCustomer;
import mainpackage.tasks.Task1;

@Component
public class NamedParamJdbcDaoImpl extends NamedParameterJdbcDaoSupport {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private PermCustomer permCustomer;
	
	public void displayPermanentCustomer() {
		permCustomer.initializeREPNUMFromDatabase(dataSource);
    	System.out.println("Permanent customer "+permCustomer.getNameAndSurname()+" with report number "+permCustomer.getREPNUM()+" has this report:");
    	permCustomer.incrementREPNUM();
        permCustomer.updateREPNUMInDatabase(dataSource);
        Task1.displayAnalytics(permCustomer);
    }
	
}
