public class Member {
    private int memberid;
    private  String name;
    private String contactInfo;

    public Member(int memberid, String name, String contactInfo){
        this.memberid = memberid;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public int getMemberId(){
        return memberid;
    }

    public void setMemberId(int memberid){
        this.memberid = memberid;
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
        return "Member{" +
                "memberId=" + memberid +
                ", name='" + name + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                '}';
    }
}
