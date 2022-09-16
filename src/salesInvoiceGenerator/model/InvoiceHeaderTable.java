
package salesInvoiceGenerator.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class InvoiceHeaderTable extends AbstractTableModel {
    
    private ArrayList<InvoiceHeader> invheaderslists;
    private String[] columns = {"No.", "Date", "Customer", "Total"};
    
    
    public InvoiceHeaderTable(ArrayList<InvoiceHeader> InvoicesArrayt) {
        this.invheaderslists = InvoicesArrayt;
    }
    
     public List<InvoiceHeader> getInvoicesArray() {
        return invheaderslists;
    }
    
    
    @Override
    public int getRowCount() {
    return invheaderslists==null  ? 0 : invheaderslists.size();
    }
    @Override
    public int getColumnCount() {
     return columns.length;
    }

   @Override
    public Object getValueAt(int Row, int Column)
    {
      InvoiceHeader InvoicesArrayLst = invheaderslists.get(Row);
        switch (Column)
        {
          case 0: return InvoicesArrayLst.getNumber();
          case 1: return InvoicesArrayLst.getDate();
          case 2: return InvoicesArrayLst.getCustomer();
          case 3: return InvoicesArrayLst.getItemTotal();
          default : return "";
     }
    }
    
   @Override
    public String getColumnName(int ColumnName)
    {
     return columns [ColumnName] ;
    }
}
    


