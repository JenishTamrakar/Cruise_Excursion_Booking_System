import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Bookings extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    /**
     * Creates new form Bookings
     */
    public Bookings() {
        initComponents();
        setLocation(340, 100);
        setResizable(false);
        show_book();
                
        String a = SignIn.un;
        
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            String query1="select NAME from user where USERNAME='"+a+"'";
            ps = con.prepareStatement(query1);
            rs = ps.executeQuery(query1);
            //jLabel2.setText(a);
//            jc1.removeAllItems();
            while(rs.next())
            {
                jLabel2.setText(rs.getString("NAME"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public ArrayList<Book> bookList(){    
        ArrayList<Book> bookingList = new ArrayList<>();
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            String query4 = "select Booking_ID, Excursion_Name, Port_ID, Booked_Date, No_of_Seats, Booking_Status, Booked_By from booking_info";
            Statement st = con.createStatement();
            //ps = con.prepareStatement(query4);
            rs = st.executeQuery(query4);
            Book asd;
            while(rs.next())
            {
                asd = new Book(rs.getInt("Booking_ID"), rs.getString("Excursion_Name"), rs.getString("Port_ID"), rs.getString("Booked_Date"), rs.getInt("No_of_Seats"), rs.getString("Booking_Status"), rs.getString("Booked_By"));
                bookingList.add(asd);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return bookingList;
    }
    
    public final void show_book(){
        ArrayList<Book> list = bookList();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        Object[] row = new Object[7];
        for(int i=0; i<list.size(); i++){
            row[0] = list.get(i).getBooking_ID();
            row[1] = list.get(i).getExcursion_Name();
            row[2] = list.get(i).getPort_ID();
            row[3] = list.get(i).getBooked_Date();
            row[4] = list.get(i).getNo_of_Seats();
            row[5] = list.get(i).getBooking_Status();
            row[6] = list.get(i).getBooked_By();
            model.addRow(row);
            //System.out.println(row);
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
        jLabel1 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        btnWaitList = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelBookID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelExcursionName = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNoofSeats = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelPortID = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabelBookedBy = new javax.swing.JLabel();
        txtBookStatus = new javax.swing.JTextField();
        txtBookedDate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabelAvailableSeats = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cruise Excursion Booking System");

        btnHome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnWaitList.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnWaitList.setText("Waiting List");
        btnWaitList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnWaitListActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Booking ID", "Excursion Name", "Port ID", "Booked Date", "No. of Seats", "Booking Status", "Booked By"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Booking ID");

        jLabelBookID.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Excursion Name");

        jLabelExcursionName.setForeground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Booked Date");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Booking Status");

        txtNoofSeats.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNoofSeats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoofSeatsActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("No. of Seats");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Port ID");

        jLabelPortID.setForeground(new java.awt.Color(255, 255, 255));

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancel.setText("Cancel Booking");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Booked By");

        jLabelBookedBy.setForeground(new java.awt.Color(255, 255, 255));

        txtBookStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookStatusActionPerformed(evt);
            }
        });

        txtBookedDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBookedDateActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Available Seats");

        jLabelAvailableSeats.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnWaitList)
                        .addGap(477, 477, 477)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(25, 25, 25))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelExcursionName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelPortID, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBookedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNoofSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabelAvailableSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtBookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabelBookedBy, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome)
                    .addComponent(btnWaitList)
                    .addComponent(jButton1))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBookID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelExcursionName, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPortID, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBookedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoofSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtBookStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabelBookedBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelAvailableSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        AdminHome Home = new AdminHome();
        Home.setVisible(true);
        dispose();        
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnWaitListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnWaitListActionPerformed
        WaitingList wl = new WaitingList();
        wl.setVisible(true);
        dispose();        
    }//GEN-LAST:event_btnWaitListActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SignIn asdf = new SignIn();
        asdf.setVisible(true);
        dispose();        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNoofSeatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoofSeatsActionPerformed
        
    }//GEN-LAST:event_txtNoofSeatsActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            int g = jTable2.getSelectedRow();
            int ns = (Integer.parseInt((String) txtNoofSeats.getText()));          
            if(g >= 0){
                if(ns<=(Integer.parseInt(jLabelAvailableSeats.getText()))){
                    String query7 = "UPDATE `booking_info` SET `Booking_ID`='"+jLabelBookID.getText()+"',`Excursion_Name`='"+jLabelExcursionName.getText()+"',`Port_ID`='"+jLabelPortID.getText()+"',`Booked_Date`='"+txtBookedDate.getText()+"',`No_of_Seats`='"+txtNoofSeats.getText()+"',`Booking_Status`= 'Booked' WHERE `Booking_ID`='"+jLabelBookID.getText()+"'";
                    ps = con.prepareStatement(query7);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Booking Successfully Updated");
                    ps.addBatch();
                }
                else{
                    String query7 = "UPDATE `booking_info` SET `Booking_ID`='"+jLabelBookID.getText()+"',`Excursion_Name`='"+jLabelExcursionName.getText()+"',`Port_ID`='"+jLabelPortID.getText()+"',`Booked_Date`='"+txtBookedDate.getText()+"',`No_of_Seats`='"+txtNoofSeats.getText()+"',`Booking_Status`= 'Wait Listed' WHERE `Booking_ID`='"+jLabelBookID.getText()+"'";
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
        }
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        show_book();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost/group_11", "root", "");
            //DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
            //model.setRowCount(0);
            int g = jTable2.getSelectedRow();
            if(g >= 0){
                String query7 = "UPDATE `booking_info` SET `Booking_ID`='"+jLabelBookID.getText()+"',`Excursion_Name`='"+jLabelExcursionName.getText()+"',`Port_ID`='"+jLabelPortID.getText()+"',`Booked_Date`='"+txtBookedDate.getText()+"',`No_of_Seats`='"+txtNoofSeats.getText()+"',`Booking_Status`='Cancelled' WHERE `Booking_ID`='"+jLabelBookID.getText()+"'";
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
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        show_book();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        int g = jTable2.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        jLabelBookID.setText(model.getValueAt(g, 0).toString());
        jLabelExcursionName.setText(model.getValueAt(g, 1).toString());
        jLabelPortID.setText(model.getValueAt(g, 2).toString());
        txtBookedDate.setText(model.getValueAt(g, 3).toString());
        txtNoofSeats.setText(model.getValueAt(g, 4).toString()); 
        txtBookStatus.setText(model.getValueAt(g, 5).toString());  
        jLabelBookedBy.setText(model.getValueAt(g, 6).toString());
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
    }//GEN-LAST:event_jTable2MouseClicked

    private void txtBookStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookStatusActionPerformed

    private void txtBookedDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBookedDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBookedDateActionPerformed

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
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Bookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Bookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnWaitList;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabelBookedBy;
    private javax.swing.JLabel jLabelExcursionName;
    private javax.swing.JLabel jLabelPortID;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtBookStatus;
    private javax.swing.JTextField txtBookedDate;
    private javax.swing.JTextField txtNoofSeats;
    // End of variables declaration//GEN-END:variables

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
}