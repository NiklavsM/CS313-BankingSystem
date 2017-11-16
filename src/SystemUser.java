public class SystemUser {

    private PersonalDetails details;
    private String id;

    public SystemUser(String id){
        this.id = id;
        this.details = new PersonalDetails();
    }

    public String getId() {
        return id;
    }

    public PersonalDetails getDetails() {
        return details;
    }

    public void setDetails(PersonalDetails details) {
        this.details = details;
    }


}
