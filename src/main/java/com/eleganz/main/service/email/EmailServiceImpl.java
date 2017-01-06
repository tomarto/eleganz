package com.eleganz.main.service.email;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.eleganz.main.exception.ServerErrorException;
import com.eleganz.main.model.request.email.EmailRequest;

/**
 * <p>
 * EmailServiceImpl class. EmailService implementation.
 * </p>
 * 
 * @author Omar Ortiz.
 */
@Service
public class EmailServiceImpl implements EmailService {

	@Value("${app.email.contact}")
	private String emailContact;

	private final JavaMailSender javaMailSender;

	/**
	 * <p>
	 * Constructor for EmailServiceImpl.
	 * </p>
	 * 
	 * @param javaMailSender
	 *            a {@link org.springframework.mail.javamail.JavaMailSender} object.
	 */
	@Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

	/** {@inheritDoc} */
	@Override
	public void send(EmailRequest request) {
		try {
			javaMailSender.send(getMailToContact(request));
			javaMailSender.send(getMailToUser(request));
		} catch(MessagingException e) {
			throw new ServerErrorException("Ocurrió un error al tratar de enviar tu mensaje. "
					+ "Por favor intenta de nuevo más tarde.", e);
		}
	}

	/**
	 * <p>
	 * Build the email to send to the Contact Email.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link javax.mail.internet.MimeMessage} object.
	 */
	private MimeMessage getMailToContact(EmailRequest request)
			throws MessagingException {
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(emailContact);
		helper.setFrom(request.getEmail());
		helper.setSubject(String.format("Solicitud Contacto - ", request.getSubject()));
		helper.setText(getPlainMessageToContact(request), getHtmlMessageToContact(request));
		return mail;
	}

	/**
	 * <p>
	 * Build the email to send to the User Email.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link javax.mail.internet.MimeMessage} object.
	 */
	private MimeMessage getMailToUser(EmailRequest request)
			throws MessagingException {
		MimeMessage mail = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mail, true);
		helper.setTo(request.getEmail());
		helper.setFrom(emailContact);
		helper.setSubject(String.format("Eleganz - Mensaje enviado"));
		helper.setText(getPlainMessageToUser(request), getHtmlMessageToUser(request));
		return mail;
	}

	/**
	 * <p>
	 * Build the message to send to the Contact Email in plan text.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	private String getPlainMessageToContact(EmailRequest request) {
		return String.format("%s envío un mensaje:\n\n%s\n\nSu información de contacto es la "
				+ "siguiente:\n\nTeléfono: %s\nEmail: %s",
				request.getName(), request.getMessage(), request.getPhone(), request.getEmail());
	}

	/**
	 * <p>
	 * Build the message to send to the Contact Email in html format.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	private String getHtmlMessageToContact(EmailRequest request) {
		return String.format("<b>%s</b> envío un mensaje:<br /><br /><b>%s</b><br /><br />"
				+ "Su información de contacto es la siguiente: <br /><br />"
				+ "<b>Teléfono:</b> %s<br /><b>Email:</b> %s",
				request.getName(), request.getMessage(), request.getPhone(), request.getEmail());
	}

	/**
	 * <p>
	 * Build the message to send to the User Email in plan text.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	private String getPlainMessageToUser(EmailRequest request) {
		return String.format("Hola %s\n\nTu mensaje fué enviado. Nos contactaremos contigo lo más "
				+ "pronto posible\n\nQue tengas un excelente día.",
				request.getName());
	}

	/**
	 * <p>
	 * Build the message to send to the User Email in html format.
	 * </p>
	 * 
	 * @param request
	 *            a {@link com.eleganz.main.model.request.email.EmailRequest} object.
	 * @return a {@link java.lang.String} object.
	 */
	private String getHtmlMessageToUser(EmailRequest request) {
		return String.format("Hola <b>%s</b><br /><br />Tu mensaje fué enviado. Nos contactaremos "
				+ "contigo lo más pronto posible<br /><br />Que tengas un excelente día.",
				request.getName());
	}
}
