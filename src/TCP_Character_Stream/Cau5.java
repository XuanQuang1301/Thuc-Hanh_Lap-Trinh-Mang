/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Character_Stream;

import java.util.*; 
import java.io.*; 

public class Cau5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine(); 
        int count[] = new int[256]; 
        for(char c : tmp.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                count[c]++;
            }
        }
        for(char c : tmp.toCharArray()){
            if(count[c] > 0){
                System.out.print(c + ":" + count[c] + "\n");
                count[c] = 0;
            }
        }
    }
}
