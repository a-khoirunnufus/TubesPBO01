/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList;
public class Database {

    private static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection con;
    public void connect(){ 
        try{
            String url="jdbc:mysql://localhost:3306/tubes";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password); 
            System.out.println("Connected to database.");
        } 
        catch(SQLException se){ 
            System.out.println("Connection error.");
        }  
    }
    //Coba yahya
    public void saveTourGuide(TourGuide t){ 
        try{
            String query="insert into tourguide values ('"+t.getId()+"','"+t.getNama()+"','"+t.getJenisKelamin()+"','"+t.getUmur()+"','"+t.getAlamat()+"','"+t.getKontak()+"');";
            Statement s = con.createStatement(); 
            s.execute(query); 
            System.out.println("Saving success.");
        } catch(SQLException se){ 
            System.out.println("Saving error.");
        } 
    }
    public void saveCustomer(Customer c){ 
        try{
            String query="insert into customer values ('"+c.getId()+"','"+c.getNama()+"','"+c.getJenisKelamin()+"','"+c.getUmur( )+"','"+c.getAlamat()+"','"+c.getKontak()+"');";
            Statement s=con.createStatement(); 
            s.execute(query); 
            System.out.println("Saving success.");
        } catch(SQLException se){ 
            System.out.println("Saving error.");
        } 
    }
    public TourGuide loadOneTourGuideById(String id){ 
    try{
        String query="select * from tourguide where id ='"+id+"'" ; Statement s=con.createStatement();
        ResultSet rs=s.executeQuery(query);
        TourGuide  t=null;
        while (rs.next()){
            String name=rs.getString(2);
            String jeniskelamin=rs.getString(3);
//            int tglLahir = Integer.parseInt(rs.getString(4));
            String umur = rs.getNString(4);
            String alamat = rs.getString(5);
            String kontak = rs.getString(6);
            t = new TourGuide(id,name,jeniskelamin,umur,alamat,kontak);
        }
            return t; 
    }catch(SQLException se){
            return null;
        }
    }
    public ArrayList<TourGuide> loadAllTourGuide(){ 
    try{
        ArrayList<TourGuide> tourguides=new ArrayList(); String query="select * from tourguide" ; 
        Statement s=con.createStatement(); ResultSet rs=s.executeQuery(query); TourGuide t;
        while (rs.next()){
            String id=rs.getString(1);
            String name=rs.getString(2);
            String jeniskelamin=rs.getString(3);
            String umur = rs.getNString(4);
            String alamat = rs.getString(5);
            String kontak = rs.getString(6);
            t = new TourGuide(id,name,jeniskelamin,umur,alamat,kontak);
            tourguides.add(t);
        }
        return tourguides; 
    }catch(SQLException se){
        return null; }
    } 
//     public void AmbilDataBarang() {
//        //Menghapus Seluruh Data
//        .getDataVector().removeAllElements();
//        //Memberitahu bahwa data kosong
//        Model.fireTableDataChanged();
//        
//        try {
//            //Memanggil koneksi :
//            Connection c=Database.getConnection();
//            //Membaca perintah SQL static di JAVA :
//            Statement st=c.createStatement();
//            //Perintah QUERY :
//            String sql = "SELECT * FROM tourguide";
//            //Menjalankan perintah Query :
//            ResultSet rs=st.executeQuery(sql);
//            
//            while (rs.next()) {
//                Object[] o=new Object[4];
//                o[0]=rs.getString("kode");
//                o[1]=rs.getString("nama");
//                o[2]=rs.getString("satuan");
//                o[3]=rs.getInt("stok");
//                Model.addRow(o);
//            }
//            rs.close();
//            st.close();
//            
//        } catch (SQLException e) {
//            System.out.println("Terjadi Error dalam pengambilan data"+e);
//        }
//        
//    }
}
    
    

