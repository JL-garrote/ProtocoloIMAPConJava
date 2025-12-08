import jakarta.mail.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws MessagingException {
        String contrasenaAplicacion = "ulhs tcwb rvsu ftnz";

        try {
            Properties props = new Properties();
            props.put("mail.store.protocol", "imap");
            props.put("mail.imap.host", "imap.gmail.com");
            props.put("mail.imap.port", "993");
            props.put("mail.imap.ssl.enable", "true");

            Session session = Session.getDefaultInstance(props, null);
            Store store = session.getStore("imap");
            store.connect("gilgarrotejuanluis@gmail.com", contrasenaAplicacion);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] mensajes = inbox.getMessages();
            for (int i = 0; i <= mensajes.length; i++) {
                System.out.println("Asunto: " + mensajes[i].getSubject());
            }

            inbox.close();
            store.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
