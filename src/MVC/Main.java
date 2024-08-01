
package MVC;

public class Main {
    public static void main(String[] args) {
        GiaoDichView view = new GiaoDichView();
        GiaoDichDAO dao = new GiaoDichDAO();
        new GiaoDichController(dao, view);
        view.setVisible(true);
    }
}