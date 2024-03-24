package dsd.socket.request;

import dsd.socket.dao.factory.DAOFactory;
import dsd.socket.dao.factory.JpaDAOFactory;
import dsd.socket.protocol.Subject;
import dsd.socket.service.CompanyService;
import dsd.socket.service.CustomerService;
import dsd.socket.service.EmployeeService;

/**
 *
 * @author matheus.buschermoehl
 */
public class RequestHandler {
    
    private static RequestHandler instance;
    private static DAOFactory daoFactory;
    private RequestHandlerService companyService;
    private RequestHandlerService customerService;
    private RequestHandlerService employeeService;
    private Object response;
    
    static {
        daoFactory = new JpaDAOFactory();
    }
    
    public static RequestHandler getInstance() {
        if(instance == null) {
            instance = new RequestHandler();
        }
        return instance;
    }
    
    private RequestHandler() {
        this.companyService = new CompanyService(daoFactory.createCompanyDAO());
        this.customerService = new CustomerService(daoFactory.createCustomerDAO(), daoFactory.createCompanyDAO());
        this.employeeService = new EmployeeService(daoFactory.createEmployeeDAO(), daoFactory.createCompanyDAO());
        this.response = null;
    }
    
    public Object handleRequest(String request){
        try {
            if(request.isBlank()) {
                throw new RequestHandlerException("Request is null. Server can't proceed.");
            }
            Subject subject = extractSubjectFromRequest(request);
            String methodStr = extractStringMethodFromRequest(request);

            switch (subject) {
                case COMPANY:
                    companyService.handleRequest(methodStr, request);
                    setResponse(companyService.getResponse());
                    break;
                case CUSTOMER:
                    customerService.handleRequest(methodStr, request);
                    setResponse(customerService.getResponse());
                    break;
                case EMPLOYEE:
                    employeeService.handleRequest(methodStr, request);
                    setResponse(employeeService.getResponse());
                    break;
                default:
                    throw new RequestHandlerException("Error: subject does not exists.");
            }
        } catch (RequestHandlerException ex) {
            setResponse(ex.getMessage());
        }
        return response;
    }

    private Subject extractSubjectFromRequest(String request) {
        return Subject.fromString(request.split(";")[0]);
    }

    private String extractStringMethodFromRequest(String request) {
        return request.split(";")[1];
    }
    
    public void clearResponse() {
        this.response = "";
    }
    
    public void setResponse(Object response) {
        this.response = response;
    }
    
    public Object getAndClearResponse() {
        Object o = this.response;
        clearResponse();
        return o;
    }
    
    
    
}
