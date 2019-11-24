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
}
