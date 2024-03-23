package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.domain.Customer;
import dsd.socket.protocol.Method;
import dsd.socket.request.RequestHandlerService;
import jakarta.validation.ConstraintViolationException;

import java.util.List;
import java.util.Optional;

public class CompanyService extends RequestHandlerService {

    private final DAO<Company, Integer> dao;

    public CompanyService(DAO<Company, Integer> dao) {
        this.dao = dao;
    }


    @Override
    public void get(String request) {
        Integer id = Integer.parseInt(extractIdFromRequest(request));

        List<Company> companies = dao.findAll();

        if(companies.isEmpty()) {
            setResponse(new String("Sem empresas cadastradas."));
        }

        Optional<Company> company = companies.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if(company.isEmpty()) {
            setResponse(new String("Empresa não encontrada."));
            return;
        }

        setResponse(company.get().toString());
    }

    @Override
    public void list(String request) {
        List<Company> companies = dao.findAll();

        if(companies.isEmpty()) {
            setResponse(0);
            return;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(companies.size());
        companies.forEach(company -> builder.append(company.toString()));

        setResponse(builder.toString());
    }

    @Override
    public void insert(String request) {
        String requestData[] = request.split(";");

        String cnpj = requestData[2];
        String socialReason = requestData[3];
        Integer foundedIn = Integer.parseInt(requestData[4]);

        Company newCompany = new Company(null, cnpj, socialReason, foundedIn, null);

        try {
            dao.insert(newCompany);
            setResponse(newCompany);
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
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
        Integer id = Integer.parseInt(extractIdFromRequest(request));

        List<Company> companies = dao.findAll();

        if(companies.isEmpty()) {
            setResponse(new String("Sem empresas cadastradas."));
        }

        Optional<Company> company = companies.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if(company.isEmpty()) {
            setResponse(new String("Empresa não encontrada."));
            return;
        }

        try {
            dao.delete(company.get().getId());
            setResponse("Empresa removida com sucesso.");
        } catch (Exception ex) {
            setResponse(ex.getMessage());
        }
    }
}
