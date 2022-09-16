/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package salesInvoiceGenerator.model;

public class InvoiceLine {
    
    private InvoiceHeader Invoice;
    private String Item;
    private double Price;
    private int Count;
    private Double Total;

        public InvoiceLine(String Item, double Price, int Count,InvoiceHeader Invoice) {
        this.Invoice = Invoice;
        this.Item = Item;
        this.Price = Price;
        this.Count = Count;
    }


    public InvoiceHeader getInvoice() {
        return Invoice;
    }
    public String getItem() {
        return Item;
    }
    public double getPrice() {
        return Price;
    }
    public int getCount() {
        return Count;
    }
    public Double getItemsTotal() {
        return Count*Price;
    }

    
    public void setInvoice(InvoiceHeader Invoice) {
        this.Invoice = Invoice;
    }
    public void setItem(String Item) {
        this.Item = Item;
    }
    public void setPrice(double Price) {
        this.Price = Price;
    }
    public void setCount(int Count) {
        this.Count = Count;
    }
    public void setTotal(Double Total) {
        this.Total = Total;
    }

    
        @Override
    public String toString() {
        return Invoice.getNumber() + "," + Item + "," + Price + "," + Count;
    }
    
     public String getItemCSV() {
        return Invoice.getNumber() + "," + Item + "," + Price + "," + Count;
    }
     
}
