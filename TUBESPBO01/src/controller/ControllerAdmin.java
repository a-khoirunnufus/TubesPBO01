/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import view.GUIAdmin;
/**
 *
 * @author Lenovo
 */
public class ControllerAdmin {
    private Application model;
    private GUIAdmin viewAdm;
    
    public ControllerAdmin(Application model, GUIAdmin viewAdm){
        this.viewAdm = viewAdm;
        this.model = model;
        viewAdm.getTfIdTG().setText("TG-"+TourGuide.getSidTG());
    }
    
    public void inputTG(){
        model.inputTourGuide(new TourGuide(viewAdm.getTfNamaTG().getText(),viewAdm.getRbJKTG(),viewAdm.getTfUmurTG().getText(),viewAdm.getTfAlamatTG().getText(),viewAdm.getTfKontakTG().getText()));
        System.out.println("jumlah tg : "+model.getDaftarTG().size());
        model.viewTourGuide();
        JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Ditambahkan!");
        viewAdm.resetViewTG();
        viewAdm.updateTableTG();
    }
    
    public void updateViewCs(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewCs().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[6];
        for(int j = 0; j<model.getDaftarCs().size(); j++){
            row[0] = model.getDaftarCs().get(j).getId();
            row[1] = model.getDaftarCs().get(j).getNama();
            row[2] = model.getDaftarCs().get(j).getJenisKelamin();
            row[3] = model.getDaftarCs().get(j).getUmur();
            row[4] = model.getDaftarCs().get(j).getAlamat();
            row[5] = model.getDaftarCs().get(j).getKontak();
            tbModel.addRow(row);           
        }
    }
    
    public void updateViewRP(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewRP().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[6];
        
        for(Customer cs: model.getDaftarCs()){
            if(!cs.getListPesanan().isEmpty()){
                for(int i = 0; i<cs.getListPesanan().size(); i++){
                    row[0] = cs.getListPesanan().get(i).getId();
                    row[1] = cs.getNama();
                    row[2] = cs.getListPesanan().get(i).getPW();
                    row[3] = cs.getListPesanan().get(i).getTglPesan();
                    tbModel.addRow(row);
                }
            }
        }
    }
}
