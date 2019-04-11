/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import com.sun.istack.internal.Nullable;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author Raphael Felipe
 */
public class Conexao {

    private static URL                url;
    private static HttpURLConnection  connection;
    private static OutputStreamWriter outputStreamWriter;
    private static InputStream        inputStream;
    private static BufferedReader     reader;
    private static String             linha, parametroLength;
    private static StringBuffer       resposta;

    public static final String        URL_SERVER = "http://192.168.43.220:8080/WebApplication1/webresources/middleware/";

    //PARA CONEXOES GET E DELETE
    @Nullable
    public static String conectaWSGD(String urlUsuario, String metodo){
        try{
            url = new URL(urlUsuario);
            connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(metodo);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Contetn-Language", "pt-BR");
            connection.setUseCaches(false);
            connection.connect();

            inputStream = connection.getInputStream();

            if(inputStream == null){
                return null;
            }

            reader   = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            resposta = new StringBuffer();

            while((linha = reader.readLine()) != null){
                resposta.append(linha);
            }

            if(resposta.length() == 0){
                return null;
            }else {

                if (connection != null) {
                    connection.disconnect();
                }

                if (reader != null) {
                    reader.close();
                }

                return resposta.toString();
            }

        }catch (Exception erro){
            System.out.println("Conexao - Get:\n" + erro.getMessage());
            return null;
        }
    }

    //PARA CONEXOES POST E PUT
    @Nullable
    public static String conectaWSPP(String urlUsuario, String parametro, String metodo){
        try{
            url = new URL(urlUsuario);
            connection = (HttpURLConnection) url.openConnection();

            parametroLength  = Integer.toString(parametro.getBytes().length);

            connection.setRequestMethod(metodo);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Length", parametroLength);
            connection.setRequestProperty("Contetn-Language", "pt-BR");
            connection.setUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.connect();

            outputStreamWriter = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            outputStreamWriter.write(parametro);
            outputStreamWriter.flush();

            inputStream = connection.getInputStream();

            if(inputStream == null){
                return null;
            }

            reader   = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            resposta = new StringBuffer();

            while((linha = reader.readLine()) != null){
                resposta.append(linha);
            }

            if(resposta.length() == 0){
                return null;
            }

            if(connection != null){
                connection.disconnect();
            }

            if(reader != null){
                reader.close();
            }

            return resposta.toString();

        }catch (Exception erro){
            System.out.println("Post: \n"+ erro.getMessage());
            return null;
        }
    }

}
