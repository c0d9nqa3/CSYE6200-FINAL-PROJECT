package pdfOperates;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

import javafx.scene.text.TextAlignment;

public class PDFGenerate
{
	public void generatePDFFile(String effectivedate, String PAname, String PBname, String conadd, String Service, String ddl, String invoiceF,String totalamount, String PbPerName,String PaPerName,String contractName, String signature_p) throws IOException {
		Document document = new Document();
		
	      try
	      {
	    	 BaseFont basefont = BaseFont.createFont("font/Smooch-Regular.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
	    	 
	    	 String filename = contractName.replaceAll("\\s", "");
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Contract/"+filename+".pdf"));
	         document.open();
	         Paragraph title = new Paragraph(contractName);
	         title.setAlignment(1);
	         Font font = new Font(basefont,12);
	         Paragraph signature_f = new Paragraph(signature_p,font); 
	         Paragraph p1 = new Paragraph("This Construction Contract Agreement (the \"Agreement\") is entered into on "+effectivedate+" (the “Effective Date”) by and between "+PBname+" (referred to as the “Contractor”), and "+PAname+", (referred to as the “Client”), collectively “the Parties.”");
	         Paragraph p2 = new Paragraph("[Construction Property]\r\n"
	         		+ "1.	The property that is to be constructed is located at the following address: "+conadd+"\r\n");
	         Paragraph p3 = new Paragraph("[Services]\r\n"
	         		+ "2.	Contractor agrees to provide construction services to Client in accordance with the terms of this Agreement, including the following:\r\n"
	         		+ "\r\n"
	         		+ Service
	         		+ "");
	         Paragraph p4 = new Paragraph("[Term]\r\n"
	         		+ "3.	The Parties agree that the Construction shall begin on the Effective Date and will end on or before "+ddl+".\r\n"
	         		+ "\r\n"
	         		+ "3.1.	The term of this Agreement may be extended upon the provision of written consent from both Parties.\r\n"
	         		+ "");
	         Paragraph p5 = new Paragraph("[Fees & Payment Terms]\r\n"
	         		+ "4.	Client agrees to pay Contractor the sum of [TOTAL CONTRACT PRICE] for the construction services described in Section 2 above. Payment shall be made as follows:\r\n"
	         		+ "\r\n"
	         		+ "A.	The Parties agree that the Constructor will provide an invoice to the Client every "+invoiceF+" days/months for the Services they complete.\r\n"
	         		+ "B.	The final invoice payment is due upon completion of the work.\r\n"
	         		+ "C.	The Parties agree that the means of payment will be through "+totalamount+".\r\n"
	         		+ "");
	         Paragraph p6 = new Paragraph("[Permits & Inspections]\r\n"
	         		+ "5.	Contractor shall obtain all necessary permits and licenses, and arrange for inspections as required by law. Contractor shall notify Client of any inspections and shall be present during all inspections.\r\n"
	         		+ "\r\n"
	         		+ "[Contractor Obligations]\r\n"
	         		+ "6.	Contractor shall ensure that the work site is kept clean and free of debris throughout the project. Upon completion of the work, Contractor shall remove all debris and leave the site in a clean and orderly condition.\r\n"
	         		+ "6.1.	The Constructor agrees to the following:\r\n"
	         		+ "A.	To supervise, manage and complete all the construction services as per this Agreement.\r\n"
	         		+ "B.	To keep record of the documents in a safe place accessible only to the Constructor and the Client.\r\n"
	         		+ "C.	To take all necessary precautions for all safety in general.\r\n"
	         		+ "D.	To bear responsibility for any acts of negligence and emergencies and accidents.\r\n"
	         		+ "E.	To provide a guarantee to the Client that the work commenced will be in accordance with the documents of this Agreement.\r\n"
	         		+ "F.	To maintain the property, keep it clean, and to safely dispose of hazardous materials and waste.\r\n"
	         		+ "G.	To train personnel on handling hazardous materials and to be responsible for any illness, damage, or loss of personnel.\r\n"
	         		+ "\r\n"
	         		+ "[Insurance]\r\n"
	         		+ "7.	The Parties agree that it is the Constructor’s responsibility to purchase an insurance policy for the construction.\r\n"
	         		+ "\r\n"
	         		+ "7.1.	The Parties further agree that it is the Client’s responsibility to maintain an insurance that covers replacement costs in the event of fire, theft, act of nature and/or casualty(s).\r\n"
	         		+ "\r\n"
	         		+ "[Governing Law]\r\n"
	         		+ "8.	This Agreement shall be governed by and construed in accordance with the laws of the State of [STATE].\r\n"
	         		+ "\r\n"
	         		+ "[Dispute Resolution]\r\n"
	         		+ "9.	Any dispute arising out of or in connection with this Agreement shall be resolved through arbitration in accordance with the rules of the American Arbitration Association. The arbitration shall take place in [CITY], [STATE]. The arbitrator's decision shall be final and binding on both parties, and judgment may be entered in any court having jurisdiction.\r\n"
	         		+ "\r\n"
	         		+ "[Termination]\r\n"
	         		+ "10.	Either party may terminate this Agreement upon written notice if the other party breaches any material term of this Agreement.\r\n"
	         		+ "[Indemnification]\r\n"
	         		+ "11.	Contractor agrees to indemnify, defend, and hold harmless Client, its officers, directors, employees, and agents, from any and all claims, damages, or expenses arising out of or in connection with Contractor's performance of the work under this Agreement.\r\n"
	         		+ "\r\n"
	         		+ "[Timeframe & Modifications]\r\n"
	         		+ "12.	Contractor agrees to complete the work described in Section 2 above within [NUMBER] days from the date this Agreement is executed, weather and other circumstances permitting. Contractor shall notify Client of any delays in completion.\r\n"
	         		+ "\r\n"
	         		+ "12.1.	Client may request changes to the work described in Section 2 above. Any changes to the work must be in writing and approved by both Parties. Additional fees may apply for any changes to the work.\r\n"
	         		+ "\r\n"
	         		+ "[Entire Agreement]\r\n"
	         		+ "13.	This Agreement constitutes the entire agreement between the parties and supersedes all prior agreements and understandings, whether written or oral, relating to the subject matter of this Agreement.\r\n"
	         		+ "\r\n"
	         		+ "13.1.	This Agreement shall be binding upon and inure to the benefit of the parties and their respective successors and assigns.\r\n"
	         		+ "\r\n"
	         		+ "13.2.	In an event where any provision of this Agreement is found to be void and unenforceable by a court of competent jurisdiction, then the remaining provisions will remain to be enforced in accordance with the Parties’ intention.\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "The Parties agree to the terms and conditions of this Agreement set forth above as demonstrated by their signatures as follows:\r\n"
	         		+ "");
	         Paragraph signiture = new Paragraph("[NAME OF CONTRACTOR]\r\n"
	         		+ "\r\n"
	         		+ "\r\n"
	         		+ "_________________________\r\n"
	         		+ "[SIGNATURE]\r\n"
	         		+ "\r\n"
	         		+ "Date:\r\n"
	         		+ "[NAME OF CLIENT]\r\n"
	         		+ "\r\n"
	         		+ ""+signature_f+"\r\n"
	         		+ "[SIGNATURE]\r\n"
	         		+ "\r\n"
	         		+ "Date: \r\n"
	         		+ "");
	         
	         
	         document.add(title);
	         document.add(p1);
	         document.add(p2);
	         document.add(p3);
	         document.add(p4);
	         document.add(p5);
	         document.add(p6);
	         document.add(signiture);
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	}
   public static void main(String[] args)
   {
	   Document document = new Document();
	      try
	      {
	         PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Contract/HelloWorld1.pdf"));
	         document.open();
	         Paragraph title = new Paragraph("sas");
	         Paragraph p1 = new Paragraph("asddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
	         title.setAlignment(1);
	         document.add(title);
	         document.add(p1);
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
   }
}