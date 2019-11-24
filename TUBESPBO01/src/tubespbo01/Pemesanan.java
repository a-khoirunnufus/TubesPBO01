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
    private static int sidP = 1;
    private String PW;
    private List<PaketWisata> listPaket = new ArrayList();
    private double totalHarga;
    private String tglPesan; //BUAT OBJEK DATE

    public Pemesanan(String PW, String tglPesan) {
        this.id = "P-"+sidP;
        this.PW = PW;
        this.tglPesan = tglPesan;
        sidP++;
    }
    
    public static int getSidP(){
        return sidP;
    }
    public void addPaketWisata (PaketWisata pw){//DIBUAT DILUAR
        listPaket.add(pw);
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setPW(String PW){
        this.PW = PW;
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
    public String getPW(){
        return PW;
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
    
    public void viewPsn(){
        System.out.println("Id Pemesanan : "+id);
        System.out.println("Paket : "+PW);
        System.out.println("Tanggal Pesan : "+tglPesan);
        System.out.println("");
    }
}
