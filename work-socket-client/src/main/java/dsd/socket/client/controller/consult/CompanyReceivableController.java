/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller.consult;

import dsd.socket.client.controller.base.BaseCosultController;
import dsd.socket.client.infra.service.CompanyService;
import dsd.socket.client.model.Company;
import dsd.socket.client.view.consult.CompanyReceivableView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class CompanyReceivableController implements BaseCosultController {

    private final CompanyReceivableView view;
    private final CompanyService companyService;

    public CompanyReceivableController() {
        this.view = new CompanyReceivableView();
        this.companyService = new CompanyService();
        initButtons();
    }

    @Override
    public void initButtons() {
        view.addActionBtnSearch(((e) -> {
            actionSeacth();
        }));
    }

    @Override
    public void fillTable() {
        view.clearTable();
        
        Map<Integer, Company> allCompanies = companyService.findAll();
        List<Object[]> values = new ArrayList<>();
        
        for (Map.Entry<Integer, Company> entry : allCompanies.entrySet()) {
            values.add(new Object[]{entry.getValue().getId(),
                entry.getValue().getCnpj(), 
                entry.getValue().getSocialReason(), 
                ((CompanyService) companyService).receivable(entry.getValue().getId())
            });
        }
        try {
            view.fillTable(values);
        } catch (Exception ex) {
            showMessage(ex.getMessage(), "Erro");
        }
        
    }
    
    public void actionRefresh() {
        fillTable();
    }

    public void actionSeacth() {
        view.clearSelection();
        String id = view.getFilter();
        if (!id.isEmpty()) {
            if (!view.searchTable(id)) {
                showMessage("No company was found with the given identifier!", "Company not found");
            }
        } else {
            showMessage("Enter a valid identifier!", "Invalid identifier");
        }
        view.clearSearch();
    }

    public void clearTable() {
        view.clearTable();
    }

    @Override
    public void showFrame() {
        view.showFrame();
        fillTable();
    }

    @Override
    public void closeFrame() {
        view.closeFrame();
    }

    @Override
    public void showMessage(String message, String title) {
        view.showMessage(message, title);
    }

}
