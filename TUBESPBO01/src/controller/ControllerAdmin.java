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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;

//table model
import tableModel.tbModCustomer;
import tableModel.tbModTempatWisata;
import tableModel.tbModTourGuide;
import tableModel.tbModPaketWisata;

import view.viewListTW;
/**
 *
 * @author Lenovo
 */
public class ControllerAdmin extends MouseAdapter{//extends MouseAdapter implements ActionListener {
    private Application model;
    private GUIAdmin viewAdm;
    
    //table view utama
    private tbModTourGuide tbModTG;
    private tbModCustomer tbModCs;
    private tbModTempatWisata tbModTW;
    private tbModPaketWisata tbModPW;
    
    private viewListTW viewTW;
    private tbModTempatWisata tbModLsTW;
    
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    
    public ControllerAdmin(Application model, GUIAdmin viewAdm) throws ParseException{
        this.viewAdm = viewAdm;
        this.model = model;

        model.loadAllTourguide();
        model.loadAllTempatWisata();
        model.loadAllCustomer();
        model.loadAllPaketWisata();
        
        //TOUR GUIDE
        viewAdm.addMouseListener(this);
        //table model tour guide
        tbModTG = new tbModTourGuide();
        viewAdm.getTbViewTGTG().setModel(tbModTG);
        
        //table model customer
        tbModCs = new tbModCustomer();
        viewAdm.getTbViewCs().setModel(tbModCs);
        
        //table model tempat wisata
        tbModTW = new tbModTempatWisata();
        viewAdm.getTBViewTW().setModel(tbModTW);
        
        //table model paket wisata
        tbModPW = new tbModPaketWisata();
        viewAdm.getTBViewPW().setModel(tbModPW);
        
        viewAdm.getTfIdTG().setText("TG-"+model.getNewIdTG());
        viewAdm.getTfIdInputPW().setText("PW-"+model.getNewIdPW());
        viewAdm.getTfIdInputTW().setText("TW-"+model.getNewIdTW());
        viewAdm.getSlRatingInputTW().setValue(0);
        
        viewAdm.getTBViewPW().addMouseListener(new MouseAdapter()
        {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                if(viewAdm.getTBViewPW().getSelectedColumn() == 3){
//                    viewTW = new viewListTW();
//                    tbModLsTW = new tbModTempatWisata();
//                    System.out.println("bayak tempat wisata : "+model.getDaftarPW().get(0).getListGuide().size());
//                    //input berupa id
//                    tbModLsTW.add(model.loadLsTWPW(model.getDaftarPW().get(viewAdm.getTBViewPW().getSelectedRow()).getId()));
//                    viewTW.getTbViewTW().setModel(tbModLsTW);
//                    viewTW.setVisible(true);
//                }
//            }
        });

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();       
    //Input TG
        if(source.equals(viewAdm.getBtnInputTG())){
            TourGuide tg = new TourGuide(viewAdm.getTfIdTG().getText(),viewAdm.getTfNamaTG().getText(),viewAdm.getRbJKTG(),Integer.parseInt(viewAdm.getTfUmurTG().getText()),viewAdm.getTfAlamatTG().getText(),viewAdm.getTfKontakTG().getText());
            model.inputTourGuide(tg);
            tbModTG.addOneRow(tg);
            JOptionPane.showMessageDialog(viewAdm, "Data berhasil di input");
            resetViewTG();
        }
    //update table TG
        else if(source.equals(viewAdm.getBtnUpdateTG())){
            tbModTG.updateTable(model.loadAllTourguide());
        }
    //Input TW
        else if(source.equals(viewAdm.getBtnInputTW())){
            TempatWisata tw = new TempatWisata(viewAdm.getTfIdInputTW().getText(),viewAdm.getTfNamaInputTW().getText(),viewAdm.getSlRatingInputTW().getValue(),viewAdm.getTaAlamatInputTW().getText());
            model.inputTempatWisata(tw);
            tbModTW.addOneRow(tw);
            JOptionPane.showMessageDialog(viewAdm, "Data berhasil di input");
            resetViewInputTW();
        }
    //Update Table TW
        else if(source.equals(viewAdm.getBtnUpdateTW())){
            tbModTW.updateTable(model.loadAllTempatWisata());
        }
    //Search Edit TW
        else if(source.equals(viewAdm.getBtnSearchEditTW())){
            searchIdEditTW();
        }
    //Edit TW
        else if(source.equals(viewAdm.getBtnEditTW())){
            TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchEditTW().getText());
            model.editTempatWisata(tw, viewAdm.getTfNamaEditTW().getText(), viewAdm.getTfAlamatEditTW().getText(), viewAdm.getSlRatingEditTW().getValue());
            tbModTW.updateTable(model.getDaftarTW());
            JOptionPane.showMessageDialog(viewAdm, "Data Telah Diubah");
            resetViewEditTW();
        }
    //Search Delete TW
        else if(source.equals(viewAdm.getBtnSearchDeleteTW())){
            searchIdDeleteTW();
        }
    //Delete TW
        else if(source.equals(viewAdm.getBtnDeleteTW())){
            TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchDeleteTW().getText());     
            model.getDaftarTW().remove(model.getDaftarTW().indexOf(tw));
            model.DeleteTempatWisata(tw);
            tbModTW.updateTable(model.getDaftarTW());
            JOptionPane.showMessageDialog(viewAdm, "Data Telah Dihapus");
            resetViewDeleteTW();
        }
    //Input PW
        else if(source.equals(viewAdm.getBtnInputPW())){
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            PaketWisata pw = null;
            try {
                pw = new PaketWisata(viewAdm.getTfIdInputPW().getText(),viewAdm.getTfNamaInputPW().getText(),Double.parseDouble(viewAdm.getTfHargaInputPW().getText()),format.parse(viewAdm.getTfTglBInputPW().getText()),format.parse(viewAdm.getTfTglPInputPW().getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
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

            try {
                model.inputPaketWisata(pw);
                System.out.println("jumlah pw : "+model.getDaftarPW().size());
            } catch (SQLException ex) {
                Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            tbModPW.addOneRow(pw);

            JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Diinput");
            resetViewInputPW();
        }
    //Update Table PW
        else if(source.equals(viewAdm.getBtnRefreshPW())){
            tbModPW.updateTable(model.getDaftarPW());
        }
    //Search Edit PW
        else if(source.equals(viewAdm.getBtnSearchEditPW())){
            searchIdEditPW();
        }
    //Edit PW masih error
        else if(source.equals(viewAdm.getBtnEditPW())){
            PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchEditPW().getText());
            try {
                model.editPaketWisata(pw,viewAdm.getTfNamaEditPW().getText(),Double.parseDouble(viewAdm.getTfHargaEditPW().getText()),format.parse(viewAdm.getTfTglBEditPW().getText()),format.parse(viewAdm.getTfTglPEditPW().getText()));
            } catch (ParseException ex) {
                Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            
            System.out.println("banyak tw : "+pw.getListTujuan().size());
            
            tbModPW.updateTable(model.getDaftarPW());

            JOptionPane.showMessageDialog(viewAdm, "Data Berhasil Diedit");
            resetViewEditPW();
        }
    //Input Customer
       
    }
    
    public void resetViewTG(){
        viewAdm.getTfIdTG().setText("TG-"+model.getNewIdTG());
        viewAdm.getTfNamaTG().setText("");
        viewAdm.getBgJKTG().clearSelection();
        viewAdm.getTfUmurTG().setText("");
        viewAdm.getTfAlamatTG().setText("");
        viewAdm.getTfKontakTG().setText("");
    }
    public void resetViewInputTW(){
        viewAdm.getTfIdInputTW().setText("TW-"+model.getNewIdTW());
        viewAdm.getTfNamaInputTW().setText("");
        viewAdm.getSlRatingInputTW().setValue(0);
        viewAdm.getTaAlamatInputTW().setText("");
    }  
    public void searchIdEditTW(){        
        TempatWisata tw = model.getTempatWisata(viewAdm.getTfIdSearchEditTW().getText());
        if(tw!=null){
            viewAdm.getTfNamaEditTW().setText(tw.getNama());
            viewAdm.getSlRatingEditTW().setValue(tw.getRating());
            viewAdm.getTfAlamatEditTW().setText(tw.getAlamat());
            JOptionPane.showMessageDialog(viewAdm, "ID Valid");
        }else{
            JOptionPane.showMessageDialog(viewAdm, "ID Tidak Valid");
        
        }
    }
    public void resetViewEditTW(){
        viewAdm.getTfIdSearchEditTW().setText("");
        viewAdm.getTfNamaEditTW().setText("");
        viewAdm.getTfAlamatEditTW().setText("");
        viewAdm.getSlRatingEditTW().setValue(0);
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
    public void resetViewDeleteTW(){
        viewAdm.getTfIdSearchDeleteTW().setText("");
        DefaultTableModel tbModelDel = (DefaultTableModel) viewAdm.getTbViewDeleteTW().getModel();
        tbModelDel.setRowCount(0);
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
    public void resetViewInputPW(){
        viewAdm.getTfIdInputPW().setText("PW-"+model.getNewIdPW());
        viewAdm.getTfNamaInputPW().setText("");
        viewAdm.getTfHargaInputPW().setText("");
        viewAdm.getTfTglBInputPW().setText("");
        viewAdm.getTfTglPInputPW().setText("");
        viewAdm.getLsTWInputPW().clearSelection();
        viewAdm.getLsTGInputPW().clearSelection();
    }  
    public void searchIdEditPW(){
        PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchEditPW().getText());
        if(pw != null){
            viewAdm.getTfNamaEditPW().setText(pw.getNama());
            viewAdm.getTfHargaEditPW().setText(Double.toString(pw.getHarga()));
            viewAdm.getTfTglBEditPW().setText(format.format(pw.getTglBerangkat()));
            viewAdm.getTfTglPEditPW().setText(format.format(pw.getTglPulang()));
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
    public void resetViewEditPW(){
        viewAdm.getTfIdSearchEditPW().setText("");
        viewAdm.getTfNamaEditPW().setText("");
        viewAdm.getTfHargaEditPW().setText("");
        viewAdm.getTfTglBEditPW().setText("");
        viewAdm.getTfTglPEditPW().setText("");
        viewAdm.getLsTWEditPW().clearSelection();
        viewAdm.getLsTGEditPW().clearSelection();
    }    
    
  
    public void searchIdDeletePW(){
//        PaketWisata pw = model.getPaketWisata(viewAdm.getTfIdSearchDeletePW().getText());
//        if(pw != null){
//            DefaultTableModel tbModel = (DefaultTableModel) viewAdm.getTbViewDeletePW().getModel();
//            tbModel.addRow(new String[]{pw.getId(),pw.getNama()});
//            JOptionPane.showMessageDialog(viewAdm, "ID Valid");
//        }else{
//            JOptionPane.showMessageDialog(viewAdm, "ID Tidak Valid");
//        }
    }    
    public void deletePW(){
//        model.getDaftarPW().remove(model.getDaftarPW().indexOf(model.getPaketWisata(viewAdm.getTfIdSearchDeletePW().getText())));
//        JOptionPane.showMessageDialog(viewAdm, "Data Telah Dihapus");
//        viewAdm.resetViewDeletePW();
//        viewAdm.updateTablePW();
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
