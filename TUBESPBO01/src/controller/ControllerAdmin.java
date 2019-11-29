/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.*;
import view.GUIAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
/**
 *
 * @author Lenovo
 */
public class ControllerAdmin {//extends MouseAdapter implements ActionListener {
    private Application model;
    private GUIAdmin viewAdm;
    
    public ControllerAdmin(Application model, GUIAdmin viewAdm){
        this.viewAdm = viewAdm;
        this.model = model;
        model.loadAllTourguide();
        model.loadAllTempatwisata();
        model.loadAllCustomer();
        model.loadAllPaketWisata();
        
        
        viewAdm.getTfIdTG().setText("TG-"+model.getNewIdTG());
        viewAdm.getTfIdInputPW().setText("PW-"+model.getNewIdPW());
        viewAdm.getTfIdInputTW().setText("TW-"+model.getNewIdTW());
        viewAdm.getSlRatingInputTW().setValue(0);
    }
    
    public void inputTG(){
        model.inputTourGuide(new TourGuide(viewAdm.getTfNamaTG().getText(),viewAdm.getRbJKTG(),Integer.parseInt(viewAdm.getTfUmurTG().getText()),viewAdm.getTfAlamatTG().getText(),viewAdm.getTfKontakTG().getText()));
        
        System.out.println("jumlah tg : "+model.getDaftarTG().size());
        model.viewTourGuide();
        JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Ditambahkan!");
        viewAdm.resetViewTG();
        updateTableTG();
    }
    public void updateTableTG(){
        
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewTGTG().getModel();
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
    
     public void updateTableTW(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTBViewTW().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[4];
        for(int j = 0; j<model.getDaftarTW().size(); j++){
            row[0] = model.getDaftarTW().get(j).getId();
            row[1] = model.getDaftarTW().get(j).getNama();
            row[2] = model.getDaftarTW().get(j).getAlamat();
            row[3] = String.valueOf(model.getDaftarTW().get(j).getRating());
            
            tbModel.addRow(row);           
        }
    }
    public void updateTableCS(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewCs().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[6];
        for(int j = 0; j<model.getDaftarCs().size(); j++){
            row[0] = model.getDaftarCs().get(j).getId();
            row[1] = model.getDaftarCs().get(j).getNama();
            row[2] = model.getDaftarCs().get(j).getJenisKelamin();
            row[3] = String.valueOf(model.getDaftarCs().get(j).getUmur());
            row[4] = model.getDaftarCs().get(j).getAlamat();
            row[5] = model.getDaftarCs().get(j).getKontak();
            tbModel.addRow(row);           
        }
    }
    
     public void updateTablePW(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTBViewPW().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[6];
        for(int j = 0; j<model.getDaftarPW().size(); j++){
            row[0] = model.getDaftarPW().get(j).getId();
            row[1] = model.getDaftarPW().get(j).getNama();
            row[3] = String.valueOf(model.getDaftarPW().get(j).getHarga());
            row[4] = model.getDaftarPW().get(j).getTglBerangkat();
            row[5] = model.getDaftarPW().get(j).getTglPulang();
            tbModel.addRow(row);           
        }
    
    }
    public void updateViewCs(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewCs().getModel();
        tbModel.setRowCount(0);
        String[] row = new String[6];
        for(int j = 0; j<model.getDaftarCs().size(); j++){
            row[0] = model.getDaftarCs().get(j).getId();
            row[1] = model.getDaftarCs().get(j).getNama();
            row[2] = model.getDaftarCs().get(j).getJenisKelamin();
            row[3] = String.valueOf(model.getDaftarCs().get(j).getUmur());
            row[4] = model.getDaftarCs().get(j).getAlamat();
            row[5] = model.getDaftarCs().get(j).getKontak();
            tbModel.addRow(row);           
        }
    }
    
    
    public void updateViewRP(){
        DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewRP().getModel();
        tbModel.setRowCount(0);
       
        String[] row = new String[4];
        
        for(Customer cs: model.getDaftarCs()){
            System.out.println(cs.getNama());
            for(Pemesanan psn: cs.getListPesanan()){
                System.out.println("jumlah paket : "+psn.getListPaket().size());
                for(PaketWisata pw: psn.getListPaket()){
                    System.out.println(pw.getNama());
                    row[0] = psn.getId();
                    row[1] = cs.getNama();
                    row[2] = pw.getNama();
                    row[3] = psn.getTglPesan();
                    tbModel.addRow(row);
                }
            }
        }
    }
    
    public void inputTW(){
        model.inputTempatWisata(new TempatWisata(viewAdm.getTfNamaInputTW().getText(),viewAdm.getTfAlamatInputTW().getText(),viewAdm.getSlRatingInputTW().getValue()));
        JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Ditambahkan!");
        viewAdm.resetViewInputTW();
        viewAdm.updateTableTW();
    }
    
    public void searchIdEditTW(){
        
        TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchEditTW().getText());
        if(tw!=null){
            viewAdm.getTfNamaEditTW().setText(tw.getNama());
            viewAdm.getTfAlamatEditTW().setText(tw.getAlamat());
            viewAdm.getSlRatingEditTW().setValue(tw.getRating());
            JOptionPane.showMessageDialog(viewAdm, "ID Valid");
        }else{
            JOptionPane.showMessageDialog(viewAdm, "ID Tidak Valid");
        
        }
    }
    
    public void editTW(){
        TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchEditTW().getText());
        model.editTempatWisata(tw, viewAdm.getTfNamaEditTW().getText(), viewAdm.getTfAlamatEditTW().getText(), viewAdm.getSlRatingEditTW().getValue());
        JOptionPane.showMessageDialog(viewAdm, "Data Telah Diubah");
        viewAdm.resetViewEditTW();
        viewAdm.updateTableTW();
    }
    
    public void searchIdDeleteTW(){
        TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchDeleteTW().getText());
        if(tw != null){
            DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewDeleteTW().getModel();
            tbModel.addRow(new String[]{tw.getId(),tw.getNama(),tw.getAlamat(),Integer.toString(tw.getRating())});
            JOptionPane.showMessageDialog(viewAdm, "ID Valid");
          
        }else{
            JOptionPane.showMessageDialog(viewAdm, "ID Tidak Valid");
        }
    }
    
    public void deleteTW(){
        TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchDeleteTW().getText());
        
        model.getDaftarTW().remove(model.getDaftarTW().indexOf(tw));
        model.DeleteTempatWisata(tw);
        
        
        JOptionPane.showMessageDialog(viewAdm, "Data Telah Dihapus");
        viewAdm.resetViewDeleteTW();
        viewAdm.updateTableTW();
        
    }
    
    public void refreshTWInputPW(){
        String[] listTw = new String[model.getDaftarTW().size()];
        int i = -1;
        for(TempatWisata tw: model.getDaftarTW()){
            i++;
            listTw[i] = tw.getNama();
        }
        viewAdm.getLsTWInputPW().setListData(listTw);
    }
    public void refreshTGinputPW(){
        String[] listTg = new String[model.getDaftarTG().size()];
        int i = -1;
        for(TourGuide tg: model.getDaftarTG()){
            i++;
            listTg[i] = tg.getNama();
        }
        viewAdm.getLsTGInputPW().setListData(listTg);
    }
    
    public void inputPW() throws SQLException{
        PaketWisata pw = new PaketWisata(viewAdm.getTfNamaInputPW().getText(),Double.parseDouble(viewAdm.getTfHargaInputPW().getText()),viewAdm.getTfTglBInputPW().getText(),viewAdm.getTfTglPInputPW().getText());
        //menambahkan tempat wisata
        List listTWInput = viewAdm.getLsTWInputPW().getSelectedValuesList();
        for(Object nmTW: listTWInput){
            pw.addTempatWisata(model.getTempatWisatabyName(nmTW.toString()));
        }
        //menambahkan tour guide
        List listTGInput = viewAdm.getLsTGInputPW().getSelectedValuesList();
        for(Object nmTG: listTGInput){
            pw.assignTourGuide(model.getTourGuidebyName(nmTG.toString()));
        }
       
        model.inputPaketWisata(pw);
        model.viewPaketWisata();
        
        JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Diinput");
        viewAdm.resetViewInputPW();
        viewAdm.updateTablePW();
    }

    public void searchIdEditPW(){
        PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchEditPW().getText());
        if(pw != null){
            viewAdm.getTfNamaEditPW().setText(pw.getNama());
            viewAdm.getTfHargaEditPW().setText(Double.toString(pw.getHarga()));
            viewAdm.getTfTglBEditPW().setText(pw.getTglBerangkat());
            viewAdm.getTfTglPEditPW().setText(pw.getTglPulang());
            //update list tw
            String[] listTw = new String[model.getDaftarTW().size()];
            int itw = -1;
            for(TempatWisata tw: model.getDaftarTW()){
                itw++;
                listTw[itw] = tw.getNama();
            }
            viewAdm.getLsTWEditPW().setListData(listTw);
            //set selected index
            int[] idxSelectTw = new int[pw.getListTujuan().size()];
            int i = 0;
            for(TempatWisata tw: pw.getListTujuan()){
                for(int j = 0; j<model.getDaftarTW().size(); j++){
                    if(tw.getId() == model.getDaftarTW().get(j).getId()){
                        idxSelectTw[i] = j;
                        i++;
                    }
                }
            }
            viewAdm.getLsTWEditPW().setSelectedIndices(idxSelectTw);
            //update list tg
            String[] listTg = new String[model.getDaftarTG().size()];
            int itg = -1;
            for(TourGuide tg: model.getDaftarTG()){
                itg++;
                listTg[itg] = tg.getNama();
            }
            viewAdm.getLsTGEditPW().setListData(listTg);
            //set selected index
            int[] idxSelectTg = new int[pw.getListGuide().size()];
            i = 0;
            for(TourGuide tg: pw.getListGuide()){
                for(int k = 0; k<model.getDaftarTG().size(); k++){
                    if(tg.getId() == model.getDaftarTG().get(k).getId()){
                        idxSelectTg[i] = k;
                        i++;
                    }
                }
            }
            viewAdm.getLsTGEditPW().setSelectedIndices(idxSelectTg);
            JOptionPane.showMessageDialog(viewAdm, "ID Valid");
        }else{
            JOptionPane.showMessageDialog(viewAdm, "ID Tidak Valid");
        }
    }
    
    public void editPW(){
        PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchEditPW().getText());
        model.editPaketWisata(pw,viewAdm.getTfNamaEditPW().getText(),Double.parseDouble(viewAdm.getTfHargaEditPW().getText()),viewAdm.getTfTglBEditPW().getText(),viewAdm.getTfTglPEditPW().getText());
        pw.getListGuide().clear();
        pw.getListTujuan().clear();
        //menambahkan tempat wisata
        List listTWEdit = viewAdm.getLsTWEditPW().getSelectedValuesList();
        for(Object nmTW: listTWEdit){
            pw.addTempatWisata(model.getTempatWisatabyName(nmTW.toString()));
        }
        //menambahkan tour guide
        List listTGEdit = viewAdm.getLsTGEditPW().getSelectedValuesList();
        for(Object nmTG: listTGEdit){
            pw.assignTourGuide(model.getTourGuidebyName(nmTG.toString()));
        }
     
        JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Diedit");
        viewAdm.resetViewEditPW();
        viewAdm.updateTablePW();
    }
    
    public void searchIdDeletePW(){
        PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchDeletePW().getText());
        if(pw != null){
            DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewDeletePW().getModel();
            tbModel.addRow(new String[]{pw.getId(),pw.getNama()});
            JOptionPane.showMessageDialog(viewAdm, "ID Valid");
        }else{
            JOptionPane.showMessageDialog(viewAdm, "ID Tidak Valid");
        }
    }
    
    public void deletePW(){
        model.getDaftarPW().remove(model.getDaftarPW().indexOf(model.getPaketWisata(viewAdm.getTfIdSearchDeletePW().getText())));
        JOptionPane.showMessageDialog(viewAdm, "Data Telah Dihapus");
        viewAdm.resetViewDeletePW();
        viewAdm.updateTablePW();
    }
  //COBA YAHYA
// GUIAdmin view;
//  Application model;
//    
//    public ControllerAdmin() {
//        view = new GUIAdmin();
//        model = new Application();
//        view.addActionListener(this);
//        view.addMouseAdabter(this);
//        view.setVisible(true);
//        model.loadTourguide(); 
//        view.setTourguideId(model.newId());
//        view.resetViewTG();
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        Object source = ae.getSource();
//        
//        if (source.equals(view.getBtnInputTG())) {
//            try{
//                String name = view.getTfNamaTG();
//                String jeniskelamin = view.getRbJKTG();
//                String umur = view.getTfUmurTG();
//                String alamat = view.getTfAlamatTG();
//                String kontak = view.getTfKontakTG();
//                String id=view.getTfIdTG();
//                
//              
//            TourGuide  t = new TourGuide(id,name,jeniskelamin,umur,alamat,kontak);
//                model.inputTourGuide(t);
//
//            }catch(Exception e){
//                System.out.println(e);
//            }
//        view.resetViewTG();
//        //view.setToyId(Toy.getSid());
//        model.loadTourguide(); 
//        view.setTourguideId (model.newId());
//        }  
//    }
}  
