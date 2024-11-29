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
public class CategoryComboBox {
    
    private int CatId;
    private String Cat;
    
    public CategoryComboBox(int catid, String cat){
        this.CatId = catid;
        this.Cat = cat;
    }
    
    public int getCatId(){
        return CatId;
    }
    
    public void setCatId(int id){
        this.CatId = id;
    }
    
    public String getCat(){
        return Cat;
    }
    
    public void setCat(String catname){
        this.Cat = catname;
    }
}
