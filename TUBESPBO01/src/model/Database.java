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
import java.util.List;
import view.GUIAdmin;
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
            //System.out.println("jumlah data : "+getNewId());
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
     public void saveTempatWisata(TempatWisata  tw){ 
        try{
            String query="insert into tempatwisata values ('"+tw.getId()+"','"+tw.getNama()+"','"+tw.getAlamat()+"','"+tw.getRating( )+"');";
            System.out.println("id"+tw.getRating());
            Statement s=con.createStatement(); 
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
    
    public int getNewIdTWPW() throws SQLException{
        String query = "select count(id_TWPW) from tempatwisatadipaketwisata;";
        Statement s = con.createStatement();
        ResultSet rs=s.executeQuery(query);
        int idBaru = 0;
        while(rs.next()){
            idBaru = Integer.parseInt(rs.getString(1));
        }
        return idBaru;
    }
    public int getNewIdTGPW() throws SQLException{
        String query = "select count(id_TGPW) from tourguidedipaketwisata;";
        Statement s = con.createStatement();
        ResultSet rs=s.executeQuery(query);
        int idBaru = 0;
        while(rs.next()){
            idBaru = Integer.parseInt(rs.getString(1));
        }
        return idBaru;
    }
    
    public void savePaketWisata(PaketWisata pw) throws SQLException{
        String[] idTw = new String[pw.getListTujuan().size()];
        for(int i = 0; i< pw.getListTujuan().size(); i++){
            idTw[i] = pw.getListTujuan().get(i).getId();
        }
        String[] idG = new String[pw.getListGuide().size()];
        for(int i = 0; i< pw.getListGuide().size(); i++){
            idG[i] = pw.getListGuide().get(i).getId();
        }
        String idTWPW = String.valueOf(getNewIdTWPW()+1);
        String idTGPW = String.valueOf(getNewIdTGPW()+1);
  
        try{
            String query="insert into paketwisata values ('"+pw.getId()+"','"+pw.getNama()+"','"+pw.getHarga( )+"','"+pw.getTglBerangkat()+"','"+pw.getTglPulang()+"');";
            Statement s=con.createStatement();           
            s.execute(query);
            //insert ke table tempatwisatadipaketwisata
            for(TempatWisata tw: pw.getListTujuan()){
                query = "insert into tempatwisatadipaketwisata values ('TWPW-"+idTWPW+"','"+pw.getId()+"','"+tw.getId()+"');";               
                s.execute(query);
                idTWPW = String.valueOf(Integer.parseInt(idTWPW)+1);
                
            }
            //insert ke table tourguidedipaketwisata
            for(TourGuide tg: pw.getListGuide()){
                query = "insert into tourguidedipaketwisata values ('TGPW-"+idTGPW+"','"+pw.getId()+"','"+tg.getId()+"');";
                s.execute(query);
                idTGPW = String.valueOf(Integer.parseInt(idTGPW)+1);
            }
            
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
            int umur = Integer.parseInt(rs.getString(4));
            String alamat = rs.getString(5);
            String kontak = rs.getString(6);
            t = new TourGuide(id,name,jeniskelamin,umur,alamat,kontak);
        }
        
        return t; 
    }catch(SQLException se){
            return null;
        }
    }
    public List<TourGuide> loadAllTourGuide(){ 
    try{
        List<TourGuide> tourguides = new ArrayList(); 
        String query="select * from tourguide;" ; 
        Statement s=con.createStatement(); 
        ResultSet rs=s.executeQuery(query); TourGuide t;
        while (rs.next()){
            String id=rs.getString(1);
            
            String name=rs.getString(2);
            String jeniskelamin=rs.getString(3);
            int umur = Integer.parseInt(rs.getString(4));
            String alamat = rs.getString(5);
            String kontak = rs.getString(6);
            t = new TourGuide(id,name,jeniskelamin,umur,alamat,kontak);
            tourguides.add(t);
        }
        return tourguides;
    }catch(SQLException se){
        return null; }
    } 
    public List<TempatWisata> loadAllTempatWisata(){ 
    try{
        List<TempatWisata> tempatwisatas = new ArrayList(); 
        String query="select * from tempatwisata;" ; 
        Statement s=con.createStatement(); 
        ResultSet rs=s.executeQuery(query); TempatWisata tw;
        while (rs.next()){
            String id=rs.getString(1);
            
            String name=rs.getString(2);
            String alamat=rs.getString(3);
            int rating = Integer.parseInt(rs.getString(4));
            tw = new TempatWisata(id,name,alamat,rating);
            tempatwisatas.add(tw);
        }
        return tempatwisatas;
    }catch(SQLException se){
        return null; }
    } 
    
    public List<Customer> loadAllCustomer(){ 
    try{
        List<Customer> customers = new ArrayList(); 
        String query="select * from Customer;" ; 
        Statement s=con.createStatement(); 
        ResultSet rs=s.executeQuery(query); Customer c;
        while (rs.next()){
            String id=rs.getString(1);
            
            String name=rs.getString(2);
            String jeniskelamin=rs.getString(3);
            int umur = Integer.parseInt(rs.getString(4));
            String alamat = rs.getString(5);
            String kontak = rs.getString(6);
            c = new Customer(id,name,jeniskelamin,umur,alamat,kontak);
            customers.add(c);
        }
        return customers;
    }catch(SQLException se){
        return null; }
    } 
    public List<PaketWisata> loadAllPaketWisata(){ 
    try{
        List<PaketWisata> paketwisatas = new ArrayList(); 
        String query="select * from paketwisata;" ; 
        Statement s=con.createStatement(); 
        ResultSet rs=s.executeQuery(query); PaketWisata pw;
        while (rs.next()){
            String id=rs.getString(1);
            String name=rs.getString(2);
            double harga = Double.parseDouble(rs.getString(3));
            
//            query = "select count(id_TWPW) from tempatwisatadipaketwisata;";
//            s = con.createStatement();
//            rs = s.executeQuery(query);
//            int nTW = 0;
//            while(rs.next()){
//                nTW = Integer.parseInt(rs.getString(1));
//            }
//            
//            for(int i = 0; i<nTW; i++){
//                
//            }
            
            String tanggalberangkat = rs.getString(4);
            String tanggalpulang = rs.getString(5);
            pw = new PaketWisata(id,name,harga,tanggalberangkat,tanggalpulang);
            paketwisatas.add(pw);
        }
        return paketwisatas;
    }catch(SQLException se){
        return null; }
    } 
    //coba delete
    
    public static void deleteRecord() throws SQLException{
  Connection connection = null;
  Statement statement = null;
  int countRecordDeleted = 0;
  String deleteTableQuery = "DELETE FROM tourguide WHERE Id_TourGuide = 'TG-7'";
  try {
   connection = getConnection();
   statement = connection.createStatement();
   System.out.println(deleteTableQuery);
   // execute delete SQL stetement
   statement.executeUpdate(deleteTableQuery);
   countRecordDeleted = statement.getUpdateCount();
   System.out.println(countRecordDeleted+" Record berhasil di delete dari TBL_USER!");
  } catch (SQLException ex) {
   System.out.println(ex.getMessage());
  } finally {
   if (statement != null) {
    statement.close();
   }
   if (connection != null) {
    connection.close();
   }
  }
 }
public void deleteTourGuide(TourGuide tg){ 
        try{
            String query="delete from tourguide WHERE Id_TourGuide = ('"+tg.getId()+"','"+tg.getNama()+"','"+tg.getJenisKelamin()+"','"+tg.getUmur( )+"','"+tg.getAlamat()+"','"+tg.getKontak()+"');";
            Statement s=con.createStatement(); 
            s.execute(query); 
            System.out.println("delete success.");
        } catch(SQLException se){ 
            System.out.println("delete error.");
        } 
    }

public void deleteTourGuide(Customer c){ 
        try{
            String query="delete from customer WHERE Id_Customer = ('"+c.getId()+"','"+c.getNama()+"','"+c.getJenisKelamin()+"','"+c.getUmur( )+"','"+c.getAlamat()+"','"+c.getKontak()+"');";
            Statement s=con.createStatement(); 
            s.execute(query); 
            System.out.println("delete success.");
        } catch(SQLException se){ 
            System.out.println("delete error.");
        } 
    }
public void deleteTempatWisata(TempatWisata tw){ 
        try{
            String query="delete from tempatwisata WHERE Id_TempatWisata ('"+tw.getId()+"','"+tw.getNama()+"','"+tw.getAlamat()+"','"+tw.getRating( )+"');";
            Statement s=con.createStatement(); 
            s.execute(query); 
            System.out.println("delete success.");
        } catch(SQLException se){ 
            System.out.println("delete error.");
        } 
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
    
    

