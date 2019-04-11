package webservice;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raphael Felipe
 */
public class Concatenador {
    
    public void Concatenador(){}
    
    public String Concatenar(String texto){
        
        String[] textos = texto.split(" ");
        texto = "";
        for(int i = 0; i < textos.length; i++){
            texto += textos[i].toString();
        }
        
        return texto;
    }
    
}
