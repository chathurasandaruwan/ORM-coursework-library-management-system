package lk.ijse.Library_management_system.dao;

import lk.ijse.Library_management_system.dao.custom.impl.BookDAOImpl;
import lk.ijse.Library_management_system.dao.custom.impl.BorrowDAOImpl;
import lk.ijse.Library_management_system.dao.custom.impl.BranchDAOImpl;
import lk.ijse.Library_management_system.dao.custom.impl.UserDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }
    public static DAOFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }
    public enum DAOType{
        BOOK,BRANCH,USER,BORROW
    }
    public SupperDAO getDAO(DAOType daoType){
        switch (daoType){
            case BOOK:
                return new BookDAOImpl();
            case USER:
                return new UserDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            case BORROW:
                return new BorrowDAOImpl();
            default:
                return null;
        }
    }
}
