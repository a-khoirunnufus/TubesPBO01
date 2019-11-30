// ini adalah model
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
// untuk admin
public class Application {
    private List<Customer> daftarCustomer;
    private List<TourGuide> daftarTourGuide;
    private List<PaketWisata> daftarPaketWisata;
    private List<TempatWisata> daftarTempatWisata;
    
//baru
    Database db;
//    List <Customer> daftarCustumerList;
//    Database db;
//    List <TourGuide> daftarTourguideList;
//    Database db;
    
    public Application(){
        daftarCustomer = new ArrayList<>();
        daftarTourGuide = new ArrayList<>();
        daftarPaketWisata = new ArrayList<>();
        daftarTempatWisata = new ArrayList<>();
        
//baru
        db = new Database(this); 
        db.connect();
    }
    
    //TOUR GUIDE
    public void inputTourGuide(TourGuide tg){
        daftarTourGuide.add(tg);
 //baru
        //daftarTourGuideList.add(tg);
        db.saveTourGuide(tg);
         
    }
    
//    public void DeleteTourGuide(TourGuide tg){
//        db.deleteTourGuide(tg);
//    }
    public void loadAllTourguide(){ 
        daftarTourGuide=db.loadAllTourGuide();
    }
    public void viewTourGuide(){
        System.out.println("jumlah tourguide : "+daftarTourGuide.size());
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
    public void editTourGuide(TourGuide tg, String nama, String jk, int umur, String alamat, String kontak){
        tg.setNama(nama);
        tg.setJenisKelamin(jk);
        tg.setUmur(umur);
        tg.setAlamat(alamat);
        tg.setKontak(kontak);
         db.updateTourGuide(tg);
    }   
    public TourGuide getTourGuide(String id){
        System.out.println("jalan");
        TourGuide tg = null;
        
        for(TourGuide t: daftarTourGuide){
            System.out.println(t.getId()+", "+id);
            if(t.getId().equals(id)){
                System.out.println("ketemu bos");
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
        //baru
//        daftarCustomer.add(c);
        db.saveCustomer(c);
        
    }
     public void loadAllCustomer(){ 
        daftarCustomer=db.loadAllCustomer();
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
    public void editCustomer(Customer cs, String nama,String jk, int umur, String alamat, String kontak){
        cs.setNama(nama);
        cs.setJenisKelamin(jk);
        cs.setUmur(umur);
        cs.setAlamat(alamat);
        cs.setKontak(kontak);
        
        db.updateCustomer(cs);
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
    public void loadAllPaketWisata(){
        daftarPaketWisata = db.loadAllPaketWisata();
    }
    public void inputPaketWisata(PaketWisata pw) throws SQLException{
        daftarPaketWisata.add(pw);
        
        
          db.savePaketWisata(pw);
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
    public PaketWisata getPaketWisatabyName(String name){
        PaketWisata pw = null;
        for(PaketWisata w: daftarPaketWisata){
            if(w.getNama().equals(name)){
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
    
    public void loadAllTempatwisata(){ 
        daftarTempatWisata=db.loadAllTempatWisata();
    }
    public void DeleteTempatWisata(TempatWisata tw){
        db.deleteTempatWisata(tw);
    }
    public void inputTempatWisata(TempatWisata tw){
        daftarTempatWisata.add(tw);
        //baru
        db.saveTempatWisata(tw);
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
        db.updateTempatWisata(tw);
    }
    //coba yahya 
     public String searchTourguide (String id) {
        int i = 0;
        while ((i < daftarTourGuide.size()) && (daftarTourGuide.get(i).getId()!= id)) {            
            i++;
        }
        return db.loadOneTourGuideById(id).toString();
    }
     public String[] getTourguideListId() {
        String[] listId = new String[daftarTourGuide.size()];
        for (int i = 0; i < daftarTourGuide.size(); i++) {
            listId[i] = daftarTourGuide.get(i).getId();
        }
        return listId;
    }
    
    
    public int getNewIdTG(){
        if (daftarTourGuide.size()==0) return 1; 
        else{
            String lastId=daftarTourGuide.get(daftarTourGuide.size()-1).getId(); 
            String lastNumId=lastId.substring(3);
            int lastNoId = Integer.parseInt(lastNumId); 
            return lastNoId+1;
        } 
    }
    
    public int getNewIdTW(){
        if (daftarTempatWisata.size()==0) return 1; 
        else{
            String lastId=daftarTempatWisata.get(daftarTempatWisata.size()-1).getId(); 
            String lastNumId=lastId.substring(3);
            int lastNoId = Integer.parseInt(lastNumId); 
            return lastNoId+1;
        } 
    }
    
    public int getNewIdPW(){
        if (daftarPaketWisata.size()==0) return 1; 
        else{
            String lastId=daftarPaketWisata.get(daftarPaketWisata.size()-1).getId(); 
            String lastNumId=lastId.substring(3);
            int lastNoId = Integer.parseInt(lastNumId); 
            return lastNoId+1;
        } 
    }
    
    public List<TempatWisata> loadLsTWPW(String idPW){
        return db.loadLsTWPW(idPW);
    }

  
}

    
    

