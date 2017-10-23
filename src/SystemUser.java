public class SystemUser {

    private Details details;
    private String id;

    public SystemUser(String id){
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }


}
