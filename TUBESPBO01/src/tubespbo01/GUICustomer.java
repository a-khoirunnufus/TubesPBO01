/*
    Edit by Nufus
 */
package tubespbo01;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class GUICustomer extends javax.swing.JFrame {

    /**
     * Creates new form GUICustomer
     */
    public GUICustomer() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgJKReg = new javax.swing.ButtonGroup();
        jDialog1 = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pRegistrasi = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrasiReg = new javax.swing.JButton();
        tfNamaReg = new java.awt.TextField();
        tfUmurReg = new java.awt.TextField();
        tfAlamatReg = new java.awt.TextField();
        rbLakiReg = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        rbPerempuanReg = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tfKontakReg = new java.awt.TextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfIdReg = new javax.swing.JTextField();
        pPemesanan = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        tfIdPsnPSN = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lsPaketWisataPSN = new javax.swing.JList<>();
        jLabel16 = new javax.swing.JLabel();
        tfTotalHargaPSN = new javax.swing.JTextField();
        btnPesanPSN = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        tfTanggalPesanPSN = new javax.swing.JTextField();
        pUbahDataPribadi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnUpdateUDP = new javax.swing.JButton();
        tfNamaUDP = new java.awt.TextField();
        tfUmurUDP = new java.awt.TextField();
        tfAlamatUDP = new java.awt.TextField();
        rbLakiUDP = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        rbPerempuanUDP = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfKontakUDP = new java.awt.TextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfIdUDP = new javax.swing.JTextField();
        pLihatPaketWisata = new javax.swing.JPanel();
        pLihatTourGuide = new javax.swing.JPanel();
        pLihatTempatWisata = new javax.swing.JPanel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Menu Customer");

        jLabel3.setText("Nama :");

        btnRegistrasiReg.setText("Registrasi");
        btnRegistrasiReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrasiRegActionPerformed(evt);
            }
        });

        bgJKReg.add(rbLakiReg);
        rbLakiReg.setText("Laki - Laki");
        rbLakiReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiRegActionPerformed(evt);
            }
        });

        jLabel8.setText("Alamat :");

        bgJKReg.add(rbPerempuanReg);
        rbPerempuanReg.setText("Perempuan");
        rbPerempuanReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPerempuanRegActionPerformed(evt);
            }
        });

        jLabel9.setText("Kontak :");

        jLabel10.setText("Jenis Kelamin :");

        jLabel11.setText("Umur :");

        jLabel12.setText("ID");

        tfIdReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pRegistrasiLayout = new javax.swing.GroupLayout(pRegistrasi);
        pRegistrasi.setLayout(pRegistrasiLayout);
        pRegistrasiLayout.setHorizontalGroup(
            pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistrasiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pRegistrasiLayout.createSequentialGroup()
                        .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegistrasiReg)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addContainerGap(489, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRegistrasiLayout.createSequentialGroup()
                        .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfNamaReg, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                                .addGroup(pRegistrasiLayout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(rbLakiReg)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rbPerempuanReg))
                                .addComponent(tfIdReg))
                            .addGroup(pRegistrasiLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(tfUmurReg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfKontakReg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfAlamatReg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(298, 298, 298))))
        );
        pRegistrasiLayout.setVerticalGroup(
            pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pRegistrasiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfIdReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNamaReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRegistrasiLayout.createSequentialGroup()
                        .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(rbPerempuanReg)
                            .addComponent(rbLakiReg))
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pRegistrasiLayout.createSequentialGroup()
                        .addComponent(tfUmurReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfAlamatReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pRegistrasiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfKontakReg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnRegistrasiReg)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Registrasi", pRegistrasi);

        jLabel14.setText("Id Pemesanan");

        jLabel15.setText("Paket Wisata");

        lsPaketWisataPSN.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "paket1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(lsPaketWisataPSN);

        jLabel16.setText("Total Harga");

        tfTotalHargaPSN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalHargaPSNActionPerformed(evt);
            }
        });

        btnPesanPSN.setText("Pesan");

        jLabel17.setText("Tanggal Pesan");

        javax.swing.GroupLayout pPemesananLayout = new javax.swing.GroupLayout(pPemesanan);
        pPemesanan.setLayout(pPemesananLayout);
        pPemesananLayout.setHorizontalGroup(
            pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pPemesananLayout.createSequentialGroup()
                        .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfIdPsnPSN, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTotalHargaPSN, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnPesanPSN)
                    .addGroup(pPemesananLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(tfTanggalPesanPSN, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        pPemesananLayout.setVerticalGroup(
            pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pPemesananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfIdPsnPSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfTotalHargaPSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pPemesananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfTanggalPesanPSN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnPesanPSN)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Pemesanan", pPemesanan);

        jLabel2.setText("Nama :");

        btnUpdateUDP.setText("Update");
        btnUpdateUDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateUDPActionPerformed(evt);
            }
        });

        bgJKReg.add(rbLakiUDP);
        rbLakiUDP.setText("Laki - Laki");
        rbLakiUDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiUDPActionPerformed(evt);
            }
        });

        jLabel6.setText("Alamat :");

        bgJKReg.add(rbPerempuanUDP);
        rbPerempuanUDP.setText("Perempuan");
        rbPerempuanUDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPerempuanUDPActionPerformed(evt);
            }
        });

        jLabel7.setText("Kontak :");

        jLabel4.setText("Jenis Kelamin :");

        jLabel5.setText("Umur :");

        jLabel13.setText("ID :");

        javax.swing.GroupLayout pUbahDataPribadiLayout = new javax.swing.GroupLayout(pUbahDataPribadi);
        pUbahDataPribadi.setLayout(pUbahDataPribadiLayout);
        pUbahDataPribadiLayout.setHorizontalGroup(
            pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUbahDataPribadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateUDP)
                    .addComponent(jLabel6)
                    .addGroup(pUbahDataPribadiLayout.createSequentialGroup()
                        .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37)
                        .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfUmurUDP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfKontakUDP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfAlamatUDP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pUbahDataPribadiLayout.createSequentialGroup()
                        .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pUbahDataPribadiLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(rbLakiUDP)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbPerempuanUDP))
                            .addGroup(pUbahDataPribadiLayout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfIdUDP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNamaUDP, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(313, Short.MAX_VALUE))
        );
        pUbahDataPribadiLayout.setVerticalGroup(
            pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pUbahDataPribadiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfIdUDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(tfNamaUDP, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbLakiUDP)
                        .addComponent(rbPerempuanUDP)))
                .addGap(13, 13, 13)
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(tfUmurUDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(tfAlamatUDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pUbahDataPribadiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(tfKontakUDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(btnUpdateUDP)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ubah Data Pribadi", pUbahDataPribadi);

        javax.swing.GroupLayout pLihatPaketWisataLayout = new javax.swing.GroupLayout(pLihatPaketWisata);
        pLihatPaketWisata.setLayout(pLihatPaketWisataLayout);
        pLihatPaketWisataLayout.setHorizontalGroup(
            pLihatPaketWisataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        pLihatPaketWisataLayout.setVerticalGroup(
            pLihatPaketWisataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lihat Paket Wisata", pLihatPaketWisata);

        javax.swing.GroupLayout pLihatTourGuideLayout = new javax.swing.GroupLayout(pLihatTourGuide);
        pLihatTourGuide.setLayout(pLihatTourGuideLayout);
        pLihatTourGuideLayout.setHorizontalGroup(
            pLihatTourGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        pLihatTourGuideLayout.setVerticalGroup(
            pLihatTourGuideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lihat Tour Guide", pLihatTourGuide);

        javax.swing.GroupLayout pLihatTempatWisataLayout = new javax.swing.GroupLayout(pLihatTempatWisata);
        pLihatTempatWisata.setLayout(pLihatTempatWisataLayout);
        pLihatTempatWisataLayout.setHorizontalGroup(
            pLihatTempatWisataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 578, Short.MAX_VALUE)
        );
        pLihatTempatWisataLayout.setVerticalGroup(
            pLihatTempatWisataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lihat Tempat Wisata", pLihatTempatWisata);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateUDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateUDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUpdateUDPActionPerformed

    private void rbLakiUDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiUDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLakiUDPActionPerformed

    private void rbPerempuanUDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanUDPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPerempuanUDPActionPerformed

    private void btnRegistrasiRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrasiRegActionPerformed
        //if error JOptionPane.showMessageDialog(null, "Hello!");
    }//GEN-LAST:event_btnRegistrasiRegActionPerformed

    private void rbLakiRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbLakiRegActionPerformed

    private void rbPerempuanRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPerempuanRegActionPerformed

    private void tfIdRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfIdRegActionPerformed

    private void tfTotalHargaPSNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalHargaPSNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalHargaPSNActionPerformed
    
    //TAB REGISTRASI
    //SETTER
    public void setTfIdReg (String id){
        tfIdReg.setText("C-"+id);
    }
    public void setTfNamaReg (String nama){
        tfNamaReg.setText(nama);
    }
    public void setTfUmurReg (String umur){
        tfUmurReg.setText(umur);
    }
    public void setTfAlamatReg (String alamat){
        tfAlamatReg.setText(alamat);
    }
    public void setTfKontakReg (String kontak){
        tfKontakReg.setText(kontak);
    }
    //GETTER
    public String getTfIdReg (){
        return tfIdReg.getText();
    }
    public String getTfNamaReg (){
        return tfNamaReg.getText();
    }
    public String getRbJKReg(){
        if(rbLakiReg.isSelected()){
            return "l";
        }else{
            return "p";
        }
    }
    public String getTfUmurReg (){
        return tfUmurReg.getText();
    }
    public String getTfAlamatReg (){
        return tfAlamatReg.getText();
    }
    public String getTfKontakReg (){
        return tfKontakReg.getText();
    }
    //LISTENER
    public void addActionListenerReg(ActionListener al){
        btnRegistrasiReg.addActionListener(al);
    }
    
    //TAB PEMESANAN
    //SETTER
    public void setTfIdPsnPSN (String id){
        tfIdPsnPSN.setText("P-"+id);
    } 
    public void setLsPaketWisataPSN (){
        
    }
    public void setTfTotalHargaPSN(String totalHarga){
        tfTotalHargaPSN.setText(totalHarga);
    }
    public void setTfTanggalPesanPSN(String tglPesan){
        tfTanggalPesanPSN.setText(tglPesan);
    }
    //GETTER
    public String getTfIdPSN (){
        return tfIdPsnPSN.getText();
    }
    public List getLsPaketWisataPSN (){
        return null;
    }
    public String getTfTotalHargaPSN (){
        return tfTotalHargaPSN.getText();
    }
    public String getTfTanggalPesanPSN(){
        return tfTanggalPesanPSN.getText();
    }
    //LISTENER
    public void addActionListenerPSN(ActionListener al){
        btnPesanPSN.addActionListener(al);
    } 
    
    //TAB UBAH DATA PRIBADI
    //SETTER
    public void setTfIdUDP (String id){
        tfIdUDP.setText("C-"+id);
    }
    public void setTfNamaUDP (String nama){
        tfNamaUDP.setText(nama);
    }
    public void setTfUmurUDP (String umur){
        tfUmurUDP.setText(umur);
    }
    public void setTfAlamatUDP (String alamat){
        tfAlamatUDP.setText(alamat);
    }
    public void setTfKontakUDP (String kontak){
        tfKontakUDP.setText(kontak);
    }
    //GETTER
    public String getTfIdUDP (){
        return tfIdUDP.getText();
    }
    public String getTfNamaUDP (){
        return tfNamaUDP.getText();
    }
    public String getRbJKUDP(){
        if(rbLakiUDP.isSelected()){
            return "l";
        }else{
            return "p";
        }
    }
    public String getTfUmurUDP (){
        return tfUmurUDP.getText();
    }
    public String getTfAlamatUDP (){
        return tfAlamatUDP.getText();
    }
    public String getTfKontakUDP (){
        return tfKontakUDP.getText();
    }
    //LISTENER
    public void addActionListenerUDP(ActionListener al){
        btnUpdateUDP.addActionListener(al);
    }
    
    //TAB LIHAT PAKET WISATA
    
    //TAB LIHAT TOUR GUIDE
    
    //TAB LIHAT TEMPAT WISATA

    
    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(GUICustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(GUICustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(GUICustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(GUICustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new GUICustomer().setVisible(true);
        }
    });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgJKReg;
    private javax.swing.JButton btnPesanPSN;
    private javax.swing.JButton btnRegistrasiReg;
    private javax.swing.JButton btnUpdateUDP;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JList<String> lsPaketWisataPSN;
    private javax.swing.JPanel pLihatPaketWisata;
    private javax.swing.JPanel pLihatTempatWisata;
    private javax.swing.JPanel pLihatTourGuide;
    private javax.swing.JPanel pPemesanan;
    private javax.swing.JPanel pRegistrasi;
    private javax.swing.JPanel pUbahDataPribadi;
    private javax.swing.JRadioButton rbLakiReg;
    private javax.swing.JRadioButton rbLakiUDP;
    private javax.swing.JRadioButton rbPerempuanReg;
    private javax.swing.JRadioButton rbPerempuanUDP;
    private java.awt.TextField tfAlamatReg;
    private java.awt.TextField tfAlamatUDP;
    private javax.swing.JTextField tfIdPsnPSN;
    private javax.swing.JTextField tfIdReg;
    private javax.swing.JTextField tfIdUDP;
    private java.awt.TextField tfKontakReg;
    private java.awt.TextField tfKontakUDP;
    private java.awt.TextField tfNamaReg;
    private java.awt.TextField tfNamaUDP;
    private javax.swing.JTextField tfTanggalPesanPSN;
    private javax.swing.JTextField tfTotalHargaPSN;
    private java.awt.TextField tfUmurReg;
    private java.awt.TextField tfUmurUDP;
    // End of variables declaration//GEN-END:variables
}
