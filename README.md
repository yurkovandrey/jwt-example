# Simple JWT Example

This project serves as a prime illustration of how to generate and verify JWT in Spring Boot applications seamlessly, eliminating the need for any external services such as IAM systems

**I strongly advise against using it in any real environment**

## 👨‍💻 Tech stack
- **Spring Boot 3**
- **Spring Security**
- [**JJWT**](https://github.com/jwtk/jjwt)
- PostgreSQL
- Liquibase

## 🔮 Installing and running locally
1. Install [Docker](https://www.docker.com/get-started)
2. Clone the repo

    ```sh
    $ git clone https://github.com/yurkovandrey/jwt-example.git
    $ cd jwt-example
    ```
3. Run

    ```sh
    $ docker-compose up
    ```
These simple steps will build and launch the application and PostgreSQL database. The application will be available on the ```http://localhost:8080```

## 🕹️ Usage

### Signup
Firstly, you need to sign up in the application by providing a valid email and password:

```sh
curl --location --request POST 'localhost:8080/api/v1/auth/signup' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "user@example.com",
    "password": "password"
}'
```
You will receive a token as a response:
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQGV4YW1wbGUuY29tIiwiaWF0IjoxNjkwNjUzOTkwLCJleHAiOjE2OTA2NTU0MzB9.o7iDBWoPR7_TlY_x-j7ZjmgvWwW7e69QmfMDpVqoSNA"
}
```

### Signin
If you've already registered an e-mail and need to regenerate a token, you should sign in using the e-mail and password
```sh
curl --location --request POST 'localhost:8080/api/v1/auth/signin' \
--header 'Content-Type: application/json' \
--data-raw '{
    "email": "user@example.com",
    "password": "password"
}'
```
You will receive a token as a response:
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyQGV4YW1wbGUuY29tIiwiaWF0IjoxNjkwNjU1MTE0LCJleHAiOjE2OTA2NTY1NTR9.PkSzccwbOYfV8H_fyaed_U_wbs1PwcArQP9QeZyK7wA"
}
```

### Check secured resource
When you have a valid token, you can use it to perform requests to the secured method
```sh
curl --location --request GET 'localhost:8080/api/v1/resource' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4eHhAeXl5LmNvbSIsImlhdCI6MTY5MDQ3NjI4NiwiZXhwIjoxNjkwNDc3NzI2fQ.5BwZ8fu93IAkijrWzQbNURq-L4gU-fuDMv6uar5FIqE'
```

## 👩‍💼 License

[MIT](LICENSE)

Put simply, you have the freedom to use the code for both private and commercial purposes.

Feel free to contact me via email [yurkov.andrey.srg@gmail.com](mailto:yurkov.andrey.srg@gmail.com).

❤️