// ini adalah model
package model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
// untuk admin
public class Application {
    private List<Customer> daftarCustomer = new ArrayList<>();
    private List<TourGuide> daftarTourGuide = new ArrayList<>();
    private List<PaketWisata> daftarPaketWisata = new ArrayList<>();
    private List<TempatWisata> daftarTempatWisata = new ArrayList<>();
    
    //TOUR GUIDE
    public void inputTourGuide(TourGuide tg){
        daftarTourGuide.add(tg);
    }
    public void viewTourGuide(){
        for(TourGuide tg: daftarTourGuide){
            System.out.println("Id : "+tg.getId());
            System.out.println("Nama : "+tg.getNama());
            System.out.println("Jenis Kelamin : "+tg.getJenisKelamin());
            System.out.println("Umur : "+tg.getUmur());
            System.out.println("Alamat : "+tg.getAlamat());
            System.out.println("Kontak : "+tg.getKontak());
            System.out.print("\n");
        }
    }  
    public void editTourGuide(String id, String nama, String jk, String umur, String alamat, String kontak){
//        TourGuide tg = Application.getTourGuide(id);
//        tg.setNama(nama);
//        tg.setJenisKelamin(jk);
//        tg.setUmur(umur);
//        tg.setAlamat(alamat);
//        tg.setKontak(kontak);
    }   
    public TourGuide getTourGuide(String id){
        TourGuide tg = null;
        
        for(TourGuide t: daftarTourGuide){
            if(t.getId() == id){
                tg = t;
                break;
            }
        }
        return tg;
    }
    public TourGuide getTourGuidebyName(String name){
        TourGuide tg = null;
        
        for(TourGuide t: daftarTourGuide){
            if(t.getNama() == name){
                tg = t;
                break;
            }
        }
        return tg;
    }
    public List<TourGuide> getDaftarTG(){
        return daftarTourGuide;
    }
    
    //CUSTOMER
    public List<Customer> getDaftarCs(){
        return daftarCustomer;
    }
    public void inputCustomer(Customer c){
        daftarCustomer.add(c);
    }
    public void viewCustomer(){
        for(Customer c: daftarCustomer){
            System.out.println("Id : "+c.getId());
            System.out.println("Nama : "+c.getNama());
            System.out.println("Jenis Kelamin : "+c.getJenisKelamin());
            System.out.println("Tanggal Lahir : "+c.getUmur());
            System.out.println("Alamat : "+c.getAlamat());
            System.out.println("Kontak : "+c.getKontak());
            System.out.print("\n");
        }
    }
    public void editCustomer(Customer cs, String nama,String jk, String umur, String alamat, String kontak){
        cs.setNama(nama);
        cs.setJenisKelamin(jk);
        cs.setUmur(umur);
        cs.setAlamat(alamat);
        cs.setKontak(kontak);
    }
    public Customer getCustomer(String id){
        Customer cs = null;
        
        for(Customer c: daftarCustomer){
            if(c.getId().equals(id)){
                cs = c;
                break;
            }
        }
        return cs;
    }
    
    //PAKET WISATA
    public List<PaketWisata> getDaftarPW(){
        return daftarPaketWisata;
    }
    public void inputPaketWisata(PaketWisata pw){
        daftarPaketWisata.add(pw);
    }
    public void viewPaketWisata(){
        for(PaketWisata pw: daftarPaketWisata){
            pw.viewPaketWisata();
        }
    }
    public PaketWisata getPaketWisata(String id){
        PaketWisata pw = null;
        for(PaketWisata w: daftarPaketWisata){
            if(w.getId().equals(id)){
                pw = w;
                break;
            }
        }
        return pw;
    }
    public void editPaketWisata(PaketWisata pw, String nama, double harga,String tglB, String tglP){
        pw.setNama(nama);
        pw.setHarga(harga);
        pw.setTglBerangkat(tglB);
        pw.setTglPulang(tglP);
    }
    
    
    //TEMPAT WISATA
    public List<TempatWisata> getDaftarTW(){
        return daftarTempatWisata;
    }
    public void inputTempatWisata(TempatWisata tw){
        daftarTempatWisata.add(tw);
    }
    public void viewTempatWisata(){
        for(TempatWisata pw: daftarTempatWisata){
            System.out.println("Id : "+pw.getId());
            System.out.println("Nama : "+pw.getNama());
            System.out.println("Alamat : "+pw.getAlamat());
            System.out.println("Rating : "+pw.getRating());
            System.out.println("");
        }
    }
    public TempatWisata getTempatWisata(String id){
        TempatWisata tw = null;
        for(TempatWisata t: daftarTempatWisata){
            if(t.getId().equals(id)){
                tw = t;
                break;
            }
        }
        return tw;
    }
    public TempatWisata getTempatWisatabyName(String name){
        TempatWisata tw = null;
        for(TempatWisata t: daftarTempatWisata){
            if(t.getNama().equals(name)){
                tw = t;
                break;
            }
        }
        return tw;
    }
    public void editTempatWisata(TempatWisata tw, String nama, String alamat, int rating){
        tw.setNama(nama);
        tw.setAlamat(alamat);
        tw.setRating(rating);
    }
    
}
