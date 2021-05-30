package helpers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class Helper {
    public static RequestDispatcher loadView(HttpServletRequest request, String viewLocation) {
        return  request.getRequestDispatcher(viewLocation);
    }
}
