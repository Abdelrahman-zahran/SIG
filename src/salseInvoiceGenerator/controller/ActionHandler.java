
package salseInvoiceGenerator.controller;



import salesInvoiceGenerator.model.InvoiceLine;
import salesInvoiceGenerator.model.InvoiceLineTable;
import salesInvoiceGenerator.model.InvoiceHeader;
import salesInvoiceGenerator.model.InvoiceHeaderTable;
import salesInvoiceGenerator.view.InvoiceFrame;
import salesInvoiceGenerator.view.ItemFrame;

import salesInvoiceGenerator.view.BasicFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.sound.sampled.Line;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ActionHandler implements ActionListener, ListSelectionListener {
    private BasicFrame Frame;
    public DateFormat DateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private JTable InvoiceHeaderTable;
    private  InvoiceFrame InvoiceFRAME;
    private  ItemFrame ItemFRAME;
    
    
    
    public ActionHandler(BasicFrame Frame) {
        this.Frame = Frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    String actionCommand = e.getActionCommand();
        System.out.println("Action Handlled");
     
        switch (e.getActionCommand())
        {
            case "Create New Invoice":
            System.out.println("Create New Invoice Action");
                CreatInvoiceFrame();
                break;
                
            case "Delete Invoice":
             System.out.println("Delete Invoice Action");
                DeleteInvoiceFrame();
                break;
                
           case "Invoice OK":
            System.out.println("Invoice OK Action");
                InvoiceOK();
                break;
                
            case "Invoice Cancel":
             System.out.println("Invoice Cancel Action");
               InvoiceCancel();
                break;
                
            case "Add new item":
             System.out.println("Add new item");
                Addnewitem ();
                break;
                
            case "Delete Item":
             System.out.println("Delete Item Action");
                DeleteItem();
                break;

            case "Add Item OK":
             System.out.println("Add Item Ok Action"); 
                 ItemLineOk();   
                break;
                
            case "Item Cancel":
            System.out.println("Item Cancel Action");
                ItemeLineCancel();
                break;
                
            case "Save File":
             System.out.println("Save File Action");
                SaveFile();
                break;
                
            case "Load File":
            System.out.println("Load File Action");
              LoadFile();
                break;
        }
    }

    
//INVOICE HEADER CONTROLL
    
    private void CreatInvoiceFrame() 
    {
        InvoiceFRAME = new InvoiceFrame(Frame);
        InvoiceFRAME.setVisible(true);
       try { 
        int invoiceNumber = 0;
        for (InvoiceHeader NewHeader : Frame.getHeaderArray()){
        if (NewHeader.getNumber()> invoiceNumber)
            invoiceNumber = NewHeader.getNumber();
            }
        invoiceNumber++;
        
        InvoiceFRAME.getCustomerNameField().setText("" + invoiceNumber);
       } catch (Exception exception)
       {
           JOptionPane.showMessageDialog(Frame," Select Headers Files First", "Files Were Not Selected", JOptionPane.ERROR_MESSAGE);
           InvoiceFRAME.setVisible(false);
        }
    }
    
        private void DeleteInvoiceFrame() 
    {
  
        int selectedInvoiceIndex = Frame.getInvoiceHeaderTable().getSelectedRow();
        if (selectedInvoiceIndex != -1) {
            Frame.getHeaderArray().remove(selectedInvoiceIndex);
            Frame.getHeaderTable().fireTableDataChanged();

            Frame.getInvoiceItemTable().setModel(new InvoiceLineTable(null));
            Frame.getCustomerNameFeild().setText("");
            Frame.getInvoiceDateField().setText("");
            Frame.getInvoiceNumberFeild().setText("");
            Frame.getInvoiceTotalFeild().setText("");
           
        }

 
    }
   
    private void InvoiceOK() 
    {
        String CustomerName=InvoiceFRAME.getCustomerNameField().getText();
        String DATEFORMATE =InvoiceFRAME.getDateField().getText();
        Date date = new Date();
        try {
            date = BasicFrame.DateFormat.parse(DATEFORMATE);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(Frame, "Inalid Date Format ", "Invalid date format", JOptionPane.ERROR_MESSAGE);
        }
        int InvNumber=0;
        for(InvoiceHeader invoice:Frame.getHeaderArray())
        {
            if(invoice.getNumber()>InvNumber)
            {
             InvNumber=invoice.getNumber();
            }
              InvNumber++;
        }
        InvoiceHeader voices=new InvoiceHeader(InvNumber,CustomerName,DATEFORMATE);
        Frame.getHeaderArray().add(voices);
        Frame.getHeaderTable().fireTableDataChanged();
        InvoiceFRAME.setVisible(false); 
        InvoiceFRAME.dispose();
        InvoiceFRAME=null;
    }
    
    private void InvoiceCancel()
    {
       InvoiceFRAME.setVisible(false);  
       InvoiceFRAME.dispose();
       InvoiceFRAME=null;
    }
 
    //INVOICE ITEM CONTROLL
        
    private void Addnewitem() 
    {
      ItemFRAME = new ItemFrame(Frame);
      ItemFRAME.setVisible(true);
       try { 
        int ItemNumber = 0;
        for (InvoiceHeader NewItem : Frame.getHeaderArray()){
        if (NewItem.getNumber()> ItemNumber)
            ItemNumber = NewItem.getNumber();
       }
        ItemNumber++;
       } catch (Exception exception)
       {
       JOptionPane.showMessageDialog(Frame," Load Invoices First ", "Files Werenot Selected", JOptionPane.ERROR_MESSAGE);
       ItemFRAME.setVisible(false);
      }
      try { 
        int Item = 0;
        for (InvoiceLine NewIt : Frame.GetItemArray()){
        if (NewIt.getCount()> Item)
            Item = NewIt.getCount();
       }
        Item++;
       } catch (Exception exception)
       {
       JOptionPane.showMessageDialog(Frame," Choose Your Customer & Creat new item first", "Files Werenot Selected", JOptionPane.ERROR_MESSAGE);
         ItemFRAME.setVisible(false);
      }
    }

    

    private void ItemLineOk()
     {
      String item = ItemFRAME.getItemNameField().getText();
      String countStr = ItemFRAME.getItemCountField().getText();
      String priceStr = ItemFRAME.getItemPriceField().getText();
        
      int count=1 ;
      double price=1;
        try
        {  
        count = Integer.parseInt(countStr);
        price = Double.parseDouble(priceStr);
        } 
      catch (NumberFormatException ex) 
      {
       JOptionPane.showMessageDialog(Frame, "Cannot convert ", "Invalid number format", JOptionPane.ERROR_MESSAGE);
      }
      int selectedInvHeader = Frame.getInvoiceHeaderTable().getSelectedRow();  
        if (selectedInvHeader != -1) 
        {
            InvoiceHeader invoice = Frame.getHeaderArray().get(selectedInvHeader);
     
            InvoiceLine line = new InvoiceLine(item, price, count, invoice);
            Frame.GetItemArray().add(line);
            InvoiceLineTable linesTableModel = (InvoiceLineTable) Frame.getInvoiceItemTable().getModel();
        
            linesTableModel.fireTableDataChanged();
            Frame.getHeaderTable().fireTableDataChanged();
        }
        Frame.getInvoiceHeaderTable().setRowSelectionInterval(selectedInvHeader, selectedInvHeader);
        ItemFRAME.setVisible(false);
        ItemFRAME.dispose();
        ItemFRAME = null;
    }
   
    private void ItemeLineCancel() {
        ItemFRAME.setVisible(false);  
        ItemFRAME.dispose();
        ItemFRAME=null;
    }
    

  //LOAD & SAVE CONTROLL
    
    private void SaveFile() {
        ArrayList<InvoiceHeader> invoicesArray = Frame. getHeaderArray();
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result = fileChooser.showSaveDialog(Frame);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                File headerFile = fileChooser.getSelectedFile();
                FileWriter HeaderFileWRITER = new FileWriter(headerFile);
                String headers = "";
                String lines = "";
                for (InvoiceHeader invoice : invoicesArray) {
                    headers += invoice.toString();
                    headers += "\n";
                    for (InvoiceLine line : invoice.getLines()) {
                        lines += line.toString();
                        lines += "\n";
                    }
                }
         
                headers = headers.substring(0, headers.length()-1);
                lines = lines.substring(0, lines.length()-1);
                result = fileChooser.showSaveDialog(Frame);
                File lineFile = fileChooser.getSelectedFile();
                FileWriter ItemsFileWRITER = new FileWriter(lineFile);
                HeaderFileWRITER.write(headers);
                ItemsFileWRITER.write(lines);
                HeaderFileWRITER.close();
                ItemsFileWRITER.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(Frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void LoadFile() 
    {
    JOptionPane.showMessageDialog(Frame, "Choose Header File ", "Attention", JOptionPane.WARNING_MESSAGE);
       JFileChooser Choose = new JFileChooser();
        try {
        int result = Choose.showOpenDialog(Frame);
        if (result == JFileChooser.APPROVE_OPTION) 
        {
            File Header=Choose.getSelectedFile();
            String headerStrpath=Header.getAbsolutePath();
            Path headerPath= Paths.get(headerStrpath);
        
            
           List<String>HeaderLines=Files.readAllLines(headerPath);
           ArrayList<InvoiceHeader> InvHeaders =new ArrayList<>();
                for (String headerLine:HeaderLines)
                {
                    String [] Part =headerLine.split(",");
                    String  Part1 = Part[0];
                    String  Part2 = Part[1];
                    String  Part3 = Part[2];
                
                int Code = Integer.parseInt(Part1);
                Date invoiceDate=DateFormat.parse(Part2);
                InvoiceHeader in = new InvoiceHeader(Code,Part3,Part2);
                InvHeaders.add(in);
                }
                 Frame.setInvheaders(InvHeaders);
                 
                 JOptionPane.showMessageDialog(Frame, "Choose Item File ", "Attention", JOptionPane.WARNING_MESSAGE);  
                 
                result = Choose.showOpenDialog(Frame);
                if (result == JFileChooser.APPROVE_OPTION) 
                {
                File Item=Choose.getSelectedFile();
                Path ItemPath= Paths.get(Item.getAbsolutePath());
        
            
                List<String>ItemLines=Files.readAllLines(ItemPath);
                ArrayList<InvoiceLine> InvItem =new ArrayList<>();
                for (String itemline :ItemLines)
                    {
                       String[] Part =itemline.split(",");
                       String  ITPart1 = Part[0];
                       String  ITPart2 = Part[1];
                       String  ITPart3 = Part[2];
                       String  ITPart4 = Part[3];

                   int InvCode = Integer.parseInt(ITPart1);
                   double Price =Double.parseDouble(ITPart3);
                   int count = Integer.parseInt(ITPart4);
                   InvoiceHeader In =Frame.getHeaderObject(InvCode);

                  InvoiceLine line =new InvoiceLine(ITPart2,Price,count,In);
                  In.getLines().add(line);
                  }
                 }
                 InvoiceHeaderTable InvoicesHeaderTable= new InvoiceHeaderTable(InvHeaders);
                    Frame.setHeaderTable(InvoicesHeaderTable);
                    Frame.getInvoiceHeaderTable().setModel(InvoicesHeaderTable);
         
                 System.out.println("file loaded");
        }
        }
        catch (IOException ex)
        {
          Logger.getLogger(ActionHandler.class.getName()).log(Level.SEVERE, null, ex);
          JOptionPane.showMessageDialog(Frame, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        catch (ParseException ex) 
        {
        Logger.getLogger(ActionHandler.class.getName()).log(Level.SEVERE, null, ex);
        JOptionPane.showMessageDialog(Frame, "Cannot read file", "Error", JOptionPane.ERROR_MESSAGE);
        }

    } 
    

  //TABLE LISENTER CHANGE CONTROLL
    
    
    
        private void DeleteItem()
    {
        int lineIndex = Frame.getInvoiceItemTable().getSelectedRow();
         int selectedInvoiceIndex = Frame.getInvoiceItemTable().getSelectedRow();
       int InvoiceIndex = Frame.getInvoiceItemTable().getSelectedRow();
        if (selectedInvoiceIndex != -1)
        {
        InvoiceLine line = Frame.getItemTable().getLines().get(lineIndex);
        Frame.getItemTable().getLines().remove(lineIndex);
        
        Frame.getHeaderTable().fireTableDataChanged();
        Frame.getItemTable().fireTableDataChanged();
        Frame.getInvoiceTotalFeild().setText("" + line.getInvoice().getItemTotal());
         JOptionPane.showMessageDialog(null, "Line Deleted Successfully ! ");
         displayInvoices();
        }
        }
    
    
     private void displayInvoices(){
         for (InvoiceLine line :Frame.GetItemArray()) {
             System.out.println(line);
         }
     }
    
        

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        int selectedInvItem = Frame.getInvoiceHeaderTable().getSelectedRow();
        int selectedInvIndex = Frame.getInvoiceHeaderTable().getSelectedRow();
        System.out.println("Invoice selected:" + selectedInvIndex);
        if (selectedInvIndex != -1  ) {
            InvoiceHeader selectedInv = Frame.getHeaderArray().get(selectedInvIndex);
         
            ArrayList<InvoiceLine> lines = selectedInv.getLines();
            InvoiceLineTable lineTableModel = new InvoiceLineTable(lines);
            Frame.setItemArray(lines);
            Frame.getInvoiceItemTable().setModel(lineTableModel);
            Frame.getCustomerNameFeild().setText(selectedInv.getCustomer());
            Frame.getInvoiceNumberFeild().setText("" + selectedInv.getNumber());
            Frame.getInvoiceTotalFeild().setText("" + selectedInv.getItemTotal());
        Frame.getInvoiceDateField().setText(selectedInv.getDate());
        
        }

    }
        
        
    }

