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
public class SubCategoryComboBox {
    private int SubCatID;
    private String SubCat;
    
    public SubCategoryComboBox(int id, String subcat){
        this.SubCatID = id;
        this.SubCat = subcat;
    }
    
    public int getSubCatId(){
        return SubCatID;
    }
    
    public void setSubCatId(int id){
        this.SubCatID = id;
    }
    
    public String getSubCat(){
        return SubCat;
    }
    
    public void setSubCat(String subcat){
        this.SubCat = subcat;
    }
}
