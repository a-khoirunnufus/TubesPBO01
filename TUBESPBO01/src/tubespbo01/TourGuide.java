package tubespbo01;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Lenovo
 */
public class TourGuide extends Person {
    public boolean[][] jadwalTourGuide = new boolean[32][12];
    
    public TourGuide(String id, String nama, String jenisKelamin, String tglLahir,
                  String alamat, String kontak){
        super(id,nama,jenisKelamin,tglLahir,alamat,kontak);
        
        for(int b = 0; b<12; b++){
            for(int h = 0; h<32; h++){
                jadwalTourGuide[h][b] = false;
            }
        }
    }
    
    public void setJadwalTourGuide(Date tglBerangkat, Date tglPulang){
        for(int b = tglBerangkat.getBulan()-1; b<=tglPulang.getBulan()-1; b++){
            for(int h = tglBerangkat.getHari()-1; h<=tglPulang.getHari()-1; h++){
                jadwalTourGuide[h][b] = true; 
            }
        }
    }
}
