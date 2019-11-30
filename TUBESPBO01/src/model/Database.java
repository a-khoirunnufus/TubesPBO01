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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import view.GUIAdmin;
public class Database {

    private Application model;
    private DateFormat format = new SimpleDateFormat("yyyy-MM-dd");   
    
    public Database(Application model){
        this.model = model;
    }
    
    private static Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Connection con;
    public void connect(){ 
        try{
            String url="jdbc:mysql://localhost:3306/tubespbo";
            String username = "root";
            String password = "";
            con = DriverManager.getConnection(url, username, password);
            //System.out.println("jumlah data : "+getNewId());
        } 
        catch(SQLException se){ 
            System.out.println("Connection error.");
        }  
    }
    
    public void saveTourGuide(TourGuide t){ 
        try{
            String query="insert into tourguide values ('"
                    +t.getId()+"','"
                    +t.getNama()+"','"
                    +t.getJenisKelamin()+"','"
                    +t.getUmur()+"','"
                    +t.getAlamat()+"','"
                    +t.getKontak()+"');";
            Statement s = con.createStatement(); 
            s.execute(query); 
            System.out.println("Saving success.");
        } catch(SQLException se){ 
            System.out.println("Saving error.");
        } 
    }
     public void saveTempatWisata(TempatWisata tw){ 
        try{
            String query = "insert into tempatwisata values ('"
                    +tw.getId()+"','"
                    +tw.getNama()+"','"
                    +tw.getRating( )+"','"
                    +tw.getAlamat()+"');";
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
        String query = "select count(idTWPW) from tempatwisatadipaketwisata;";
        Statement s = con.createStatement();
        ResultSet rs=s.executeQuery(query);
        int idBaru = 0;
        while(rs.next()){
            idBaru = Integer.parseInt(rs.getString(1));
        }
        return idBaru;
    }
    public int getNewIdTGPW() throws SQLException{
        String query = "select count(idTGPW) from tourguidedipaketwisata;";
        Statement s = con.createStatement();
        ResultSet rs=s.executeQuery(query);
        int idBaru = 0;
        while(rs.next()){
            idBaru = Integer.parseInt(rs.getString(1));
        }
        return idBaru;
    }
    
    public void savePaketWisata(PaketWisata pw) throws SQLException{
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
            String query="insert into paketwisata values ('"+pw.getId()+"','"+pw.getNama()+"','"+pw.getHarga( )+"','"+format.format(pw.getTglBerangkat())+"','"+format.format(pw.getTglPulang())+"');";
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
        String query="select * from tourguide where idTG ='"+id+"'" ; Statement s=con.createStatement();
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
            String alamat=rs.getString(4);
            int rating = Integer.parseInt(rs.getString(3));
            tw = new TempatWisata(id,name,rating,alamat);
            tempatwisatas.add(tw);
        }
        return tempatwisatas;
    }catch(SQLException se){
        return null; }
    } 
    
    public List<Customer> loadAllCustomer(){ 
    try{
        List<Customer> customers = new ArrayList(); 
        String query="select * from customer;" ; 
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
    public List<PaketWisata> loadAllPaketWisata() throws ParseException{ 
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
            
            Date tglBerangkat = format.parse(rs.getString(4));
            Date tglPulang = format.parse(rs.getString(5));
            pw = new PaketWisata(id,name,harga,tglBerangkat,tglPulang);
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
  String deleteTableQuery = "DELETE FROM tourguide WHERE IdTG = 'TG-7'";
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
//public void deleteTourGuide(TourGuide tg){ 
//        try{
//            String query="delete from tourguide WHERE Id_TourGuide = ('"+tg.getId()+"','"+tg.getNama()+"','"+tg.getJenisKelamin()+"','"+tg.getUmur( )+"','"+tg.getAlamat()+"','"+tg.getKontak()+"');";
//            Statement s=con.createStatement(); 
//            s.execute(query); 
//            System.out.println("delete success.");
//        } catch(SQLException se){ 
//            System.out.println("delete error.");
//        } 
//    }

//public void deleteTourGuide(Customer c){ 
//        try{
//            String query="delete from customer WHERE Id_Customer = ('"+c.getId()+"','"+c.getNama()+"','"+c.getJenisKelamin()+"','"+c.getUmur( )+"','"+c.getAlamat()+"','"+c.getKontak()+"');";
//            Statement s=con.createStatement(); 
//            s.execute(query); 
//            System.out.println("delete success.");
//        } catch(SQLException se){ 
//            System.out.println("delete error.");
//        } 
//    }
public void deleteTempatWisata(TempatWisata tw){ 
        try{
            String query="delete from tempatwisata WHERE idTW = ('"+tw.getId()+"');";
            Statement s=con.createStatement(); 
            s.execute(query); 
            System.out.println("delete success.");
        } catch(SQLException se){ 
            System.out.println("delete error.");
        } 
    }

public void updateTourGuide(TourGuide tg){
    try{
               
        String query="update tourguide set namaTG = '"+tg.getNama()
                +"', jenisKelaminTG = '"+tg.getJenisKelamin()
                +"', umurTG = '"+tg.getUmur( )
                +"', alamatTG = '"+tg.getAlamat()
                +"',kontakTG = '"+tg.getKontak()
                +"' where idTG = '"+tg.getId()+"';";
            
        Statement s=con.createStatement(); 
        s.execute(query); 
           System.out.println("bisa?");
            System.out.println("update success.");
        } catch(SQLException se){ 
            System.out.println("update error.");
        } 
}

public void updatePaketWisata(PaketWisata pw){
    try{               
        String query="update paketWisata set namaPW = '"+pw.getNama()
                +"', hargaPW = '"+pw.getHarga()
                +"', tglBerangkatPW = '"+format.format(pw.getTglBerangkat())
                +"', tglPulangPW = '"+format.format(pw.getTglPulang())
                +"' where idPW = '"+pw.getId()+"';";
        System.out.println("query : "+query);
        Statement s=con.createStatement(); 
        s.execute(query);
        //query menambahkan list tujuan
//        query = "update tempatWisataDiPaketWisata set idTW = '"+pw.
        System.out.println("update success.");
    } catch(SQLException se){ 
        System.out.println("update error.");
    }
}

public void updateCustomer(Customer c){
    try{           
        String query="update Customer set namaCs = '"+c.getNama()
                +"', jenisKelaminCs = '"+c.getJenisKelamin()
                +"', umurCs = '"+c.getUmur( )
                +"', alamatCs = '"+c.getAlamat()
                +"',kontakCs = '"+c.getKontak()
                +"' where idCs = '"+c.getId()+"';";
            
        Statement s=con.createStatement(); 
        s.execute(query); 
           System.out.println("bisa?");
            System.out.println("update success.");
        } catch(SQLException se){ 
            System.out.println("update error.");
    } 
}
public void updateTempatWisata(TempatWisata tw){
    try{
            String query="update tempatwisata set namaTW = '"+tw.getNama()+"', ratingTW = '"+tw.getRating( )+"', alamatTW = '"+tw.getAlamat()+"' where idTW = '"+tw.getId()+"';";
            Statement s=con.createStatement(); 
            s.execute(query); 
            System.out.println("update success.");
        } catch(SQLException se){ 
            System.out.println("update error.");
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

    public List<TempatWisata> loadLsTWPW(String idPW){
        try{
            List<TempatWisata> listTWPW = new ArrayList<>();
            String query = "select idTW from tempatWisata join tempatWisataDiPaketWisata using (idTW) where idPW = '"+idPW+"';";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(query);
            String idTw;
            while(rs.next()){
                idTw = rs.getString(1);
                listTWPW.add(model.getTempatWisata(idTw));
            }
            return listTWPW;
        }catch(SQLException se){
            return null;
    }
}
}
    
    

