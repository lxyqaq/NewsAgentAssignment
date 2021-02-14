package controller;

/**
 * @ClassName DaoExceptionHandler
 * @Description NewsAgent ExceptionHandler
 * @Author lxyqaq @Email A00279565@student.ait.ie
 * @Date 2021/2/9 18:17
 * @Version 1.0
 */
public class DaoExceptionHandler extends Exception {

    String message;

    public DaoExceptionHandler(String errMessage){
        message = errMessage;
    }

    public String getMessage() {
        return message;
    }

}
