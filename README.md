# JSP Comment Board Portfolio([日本語は下にあります](#jsp-ポートフォリオコメントボード))

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

## 🛑 Credentials & Authentication

Login credentials are currently loaded via **OS environment variables**, and DB ones are loaded from a `db.properties` file placed in the `$CATALINA_HOME/conf/` directory. I plan to make the code fully env dependent because it's easy and hassle-free, but not yet.

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
     │         ├── dao/            # Data Access Object
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

That's me, [Kade](https://github.com/Kade-JSL). And this repo is an almost perfect recollection of the project I've done during my Java bootcamp era. Feel free to fork or reference.

---

# JSP ポートフォリオ・コメントボード

JSP/ServletとPostgreSQLを用いて構築した、ミニマルなJava Webアプリです。基本的なフルスタックのCRUD操作の実演に加え、簡易的なセッションベースのアクセス制限も実装したものです。

---

## 🔎 プロジェクト概要

このリポジトリは以下を実装したポートフォリオ用のプロジェクトです：

- 基本的なCRUDができるコメントボード(作成(Create)・閲覧(Read)・編集(Update)・削除(Delete))
- 非認証ユーザー向けの閲覧専用ビュー
- 認証済みユーザー(即ち、あなた)向けの管理ビュー
- PostgreSQLをバックエンドDBとして採用
- Servletを活用したリクエストルーティング、セッション制御
- フォームとレイアウトはBootstrap基盤
- `Properties`と`InputStream`オブジェクトを活用した `.properties` 設定ファイル読み込み
- JSTLを活用そた条件付き描画

ローカルでテストする用途のアプリです。いわゆる「俺の環境では動くが？」状態でございます。

---

## 📚 技術スタック

- Java (JSP/Servlet)
- PostgreSQL
- Tomcat (Eclipse IDE内では動作確認済み)
- JSTL
- Bootstrap (v5)
- Java EE Jakarta 依存性

---

## 🛠 機能実装

| 機能 | 状況 |
|---|---|
| コメント一覧の表示 (`R`) | ✅ 完了 |
| コメント作成 (`C`) | ✅ 完了 |
| コメント編集・削除 (`U`/`D`) | ✅ 完了 |
| 環境変数を利用した簡単ログイン | ✅ 完了 |
| Servletセッション制御 | ✅ 完了 |
| `.properties`ファイル読み込み | 💫 ローカルでは別の方法 |
| サーバーへのデプロイ対応 | 🔜 近日中公開！ |

---

## 🛑 DB連携・ログイン認証

ただ今のコードでは`$CATALINA_HOME/conf/db.properties`にてDBのログイン情報を、Eclipseの`Run Configuration`にてウェブサイトのログイン情報を格納しています。最終的にサーバーに導入する際には全部環境変数から読み込むようにする予定です。

```properties
# db.properties
db.url=jdbc:postgresql://localhost:5432/your_db
db.user=your_user
db.password=your_password
db.driver=org.postgresql.Driver
```
```bash
# 認証方法
# idとpwフィールドをフォームに入れて/loginにPOSTリクエストを送るとログインセッション取得
```

---

## 🗂 ソースツリー

```bash
src/
 └── main/
     ├── java/
     │    └── com.kade.jspportfolio/
     │         ├── controller/     # サーブレット
     │         ├── dao/            # データアクセスオブジェクト
     │         ├── dto/            # データ転送オブジェクト
     │         └── dbmanager/      # DB連携のためのシングルトン
     └── webapp/
          ├── index.jsp
          ├── login.jsp
          ├── enter.jsp
          ├── edit.jsp
          └── WEB-INF/web.xml
```

---

## 🐛 既知の問題

- Tomcatの具合が悪いのか、結局`.properties`ファイルは思い通りには読み込めませんでした(本来なら`src/main/resources`フォルダなどに入れるべき)。
- Eclipseにて環境変数を読み込む時には必ず`Run Configuration`をご確認ください。Eclipseで稼働するTomcatはシステムとは別の環境です。
- デモプロジェクトであるため、暗号化やCSRF対策などは意図的に見逃しました。

---

## 👀 今後の見込み

- [ ] 本番環境を想定したアクセス制限の設定の強化
- [ ] MVCパターンをもっと明確に分離するためのリファクタリング
- [ ] Docker対応
- [ ] (あわよくば)ユニットテスト対応

---

## 🔧 クレジット

- README文書まで全部、私Kadeが担当しました。かつて就活塾にて作成したプロジェクトを(ほぼ)完璧に再現したものです。Forkや引用などもご自由にどうぞ。
