package User.SeeOrder.Swing.CellLate;

import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;

public class CellLateEditor extends DefaultCellEditor {

    private TableActionLateEvent event;

    public CellLateEditor(TableActionLateEvent event) {
        super(new JCheckBox());
        this.event = event;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        CellActionLate action = new CellActionLate();
        action.initEvent(event, row);
        action.setBackground(table.getSelectionBackground());
        return action;
    }
}
