package juan.co.edu.uptc.views.tables.byState;

import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.views.tables.Table;
import juan.co.edu.uptc.views.wildCardClasses.Global;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class WorkByState extends JPanel {
    private Table tableByDateAppointments;
    private final Interfaces.Presenter presenter;

    public WorkByState(Interfaces.Presenter presenter) {
        this.presenter = presenter;
        initWorkPanel();
    }

    private void initWorkPanel() {
        tableByDateAppointments = new Table();
        tableByDateAppointments.createTable(new String[]{"Estado", "Cantidad de registros"});
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        createTitle();
        createTable();
    }
    private void createTable() {
        JScrollPane scrollPane = new JScrollPane(tableByDateAppointments.getTable());
        scrollPane.setPreferredSize(obtainSizeForTable());
        setTableData();
        add(scrollPane, BorderLayout.CENTER);
    }
    private void createTitle() {
        JPanel subHeaderPanel = new JPanel();
        subHeaderPanel.setBackground(Global.WORK_BACKGROUND_COLOR);
        subHeaderPanel.setLayout(new BoxLayout(subHeaderPanel, BoxLayout.X_AXIS));
        subHeaderPanel.setPreferredSize(obtainSizeForSubHeader());
        createTitle(subHeaderPanel);
        add(subHeaderPanel, BorderLayout.NORTH);
    }
    private void createTitle(JPanel panel) {
        JLabel title = new JLabel("Registros ordenados por estado");
        title.setFont(Global.FONT_TITLE_BIG);
        title.setForeground(Global.WORK_TEXT_COLOR);
        title.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.add(title);
    }
    private Dimension obtainSizeForTable() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.5;
        return new Dimension((int) width, (int) height);
    }
    private Dimension obtainSizeForSubHeader() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth() * 0.95;
        double height = screenSize.getHeight() * 0.1;
        return new Dimension((int) width, (int) height);
    }

    private void setTableData() {
        Object[][] vehiclesList = presenter.obtainVehiclesByState();
        for (Object[] datum : vehiclesList) {
            tableByDateAppointments.putData(datum);
        }
    }
}
