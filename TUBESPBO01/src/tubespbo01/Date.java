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
public class Date {
    private int hari;
    private int bulan;
    private int tahun;
    
    public Date (int hari, int bulan, int tahun){
        this.hari = hari;
        this.bulan = bulan;
        this.tahun = tahun;
    }
    
    public int getHari(){
        return hari;
    }
    
    public int getBulan(){
        return bulan;
    }
    
    public int getTahun(){
        return tahun;
    }
    
    public void viewDate(){
        System.out.println(hari+"-"+bulan+"-"+tahun);
    }
    
}
