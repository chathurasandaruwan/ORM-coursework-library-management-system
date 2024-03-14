package lk.ijse.Library_management_system.bo;

import lk.ijse.Library_management_system.bo.custom.impl.BookBOImpl;
import lk.ijse.Library_management_system.bo.custom.impl.BranchBOImpl;
import lk.ijse.Library_management_system.bo.custom.impl.UserBOImpl;


public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }
    public static BOFactory getBoFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOType{
        BOOK,BRANCH,USER
    }
    public SupperBO getBO(BOType boType){
        switch (boType){
            case BOOK:
                return new BookBOImpl();
            case USER:
                return new UserBOImpl();
            case BRANCH:
                return new BranchBOImpl();
            default:
                return null;

        }
    }

}
