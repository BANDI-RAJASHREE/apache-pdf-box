# Apache PDFBox Integration with Spring Boot

This Spring Boot module demonstrates how to use **[Apache PDFBox](https://pdfbox.apache.org/)** to create and read PDF documents through REST APIs.

---

## Features

- Create PDF files with dynamic text content  
- Extract and return text content from existing PDF files

---

## Endpoints

### 1. **Create PDF**

- **Method:** `POST`  
- **URL:** `/pdf/create`  
- **Query Parameter:**  
  - `path` – absolute file path where the PDF will be saved (e.g., `D:/new-2.pdf`)  
- **Request Body:** Plain text (raw string)

#### Sample Request

**POST** `http://localhost:8080/pdf/create?path=D:/new-2.pdf`

**Headers:**
- `Content-Type: text/plain`

**Body (raw text):**

Apache PDFBox is an open-source Java library developed by the Apache Software
Foundation, designed for creating, manipulating, and extracting content from PDF
documents. It is widely used in Java applications for tasks such as generating reports,
processing forms, and converting PDFs to other formats.
Core Features
PDF Creation & Editing: Programmatically create new PDFs or modify existing ones by
adding text, images, annotations, or pages.


---

### 2. **Read PDF**

- **Method:** `GET`  
- **URL:** `/pdf/read`  
- **Query Parameter:**  
  - `path` – absolute path of the PDF file to be read

#### Sample Request

**GET** `http://localhost:8080/pdf/read?path=D:/output.pdf`

**Response (Extracted Text):**

Apache PDFBox is an open-source Java library developed by the Apache Software
Foundation, designed for creating, manipulating, and extracting content from PDF
documents. It is widely used in Java applications for tasks such as generating reports,
processing forms, and converting PDFs to other formats.
Core Features
PDF Creation & Editing: Programmatically create new PDFs or modify existing ones by
adding text, images, annotations, or pages.

