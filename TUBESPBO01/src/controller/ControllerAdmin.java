/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.JOptionPane;
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
}
