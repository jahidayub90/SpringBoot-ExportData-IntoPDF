package com.example.stech.service;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.example.stech.model.Employee;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class DatabasePDFService {
	 
    public static ByteArrayInputStream employeePDFReport(List<Employee> employees) {
        Document document = new Document(PageSize.A4.rotate());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
 
        try {
 
            PdfWriter.getInstance(document, out);
            document.open();
 
            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 20); /// TIMES_BOLD
            Paragraph para = new Paragraph("Meritech Employee Information", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER); // Centre
            document.add(para);
            document.add(Chunk.NEWLINE);
 
            PdfPTable table = new PdfPTable(8);
            // Add PDF Table Header ->
            Stream.of("ID", "Department","First Name", "Last Name", "Gender", "Mail", "Address" ,"Phone Number").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.CYAN);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(2); //
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });
 
            for (Employee employee : employees) {
                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(employee.getId())));
                idCell.setPaddingLeft(4);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);

                PdfPCell departmentCell = new PdfPCell(new Phrase(employee.getDepartment()));
                departmentCell.setPaddingLeft(4);
                departmentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                departmentCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(departmentCell);

 
                PdfPCell firstNameCell = new PdfPCell(new Phrase(employee.getFirstName()));
                firstNameCell.setPaddingLeft(4);
                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(firstNameCell);
 
                PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(employee.getLastName())));
                lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                lastNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                lastNameCell.setPaddingRight(4);
                table.addCell(lastNameCell);
                //===================

                PdfPCell genderCell = new PdfPCell(new Phrase(String.valueOf(employee.getGender())));
                genderCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                genderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                genderCell.setPaddingRight(4);
                table.addCell(genderCell);
 
                PdfPCell mailCell = new PdfPCell(new Phrase(String.valueOf(employee.getMail())));
                mailCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                mailCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                mailCell.setPaddingRight(4);
                table.addCell(mailCell);


                PdfPCell addressCell = new PdfPCell(new Phrase(String.valueOf(employee.getAddress())));
                addressCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                addressCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                addressCell.setPaddingRight(4);
                table.addCell(addressCell);


                PdfPCell phoneNumberCell = new PdfPCell(new Phrase(String.valueOf(employee.getPhoneNumber())));
               // phoneNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                phoneNumberCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                phoneNumberCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                phoneNumberCell.setPaddingRight(4);
                table.addCell(phoneNumberCell);

            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
 
        return new ByteArrayInputStream(out.toByteArray());
    }
}
