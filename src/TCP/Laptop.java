package TCP;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.*; 

public class Laptop implements Serializable {
    private static final long serialVersionUID = 20150711L;
    private int id; 
    private String code; 
    private String name; 
    private int quantity ;
    public Laptop(){
        
    }

    public Laptop(int id, String code, String name, int quntity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quntity) {
        this.quantity = quntity;
    }
    
}
