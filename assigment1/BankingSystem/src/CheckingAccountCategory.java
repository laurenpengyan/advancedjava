// M2 HOMEWORK ENUM
public enum CheckingAccountCategory {
    PERSONAL, STUDENT, BUSINESS;

    public void getCheckingAccountCategory() {
        switch (this) {
            case PERSONAL: {
                System.out.println("this is Personal category of checking account ");
                break;
            }
            case STUDENT: {
                System.out.println("this is Student category of checking account");
                break;
            }
            case BUSINESS: {
                System.out.println("this is Business category of checking account");
                break;
            }
        }
    }
}