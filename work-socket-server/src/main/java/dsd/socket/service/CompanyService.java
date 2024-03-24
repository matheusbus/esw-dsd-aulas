package dsd.socket.service;

import dsd.socket.dao.DAO;
import dsd.socket.domain.Company;
import dsd.socket.protocol.CompanyMethod;
import dsd.socket.request.RequestHandlerService;

import java.util.List;
import java.util.Optional;

public class CompanyService extends RequestHandlerService {

    private final DAO<Company, Integer> dao;

    public CompanyService(DAO<Company, Integer> dao) {
        this.dao = dao;
    }

    @Override
    protected void handleRequest(String methodStr, String request) {
        CompanyMethod method = CompanyMethod.fromString(methodStr);

        switch (method) {
            case GET:
                get(request);
                break;
            case LIST:
                list(request);
                break;
            case INSERT:
                insert(request);
                break;
            case UPDATE:
                update(request);
                break;
            case DELETE:
                delete(request);
                break;
            case PAYROLL:
                calculatePayRoll(request);
                break;
        }
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
        companies.forEach(company -> builder.append(company.toString() + ","));

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
            dao.beginTrans();
            dao.insert(newCompany);
            dao.commitTrans();

            setResponse(newCompany);
        } catch (Exception ex) {
            dao.rollback();
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

        try {
            dao.beginTrans();
            dao.update(companyToUpdate);
            dao.commitTrans();
            setResponse(companyToUpdate.toString());
        } catch (Exception ex) {
            dao.rollback();
            setResponse(ex.getMessage());
        }
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
            dao.beginTrans();
            dao.delete(company.get().getId());
            dao.commitTrans();
            setResponse("Empresa removida com sucesso.");
        } catch (Exception ex) {
            dao.rollback();
            setResponse(ex.getMessage());
        }
    }

    public void calculatePayRoll(String request) {
        Integer id = Integer.parseInt(extractIdFromRequest(request));

        Company company = dao.find(id);

        if(company == null) {
            setResponse(new String("Empresa não encontrada."));
            return;
        }

        double payRoll = company.calculatePayRoll();
        setResponse(payRoll);
    }
}
