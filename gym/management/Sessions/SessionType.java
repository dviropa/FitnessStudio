package gym.management.Sessions;

public enum SessionType {
    MachinePilates(80, 10),
    ThaiBoxing(100, 20),
    Pilates(60, 30),
    Ninja(150, 5);

    private final int price; // מחיר
    private final int maxParticipants; // מספר משתתפים מקסימלי

    // בנאי פרטי
    SessionType(int price, int maxParticipants) {
        this.price = price;
        this.maxParticipants = maxParticipants;
    }

    // גטרים לגישה לערכים
    public int getPrice() {
        return price;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }
}

