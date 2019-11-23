/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo01;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class Customer extends Person{
    private List<Pemesanan> listPesanan;
    
    public Customer(String id,String nama, String jenisKelamin, String tglLahir,
                  String alamat, String kontak){
        super(id,nama,jenisKelamin,tglLahir,
                  alamat,kontak);
    }

    public void setListPesanan(List<Pemesanan> listPesanan) {
        this.listPesanan = listPesanan;
    }

    public List<Pemesanan> getListPesanan() {
        return listPesanan;
    }
    
    
    public void createPemesanan(String id, String tglPesan){
        Pemesanan pesanan = new Pemesanan(id,tglPesan);
        
        listPesanan.add(pesanan);
    }
}
