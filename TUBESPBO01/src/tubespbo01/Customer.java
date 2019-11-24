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
    private static int sidC = 1;
    private List<Pemesanan> listPesanan;
    
    public Customer(String nama, String jenisKelamin, String umur,
                  String alamat, String kontak){
        super("C-"+sidC,nama,jenisKelamin,umur,
                  alamat,kontak);
        listPesanan = new ArrayList<>();
        sidC++;
    }
    
    public static int getSidC(){
        return sidC;
    }

    public void setListPesanan(List<Pemesanan> listPesanan) {
        this.listPesanan = listPesanan;
    }

    public List<Pemesanan> getListPesanan() {
        return listPesanan;
    }
    
    
    public void createPemesanan(String PW, String tglPesan){
        Pemesanan pesanan = new Pemesanan(PW,tglPesan);
        
        listPesanan.add(pesanan);
    }
}
