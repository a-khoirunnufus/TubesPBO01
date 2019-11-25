/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Application;
import view.GUITourGuide;
/**
 *
 * @author Lenovo
 */
public class ControllerTourGuide {
    private Application model;
    private GUITourGuide viewTG;
    
    public ControllerTourGuide(Application model, GUITourGuide viewTG){
        this.viewTG = viewTG;
        this.model = model;
    }
}
