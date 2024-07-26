package br.com.dbc.vemser.pessoaapi;

import br.com.dbc.vemser.pessoaapi.dto.PessoaDto;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fmConfiguration;
    //@Value("${mail.pessoa.criar}")
    private String pessoaCriada;

    @Value("${spring.mail.username:jxsantos2013@gmail.com}")
    private String de;

    private String para = "bevake2776@stikezz.com";
    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(de);
        message.setTo(para);
        message.setSubject("Assunto");
        message.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(de);
        helper.setTo(para);
        helper.setSubject("Assunto");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");

        File file1 = new File("imagem.jpg");
        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(String message) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(de);
            mimeMessageHelper.setTo(para);
            mimeMessageHelper.setSubject("Assunto");
            mimeMessageHelper.setText(message, true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public String geContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Nome");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getContentFromTemplate(String type, PessoaDto pessoa) throws IOException, TemplateException {
        Template template = null;
        switch(type) {
            case "ec":
                System.out.println("ec");
                template = fmConfiguration.getTemplate("email-template.ftl");
                break;

            case "eu":
                System.out.println("eu");
                template = fmConfiguration.getTemplate("email-template2.ftl");
                break;
            case "ed":
                System.out.println("ed");
                template = fmConfiguration.getTemplate("email-template3.ftl");
                break;
        }

        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", pessoa.getEmail());
        dados.put("aniversario", pessoa.getDataNascimento());
        dados.put("cpf", pessoa.getCpf());

        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        sendEmail(html);
        return html;
    }

}
