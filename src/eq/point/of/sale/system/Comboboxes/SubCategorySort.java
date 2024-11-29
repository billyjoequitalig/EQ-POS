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
public class SubCategorySort {

    private int SubCatSortID;
    private String SubCatSort;

    public SubCategorySort(int sortid, String subcatsort) {
        this.SubCatSortID = sortid;
        this.SubCatSort = subcatsort;
    }

    public int getSubCatSortId() {
        return SubCatSortID;
    }

    public void setSubCatSortId(int sortid) {
        this.SubCatSortID = sortid;
    }

    public String getSubCatSort() {
        return SubCatSort;
    }

    public void setSubCatSort(String subcatsort) {
        this.SubCatSort = subcatsort;
    }
}
