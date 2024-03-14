/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sds.socket.server.request;

import sds.socket.server.dao.factory.DAOFactory;
import sds.socket.server.dao.factory.JpaDAOFactory;
import sds.socket.server.protocol.Subject;
import sds.socket.server.service.CompanyService;
import sds.socket.server.service.CustomerService;
import sds.socket.server.service.EmployeeService;

/**
 *
 * @author matheus.buschermoehl
 */
public class RequestHandler {
    
    private static RequestHandler instance;
    private static DAOFactory daoFactory;
    
    private static CompanyService companyService;
    private static CustomerService customerService;
    private static EmployeeService employeeService;
    
    private String response;
    
    static {
        daoFactory = new JpaDAOFactory();
    }
    
    public RequestHandler getInstance() {
        if(instance == null) {
            instance = new RequestHandler();
        }
        return instance;
    }
    
    private RequestHandler() {
        companyService = new CompanyService(
                daoFactory.createCompanyDAO()
        );
        
        customerService = new CustomerService(
                daoFactory.createCustomerDAO()
        );
        
        employeeService = new EmployeeService(
                daoFactory.createEmployeeDAO()
        );
        this.response = "";
    }
    
    public void handleRequest(String request) {
        Subject subject = extractSubjectFromRequest(request);
        
        switch (subject) {
            case COMPANY:
                handleCompanyRequest(request);
                break;
            case CUSTOMER:
                handleCustomerRequest(request);
                break;
            case EMPLOYEE:
                handleEmployeeRequest(request);
                break;
            default:
                throw new RequestHandlerException("Error: subject does not exists.");
        }
    }
    
    public void handleCompanyRequest(String request) {
        
    }
    
    public void handleCustomerRequest(String request) {
        
    }
    
    public void handleEmployeeRequest(String request) {
        
    }
    
    public Subject extractSubjectFromRequest(String request) {
        return Subject.fromString(request.split(";")[0]);
    }
    
    public void clearResponse() {
        this.response = "";
    }
    
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String getAndClearResponse() {
        String r = this.response;
        clearResponse();
        return r;
    }
    
    
    
}
