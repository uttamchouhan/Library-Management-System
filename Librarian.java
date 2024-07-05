public class Librarian {
    private int librarianId;
    private  String name;
    private String contactInfo;

    public Librarian(int librarianId, String name, String contactInfo){
        this.librarianId = librarianId;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public int getLibrarianId(){
        return librarianId;
    }

    public void setLibrarianId(int librarianId){
        this.librarianId = librarianId;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public void setContactInfo(String contactInfo){
        this.contactInfo = contactInfo;
    }

    @Override
    public String toString() {
        return "Librarian{" +
                "librarianId=" + librarianId +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
