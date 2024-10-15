package ddaaniel.io.queueManagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender mailSender() {
            /*
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com"); // Defina aqui o host do seu SMTP qoqy eftt oipu zwnl

            mailSender.setPort(587);

            mailSender.setUsername("niel.oliveira23@gmail.com");
            mailSender.setPassword("qoqy eftt oipu zwnl");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            return mailSender;

            */
        return new JavaMailSenderImpl();
    }

    //  Sem a classe MailConfig: O Spring Boot já é capaz de configurar o envio de e-mails
    //  usando o JavaMailSender e as propriedades que você definiu em application.properties.
    //
    //  Se precisar customizar: A classe MailConfig só seria necessária se você quisesse
    //  customizar o JavaMailSender além das propriedades básicas que o Spring Boot configura
    //  automaticamente (como mudar comportamentos avançados ou adicionar configurações
    //  específicas).



    //  @Bean: O método mailSender() cria e configura um bean do tipo JavaMailSender. Esse bean
    //  é usado pelo Spring para enviar e-mails.
    //
    //  JavaMailSenderImpl: Este é o objeto específico que implementa a interface JavaMailSender
    //  e permite enviar e-mails. No exemplo atual, o JavaMailSenderImpl é retornado sem nenhuma
    //  configuração.
}