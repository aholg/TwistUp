/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twistup;

/**
 *
 * @author Anton
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Random;

public class TwistUp {

    static Map diacritics = new Hashtable();

    /**
     * This program twists up an english string and replacing as many letters 
     * as possible with diacritics. 
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Anton\\OneDrive\\Documents\\diacritics.txt"));
        char diaKey;
        String diaLetters;
        String sample = "For, after all, how do we know that two and two make four? \n"
                + "Or that the force of gravity works? Or that the past is unchangeable? \n"
                + "If both the past and the external world exist only in the mind, \n"
                + "and if the mind itself is controllable – what then?";
        try {
            
            String line = br.readLine();

            while (line != null) {
                diaKey = line.charAt(0);
                diaLetters = line.substring(2);
                diacritics.put(diaKey, diaLetters);
                line = br.readLine();
            }
            
        } finally {
            br.close();
        }
        String diaMatch;
        StringBuilder sb = new StringBuilder();
        Random rand=new Random();
        int n=0;
        for(int i=0;i<sample.length();i++){
            char letter=sample.charAt(i);
            diaMatch=(String)diacritics.get(letter);
            if(diaMatch!=null){
                n=rand.nextInt(diaMatch.length()-1);
                sb.append(diaMatch.charAt(n));
            }else{
                sb.append(letter);
            }
            diaMatch=null;
        }
        System.out.println(sb.toString());
       
    }

}
