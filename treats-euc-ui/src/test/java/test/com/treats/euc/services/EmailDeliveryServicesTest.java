package test.com.treats.euc.services;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.activation.MimetypesFileTypeMap;
import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.apache.tika.metadata.Metadata;
import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.treats.euc.pdf.PdfGenerator;
import com.treats.euc.services.EmailDeliveryServices;

public class EmailDeliveryServicesTest {

	@Test
	public void testEmailSend() throws MessagingException, IOException, DocumentException {
		/* 
		EmailDeliveryServices sender = new EmailDeliveryServices();
		sender.setSender("treats.hackathon@gmail.com", "hackathon2018");
		sender.setSenderName("TREATS Hackathon Team");
		sender.addRecipient("treats.hackathon@gmail.com");
		sender.setSubject("Java Email Testing Example!");
		ArrayList<String> emailBodyText = new ArrayList<String>();
		emailBodyText.add("RFC 822 header fields must contain only US-ASCII characters. \n");
		emailBodyText.add("MIME allows non ASCII characters to be present in certain portions of certain headers, by encoding those characters. \n");
		emailBodyText.add("RFC 2047 specifies the rules for doing this. \n");
		emailBodyText.add("The MimeUtility class provided in this package can be used to to achieve this. ");
		//sender.setBody("Java Email Testing Example...");
		sender.setBody(emailBodyText);
		//sender.addAttachment("/Users/simonchau/Downloads/LTN20180511497_C.pdf");
		File file = new File("/Users/simonchau/Downloads/LTN20180511497_C.pdf");
		//MimetypesFileTypeMap mimeTypesMap = new MimetypesFileTypeMap();
		// String mimeType = mimeTypesMap.getContentType(file);
		String mimeType = "application/pdf";
		String fileDescription = "Testing Document";
		// System.out.println("mime type: "+ mimeType);
		ByteArrayInputStream fileInputStream = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
	    //PDDocument document = PDDocument.load(file); 
		sender.addAttachmentFromFileObject(fileInputStream, mimeType, fileDescription);
		sender.send();
		*/
		//String filePath = "/Users/simonchau/Downloads/LTN20180511497_C.pdf";
    	PdfGenerator pdf = new PdfGenerator();
    	// Metadata metadataTest = new Metadata();
    	
    	// pdf.setOutputMethod("L");	//Save to Local
    	// pdf.setFullFileName("C:\\temp\\testing8.pdf");
      	pdf.setPdfContent("<html><body> This is my Project </body></html>");
    	
     	ByteArrayOutputStream baos = pdf.generatePdf();
		EmailDeliveryServices sender = new EmailDeliveryServices();
		sender.sendEmailWithPdfAndDefaultSetup(baos);
	}
}
