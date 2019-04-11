/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

/**
 *
 * @author Raphael Felipe
 */
public class ModeloTexto {
    private String textoInicial, textoUppercase, textoConcatenado;

    public String getTextoUppercase() {
        return textoUppercase;
    }

    public void setTextoUppercase(String textoUppercase) {
        this.textoUppercase = textoUppercase;
    }

    public String getTextoConcatenado() {
        return textoConcatenado;
    }

    public void setTextoConcatenado(String textoConcatenado) {
        this.textoConcatenado = textoConcatenado;
    }

    /**
     * @return the textoInicial
     */
    public String getTextoInicial() {
        return textoInicial;
    }

    /**
     * @param textoInicial the textoInicial to set
     */
    public void setTextoInicial(String textoInicial) {
        this.textoInicial = textoInicial;
    }
    
    
    
}
