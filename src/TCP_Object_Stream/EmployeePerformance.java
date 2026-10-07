/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP_Object_Stream;

/**
 *
 * @author Lenovo
 */
import java.util.*; 
import java.io.*; 

public class EmployeePerformance implements  Serializable{
    private static final long serialVersionUID = 20220915L; 
    private int id; 
    private String name; 
    private List<Integer> monthlyScores ; 
    private float avgScore; 
    private String rating; 

    public EmployeePerformance() {
    }

    public EmployeePerformance(int id, String name, List<Integer> monthlyScores, float avgScore, String rating) {
        this.id = id;
        this.name = name;
        this.monthlyScores = monthlyScores;
        this.avgScore = avgScore;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMonthlyScores() {
        return monthlyScores;
    }

    public void setMonthlyScores(List<Integer> monthlyScores) {
        this.monthlyScores = monthlyScores;
    }

    public float getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(float avgScore) {
        this.avgScore = avgScore;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
    
}
