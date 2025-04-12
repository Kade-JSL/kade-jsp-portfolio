# JSP Comment Board Portfolio([日本語は下にあります](#JSP-ポートフォリオ-コメントボード))

A minimalist Java web app build with JSP/Servlet, and PostgreSQL to demonstrate basic full stack CRUD operations with simple session based access control.

## 🔎 Project Overview

This repo is a portfolio project that implements:

- A basic **CRUD comment board** (Create, Read, Update, Delete)
- User-facing **read-only** view
- A protected **admin view** for authenticated users (you, and me)
- PostgreSQL as backend DB
- Servlet based request routing and session control
- Forms and layout enhanced by Bootstrap
- `.properties` config loading via `Properties` and `InputStream`
- JSTL for conditional rendering

This is a local test app. So it *Works on My Machine™*.

---

## 📚 Tech Stack

- Java (JSP/Servlet)
- PostgreSQL
- Tomcat (tested inside Eclipse IDE)
- JSTL
- Bootstrap(v5)
- Java EE Jakarta dependencies

---

## 🛠 Features

| Feature | Status |
|---|---|
| Comment Listing(`R`) | ✅ Done |
| Add a comment(`C`) | ✅ Done |
| Edit/Delete comment(`U`/`D`) | ✅ Done |
| Simple login feature via env | ✅ Done |
| Servlet session control | ✅ Done |
| `.properties` file loading | 💫 Local workaround |
| Deployment-ready | 🔜 Soon™ |

---

## 🛑 Admin Access (Local Dev Only)

Login credentials are currently loaded via **OS environment variables**, or alternatively from a `db.properties` file placed in the `$CATALINA_HOME/conf/` directory. I plan to make the code fully env dependant because it's easy and hassle-free, but not yet.

```properties
# db.properties
db.url=jdbc:postgresql://localhost:5432/your_db
db.user=your_user
db.password=your_password
db.driver=org.postgresql.Driver
```

To authenticate: POST to `/login`, via form fields `id`, and `pw`.

---

## 🗂 Source Structure

```bash
src/
 └── main/
     ├── java/
     │    └── com.kade.jspportfolio/
     │         ├── controller/     # Servlets
     │         ├── dao/            # Data Access Layer
     │         ├── dto/            # Data Transfer Objects
     │         └── dbmanager/      # DB Singleton
     └── webapp/
          ├── index.jsp
          ├── login.jsp
          ├── enter.jsp
          ├── edit.jsp
          └── WEB-INF/web.xml
```

---

## 🐛 Known Issues

- Failed numerous times to load `.properties` properly.
- Load envs via Run Configuration when running it in Eclipse, because Tomcat runs utterly separately from system.
- No encryption or CSRF thing: this is an intentionally insecure demo.

---

## 👀 What to do next

- [ ] Hardened credential (and config) handling for production
- [ ] Refactor codebase for better MVC separation
- [ ] Dockerize the setup
- [ ] Add unit testing (optional)

---

## 🔧 Credits

That's me, [Kade](https://github.com/Kade-JSL). And this repo is almost perfect recollection of my old bootcamp project. Feel free to fork or reference.

---

# JSP ポートフォリオ: コメントボード

追加予定
