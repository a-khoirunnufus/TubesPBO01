/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Application;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Customer;
import model.PaketWisata;
import view.GUICustomer;
import model.Pemesanan;
import model.TempatWisata;
import model.TourGuide;

/**
 *
 * @author Lenovo
 */
public class ControllerCustomer {
    private GUICustomer viewCs;
    private Application model;
    
    public ControllerCustomer(Application model, GUICustomer viewCs){
        this.viewCs = viewCs;
        this.model = model;
        viewCs.getTfIdReg().setText("C-"+Customer.getSidC());
        viewCs.getTfIdPsnPsn().setText("P-"+Pemesanan.getSidP());
    }
    
    public void registReg(){        
        model.inputCustomer(new Customer(viewCs.getTfNamaReg(),viewCs.getRbJKReg(),Integer.parseInt(viewCs.getTfUmurReg()),viewCs.getTfAlamatReg(),viewCs.getTfKontakReg()));
        System.out.println("jumlah customer : "+model.getDaftarCs().size());
        model.viewCustomer();
        JOptionPane.showMessageDialog(viewCs, "Data Berhasil Ditambahkan!");
        viewCs.resetViewReg();
    }
    
    public void pesanPsn(){
        Customer cs = model.getCustomer(viewCs.getTfIdCsPsn());
        if(cs != null){
            double tHarga = Double.parseDouble(viewCs.getTfTotalHargaPsn().getText());
            List<PaketWisata> listPWPsn = new ArrayList<>();
            List listPWNmPsn = viewCs.getLsPaketWisataPsn().getSelectedValuesList(); 
            for(Object nmPW: listPWNmPsn){
                listPWPsn.add(model.getPaketWisatabyName(nmPW.toString()));
            }
                        
            cs.createPemesanan(listPWPsn, tHarga, viewCs.getTfTglPesanPsn());
            
            JOptionPane.showMessageDialog(viewCs, "Data Berhasil Ditambahkan!");
        }else{
            JOptionPane.showMessageDialog(viewCs, "Id Customer Tidak Tersedia!");
        }
        viewCs.resetViewPsn();
    }
    
    public void cariIdCsUDP(){
        String idCs = viewCs.getTfIdCsUDP();
        Customer cs = model.getCustomer(idCs);
        if(cs != null){
            viewCs.getTfNamaUDP().setText(cs.getNama());
            if(cs.getJenisKelamin() == "Laki-Laki"){
                viewCs.getRbLakiUDP().setSelected(true);
            }else{
                viewCs.getRbPerempuanUDP().setSelected(true);
            }
            viewCs.getTfUmurUDP().setText(String.valueOf(cs.getUmur()));
            viewCs.getTfAlamatUDP().setText(cs.getAlamat());
            viewCs.getTfKontakUDP().setText(cs.getKontak());
            JOptionPane.showMessageDialog(viewCs, "Id Valid");
        }else{
            JOptionPane.showMessageDialog(viewCs, "Id Tidak Valid");
        }
    }
    
    public void updateUDP(){
        Customer cs = model.getCustomer(viewCs.getTfIdCsUDP());
        String jK;
        if(viewCs.getRbLakiUDP().isSelected()){
            jK = "Laki-Laki";
        }else{
            jK = "Perempuan";
        }
        model.editCustomer(cs, viewCs.getTfNamaUDP().getText(), jK, Integer.parseInt(viewCs.getTfUmurUDP().getText()), viewCs.getTfAlamatUDP().getText(), viewCs.getTfKontakUDP().getText());
        JOptionPane.showMessageDialog(viewCs, "Data Diupdate");
        viewCs.resetViewUDP();
        model.viewCustomer();
    }
    
    public void refreshPsn(){
        String[] listPw = new String[model.getDaftarPW().size()];
        int i = -1;
        for(PaketWisata pw: model.getDaftarPW()){
            i++;
            listPw[i] = pw.getNama();
        }
        viewCs.getLsPaketWisataPsn().setListData(listPw);
    }
    
    public void getHargaTotalPsn(){
        double th = 0;
        
        List listPWPsn = viewCs.getLsPaketWisataPsn().getSelectedValuesList();
        for(Object nmPW: listPWPsn){
            th += model.getPaketWisatabyName(nmPW.toString()).getHarga();
        }
        viewCs.getTfTotalHargaPsn().setText(Double.toString(th));
    }
    
    public void refreshTbLPW(){
        DefaultTableModel tbModel = (DefaultTableModel) viewCs.getTbLPW().getModel();
        tbModel.setRowCount(0);
       
        String[] row = new String[7];
        for(int j = 0; j<model.getDaftarPW().size(); j++){
            row[0] = model.getDaftarPW().get(j).getId();
            row[1] = model.getDaftarPW().get(j).getNama();
            row[2] = Double.toString(model.getDaftarPW().get(j).getHarga());
            row[3] = "";
            for(TempatWisata tw: model.getDaftarPW().get(j).getListTujuan()){
                row[3] += tw.getNama()+", ";
            }
            row[4] = "";
            for(TourGuide tg: model.getDaftarPW().get(j).getListGuide()){
                row[4] += tg.getNama()+", ";
            }
            row[5] = model.getDaftarPW().get(j).getTglBerangkat();
            row[6] = model.getDaftarPW().get(j).getTglPulang();
            tbModel.addRow(row);
            
            viewCs.getTbLPW().setRowHeight(j, 16);
        }
    }
    
    public void refreshTbLTG(){
        DefaultTableModel tbModel = (DefaultTableModel) viewCs.getTbLTG().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[6];
        for(int j = 0; j<model.getDaftarTG().size(); j++){
            row[0] = model.getDaftarTG().get(j).getId();
            row[1] = model.getDaftarTG().get(j).getNama();
            row[2] = model.getDaftarTG().get(j).getJenisKelamin();
            row[3] = String.valueOf(model.getDaftarTG().get(j).getUmur());
            row[4] = model.getDaftarTG().get(j).getAlamat();
            row[5] = model.getDaftarTG().get(j).getKontak();
            tbModel.addRow(row);           
        }
    }
    public void refreshTbLTW(){
        DefaultTableModel tbModel = (DefaultTableModel) viewCs.getTbLTW().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[4];
        for(int j = 0; j<model.getDaftarTW().size(); j++){
            row[0] = model.getDaftarTW().get(j).getId();
            row[1] = model.getDaftarTW().get(j).getNama();
            row[2] = model.getDaftarTW().get(j).getAlamat();
            row[3] = Integer.toString(model.getDaftarTW().get(j).getRating());
            tbModel.addRow(row);           
        }
    }
}
