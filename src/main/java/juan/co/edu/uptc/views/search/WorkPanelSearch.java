package juan.co.edu.uptc.views.search;

import  juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.views.wildCardClasses.NumericTextField;
import lombok.Getter;
import lombok.Setter;
import juan.co.edu.uptc.views.wildCardClasses.CustomButton;
import juan.co.edu.uptc.views.wildCardClasses.Global;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Getter
@Setter
public class WorkPanelSearch extends JPanel {
    private Interfaces.Presenter presenter;
    private JComboBox byFabricante;
    private NumericTextField byRangoElectrico;
    private JComboBox byModeloDeVehiculo;
    private JDialog parent;

    public WorkPanelSearch(JDialog parent, Interfaces.Presenter presenterVet){
        this.parent = parent;
        this.presenter = presenterVet;
    }

    public void buildPanel() {
        initWorkPanel();
        createLabelAndText();
        requestFocusInWindow();
        addButtons();
    }

    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BorderLayout());
    }

    private void createLabelAndText(){
        JPanel gridPanel = new JPanel(new GridLayout(4, 3, 20, 20));
        addFirstAndSecondRow(gridPanel);
        createEmptySpace(gridPanel);
        createEmptySpace(gridPanel);
        int marginSize = 50;
        JPanel marginPanel = new JPanel(new BorderLayout());
        marginPanel.add(gridPanel, BorderLayout.CENTER);
        marginPanel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));
        add(marginPanel);
    }


    private void addFirstAndSecondRow(JPanel gridPanel){
        JLabel label = new JLabel("Por Fabricante:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Por Rango Electrico:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        label = new JLabel("Por Modelo del Vehiculo:");
        label.setFont(Global.FONT_TEXTS);
        gridPanel.add(label);
        byFabricante = new JComboBox<>(presenter.getManufacters());
        gridPanel.add(byFabricante);
        byRangoElectrico = new NumericTextField("Rango Electrico");
        gridPanel.add(byRangoElectrico);
        byModeloDeVehiculo = new JComboBox<>(presenter.getVehicleModels());
        gridPanel.add(byModeloDeVehiculo);
    }

    private void createEmptySpace(JPanel gridPanel){
        for (int i = 0; i < 3; i++) {
            gridPanel.add(new JLabel(""));
        }
    }


    private void addButtons(){
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        buttonPanel.add(createButtonRegister());
        buttonPanel.add(createButtonReturn());
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JButton createButtonRegister(){
        CustomButton button = new CustomButton("Buscar");
        button.addActionListener(e -> {
            if (presenter != null) {
                String model = Objects.requireNonNull(byModeloDeVehiculo.getSelectedItem()).toString();
                String manufacturer = Objects.requireNonNull(byFabricante.getSelectedItem()).toString();
                int electricRange = Integer.parseInt(Objects.requireNonNull(byRangoElectrico.getText()));
                JOptionPane.showMessageDialog(this, presenter.countByModelManufacturerAndElectricRange(model, manufacturer, electricRange));
            }
        });
        return button;
    }

    private JButton createButtonReturn() {
        CustomButton button = new CustomButton("Volver");
        button.addActionListener(e -> parent.dispose());
        return button;
    }

    public String[] returnData() {
        return new String[]{
                Objects.requireNonNull(byFabricante.getSelectedItem()).toString(),
                Objects.requireNonNull(byRangoElectrico.getText()),
                Objects.requireNonNull(byModeloDeVehiculo.getSelectedItem()).toString(),
        };
    }
}