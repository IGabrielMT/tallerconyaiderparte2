package juan.co.edu.uptc.views.tables.byCountry;

import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.views.tables.byCity.MainByCity;
import juan.co.edu.uptc.views.tables.byState.MainByState;
import juan.co.edu.uptc.views.mainpage.MainPageFrame;
import juan.co.edu.uptc.views.wildCardClasses.Global;
import juan.co.edu.uptc.views.wildCardClasses.LabelHeader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FooterByCountry extends JPanel {
    private final MainPageFrame mainPageFrame;
    private final JDialog parent;
    private final Interfaces.Presenter presenterVet;

    public FooterByCountry(JDialog parent, MainPageFrame mainPageFrame, Interfaces.Presenter presenterVet) {
        this.parent = parent;
        this.mainPageFrame = mainPageFrame;
        this.presenterVet = presenterVet;
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
        JLabel date = new LabelHeader("Registros Por Estado");
        date.setFont(Global.FONT_TEXTS);
        date.setForeground(Global.FOOTER_TEXT_COLOR);
        date.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createByDateAppointments();
            }
        });
        gridPanel.add(date);
    }
    private void createTitle4(JPanel gridPanel) {
        JLabel petsNext = new LabelHeader("Registros Por Ciudad");
        petsNext.setFont(Global.FONT_TEXTS);
        petsNext.setForeground(Global.FOOTER_TEXT_COLOR);
        petsNext.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                parent.dispose();
                createByNextVaccineAppointments();
            }
        });
        gridPanel.add(petsNext);
    }
    private void createByDateAppointments(){
        MainByState mainByDateAppointments = new MainByState(mainPageFrame, presenterVet);
        mainByDateAppointments.setVisible(true);
    }
    private void createByNextVaccineAppointments(){
        MainByCity mainByCity = new MainByCity(mainPageFrame, presenterVet);
        mainByCity.setVisible(true);

    }

}
