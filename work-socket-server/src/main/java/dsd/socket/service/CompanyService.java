package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.protocol.CompanyMethod;
import dsd.socket.request.RequestHandlerService;

public class CompanyService implements RequestHandlerService {

    private final DAO<Company, Integer> dao;
    private Object response;

    public CompanyService(DAO<Company, Integer> dao) {
        this.dao = dao;
    }

    @Override
    public void handleRequest(String methodStr, String request) {
        CompanyMethod method = CompanyMethod.fromString(methodStr);

        // VAI CHAMAR OS MÉTODOS PARA CADA TIPO DE MÉTODO
        switch (method) {
            case GET:
                findById(request);
                break;
            case LIST:
                list();
                break;
            case INSERT:
                createCompany(request);
                break;
            case UPDATE:
                break;
            case DELETE:
                break;
            case HIRE:
                break;
        }
    }

    private void createCompany(String request) {
        String requestData[] = request.split(";");

        String cnpj = requestData[2];
        String socialReason = requestData[3];
        Integer foundedIn = Integer.parseInt(requestData[4]);

        Company newCompany = Company.builder()
                .id(null)
                .cnpj(cnpj)
                .socialReason(socialReason)
                .foundedIn(foundedIn)
                .build();

        dao.insert(newCompany);
        setResponse(newCompany);
    }

    private void list() {

    }

    private void findById(String request) {
        String requestData[] = request.split(";");

        Company company = dao.find(Integer.parseInt(requestData[2]));
        setResponse(company);
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
