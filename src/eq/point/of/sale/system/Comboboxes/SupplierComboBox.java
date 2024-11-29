/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eq.point.of.sale.system.Comboboxes;

/**
 *
 * @author Allan
 */
public class SupplierComboBox {
    private int SupId;
    private String Sup;
    
    public SupplierComboBox(int supid, String sup){
        this.SupId = supid;
        this.Sup = sup;
    }
    
    public int getSupId(){
        return SupId;
    }
    
    public void setSupId(int supid){
        this.SupId = supid;
    }
    
    public String getSup(){
        return Sup;
    }
    
    public void setSup(String sup){
        this.Sup = sup;
    }
}
