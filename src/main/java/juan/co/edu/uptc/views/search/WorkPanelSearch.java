package juan.co.edu.uptc.views.search;

import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.views.wildCardClasses.CustomButton;

import juan.co.edu.uptc.views.wildCardClasses.Global;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.Arrays;

@Getter
@Setter
public class WorkPanelSearch extends JPanel {
    private Interfaces.Presenter presenter;
    private JDialog parent;

    public WorkPanelSearch(JDialog parent, Interfaces.Presenter presenterVet){
        this.parent = parent;
        this.presenter = presenterVet;
    }

    public void buildPanel() {
        initWorkPanel();
        addButtons();
        requestFocusInWindow();
    }

    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(null); // Set layout to null for manual positioning
    }

    private void addButtons(){
        CustomButton buttonRegister = createButtonRegister();
        CustomButton buttonReturn = createButtonReturn();

        // Calculate the center position for the buttons
        int panelWidth = 600; // Assuming the panel width
        int panelHeight = 500; // Assuming the panel height
        int buttonWidth = 200;
        int buttonHeight = 60;
        int buttonY = (panelHeight / 2) + 50; // Centered vertically with some offset

        buttonRegister.setBounds((panelWidth / 2) - buttonWidth - 10, buttonY, buttonWidth, buttonHeight);
        buttonReturn.setBounds((panelWidth / 2) + 10, buttonY, buttonWidth, buttonHeight);

        add(buttonRegister);
        add(buttonReturn);
    }

    private CustomButton createButtonRegister(){
        CustomButton button = new CustomButton("Buscar");
        button.addActionListener(e -> {
            if (presenter != null) {
                String manufacturer = selectManufacturer();
                int electricRange = selectElectricRange();
                String model = selectVehicleModel();

                if (manufacturer != null && model != null) {
                    JOptionPane.showMessageDialog(this, presenter.countByModelManufacturerAndElectricRange(model, manufacturer, electricRange));
                }
            }
        });
        return button;
    }

    private CustomButton createButtonReturn() {
        CustomButton button = new CustomButton("Volver");
        button.addActionListener(e -> parent.dispose());
        return button;
    }

    private String selectManufacturer() {
        String manufacturer = null;
        while (manufacturer == null || manufacturer.isEmpty()) {
            Object[] manufacturers = presenter.getManufacters();
            String[] manufacturerStrings = Arrays.copyOf(manufacturers, manufacturers.length, String[].class);
            manufacturer = (String) JOptionPane.showInputDialog(this, "Seleccione el fabricante:", "Fabricante", JOptionPane.QUESTION_MESSAGE, null, manufacturerStrings, manufacturerStrings[0]);
            if (manufacturer == null || manufacturer.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un fabricante.");
            }
        }
        return manufacturer;
    }

    private int selectElectricRange() {
        int electricRange = -1;
        while (electricRange == -1) {
            String input = JOptionPane.showInputDialog(this, "Ingrese el rango eléctrico:");
            try {
                electricRange = Integer.parseInt(input);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un número válido para el rango eléctrico.");
            }
        }
        return electricRange;
    }

    private String selectVehicleModel() {
        String model = null;
        while (model == null || model.isEmpty()) {
            Object[] vehicleModels = presenter.getVehicleModels();
            String[] vehicleModelStrings = Arrays.copyOf(vehicleModels, vehicleModels.length, String[].class);
            model = (String) JOptionPane.showInputDialog(this, "Seleccione el modelo del vehículo:", "Modelo del Vehículo", JOptionPane.QUESTION_MESSAGE, null, vehicleModelStrings, vehicleModelStrings[0]);
            if (model == null || model.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar un modelo de vehículo.");
            }
        }
        return model;
    }
}