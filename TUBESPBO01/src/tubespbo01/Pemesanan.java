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
public class Pemesanan {
    private String id;
    private List<PaketWisata> listPaket = new ArrayList();
    private double totalHarga;
    private String tglPesan; //BUAT OBJEK DATE

    public Pemesanan(String id, String tglPesan) {
        this.id = id;
        this.tglPesan = tglPesan;
    }
    
    public void addPaketWisata (PaketWisata pw){//DIBUAT DILUAR
        listPaket.add(pw);
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setListPaket(List<PaketWisata> listPaket) {
        this.listPaket = listPaket;
    }
    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
    public void setTglPesan(String tglPesan) {
        this.tglPesan = tglPesan;
    }
    public String getId() {
        return id;
    }
    public List<PaketWisata> getListPaket() {
        return listPaket;
    }
    public double getTotalHarga() {
        return totalHarga;
    }
    public String getTglPesan() {
        return tglPesan;
    } 
}
