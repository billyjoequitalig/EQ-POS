/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eq.point.of.sale.system;

/**
 *
 * @author Diowinard Medrano
 */
public class PrintReceipt {

    private String qty;
     private String uom;
      private String description;
       private String unitcost;
       private String total;
      
       

    public PrintReceipt(String qty, String uom, String description,String unitcost,String total) {
        this.qty = qty;
        this.uom = uom;
        this.description = description;
        this.total = total;
        this.unitcost=unitcost;
        
    }

    public String getUnitcost() {
        return unitcost;
    }

    public void setUnitcost(String unitcost) {
        this.unitcost = unitcost;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

   

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getUom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
