/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TempatWisata;

/**
 *
 * @author Lenovo
 */
public class tbModLsTW extends AbstractTableModel{
    
    List<TempatWisata> list = new ArrayList<>();
    private final String[] header = {"Id","Nama","Rating","Alamat"};
    
    
    @Override
    public int getRowCount() {
        return list.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TempatWisata tw = list.get(rowIndex);
        switch(columnIndex){
            case 0 : return tw.getId();
            case 1 : return tw.getNama();
            case 2 : return tw.getRating();
            case 3 : return tw.getAlamat();
            default : return null;
        }
    }
    
    public void add(List<TempatWisata> listTW){
        list = listTW;
        fireTableDataChanged();
    }
    
}
