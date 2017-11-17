public class EditDetailsThread extends Thread {

    private String detailsField;
    private SystemUser user;
    private String newValue;

    public EditDetailsThread(String detailsField, String newValue, SystemUser user) {
        this.detailsField = detailsField;
        this.user = user;
        this.newValue = newValue;
    }

    @Override
    public void run() {
        if(detailsField.equals("name")) {
            System.out.println("Changing Name from " + user.getDetails().getName() + " to " + newValue);
            user.getDetails().setName(newValue);
            System.out.println("Changed Name to " + user.getDetails().getName());
        } else if (detailsField.equals("email")) {
            System.out.println("Changing Email from " + user.getDetails().getEmail() + " to " + newValue);
            user.getDetails().setName(newValue);
            System.out.println("Changed Email to " + user.getDetails().getEmail());
        } else if (detailsField.equals("phone")) {
            System.out.println("Changing Phone from " + user.getDetails().getPhone() + " to " + newValue);
            user.getDetails().setName(newValue);
            System.out.println("Changed Phone to " + user.getDetails().getPhone());
        } else if (detailsField.equals("address")) {
            System.out.println("Changing Address from " + user.getDetails().getAddress() + " to " + newValue);
            user.getDetails().setName(newValue);
            System.out.println("Changed Address to " + user.getDetails().getAddress());
        } else {
            System.out.println("details field entered was incorrect!");
        }
    }

}
