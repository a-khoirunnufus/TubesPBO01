/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Application;
import javax.swing.ButtonModel;
import javax.swing.JOptionPane;
import model.Customer;
import view.GUICustomer;
import model.Pemesanan;

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
        model.inputCustomer(new Customer(viewCs.getTfNamaReg(),viewCs.getRbJKReg(),viewCs.getTfUmurReg(),viewCs.getTfAlamatReg(),viewCs.getTfKontakReg()));
        System.out.println("jumlah customer : "+model.getDaftarCs().size());
        model.viewCustomer();
        JOptionPane.showMessageDialog(viewCs, "Data Berhasil Ditambahkan!");
        viewCs.resetViewReg();
    }
    
    public void pesanPsn(){
        Customer cs = model.getCustomer(viewCs.getTfIdCsPsn());
        if(cs != null){
            cs.createPemesanan(viewCs.getLsPaketWisataPsn().getSelectedValue(),viewCs.getTfTglPesanPsn());
            System.out.println("nama pemesan : "+cs.getNama());
            System.out.println("jumlah pemesanan : "+model.getCustomer(viewCs.getTfIdCsPsn()).getListPesanan().size());
            for(Pemesanan Psn: model.getCustomer(viewCs.getTfIdCsPsn()).getListPesanan()){
                Psn.viewPsn();
            }
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
            viewCs.getTfUmurUDP().setText(cs.getUmur());
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
        model.editCustomer(cs, viewCs.getTfNamaUDP().getText(), jK, viewCs.getTfUmurUDP().getText(), viewCs.getTfAlamatUDP().getText(), viewCs.getTfKontakUDP().getText());
        JOptionPane.showMessageDialog(viewCs, "Data Diupdate");
        viewCs.resetViewUDP();
        model.viewCustomer();
    }
}
