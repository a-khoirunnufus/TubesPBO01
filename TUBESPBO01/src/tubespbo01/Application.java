// ini adalah model
package tubespbo01;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
// untuk admin
public class Application {
    private List<Customer> daftarCustomer = new ArrayList<>();
    private static List<TourGuide> daftarTourGuide = new ArrayList<>();
    private static List<PaketWisata> daftarPaketWisata = new ArrayList<>();
    private static List<TempatWisata> daftarTempatWisata = new ArrayList<>();
    
    //TOUR GUIDE
    public static void inputTourGuide(TourGuide tg){
        daftarTourGuide.add(tg);
    }
    public static void viewTourGuide(){
        for(TourGuide tg: daftarTourGuide){
            System.out.println("Nama : "+tg.getNama());
            System.out.println("Jenis Kelamin : "+tg.getJenisKelamin());
            System.out.println("Umur : "+tg.getUmur());
            System.out.println("Alamat : "+tg.getAlamat());
            System.out.println("Kontak : "+tg.getKontak());
            System.out.print("\n");
        }
    }  
    public static void editTourGuide(String id, String nama, String jk, String umur, String alamat, String kontak){
        TourGuide tg = Application.getTourGuide(id);
        tg.setNama(nama);
        tg.setJenisKelamin(jk);
        tg.setUmur(umur);
        tg.setAlamat(alamat);
        tg.setKontak(kontak);
    }   
    public static TourGuide getTourGuide(String id){
        TourGuide tg = null;
        
        for(TourGuide t: daftarTourGuide){
            if(t.getId() == id){
                tg = t;
                break;
            }
        }
        return tg;
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
            System.out.println("Nama : "+c.getNama());
            System.out.println("Jenis Kelamin : "+c.getJenisKelamin());
            System.out.println("Tanggal Lahir : "+c.getUmur());
            System.out.println("Alamat : "+c.getAlamat());
            System.out.println("Kontak : "+c.getKontak());
            System.out.print("\n");
        }
    }
    public void editCustomer(String id, String nama,String jk, String umur, String alamat, String kontak){
//        Customer c = new Application.getCustomer(id);
//        c.setNama(nama);
//        c.setJenisKelamin(jk);
//        c.setUmur(umur);
//        c.setAlamat(alamat);
//        c.setKontak(kontak);
    }
    public Customer getCustomer(String id){
        Customer cs = null;
        
        for(Customer c: daftarCustomer){
            if(c.getId() == id){
                cs = c;
                break;
            }
        }
        return cs;
    }
    
    //PAKET WISATA
    public static void inputPaketWisata(PaketWisata pw){
        daftarPaketWisata.add(pw);
    }
    public static void viewPaketWisata(){
        for(PaketWisata pw: daftarPaketWisata){
            
        }
    }
    public static PaketWisata getPaketWisata(String id){
        PaketWisata pw = null;
        for(PaketWisata w: daftarPaketWisata){
            if(w.getId() == id){
                pw = w;
                break;
            }
        }
        return pw;
    }
    public static void editPaketWisata(String id, String nama, double harga,Date tglB, Date tglP, 
                                        List<TourGuide> listTg, List<TempatWisata> listTw){
        PaketWisata pw = Application.getPaketWisata(id);
        pw.setNama(nama);
        pw.setHarga(harga);
        pw.setTglBerangkat(tglB);
        pw.setTglPulang(tglP);
        pw.setListGuide(listTg);
        pw.setListTujuan(listTw);
        List tourGuideBertugas = new ArrayList();
    }
    
    
    //TEMPAT WISATA
    public static void inputTempatWisata(TempatWisata tw){
        daftarTempatWisata.add(tw);
    }
    public static void viewTempatWisata(){
        for(TempatWisata pw: daftarTempatWisata){
            
        }
    }
    public static TempatWisata getTempatWisata(String id){
        TempatWisata tw = null;
        for(TempatWisata t: daftarTempatWisata){
            if(t.getId() == id){
                tw = t;
                break;
            }
        }
        return tw;
    }
    public static void editTempatWisata(String id, String nama, String alamat){
        TempatWisata tw = Application.getTempatWisata(id);
        tw.setNama(nama);
        tw.setAlamat(alamat);
    }
    
}
