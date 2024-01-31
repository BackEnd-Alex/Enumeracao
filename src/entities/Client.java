package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
    private String name;
    private String email;
    private Date birthDate;

    public Client(String name, Date birthDate, String email) {
        this.name = name;
        this.birthDate = birthDate;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + sdf.format(birthDate) + ") - " + email;
    }
}
