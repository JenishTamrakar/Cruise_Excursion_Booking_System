import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerMyBooking extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String b;
    
    //static String x;
    /**
     * Creates new form CustomerMyBooking
     */
    public CustomerMyBooking() {
        initComponents();
        setLocation(340, 100);
        setResizable(false);
        String a = SignIn.un;
        
        //to show name of the user
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            String query1="select NAME from user where USERNAME='"+a+"'";
            ps = con.prepareStatement(query1);
            rs = ps.executeQuery(query1);
           
            while(rs.next())
            {
                b = rs.getString("NAME");
                //x = b;
                //System.out.println(b);
                jLabel2.setText(b);
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        show_book();
        
    }
    
    
    public ArrayList<Book> bookList(){
       
        ArrayList<Book> bookingList = new ArrayList<>();
        try{
        con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
        String query4 = "SELECT `Booking_ID`, `Excursion_Name`, `Port_ID`, `Booked_Date`, `No_of_Seats`, `Booking_Status`, `Booked_By` FROM `booking_info` WHERE `Booking_Status`='Booked' AND `Booked_By`='"+b+"'";
        ps = con.prepareStatement(query4);
            
            //ps.setString(1, b);
            rs = ps.executeQuery();
            // System.out.print(b);
            Book asd;
            while(rs.next())
            {
                asd = new Book(rs.getInt("Booking_ID"), rs.getString("Excursion_Name"), rs.getString("Port_ID"), rs.getString("Booked_Date"), rs.getInt("No_of_Seats"), rs.getString("Booking_Status"), rs.getString("Booked_By"));
                bookingList.add(asd);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            //e.printStackTrace();
        }
        return bookingList;
    }
    
    public void show_book(){
        ArrayList<Book> list = bookList();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        Object[] row = new Object[7];
        for(int i=0; i<list.size(); i++){
            row[0] = list.get(i).getBooking_ID();
            row[1] = list.get(i).getExcursion_Name();
            row[2] = list.get(i).getPort_ID();
            row[3] = list.get(i).getBooked_Date();
            row[4] = list.get(i).getNo_of_Seats();
            row[5] = list.get(i).getBooking_Status();
            //row[6] = list.get(i).getBooked_By();
            model.addRow(row);
            //System.out.println(row);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnWaitList = new javax.swing.JButton();
        btnLogOut = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNoofSeats = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabelBookID = new javax.swing.JLabel();
        jLabelExcursionName = new javax.swing.JLabel();
        jLabelPortID = new javax.swing.JLabel();
        jLabelBookedDate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelBookStatus = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelAvailableSeats = new javax.swing.JLabel();
        btnMyProfile = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cruise Excursion Booking System");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 660, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Customer's Name");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(540, 50, 140, 20);

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });
        jPanel1.add(btnHome);
        btnHome.setBounds(10, 80, 110, 23);

        btnWaitList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnWaitList.setText("View Waiting List");
        btnWaitList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitListActionPerformed(evt);
            }
        });
        jPanel1.add(btnWaitList);
        btnWaitList.setBounds(130, 80, 150, 23);

        btnLogOut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnLogOut.setText("Log Out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogOut);
        btnLogOut.setBounds(590, 80, 90, 23);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("My Bookings");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 110, 150, 37);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Excursion Name", "Port ID", "Booked Date", "No. of Seats", "Booking Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 670, 100);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Booking ID");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 290, 70, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Excursion Name");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(290, 290, 110, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Port ID");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 320, 70, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No. of Seats");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 350, 80, 20);

        txtNoofSeats.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNoofSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoofSeatsActionPerformed(evt);
            }
        });
        jPanel1.add(txtNoofSeats);
        txtNoofSeats.setBounds(130, 350, 80, 21);

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);
        btnUpdate.setBounds(450, 410, 90, 23);

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel Booking");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);
        btnCancel.setBounds(550, 410, 130, 23);

        jLabelBookID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelBookID);
        jLabelBookID.setBounds(130, 290, 80, 20);

        jLabelExcursionName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelExcursionName);
        jLabelExcursionName.setBounds(410, 290, 270, 20);

        jLabelPortID.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelPortID);
        jLabelPortID.setBounds(130, 320, 100, 20);

        jLabelBookedDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelBookedDate);
        jLabelBookedDate.setBounds(410, 320, 100, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Booked Date");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(290, 320, 100, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Booking Status");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(290, 350, 100, 20);

        jLabelBookStatus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelBookStatus);
        jLabelBookStatus.setBounds(410, 350, 100, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Available Seats");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 380, 100, 20);

        jLabelAvailableSeats.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelAvailableSeats);
        jLabelAvailableSeats.setBounds(130, 380, 80, 20);

        btnMyProfile.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMyProfile.setText("My Profile");
        btnMyProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyProfileActionPerformed(evt);
            }
        });
        jPanel1.add(btnMyProfile);
        btnMyProfile.setBounds(290, 80, 100, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        CustomerHome Home = new CustomerHome();
        Home.setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        SignIn sin = new SignIn();
        sin.setVisible(true);
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void btnWaitListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaitListActionPerformed
        WaitingList Wl= new WaitingList();
        Wl.setVisible(true);
        dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnWaitListActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            //DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            //model.setRowCount(0);
            int g = jTable1.getSelectedRow();
            if(g >= 0){
                String query7 = "UPDATE `booking_info` SET `Booking_ID`='"+jLabelBookID.getText()+"',`Excursion_Name`='"+jLabelExcursionName.getText()+"',`Port_ID`='"+jLabelPortID.getText()+"',`Booked_Date`='"+jLabelBookedDate.getText()+"',`No_of_Seats`='"+txtNoofSeats.getText()+"',`Booking_Status`='Cancelled' WHERE `Booking_ID`='"+jLabelBookID.getText()+"'";
                ps = con.prepareStatement(query7);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Booking Successfully Cancelled");
                ps.addBatch();
            }
            else{
                JOptionPane.showMessageDialog(null, "Error. Please select a booking.");
            }
        }   
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        show_book();
       
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int g = jTable1.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jLabelBookID.setText(model.getValueAt(g, 0).toString());
        jLabelExcursionName.setText(model.getValueAt(g, 1).toString());
        jLabelPortID.setText(model.getValueAt(g, 2).toString());
        jLabelBookedDate.setText(model.getValueAt(g, 3).toString());
        txtNoofSeats.setText(model.getValueAt(g, 4).toString()); 
        jLabelBookStatus.setText(model.getValueAt(g, 5).toString());
        //for available seats
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            String query = "select SUM(No_of_Seats) from booking_info where Booking_Status = 'Booked' AND Excursion_Name='"+jLabelExcursionName.getText()+"'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            int s = 0;
            while(rs.next())
            {    
                //System.out.println( rs.getInt(1));
                s = rs.getInt(1);
            }
            int available_seats = (32 - s);
            String av_seats = "" + available_seats;
            //System.out.println(available_seats);
            jLabelAvailableSeats.setText(av_seats);
        }
        catch(Exception e)
        {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            int g = jTable1.getSelectedRow();
            int ns = (Integer.parseInt((String) txtNoofSeats.getText()));          
            if(g >= 0){
                if(ns<=(Integer.parseInt(jLabelAvailableSeats.getText()))){
                    String query7 = "UPDATE `booking_info` SET `Booking_ID`='"+jLabelBookID.getText()+"',`Excursion_Name`='"+jLabelExcursionName.getText()+"',`Port_ID`='"+jLabelPortID.getText()+"',`Booked_Date`='"+jLabelBookedDate.getText()+"',`No_of_Seats`='"+txtNoofSeats.getText()+"',`Booking_Status`= 'Booked' WHERE `Booking_ID`='"+jLabelBookID.getText()+"'";
                    ps = con.prepareStatement(query7);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Booking Successfully Updated");
                    ps.addBatch();
                }
                else{
                    String query7 = "UPDATE `booking_info` SET `Booking_ID`='"+jLabelBookID.getText()+"',`Excursion_Name`='"+jLabelExcursionName.getText()+"',`Port_ID`='"+jLabelPortID.getText()+"',`Booked_Date`='"+jLabelBookedDate.getText()+"',`No_of_Seats`='"+txtNoofSeats.getText()+"',`Booking_Status`= 'Wait Listed' WHERE `Booking_ID`='"+jLabelBookID.getText()+"'";
                    ps = con.prepareStatement(query7);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Booking Successfully Updated. Your booking has been taken to the Wait List due to "
                            + "unavailability of sufficient seats.");
                    ps.addBatch();
               }
            }
            else{
                JOptionPane.showMessageDialog(null, "Error. Please select a booking.");
            }   
        }   
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        show_book();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtNoofSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoofSeatsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoofSeatsActionPerformed

    private void btnMyProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyProfileActionPerformed
        MyProfile mp = new MyProfile();
        mp.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnMyProfileActionPerformed
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(CustomerMyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMyBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMyBooking().setVisible(true);
            }
        });
    }
    
    private static class Book {
        private int Booking_ID, No_of_Seats;
        private String Excursion_Name, Booked_Date, Port_ID, Booking_Status, Booked_By;
        
        public Book(int Booking_ID, String Excursion_Name, String Port_ID, String Booked_Date, int No_of_Seats, String Booking_Status, String Booked_By) {
            this.Booking_ID = Booking_ID;
            this.Excursion_Name = Excursion_Name;
            this.Port_ID = Port_ID;
            this.Booked_Date = Booked_Date;
            this.No_of_Seats = No_of_Seats;
            this.Booking_Status = Booking_Status;        
            this.Booked_By = Booked_By;
        }
        public int getBooking_ID(){
            return Booking_ID;
        }
        public String getExcursion_Name(){
            return Excursion_Name;
        }
        public String getPort_ID(){
            return Port_ID;
        }
        public String getBooked_Date(){
            return Booked_Date;
        }
        public int getNo_of_Seats(){
            return No_of_Seats;
        }
        public String getBooking_Status(){
            return Booking_Status;
        }
        public String getBooked_By(){
            return Booked_By;
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnMyProfile;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWaitList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAvailableSeats;
    private javax.swing.JLabel jLabelBookID;
    private javax.swing.JLabel jLabelBookStatus;
    private javax.swing.JLabel jLabelBookedDate;
    private javax.swing.JLabel jLabelExcursionName;
    private javax.swing.JLabel jLabelPortID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtNoofSeats;
    // End of variables declaration//GEN-END:variables
    
    
}
