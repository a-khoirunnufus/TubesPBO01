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
        viewAdm.getTfIdInputTW().setText("TW-"+TempatWisata.getSidTW());
        viewAdm.getSlRatingInputTW().setValue(0);
        viewAdm.getTfIdInputPW().setText("PW-"+PaketWisata.getSidPW());
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
        model.getDaftarTW().remove(model.getDaftarTW().indexOf(model.getTempatWisata(viewAdm.getTfIdSearchDeleteTW().getText())));
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
    
    public void inputPW(){
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
        PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchEditPW().getText());
        if(pw != null){
            
        }
    }
}
