/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
/**
 *
 * @author Lenovo
 */
public class Customer extends Person{
    private List<Pemesanan> listPesanan;
    
    public Customer(String id, String nama, String jenisKelamin, int umur,
                  String alamat, String kontak){
        super(id,nama,jenisKelamin,umur,
                  alamat,kontak);
        listPesanan = new ArrayList<>();
    }
    
    public List<Pemesanan> getListPesanan() {
        return listPesanan;
    }
       
    public void createPemesanan(List<PaketWisata> lsPw, double tHarga, Date tglPesan){
        Pemesanan psn = new Pemesanan(lsPw, tHarga, tglPesan);
 
        listPesanan.add(psn);
    }
}
