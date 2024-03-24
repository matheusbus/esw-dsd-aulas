/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsd.socket.client.controller;

import dsd.socket.client.controller.base.BaseCosultController;
import dsd.socket.client.infra.service.CompanyService;
import dsd.socket.client.model.Company;
import dsd.socket.client.view.consult.CompanyConsultView;

/**
 *
 * @author Matheus
 */
public final class CompanyConsultController implements BaseCosultController {

    private final CompanyConsultView view;
    private final Company companySelected;
    private final CompanyService companyService;

    public CompanyConsultController() {
        this.view = new CompanyConsultView();
        this.companySelected = null;
        this.companyService = new CompanyService();
        initButtons();
        setBtnSelect(false);
    }

    @Override
    public void initButtons() {
        view.addActionBtnRegister(((e) -> {
            actionRegister();
        }));
        view.addActionBtnSearch(((e) -> {
            actionSeacth();
        }));
        view.addActionBtnSelect(((e) -> {
            actionSelect();
        }));
        view.addActionBtnUpdate(((e) -> {
            actionUpdate();
        }));
        view.addActionBtnRemove(((e) -> {
            actionRemove();
        }));
    }

    @Override
    public void fillTable() {
        view.clearTable();
        
        try {
            view.fillTable(companyService.findAll());
        } catch (Exception ex) {
            showMessage(ex.getMessage(), "Erro");
        }
        
    }

    public void actionSeacth() {
        view.clearSelection();
        String id = view.getFilter();
        if (!id.isEmpty()) {
            if (view.searchTable(id)) {
                showMessage("Success!", "Success");
            } else {
                showMessage("No company was found with the given identifier!", "Company not found");
            }
        } else {
            showMessage("Enter a valid identifier!", "Invalid identifier");
        }
    }

    public void actionRegister() {
        CompanyRegisterController companyRegisterController = new CompanyRegisterController();
        companyRegisterController.showFrame();
    }

    public void actionUpdate() {
        try {
            String id = view.getIdTableRecord();
            
            
            
            //Company company = (Company) repository.getById(id);
            //CadastroCarroController cadastroCarroController = new CadastroCarroController(new CadastroCarroView(), carro, this);
            //cadastroCarroController.exibirTela();
        } catch (Exception e) {
            showMessage("No records were selected.", "Error");
        }
    }

    public void actionSelect() {
        String id = view.getIdTableRecord();
        //cadastroVendaController.setVeiculo(veiculoRepositorio.buscarVeiculo(sPlaca));
        //cadastroVendaController.populaListaVeiculo();
        closeFrame();
    }

    public void actionRemove() {
        try {
            if (0 == view.question("Are you sure you want to delete the selected record?", "Deletion confirmation")) {
                
                // enviar requisicao para delete
                
                //pessoasRepositorio.removerPessoa(ConsultaFuncionariosView.getCPFTabelaRegistro());
                fillTable();
                showMessage("Registration successfully removed", "Success");
            }
        } catch (Exception e) {
            showMessage("No records were selected.", "Error");
        }
    }

    public void clearTable() {
        view.clearTable();
    }

    public void setBtnSelect(Boolean bool) {
        view.setBtnSelect(bool);
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
