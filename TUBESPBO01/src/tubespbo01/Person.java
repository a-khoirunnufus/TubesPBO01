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
public abstract class Person {
    private String id;
    private String nama;
    private String jenisKelamin;
    private String tglLahir;
    private String alamat;
    private String kontak;
    
    public Person(String id, String nama, String jenisKelamin, String tglLahir,
                  String alamat, String kontak){
        this.id = id;
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.kontak = kontak;
    }
    
    //SETTER
    public void setId(String id){
        this.id = id;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }
    public void setTglLahir(String tglLahir) {
        this.tglLahir = tglLahir;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
    
    //GETTER
    public String getId(){
        return id;
    }
    public String getNama() {
        return nama;
    }
    public String getJenisKelamin() {
        return jenisKelamin;
    }
    public String getTglLahir() {
        return tglLahir;
    }
    public String getAlamat() {
        return alamat;
    }
    public String getKontak() {
        return kontak;
    }   
}
