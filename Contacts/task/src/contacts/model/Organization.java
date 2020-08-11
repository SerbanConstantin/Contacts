package contacts.model;

public class Organization extends Contact{
    private String organizationName;
    private String address;

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + getOrganizationName() +
                "\nAddress: " + getAddress() +
                super.toString();
    }

    @Override
    public String getInfo() {
        return getOrganizationName();
    }
}
