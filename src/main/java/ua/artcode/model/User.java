package ua.artcode.model;

import ua.artcode.exceptions.IncorrectEmailException;
import ua.artcode.exceptions.IncorrectNPasswordException;
import ua.artcode.exceptions.IncorrectNameSurnameException;
import ua.artcode.exceptions.IncorrectPhoneException;

import static ua.artcode.utils.ValidationUtils.*;

/**
 * Created by gorobec on 27.11.16.
 */
public class User {

    private String name;
    private String surname;
    private String phone;
    private String email;
    private String password;

    public User(String name, String surname,
                String phone, String email, String password)
                    throws IncorrectNameSurnameException, IncorrectPhoneException,
                    IncorrectEmailException, IncorrectNPasswordException {

        validateName(name);
        validateName(surname);
        validatePhone(phone);
        validateEmail(email);
        validatePassword(password);

        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!name.equals(user.name)) return false;
        return surname.equals(user.surname);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
