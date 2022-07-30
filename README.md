Swagger configuration example for Springdocs


http://localhost:8080/swagger-ui
<img width="1000" alt="image" src="https://user-images.githubusercontent.com/43916357/182003845-790acea1-8b85-4826-937c-476fd55f1223.png">

Request Body:

<img width="1000" alt="image" src="https://user-images.githubusercontent.com/43916357/182003861-ec4c3b9d-4d5c-48e6-862f-e04a3726d419.png">
<img width="450" alt="image" src="https://user-images.githubusercontent.com/43916357/182003873-ccbe41c5-7f88-4ad6-8479-5a0ef84029bf.png">


Response Body:

<img width="1000" alt="image" src="https://user-images.githubusercontent.com/43916357/182003885-c0855a28-cb2e-46ae-a552-34f376198918.png">
<img width="1000" alt="image" src="https://user-images.githubusercontent.com/43916357/182003898-3c95f647-1e44-46ed-9d26-6c1276767aa6.png">



http://localhost:8080/v3/api-docs

{
  "openapi": "3.0.1",
  "info": {
    "title": "Spring Boot Swagger API",
    "description": "Example of Springdocs swagger usage",
    "contact": {
      "name": "Marco",
      "url": "randomURL",
      "email": "randomEmail@random.com"
    },
    "version": "v0.0.1"
  },
  "servers": [
    {
      "url": "http://localhost:8080",
      "description": "Generated server url"
    }
  ],
  "security": [
    {
      "AzureAD": [
        "write_user",
        "read_user"
      ]
    }
  ],
  "paths": {
    "/api/springdocs": {
      "post": {
        "tags": [
          "Spring Docs Example"
        ],
        "summary": "Swagger Docs Summary",
        "description": "Swagger Docs Description",
        "operationId": "createUser",
        "parameters": [
          {
            "name": "Authorization",
            "in": "header",
            "description": "Authentication is Required",
            "required": true,
            "schema": {
              "maxLength": 8,
              "minLength": 4,
              "pattern": "(password|taco)",
              "type": "string"
            }
          }
        ],
        "requestBody": {
          "content": {
            "application/json": {
              "schema": {
                "$ref": "#/components/schemas/User"
              }
            }
          },
          "required": true
        },
        "responses": {
          "200": {
            "description": "SUCCESS!!!!!",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/SwaggerSuccessResponse"
                }
              }
            }
          },
          "400": {
            "description": "YOUR REQUEST IS BAD!!!!!",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/UserAPIResponse"
                }
              }
            }
          },
          "404": {
            "description": "THIS AINT FOUND!!!!!",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/UserAPIResponse"
                }
              }
            }
          },
          "500": {
            "description": "INTERNAL SERVER ERROR!!!!!",
            "content": {
              "application/json": {
                "schema": {
                  "$ref": "#/components/schemas/UserAPIResponse"
                }
              }
            }
          }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "SwaggerSuccessResponse": {
        "type": "object",
        "properties": {
          "message": {
            "type": "string",
            "example": "Great Success!!!"
          }
        },
        "additionalProperties": false
      },
      "User": {
        "required": [
          "id",
          "username"
        ],
        "type": "object",
        "properties": {
          "id": {
            "title": "Value of an id",
            "maximum": 10000,
            "minimum": 0,
            "type": "integer",
            "description": "ID is required due to xyz...",
            "format": "int32",
            "example": 5
          },
          "username": {
            "title": "A users username",
            "pattern": "/^[a-z ,.'-]+$/i",
            "type": "string",
            "description": "Username is required to identify a user",
            "example": "swagger_pro"
          },
          "hasPet": {
            "title": "Does user have a pet?",
            "type": "boolean",
            "description": "Do you have a puppers, doge, kitty?",
            "example": false,
            "default": false
          },
          "invisibleField": {
            "type": "string",
            "deprecated": true,
            "default": "Bazinga"
          }
        },
        "additionalProperties": false
      },
      "UserAPIResponse": {
        "type": "object",
        "properties": {
          "id": {
            "title": "User's ID",
            "maximum": 10000,
            "minimum": 0,
            "type": "integer",
            "description": "This is the users ID",
            "format": "int32",
            "example": 5
          },
          "responseCode": {
            "title": "Response Code",
            "maximum": 504,
            "minimum": 200,
            "type": "integer",
            "description": "The response code returned to the user",
            "format": "int32",
            "example": 0
          },
          "errorMessage": {
            "title": "Error message",
            "pattern": "/^[a-z ,.'-]+$/i",
            "type": "string",
            "description": "This is an error message returned to the user",
            "example": "Invalid Request >:("
          }
        },
        "additionalProperties": false
      }
    },
    "securitySchemes": {
      "AzureAD": {
        "type": "oauth2",
        "flows": {
          "implicit": {
            "authorizationUrl": "Authorization URL",
            "scopes": {
              "write_user": "Add a user",
              "read_user": "read a user"
            }
          }
        }
      }
    }
  }
}
