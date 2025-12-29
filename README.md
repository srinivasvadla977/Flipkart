#🛒 Flipkart Backend Application

A Spring Boot backend application that simulates core functionalities of an e-commerce platform like Flipkart, supporting Seller and Consumer roles with JWT-based authentication and authorization.

The application is Dockerized, deployed on Render, and uses a cloud-hosted MySQL database (Aiven).

##🚀 Features

👥 User Roles

SELLER<br>
CONSUMER

🔐 Authentication & Security

JWT-based authentication<br>
Role-based authorization<br>
Password hashing using BCrypt<br>
Secure API access with Spring Security

🧑‍💼 Seller Capabilities

Add products for sale<br>
View own products<br>
Update own products<br>
Delete own products

🛍️ Consumer Capabilities

View all available products<br>
Add products to cart<br>
Remove products from cart<br>
View all items in own cart

🛠 Tech Stack
| Layer | Technology |
|------|------------|
| Language | Java 21 |
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Database | MySQL (Remote – Aiven) |
| Password Encoding | BCrypt |
| API Documentation | Swagger / OpenAPI |
| Build Tool | Maven |
| Containerization | Docker |
| Hosting | Render |

🔑 Authentication Flow

User registers as SELLER or CONSUMER<br>
User logs in using credentials<br>
Server generates a JWT token<br>
Token must be sent in request headers:
Authorization: Bearer <JWT_TOKEN><br>
Access to APIs is granted based on user role

📖 API Documentation (Swagger)

The application provides interactive API documentation using Swagger (OpenAPI), allowing developers and testers to explore and test endpoints directly from the browser.

🔗 Live Swagger URL (Render Deployment): https://flipkart-sd9f.onrender.com/swagger-ui/index.html<br>
Note: The live demo may take couple of minutes to load initially as the server goes into sleep mode during inactivity (Render free tier limitation).

Swagger Features

🔐 JWT Authorize button for authenticated requests<br>
🧪 Test APIs directly from the UI<br>
📄 Clear request & response models<br>
🔎 Organized endpoints by functionality

How to Use JWT in Swagger:

Open the Swagger URL<br>
Click Authorize (🔒 icon)<br>
Enter your token in the field<br>
Click Authorize<br>
Access protected APIs based on your role (SELLER / CONSUMER)

🐳 Docker Support:

The application is fully Dockerized using a multi-stage Docker build.<br>
Build Image,<br>
docker build -t flipkart-backend .<br>
Run Container,<br>
docker run -p 8080:8080 flipkart-backend

☁️ Deployment

Deployed on Render<br>
Uses environment variables for secrets<br>
MySQL hosted on Aiven<br>
SSL-enabled DB connectivity<br>
Render-managed port mapping

Required Environment Variables<br>
SPRING_DATASOURCE_URL<br>
SPRING_DATASOURCE_USERNAME<br>
SPRING_DATASOURCE_PASSWORD<br>

🔒 Security Highlights

Stateless authentication using JWT<br>
Role-based endpoint access<br>
Secure password storage with BCrypt<br>
Swagger endpoints whitelisted<br>
Production-ready security configuration<br>

✅ Future Enhancements (Optional)

Order management<br>
Payment integration<br>
Product search & filtering<br>
Pagination & sorting<br>
Admin role

👨‍💻 Author : Srinivas V
Flipkart Backend Project<br>
Built with ❤️ using Spring Boot, Security, Docker, and Cloud services.
