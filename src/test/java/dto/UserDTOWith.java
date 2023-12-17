package dto;

public class UserDTOWith {
  String password;
  String email;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserDTOWith withEmail (String email){
        this.email=email;
        return this;
    }
    public UserDTOWith withPassword (String password){
        this.password= password;
        return this;
    }

}
