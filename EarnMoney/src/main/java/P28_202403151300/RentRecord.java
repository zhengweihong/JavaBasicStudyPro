package P28_202403151300;

public class RentRecord {
    private String userEmail;
    private String itemId;
    private String itemName;
    private String dueDate;

    public RentRecord(String userEmail, String itemId, String itemName, String dueDate) {
        this.userEmail = userEmail;
        this.itemId = itemId;
        this.itemName = itemName;
        this.dueDate = dueDate;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
