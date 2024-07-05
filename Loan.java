import java.util.Date;

class Loan {
    private int loanId;
    private Book book;
    private Member member;
    private Date dueDate;

    public Loan(int loanId, Book book, Member member, Date dueDate) {
        this.loanId = loanId;
        this.book = book;
        this.member = member;
        this.dueDate = dueDate;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public Book getBook() {
        return book;
    }

    public void  setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member){
        this.member = member;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDate(Date dueDate){
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "loanId=" + loanId +
                ", book=" + book +
                ", member=" + member +
                ", dueDate=" + dueDate +
                '}';
    }
}