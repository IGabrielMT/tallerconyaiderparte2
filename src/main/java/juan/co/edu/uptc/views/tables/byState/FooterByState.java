package juan.co.edu.uptc.views.tables.byState;

import juan.co.edu.uptc.views.tables.byCity.MainByCity;
import juan.co.edu.uptc.views.tables.byCountry.MainByCountry;
import juan.co.edu.uptc.views.mainpage.MainPageFrame;
import juan.co.edu.uptc.views.wildCardClasses.Global;
import juan.co.edu.uptc.views.wildCardClasses.LabelHeader;
import juan.co.edu.uptc.interfaces.Interfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FooterByState extends JPanel {
    private final JDialog parent;
    private final MainPageFrame mainPageFrame;
    private final Interfaces.Presenter presenter;

    public FooterByState(JDialog parent, MainPageFrame mainPageFrame, Interfaces.Presenter presenter) {
        this.mainPageFrame = mainPageFrame;
        this.parent = parent;
        this.presenter = presenter;
        initPanel();
    }
    private void initPanel() {
        this.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        this.setLayout(new BorderLayout());
        createWorkPanel();
    }
    private void createWorkPanel() {
        JPanel gridPanel = new JPanel(new GridLayout(1, 4, 40, 40));
        gridPanel.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        int marginSize = 60;
        JPanel marginPanel = new JPanel(new BorderLayout());
        marginPanel.add(gridPanel, BorderLayout.CENTER);
        marginPanel.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));
        marginPanel.setBackground(Global.FOOTER_BACKGROUND_COLOR);
        addContent(gridPanel);
        add(marginPanel);
    }
    private void addContent(JPanel gridPanel){
        createTitle1(gridPanel);
        createTitle3(gridPanel);
        createTitle4(gridPanel);
    }
    private void createTitle1(JPanel gridPanel){
        JLabel orderBy = new LabelHeader("Ordernar por: ");
        orderBy.setFont(Global.FONT_TITLE_NORMAL);
        orderBy.setForeground(Global.FOOTER_TEXT_COLOR);
        gridPanel.add(orderBy);
    }
    private void createTitle3(JPanel gridPanel){
        JLabel petsNextTo = new LabelHeader("Registros de Ciudad");
        petsNextTo.setFont(Global.FONT_TEXTS);
        petsNextTo.setForeground(Global.FOOTER_TEXT_COLOR);
        petsNextTo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createByNextVaccine();
            }
        });
        gridPanel.add(petsNextTo);
    }
    private void createTitle4(JPanel gridpanel){
        JLabel responsible = new LabelHeader("Registros Por Condado");
        responsible.setFont(Global.FONT_TEXTS);
        responsible.setForeground(Global.FOOTER_TEXT_COLOR);
        responsible.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createByParentAppointments();
            }
        });
        gridpanel.add(responsible);
    }
    private void createByParentAppointments(){
        MainByCountry mainByCountry = new MainByCountry(mainPageFrame, presenter);
        mainByCountry.setVisible(true);
    }
    private void createByNextVaccine(){
        MainByCity mainByCity = new MainByCity(mainPageFrame, presenter);
        mainByCity.setVisible(true);
    }



}
