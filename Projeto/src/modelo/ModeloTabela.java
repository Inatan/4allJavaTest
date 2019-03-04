package modelo;

import javax.swing.Icon;
import javax.swing.table.AbstractTableModel;

/**
 * Essa classe foi necessária ser criada para permitir que as imagens sejam 
 * inseridas na tabela. 
 * Ela herda de uma modelo abstrato de tabela, possui poucas mudanças
 * Mantive me inglês para respeitar o padrão da classe pai
 * @author Inatan
 */
public class ModeloTabela extends AbstractTableModel{

    private String[] columns; // cabeçalhos
    private Object[][] rows; //

    //construtor
    public ModeloTabela() {
    
    }
    
    //construtor
    public ModeloTabela(String[] columns, Object[][] rows) {
        this.columns = columns;
        this.rows = rows;
    }
 

    
    @Override
    public boolean isCellEditable(int row, int col) {
        if ( col == 0 ) {
            return false;
        } else {
            return true;
        }
    }
    
    
    @Override
     public Class getColumnClass(int column){ // funçao alterada para adicionara imagem
        if(column == 0){
            return Icon.class;
        }
        else{
            return getValueAt(0,column).getClass();
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    } 
     
    @Override
    public int getRowCount(){
        return this.rows.length;
    }

    @Override
    public int getColumnCount(){
        return this.columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.rows[rowIndex][columnIndex];
    }
    
    @Override
    public void setValueAt(Object value, int row, int column) {
        rows[row][column] = value;
        fireTableCellUpdated(row, column);
    }
}
