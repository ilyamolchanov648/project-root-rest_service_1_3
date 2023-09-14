import model.User;

import java.io.*;
import java.net.*;
import java.util.List;


public class HttpServer {

    public static void main(String[] args) {
        int port = 8080;

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                handleRequest(clientSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        OutputStream out = clientSocket.getOutputStream();

        String requestLine = in.readLine();
        String[] requestParts = requestLine.split(" ");
        String method = requestParts[0];
        String path = requestParts[1];

        if (method.equals("GET") && path.equals("/api/users")) {
            UserDao userDao = new UserDao(); // Создаем объект для взаимодействия с базой данных
            List<User> users = userDao.getAllUsers(); // Получаем список пользователей

            String response = "HTTP/1.1 200 OK\r\n\r\n" + convertUsersToJson(users); // Формируем JSON-ответ
            out.write(response.getBytes());
        } else {
            String response = "HTTP/1.1 404 Not Found\r\n\r\n";
            out.write(response.getBytes());
        }

        out.flush();
        clientSocket.close();
    }

    private static String convertUsersToJson(List<User> users) {
        StringBuilder json = new StringBuilder("{\"users\": [");
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            json.append("{\"id\": ").append(user.getId()).append(", \"name\": \"").append(user.getName()).append("\"}");
            if (i < users.size() - 1) {
                json.append(", ");
            }
        }
        json.append("]}");
        return json.toString();
    }




}
