/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simba;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class AsetKeluar extends javax.swing.JFrame {
    Database database;
    static String nama,sd,ss,tgl,g;
    static int ad,as,id;
    Aset a;
    /**
     * Creates new form Utama
     */
    public AsetKeluar() {
        initComponents();
        database = new Database();
        tabelHafalan();
        System.out.print(a.id);
//        insert();
        setLocationRelativeTo(null);
    }
    private void tabelHafalan(){
        PreparedStatement ps;
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        
        try{
            ps = database.conn.prepareStatement("select * from asetkeluar");
            ResultSet rs = ps.executeQuery();
            int no = 1;
            while(rs.next()){
                Object o[] = {
                    no++, 
                    rs.getInt("id_aset"),
                    rs.getString("nama"), 
                    rs.getInt("jumlah"),
                    rs.getInt("nilai"),
                    rs.getString("kondisi"),
                };
                model.addRow(o); 
            }     
        }catch (Exception e){
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        insert = new javax.swing.JLabel();
        update = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        judul = new javax.swing.JLabel();
        tfid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        background = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        insert.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        insert.setText("Insert");
        insert.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        insert.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                insertMouseClicked(evt);
            }
        });
        jPanel1.add(insert);
        insert.setBounds(820, 170, 60, 20);

        update.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        update.setText("Update");
        update.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        update.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateMouseClicked(evt);
            }
        });
        jPanel1.add(update);
        update.setBounds(30, 170, 60, 20);

        delete.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        delete.setText("Delete");
        delete.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        jPanel1.add(delete);
        delete.setBounds(120, 170, 60, 20);

        lid.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lid.setText("Masukkan ID");
        jPanel1.add(lid);
        lid.setBounds(30, 110, 140, 17);
        jPanel1.add(logo);
        logo.setBounds(770, 30, 100, 100);

        judul.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        judul.setText("Daftar Aset Keluar");
        jPanel1.add(judul);
        judul.setBounds(450, 60, 320, 40);
        jPanel1.add(tfid);
        tfid.setBounds(30, 140, 150, 20);

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No", "ID", "Nama", "Jumlah", "Nilai", "Kondisi"
            }
        ));
        jScrollPane1.setViewportView(tabel);
        if (tabel.getColumnModel().getColumnCount() > 0) {
            tabel.getColumnModel().getColumn(0).setMinWidth(30);
            tabel.getColumnModel().getColumn(0).setPreferredWidth(1);
            tabel.getColumnModel().getColumn(0).setMaxWidth(30);
            tabel.getColumnModel().getColumn(1).setMinWidth(30);
            tabel.getColumnModel().getColumn(1).setPreferredWidth(1);
            tabel.getColumnModel().getColumn(1).setMaxWidth(30);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 210, 850, 230);
        jPanel1.add(background);
        background.setBounds(0, 0, 900, 500);

        jLabel1.setText("Kembali");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 70, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_insertMouseClicked
        // TODO add your handling code here:
        new Insert().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_insertMouseClicked

    private void updateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateMouseClicked
        // TODO add your handling code here:
        try{
            String sql = "select * from aset where id_aset=?";
            PreparedStatement pst;
            pst = database.conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tfid.getText()));
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Object o[] = {
                    id=Integer.parseInt(rs.getString("id_h")),
                    nama=rs.getString("nama"), 
                    sd=rs.getString("suratd"),
                    sd=rs.getString("surats"),
                    ad=rs.getInt("ayatd"),
                    as=rs.getInt("ayats"),
                    tgl=rs.getString("tanggal"),
                    g=rs.getString("guru"),
                };
            
                
            }
            
            this.dispose();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
        
        
//        Update u = new Update();
//        u.setVisible(true);
//        u.setLocationRelativeTo(null);
    }//GEN-LAST:event_updateMouseClicked

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        try {
            String sql = "DELETE FROM hafalan WHERE id_h=?";
            PreparedStatement pst;
            pst = database.conn.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(tfid.getText()));
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Delete Berhasil");
            AsetKeluar utama = new AsetKeluar();
            utama.setVisible(true);
            utama.setLocationRelativeTo(null);
//           
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }//GEN-LAST:event_deleteMouseClicked
    private void insert(){
        try {
            
            String sql = "INSERT INTO asetkeluar VALUES (?,?,?,?)";
            PreparedStatement pst;
            pst = database.conn.prepareStatement(sql);
            
//            pst.setInt(1, Integer.parseInt(a.id));
//            pst.setString(2, a.nama);
//            pst.setInt(3, Integer.parseInt(a.jml));
//            pst.setInt(4, Integer.parseInt(a.ni));
            
            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Input Berhasil");
            
//            Aset aset = new Aset();
//            aset.setVisible(true);
//            aset.setLocationRelativeTo(null);
////            nama=tfnama.getText();
//            sd=cbsuratd.getModel().getSelectedItem().toString();
//            ss=cbsurats.getModel().getSelectedItem().toString();
//            ad=Integer.parseInt(tfayatd.getText());
//            as=Integer.parseInt(tfayats.getText());
//            tgl=tftgl.getText();
//            g=rbguru;
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel insert;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel judul;
    private javax.swing.JLabel lid;
    private javax.swing.JLabel logo;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tfid;
    private javax.swing.JLabel update;
    // End of variables declaration//GEN-END:variables
}
