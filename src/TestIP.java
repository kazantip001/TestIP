import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestIP {
    public static void main(String[] args)  {
        String dvr = "http://78.26.214.18/";
        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(dvr) .openConnection();
            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(250);
            connection.setReadTimeout(250);

            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode())
            {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");

                }
                System.out.println(sb.toString());
            }else
            {
                System.out.println("Fail:" + connection.getResponseCode() + "," + connection.getResponseMessage());
            }


        }catch(Throwable cause) {
            cause.printStackTrace();
        }finally {
            if (connection != null){
                connection.disconnect();
            }
        }

    }
}
