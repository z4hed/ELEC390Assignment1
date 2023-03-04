package modelData;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class profile implements Serializable {
    private String Name, Surname;
    private int ID;
    float GPA;
    ArrayList<records> profileAccessedAt;

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setName(String name) {
        Name = name;
    }
}
