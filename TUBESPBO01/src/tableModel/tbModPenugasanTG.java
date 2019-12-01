/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableModel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.TourGuide;

/**
 *
 * @author Lenovo
 */
public class tbModPenugasanTG extends AbstractTableModel {
    List<String[]> list = new ArrayList<>();
    private final String[] header = {"Paket Wisata","Tanggal Berangkat","Tanggal Pulang","Customer"};
    
    
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
        String[] row = list.get(rowIndex);
        switch(columnIndex){
            case 0 : return row[0];
            case 1 : return row[1];
            case 2 : return row[2];
            case 3 : return "Lihat Data";
            default : return null;
        }
    }
    
    public void updateTable(List<String[]> listPngs){
        list = listPngs;
        fireTableDataChanged();
    }
    
}
