
package salesInvoiceGenerator.view;

import salseInvoiceGenerator.controller.ActionHandler;
import salesInvoiceGenerator.model.InvoiceLine;
import salesInvoiceGenerator.model.InvoiceLineTable;
import salesInvoiceGenerator.model.InvoiceHeader;
import salesInvoiceGenerator.model.InvoiceHeaderTable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BasicFrame extends javax.swing.JFrame {

    public BasicFrame() {
        initComponents();
    }
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        InvoiceNumberLabel = new javax.swing.JLabel();
        InvoiceDateLabel = new javax.swing.JLabel();
        CustomerNameLabel = new javax.swing.JLabel();
        InvoiceTotalLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvoiceItemTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        InvoiceHeaderTable = new javax.swing.JTable();
        InvoiceHeaderTable.getSelectionModel().addListSelectionListener(Controller);

        jLabel6 = new javax.swing.JLabel();
        CreateNewInvoiceButton = new javax.swing.JButton();
        CreateNewInvoiceButton.addActionListener(Controller);
        DeleteInvoiceButton = new javax.swing.JButton();
        DeleteInvoiceButton.addActionListener(Controller);
        CreateNewItemButton = new javax.swing.JButton();
        CreateNewItemButton.addActionListener(Controller);
        DeleteItemButton = new javax.swing.JButton();
        DeleteItemButton.addActionListener(Controller);
        InvoiceDateField = new javax.swing.JTextField();
        CustomerNameFeild = new javax.swing.JTextField();
        InvoiceNumberFeild = new javax.swing.JLabel();
        InvoiceTotalFeild = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        LoadFileButton = new javax.swing.JMenuItem();
        LoadFileButton.addActionListener(Controller);
        SaveFileButton = new javax.swing.JMenuItem();
        SaveFileButton.addActionListener(Controller);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sale Invoice Genrator");
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));

        InvoiceNumberLabel.setText("Invoice Number");

        InvoiceDateLabel.setText("Invoice Date");

        CustomerNameLabel.setText("Customer Name");

        InvoiceTotalLabel.setText("Invoice Total");

        jLabel5.setText("Invoice Item");

        InvoiceItemTable.setAutoCreateRowSorter(true);
        InvoiceItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No.", "Item Name", "Item Price", "Count", "Items Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        InvoiceItemTable.setShowGrid(true);
        InvoiceItemTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(InvoiceItemTable);
        InvoiceItemTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        InvoiceHeaderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No.", "Date", "Customer", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        InvoiceHeaderTable.setShowGrid(true);
        jScrollPane2.setViewportView(InvoiceHeaderTable);

        jLabel6.setText("Invoice Table");

        CreateNewInvoiceButton.setText("Create New Invoice");

        DeleteInvoiceButton.setText("Delete Invoice");
        DeleteInvoiceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteInvoiceButtonActionPerformed(evt);
            }
        });

        CreateNewItemButton.setText("Add new item");
        CreateNewItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewItemButtonActionPerformed(evt);
            }
        });

        DeleteItemButton.setText("Delete Item");

        InvoiceNumberFeild.setText(".");

        InvoiceTotalFeild.setText(".");

        jMenu1.setText("File");

        LoadFileButton.setText("Load File");
        LoadFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadFileButtonActionPerformed(evt);
            }
        });
        jMenu1.add(LoadFileButton);

        SaveFileButton.setText("Save File");
        jMenu1.add(SaveFileButton);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(InvoiceNumberLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(InvoiceNumberFeild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CustomerNameLabel)
                            .addComponent(InvoiceTotalLabel)
                            .addComponent(InvoiceDateLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(InvoiceDateField)
                            .addComponent(CustomerNameFeild)
                            .addComponent(InvoiceTotalFeild, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(CreateNewInvoiceButton)
                .addGap(30, 30, 30)
                .addComponent(DeleteInvoiceButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CreateNewItemButton)
                .addGap(62, 62, 62)
                .addComponent(DeleteItemButton)
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceNumberLabel)
                            .addComponent(InvoiceNumberFeild))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceDateLabel)
                            .addComponent(InvoiceDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CustomerNameLabel)
                            .addComponent(CustomerNameFeild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(InvoiceTotalLabel)
                            .addComponent(InvoiceTotalFeild))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CreateNewInvoiceButton)
                    .addComponent(DeleteInvoiceButton)
                    .addComponent(CreateNewItemButton)
                    .addComponent(DeleteItemButton))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void CreateNewItemButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void DeleteInvoiceButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void LoadFileButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

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
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BasicFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BasicFrame().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton CreateNewInvoiceButton;
    private javax.swing.JButton CreateNewItemButton;
    private javax.swing.JTextField CustomerNameFeild;
    private javax.swing.JLabel CustomerNameLabel;
    private javax.swing.JButton DeleteInvoiceButton;
    private javax.swing.JButton DeleteItemButton;
    private javax.swing.JLabel InvoiceNumberFeild;
    private javax.swing.JLabel InvoiceNumberLabel;
    private javax.swing.JTextField InvoiceDateField;
    private javax.swing.JLabel InvoiceDateLabel;
    private javax.swing.JTable InvoiceHeaderTable;
    private javax.swing.JTable InvoiceItemTable;
    private javax.swing.JLabel InvoiceTotalFeild;
    private javax.swing.JLabel InvoiceTotalLabel;
    private javax.swing.JMenuItem LoadFileButton;
    private javax.swing.JMenuItem SaveFileButton;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration                   
     ActionHandler Controller=new ActionHandler(this); 
     
     public ArrayList<InvoiceHeader> HeaderArray;
     public ArrayList<InvoiceLine> ItemArray;
     private InvoiceHeaderTable HeaderTable;
     private InvoiceLineTable ItemTable;
     public static DateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public ArrayList<InvoiceLine> GetItemArray() {
        return ItemArray;
    }
    
    public void setItemArray(ArrayList<InvoiceLine> Items){
        this.ItemArray = Items;
        ItemTable= new InvoiceLineTable(ItemArray);
        this.InvoiceItemTable.setModel(ItemTable);
    }
    
    
        public void setInvheaders(ArrayList<InvoiceHeader> invoices) {
        this.HeaderArray = invoices;
        HeaderTable= new InvoiceHeaderTable(HeaderArray);
        this.InvoiceHeaderTable.setModel(HeaderTable);
    }

    
    public ArrayList<InvoiceHeader> getHeaderArray() {
        return HeaderArray;
    }
    



    public ActionHandler getController() {
        return Controller;
    }

    public InvoiceHeader getHeaderObject(int Code)  {
     for  (InvoiceHeader inv :HeaderArray){
       if (inv.getNumber() == Code){
         return inv; }
     }
       return null;
    }

    public void setHeaderTable(InvoiceHeaderTable HeaderTable) {
        this.HeaderTable = HeaderTable;
    }
    
  
        public void setitemTable(InvoiceLineTable ItemTable) {
        this.ItemTable = ItemTable;
    }

     
    public InvoiceHeaderTable getHeaderTable() {
        return HeaderTable;
    }

    
        public InvoiceLineTable getItemTable() {
        return ItemTable;
    }
//    public void setInvLineTableModel(Invoice_line_Table_Cls invLineTableModel) {
//        this.ItemTable = invLineTableModel;
//    }
//    
        
        
        
    public InvoiceHeaderTable getHeaderTableModel() {
        return HeaderTable;
    }

    public void setHeaderTableModel(InvoiceHeaderTable headerTableModel) {
        this.HeaderTable = headerTableModel;
    }
        
        
    public JTable getInvoiceHeaderTable() {
        return InvoiceHeaderTable;
    }

    public JTable getInvoiceItemTable() {
        return InvoiceItemTable;
    }

    public void setInvoiceItemTable(JTable InvoiceItemTable) {
        this.InvoiceItemTable = InvoiceItemTable;
    }

    public void setInvoiceHeaderTable(JTable InvoiceHeaderTable) {
        this.InvoiceHeaderTable = InvoiceHeaderTable;
    }
    


    public JLabel getInvoiceNumberFeild() {
        return InvoiceNumberFeild;
    }

    public JTextField getInvoiceDateField() {
        return InvoiceDateField;
    }

    public JLabel getInvoiceTotalFeild() {
        return InvoiceTotalFeild;
    }

    public JTextField getCustomerNameFeild() {
        return CustomerNameFeild;
    }

 

}
