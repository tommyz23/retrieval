package software.dzjz.retrieval.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextHolder {

    private static final Logger log = LoggerFactory.getLogger(ContextHolder.class);

    private static final ThreadLocal userContextHolder = new ThreadLocal();

    private static final ThreadLocal caseContextHolder = new ThreadLocal();

    //select DMMS from PUB_DMB where LBBH='系统缺省' and DMBH = '法院代码';
    private static final ThreadLocal def_fydmHolder = new ThreadLocal();


    @SuppressWarnings("unchecked")
    public static void setUserContext(Object context) {
        userContextHolder.set(context);
    }

    public static Object getUserContext() {
        return (Object) userContextHolder.get();
    }

    public static void clearUserCustomerType() {
        userContextHolder.remove();
    }

    @SuppressWarnings("unchecked")
    public static void setCaseContext(Object context) {
        caseContextHolder.set(context);
    }

    public static Object getCaseContext() {
        return (Object) caseContextHolder.get();
    }

    public static void clearCaseCustomerType() {
        caseContextHolder.remove();
    }

    @SuppressWarnings("unchecked")
    public static void setDef_fydm(String fydm) {
        def_fydmHolder.set((Object)fydm);
    }

    public static String getDef_fydm() {
        return (String) def_fydmHolder.get();
    }

    public static void clearDeffydmCustomerType() {
        def_fydmHolder.remove();
    }
}
