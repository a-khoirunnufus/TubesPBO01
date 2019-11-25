package controller;

import view.*;
import model.Application;

public class ControllerMainMenu {
    private Application model = new Application();
    private GUIMainMenu viewMM;
    private GUIAdmin viewAdm = new GUIAdmin(this,model);
    private GUITourGuide viewTG = new GUITourGuide(this,model);
    private GUICustomer viewCs = new GUICustomer(this,model);
    
    public ControllerMainMenu(GUIMainMenu viewMM){
        this.viewMM = viewMM;
    }
    
    public void menuAdmin(){
        viewAdm.setVisible(true);
        viewMM.setVisible(false);
    }
    
    public void menuTourGuide(){
        viewTG.setVisible(true);
        viewMM.setVisible(false);
    }
    
    public void menuCustomer(){
        viewCs.setVisible(true);
        viewMM.setVisible(false);
    }
    
    public void toMainMenu(){
        viewMM.setVisible(true);
        viewAdm.setVisible(false);
        viewTG.setVisible(false);
        viewCs.setVisible(false);
    }
}
