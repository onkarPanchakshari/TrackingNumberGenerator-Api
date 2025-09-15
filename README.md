# 📦 Tracking Number Generator API

A Spring Boot REST API that generates **unique tracking numbers** for orders.  
This project demonstrates scalable API design, exception handling, Swagger docs, and deployment on **Render**.

---

## 🚀 Features
- Generate unique tracking numbers
- Prevent duplicate codes
- RESTful API with Spring Boot
- Swagger UI for API documentation
- PostgreSQL database (And H2 For Testing)
- Global exception handling
- JUnit & MockMvc test cases
- Deployed on Render

---

## 🛠 Tech Stack
- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- PostgresSQL / H2(For Testing) 
- Maven  
- Springdoc OpenAPI (Swagger)  
- Render (for deployment)

---

## ⚙️ Installation (Local)

  1  **Clone the repository**
   ```bash
  [ git clone https://github.com/onkarPanchakshari/tracking-number-api.git](https://github.com/onkarPanchakshari/TrackingNumberGenerator-Api.git)

## 📖 Swagger API Docs

Swagger UI is enabled using Springdoc OpenAPI.

OpenAPI JSON: http://localhost:8080/v3/api-docs

Swagger UI: http://localhost:8080/swagger-ui.html

🌍 Deployment on Render

This project is deployed on Render.

👉 Live API Base URL:

https://trackingnumbergenerator-api.onrender.com/ (Add The Parames)
   EX:- https://trackingnumbergenerator-api.onrender.com/api/next-tracking-number?originCountryId=IN&destinationCountryId=ID&weight=4.234&customerId=f47ac10b-58cc-4372-a567-0e02b2c3d479&customerName=patil Logistics&customerSlug=patil-logistics

🤝 Contributing

Contributions are welcome!
Fork this repository
Create a new branch (feature/new-feature)
Commit your changes
Push the branch
Open a pull request
