package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.protocol.Method;
import dsd.socket.request.RequestHandlerService;

import java.util.List;

public class CompanyService extends RequestHandlerService {

    private final DAO<Company, Integer> dao;
    private Object response;

    public CompanyService(DAO<Company, Integer> dao) {
        this.dao = dao;
    }


    @Override
    public void get(String request) {
        String requestData[] = request.split(";");

        Company company = dao.find(Integer.parseInt(requestData[2]));
        setResponse(company.toString());
    }

    @Override
    public void list(String request) {
        List<Company> companies = dao.findAll();
        setResponse(companies.stream().toString());
    }

    @Override
    public void insert(String request) {
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

    @Override
    public void update(String request) {
        String requestData[] = request.split(";");

        Company companyToUpdate = dao.find(Integer.parseInt(requestData[2]));
        if(companyToUpdate == null) {
            setResponse("Company was not found.");
            return;
        }

        String cnpj = requestData[3];
        String socialReason = requestData[4];
        Integer foundedIn = Integer.parseInt(requestData[5]);

        companyToUpdate.setCnpj(cnpj);
        companyToUpdate.setSocialReason(socialReason);
        companyToUpdate.setFoundedIn(foundedIn);

        dao.update(companyToUpdate);
        setResponse(companyToUpdate.toString());
    }

    @Override
    public void delete(String request) {
        String requestData[] = request.split(";");

        Company companyToDelete = dao.find(Integer.parseInt(requestData[2]));
        if(companyToDelete == null) {
            setResponse("Company was not found.");
            return;
        }

        dao.delete(companyToDelete.getId());
        setResponse("Company deleted successfully!");
    }

    @Override
    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
