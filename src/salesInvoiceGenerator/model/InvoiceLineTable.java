
package salesInvoiceGenerator.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nadah
 */
public class InvoiceLineTable extends AbstractTableModel {
    
    private ArrayList<InvoiceLine> ItemArray;
    private String[] columns = {"No.", "Item Name", "Item Price", "Count", "Item Total"};

    
    
      public InvoiceLineTable(ArrayList<InvoiceLine> ItemArray) {
      this.ItemArray = ItemArray;
    }

    public ArrayList<InvoiceLine> getLines() {
        return ItemArray;
    }
    
    @Override
    public int getRowCount() {
    return    ItemArray == null ? 0 : ItemArray.size();
    }

    @Override
    public int getColumnCount() {
     return columns.length;

    }

    @Override
    public Object getValueAt(int Row, int Column) {
//                if (ItemArray == null) {
//            return "";
//        } else {
    
          InvoiceLine ItemArrayLst = ItemArray.get(Row);
          switch(Column) 
           {
           case 0: return ItemArrayLst.getInvoice().getNumber();
           case 1: return ItemArrayLst.getItem();
           case 2: return ItemArrayLst.getPrice();
           case 3: return ItemArrayLst.getCount();
           case 4: return ItemArrayLst.getItemsTotal();
           default : return "";
           }
          }
//          }
   
    
    @Override
    public String getColumnName(int Col) {
        return columns[Col];
    }
 
//
//
//        @Override
//    public boolean isCellEditable(int rowIndex, int columnIndex) {
//    return true;
//    }
//
//    
    
    
    
    
}
