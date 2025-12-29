🛒 Flipkart Backend Application

A Spring Boot backend application that simulates core functionalities of an e-commerce platform like Flipkart, supporting Seller and Consumer roles with JWT-based authentication and authorization.

The application is Dockerized, deployed on Render, and uses a cloud-hosted MySQL database (Aiven).

🚀 Features

👥 User Roles

SELLER
CONSUMER

🔐 Authentication & Security

JWT-based authentication
Role-based authorization
Password hashing using BCrypt
Secure API access with Spring Security

🧑‍💼 Seller Capabilities

Add products for sale
View own products
Update own products
Delete own products

🛍️ Consumer Capabilities

View all available products
Add products to cart
Remove products from cart
View all items in own cart

🛠 Tech Stack
Layer	Technology
Language	Java 21
Framework	Spring Boot
Security	Spring Security + JWT
Database	MySQL (Remote – Aiven)
Password Encoding	BCrypt
API Documentation	Swagger / OpenAPI
Build Tool	Maven
Containerization	Docker
Hosting	Render

🔑 Authentication Flow

User registers as SELLER or CONSUMER
User logs in using credentials
Server generates a JWT token
Token must be sent in request headers:
Authorization: Bearer <JWT_TOKEN>
Access to APIs is granted based on user role

📖 API Documentation (Swagger)

The application provides interactive API documentation using Swagger (OpenAPI), allowing developers and testers to explore and test endpoints directly from the browser.

🔗 Live Swagger URL (Render Deployment): https://flipkart-sd9f.onrender.com/swagger-ui/index.html
Note: The live demo may take a few seconds to load initially as the server goes into sleep mode during inactivity (Render free tier limitation).

Swagger Features

🔐 JWT Authorize button for authenticated requests
🧪 Test APIs directly from the UI
📄 Clear request & response models
🔎 Organized endpoints by functionality

How to Use JWT in Swagger:

Open the Swagger URL
Click Authorize (🔒 icon)
Enter your token in the field
Click Authorize
Access protected APIs based on your role (SELLER / CONSUMER)

🐳 Docker Support:

The application is fully Dockerized using a multi-stage Docker build.
Build Image,
docker build -t flipkart-backend .
Run Container,
docker run -p 8080:8080 flipkart-backend

☁️ Deployment

Deployed on Render
Uses environment variables for secrets
MySQL hosted on Aiven
SSL-enabled DB connectivity
Render-managed port mapping

Required Environment Variables
SPRING_DATASOURCE_URL
SPRING_DATASOURCE_USERNAME
SPRING_DATASOURCE_PASSWORD

🔒 Security Highlights

Stateless authentication using JWT
Role-based endpoint access
Secure password storage with BCrypt
Swagger endpoints whitelisted
Production-ready security configuration

✅ Future Enhancements (Optional)

Order management
Payment integration
Product search & filtering
Pagination & sorting
Admin role

👨‍💻 Author : Srinivas V

Flipkart Backend Project
Built with ❤️ using Spring Boot, Security, Docker, and Cloud services.
