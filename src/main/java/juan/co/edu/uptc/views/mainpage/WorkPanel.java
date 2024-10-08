package juan.co.edu.uptc.views.mainpage;


import juan.co.edu.uptc.interfaces.Interfaces;
import juan.co.edu.uptc.views.search.SearchMainPage;
import juan.co.edu.uptc.views.wildCardClasses.CustomButton;
import juan.co.edu.uptc.views.wildCardClasses.Global;

import javax.swing.*;
import java.awt.*;

public class WorkPanel extends JPanel {
    private final MainPageFrame mainPageFrame;
    private final Interfaces.Presenter presenterVet;

    public WorkPanel(MainPageFrame mainPageFrame, Interfaces.Presenter presenterVet){
        this.mainPageFrame = mainPageFrame;
        this.presenterVet = presenterVet;
        initWorkPanel();
        createLabelAndButton();
    }

    private void initWorkPanel() {
        setBackground(Global.WORK_BACKGROUND_COLOR);
        setForeground(Global.WORK_TEXT_COLOR);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }
    private void createLabelAndButton(){
        add(Box.createVerticalGlue());
        JLabel label = new JLabel("Analisis Por Vehiculo");
        label.setFont(Global.FONT_TITLE_BIG);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label);
        add(Box.createVerticalStrut(50));
        CustomButton button = new CustomButton("Buscar");
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> registerAppointment());
        add(button);
        add(Box.createVerticalGlue());
    }
    private void registerAppointment(){
        SearchMainPage searchMainPage = new SearchMainPage(mainPageFrame, presenterVet);
        searchMainPage.setVisible(true);
    }
}
