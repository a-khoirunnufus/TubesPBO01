package controller;

import view.*;
import model.*;

public class ControllerMainMenu {
    private Database db;
    private Application model;
    private GUIMainMenu viewMM;
    private GUIAdmin viewAdm;
    private GUITourGuide viewTG;
    private GUICustomer viewCs;
    
    public ControllerMainMenu(Database db, Application model, GUIMainMenu viewMM){
        this.db = db;
        this.model = model;
        this.viewMM = viewMM;
        viewTG = new GUITourGuide(this,model);
        viewCs = new GUICustomer(this,model);
        viewAdm = new GUIAdmin(this,model,db);
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
