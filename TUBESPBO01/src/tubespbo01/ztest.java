/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo01;

/**
 *
 * @author Lenovo
 */
public class ztest {
    
    public static void testtanggal(){
        Date tglBerangkat = new Date(14,1,2019);
        Date tglPulang = new Date(23,1,2019);
        TourGuide tg = new TourGuide("1","a","b","c","d","e");
        tg.setJadwalTourGuide(tglBerangkat,tglPulang);

        for(int b = 0; b<1; b++){
            for(int h = 0; h<32; h++){
                System.out.print((h+1)+"-"+(b+1)+"-"+"2019 = ");
                if(!tg.jadwalTourGuide[h][b]){
                    System.out.println("KOSONG");
                }else{
                    System.out.println("KERJA");
                }
            }
        }
    }
    
    public static void main(String[] args){
        //TEST INPUT TOUR GUIDE
        TourGuide tg1 = new TourGuide("1","Ahmad","Laki-Laki","03-03-2000","suatu tempat dibumi","088888888888");
        Application.inputTourGuide(tg1);
        //TEST VIEW TOUR GUIDE
        Application.viewTourGuide();
        
        
        //TEST INPUT CUSTOMER
        Customer c1 = new Customer("1","Budi","Laki-Laki","03-03-2000","suatu tempat dibumi","088888888888");
        Application.inputCustomer(c1);
        //TEST VIEW CUSTOMER
        Application.viewCustomer();
        
        //Application.editTourGuide("1").
        
    }
}
