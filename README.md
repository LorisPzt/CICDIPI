# IpiCICD - Mini App Users & Posts

Mini API Spring Boot pour creer des utilisateurs et leurs posts.

## Stack

- Spring Boot 3
- Spring Data JPA
- H2 in-memory
- Swagger UI (springdoc)

## Lancer le projet

```bash
./gradlew bootRun
```

## URLs utiles

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`
- H2 Console: `http://localhost:8080/h2-console`

## Endpoints principaux

- `POST /api/users` - creer un utilisateur
- `GET /api/users` - lister les utilisateurs
- `POST /api/posts` - creer un post
- `GET /api/posts` - lister tous les posts
- `GET /api/posts/{id}` - detail d'un post
- `GET /api/users/{userId}/posts` - posts d'un utilisateur

## Exemples de payload

### Creer un utilisateur

```json
{
  "username": "alice",
  "password": "secret",
  "email": "alice@example.com"
}
```

### Creer un post

```json
{
  "userId": 1,
  "title": "Mon premier post",
  "content": "Hello H2 + Swagger"
}
```

