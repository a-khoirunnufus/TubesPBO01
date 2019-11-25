package controller;

import view.*;
import model.Application;

public class ControllerMainMenu {
    private Application model;
    private GUIMainMenu viewMM;
    private GUIAdmin viewAdm;
    private GUITourGuide viewTG = new GUITourGuide(this,model);
    private GUICustomer viewCs = new GUICustomer(this,model);
    
    public ControllerMainMenu(Application model, GUIMainMenu viewMM){
        this.model = model;
        this.viewMM = viewMM;
        viewCs = new GUICustomer(this,model);
        viewAdm = new GUIAdmin(this,model);
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
