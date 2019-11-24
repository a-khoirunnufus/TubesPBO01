/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo01;

import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class Controller {
    private Application model;
    private GUICustomer viewCs;
    
    public Controller(GUICustomer viewCs){
        this.viewCs = viewCs;
        model = new Application();
    }
    
    public void regist(){        
        model.inputCustomer(new Customer(viewCs.getTfIdReg(),viewCs.getTfNamaReg(),viewCs.getRbJKReg(),viewCs.getTfUmurReg(),viewCs.getTfAlamatReg(),viewCs.getTfKontakReg()));
        System.out.println("jumlah customer : "+model.getDaftarCs().size());
        model.viewCustomer();
        JOptionPane.showMessageDialog(viewCs, "Data Berhasil Ditambahkan!");        
    }
}
