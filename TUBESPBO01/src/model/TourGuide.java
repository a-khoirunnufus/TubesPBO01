package model;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class TourGuide extends Person {
    private static int sidTG = 1;
    public boolean[][] jadwalTourGuide = new boolean[32][12];
    
    public TourGuide(String nama, String jenisKelamin, String tglLahir,
                  String alamat, String kontak){
        super("TG-"+sidTG,nama,jenisKelamin,tglLahir,alamat,kontak);
        sidTG++;
        
        for(int b = 0; b<12; b++){
            for(int h = 0; h<32; h++){
                jadwalTourGuide[h][b] = false;
            }
        }
        
    }
    
    public static int getSidTG(){
        return sidTG;
    }
    
    public void setJadwalTourGuide(Date tglBerangkat, Date tglPulang){
        for(int b = tglBerangkat.getBulan()-1; b<=tglPulang.getBulan()-1; b++){
            for(int h = tglBerangkat.getHari()-1; h<=tglPulang.getHari()-1; h++){
                jadwalTourGuide[h][b] = true; 
            }
        }
    }
    
    public List<PaketWisata> getLsPaketWisataTGS(List<PaketWisata> listPW){
        List listPWTGS = new ArrayList();
        for(PaketWisata pw: listPW){
            for(int i = 0; i<pw.getListGuide().size(); i++){
                if(this.getNama() == pw.getListGuide().get(i).getNama()){
                    listPWTGS.add(pw);
                    break;
                }
            }
        }
        return listPWTGS;
    }

    public List<List<String>> getLsPWnCsTGS(List<Customer> listCs, List<PaketWisata> listPW){
        List<List<String>> listPWnCsTGS = new ArrayList<>();

        List<PaketWisata> listPWTGS = new ArrayList(); 
        listPWTGS = getLsPaketWisataTGS(listPWTGS);
        
        for(Customer cs: listCs){
            for(Pemesanan psn: cs.getListPesanan())
                for(PaketWisata pw: psn.getListPaket())
                    for(int i = 0; i<listPWTGS.size(); i++){
                        if(listPWTGS.get(i).getId() == pw.getId()){
                            List<String> innerListPWnCsTGS = new ArrayList<>();
                            innerListPWnCsTGS.add(pw.getId());
                            innerListPWnCsTGS.add(cs.getId());
                            listPWnCsTGS.add(innerListPWnCsTGS);
                        }
                    }
        }
        
        //SORTING PADA LIST SEKARANG
//        List<List<String>> newListPWnCsTGS = new ArrayList<>();
//        
//        
//        String idPW = listPWnCsTGS.get(0).get(0);
//        String idCs = listPWnCsTGS.get(0).get(1);
//        listPWnCsTGS.remove(0);
//        
//        List<String> inLs = new ArrayList();
//        inLs.add(idPW);
//        inLs.add(idCs);
//        
//        for(List<String> pw : listPWnCsTGS){
//            if(pw.get(0) == idPW){
//                inLs
//            }
//        }
//        newListPWnCsTGS.add()

        return listPWnCsTGS;
    }
}
