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
public class ColorComboBox {
    private int ColorId;
    private String Color;
    
    public ColorComboBox(int colorid, String color){
        this.ColorId = colorid;
        this.Color = color;
    }
    
    public int getColorId(){
        return ColorId;
    }
    
    public void setColorId(int colorid){
        this.ColorId = colorid;
    }
    
    public String getColor(){
        return Color;
    }
    
    public void setColor(String color){
        this.Color = color;
    }
}
