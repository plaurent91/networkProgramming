/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

public class Participant {

    private int ID;
    private String Name;
    private String Sex;
    private String Country;
    private String Birthdate;
    private float Size;
    private float Weight;
    private String Sport;
    
    public Participant (int ID, String Name, String Sex, String Country, String Birthdate, float Size, float Weight, String Sport) {
        this.ID = ID;
        this.Name = Name;
        this.Sex = Sex;
        this.Country = Country;
        this.Birthdate = Birthdate;
        this.Size = Size;
        this.Weight = Weight;
        this.Sport = Sport;
    };

    public int getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public String getSex() {
        return Sex;
    }

    public String getCountry() {
        return Country;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public float getSize() {
        return Size;
    }

    public float getWeight() {
        return Weight;
    }

    public String getSport() {
        return Sport;
    }

}
