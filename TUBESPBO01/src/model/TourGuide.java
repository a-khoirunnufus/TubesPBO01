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
}
