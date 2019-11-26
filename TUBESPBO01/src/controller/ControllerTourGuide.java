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
    
    public void searchIdTG(){
        TourGuide tg = model.getTourGuide(viewTG.getTfIdSearchTGPW().getText());
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
}
