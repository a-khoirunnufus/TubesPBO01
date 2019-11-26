/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Application;
import model.Customer;
import model.PaketWisata;
import model.TourGuide;
import view.GUITourGuide;
/**
 *
 * @author Lenovo
 */
public class ControllerTourGuide {
    private Application model;
    private GUITourGuide viewTG;
    
    public ControllerTourGuide(Application model, GUITourGuide viewTG){
        this.viewTG = viewTG;
        this.model = model;
    }
    
    public void searchIdTGPNGS(){
        TourGuide tg = model.getTourGuide(viewTG.getTfIdSearchTGPNGS().getText());
        if(tg != null){
            JOptionPane.showMessageDialog(viewTG, "Id Valid");
            //mengupdate view table
            DefaultTableModel tbModel = (DefaultTableModel) viewTG.getTbViewPNGS().getModel();
            tbModel.setRowCount(0);
            String[] row = new String[4];
            
            List<List<String>> lsPWnCsTGS = tg.getLsPWnCsTGS(model.getDaftarCs(), model.getDaftarPW());
            
            for(List<String> inLs: lsPWnCsTGS){
                PaketWisata pw = model.getPaketWisata(inLs.get(0));
                Customer cs = model.getCustomer(inLs.get(1));
                row[0] = pw.getNama();
                row[1] = pw.getTglBerangkat();
                row[2] = pw.getTglPulang();
                row[3] = cs.getNama();
                tbModel.addRow(row);         
            }
        }else{
            JOptionPane.showMessageDialog(viewTG, "Id Tidak Valid");
        }
    }
    
    public void searchIdUDP(){
        TourGuide tg = model.getTourGuide(viewTG.getTfIdSearchTGUDP().getText());
        if(tg != null){
            viewTG.getTfNamaUDP().setText(tg.getNama());
            if(tg.getJenisKelamin() == "Laki-Laki"){
                viewTG.getBgJKUDP().setSelected(viewTG.getRbLakiUDP().getModel(), true);
            }else{
                viewTG.getBgJKUDP().setSelected(viewTG.getRbPerempuanUDP().getModel(), true);
            }
            viewTG.getTfUmurUDP().setText(tg.getUmur());
            viewTG.getTfAlamatUDP().setText(tg.getAlamat());
            viewTG.getTfKontakUDP().setText(tg.getKontak());
            JOptionPane.showMessageDialog(viewTG, "Id Valid");            
        }else{
            JOptionPane.showMessageDialog(viewTG, "Id Tidak Valid");
            
        }
    }
    
    public void editTourGuide(){
        TourGuide tg = model.getTourGuide(viewTG.getTfIdSearchTGUDP().getText());
        String jk;
        if(viewTG.getRbLakiUDP().isSelected()){
            jk = "Laki-Laki";
        }else{
            jk = "Perempuan";
        }
        model.editTourGuide(tg, viewTG.getTfNamaUDP().getText(), jk, viewTG.getTfUmurUDP().getText(), viewTG.getTfAlamatUDP().getText(), viewTG.getTfKontakUDP().getText());
        JOptionPane.showMessageDialog(viewTG, "Data Telah Diedit");
        viewTG.resetViewUDP();
    }
}
