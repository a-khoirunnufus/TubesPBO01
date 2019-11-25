/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import model.Application;
import view.GUIAdmin;
/**
 *
 * @author Lenovo
 */
public class ControllerAdmin {
    private Application model;
    private GUIAdmin viewAdm;
    
    public ControllerAdmin(GUIAdmin viewAdm){
        this.viewAdm = viewAdm;
    }
}
