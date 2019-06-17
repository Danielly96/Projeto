/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
 
@ManagedBean
@RequestScoped
public class Login {
     private String username;
 private String password;
     
     
 public void login() {
         
         FacesContext context = FacesContext.getCurrentInstance();
 
         if(this.username.equals("admin") && this.password.equals("admin")){
             context.getExternalContext().getSessionMap().put("user", username);
             try {
 context.getExternalContext().redirect("principal.xhtml");
 } catch (IOException e) {
 e.printStackTrace();
 }
         }
         else  {
                    //Send an error message on Login Failure 
             context.addMessage(null, new FacesMessage("Authentication Failed. Check username or password."));
 
         } 
     }
 
     public void logout() {
     	FacesContext context = FacesContext.getCurrentInstance();
     	context.getExternalContext().invalidateSession();
         try {
 context.getExternalContext().redirect("home.xhtml");
 } catch (IOException e) {
 e.printStackTrace();
 }
     }
     
     
 public String getUsername() {
 return username;
 }
 
 public void setUsername(String username) {
 this.username = username;
 }
 
 public String getPassword() {
 return password;
 }
 
 public void setPassword(String password) {
 this.password = password;
 }
}
 