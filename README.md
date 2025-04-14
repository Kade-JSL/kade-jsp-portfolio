# JSP Comment Board Portfolio([日本語は下にあります](#jsp-ポートフォリオコメントボード))

A minimalist Java web app build with JSP/Servlet, and PostgreSQL to demonstrate basic full stack CRUD operations with simple session based access control. The demo is on https://portfolio-jsp.kade.jp/ , and proudly self-hosted on my Raspberry Pi server.

## 🔎 Project Overview

This repo is a portfolio project that implements:

- A basic **CRUD comment board** (Create, Read, Update, Delete)
- User-facing **read-only** view
- A protected **admin view** for authenticated users
- PostgreSQL as backend DB
- Servlet based request routing and session control
- Forms and layout enhanced by Bootstrap
- `.properties` config loading via `Properties` and `InputStream`
- JSTL for conditional rendering
- **Deployed to real server**(NEW!)
- **Forwarded via [Cloudflare Tunnel](https://developers.cloudflare.com/cloudflare-one/connections/connect-networks/)**(NEW!)

This was a local test app, though. So it only *Works on My Machine™*.

---

## 📚 Tech Stack

- Java (JSP/Servlet)
- PostgreSQL
- Tomcat
- JSTL
- Bootstrap(v5)
- Java EE Jakarta dependencies
- Linux (Raspberry Pi OS / Debian Bookworm)
- Cloudflare

---

## 🛠 Features

| Feature | Status |
|---|---|
| Comment Listing(`R`) | ✅ Done |
| Add a comment(`C`) | ✅ Done |
| Edit/Delete comment(`U`/`D`) | ✅ Done |
| Simple login feature via env | ✅ Done |
| Servlet session control | ✅ Done |
| Deployment-ready | 🔜 Almost done! |

---

## 🛑 Credentials & Authentication

At first, you have to make a env file before deployment:

```bash
# /etc/default/tomcat-env (or other place you prefer)
JSP_ADMIN_ID=**yourid**
JSP_ADMIN_PW=**yourpw**
JSP_DB_URL=jdbc:postgresql://localhost:5432/**yourdatabase**
JSP_DB_USER=**yourdbname**
JSP_DB_PW=**yourdbpw**
JSP_DB_DRIVER=org.postgresql.Driver
# optional: specify JAVA_HOME
# JAVA_HOME=/usr/lib/jvm/java-17-openjdk-*
```

And make sure proper Java and `postgres` is installed. Set up the DB manually (sorry, no JPA) in `psql`, search for tutorials.

When the webpage loads properly, try to log in with the `id` and `pw` you configured in env file. If this is successful, you're good to go.

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

- Too many configs needed: I made the webapp initially to deploy to my server only, but I'm planning to take more automated approach.
- No encryption or CSRF thing: this is an intentionally insecure demo.

---

## 👀 What to do next

- [ ] Hardened credential (and config) handling for production
- [ ] Refactor codebase for better MVC separation
- [ ] Dockerize the setup
- [ ] Add unit testing (optional)
- [ ] Deployment automation

---

## 🔧 Credits

That's me, [Kade](https://github.com/Kade-JSL). And this repo is an almost perfect recollection of the project I've done during my Java bootcamp era. Feel free to fork or reference.

---

# JSP ポートフォリオ・コメントボード

JSP/ServletとPostgreSQLを用いて構築した、ミニマルなJava Webアプリです。基本的なフルスタックのCRUD操作の実演に加え、簡易的なセッションベースのアクセス制限も実装したものです。現在 https://portfolio-jsp.kade.jp/ にて、自家製Raspberry Piサーバーを通じてセルフホストされております。

---

## 🔎 プロジェクト概要

このリポジトリは以下を実装したポートフォリオ用のプロジェクトです：

- 基本的なCRUDができるコメントボード(作成(Create)・閲覧(Read)・編集(Update)・削除(Delete))
- 非認証ユーザー向けの閲覧専用ビュー
- 認証済みユーザー向けの管理ビュー
- PostgreSQLをバックエンドDBとして採用
- Servletを活用したリクエストルーティング、セッション制御
- フォームとレイアウトはBootstrap基盤
- `Properties`と`InputStream`オブジェクトを活用した `.properties` 設定ファイル読み込み
- JSTLを活用そた条件付き描画
- **実際のサーバーにデプロイ**(NEW!)
- **[Cloudflare Tunnel](https://developers.cloudflare.com/cloudflare-one/connections/connect-networks/)でフォワーディング**(NEW!)

ローカルでテストする用途のアプリでしたので、いわゆる「俺の環境では動くが？」状態でございます。

---

## 📚 技術スタック

- Java (JSP/Servlet)
- PostgreSQL
- Tomcat (Eclipse IDE内では動作確認済み)
- JSTL
- Bootstrap (v5)
- Java EE Jakarta 依存性
- Linux (Raspberry Pi OS / Debian Bookworm)
- Cloudflare

---

## 🛠 機能実装

| 機能 | 状況 |
|---|---|
| コメント一覧の表示 (`R`) | ✅ 完了 |
| コメント作成 (`C`) | ✅ 完了 |
| コメント編集・削除 (`U`/`D`) | ✅ 完了 |
| 環境変数を利用した簡単ログイン | ✅ 完了 |
| Servletセッション制御 | ✅ 完了 |
| サーバーへのデプロイ対応 | 🔜 だいたい終わり！ |

---

## 🛑 DB連携・ログイン認証

デプロイする前に、環境変数ファイルを作成します：

```bash
# /etc/default/tomcat-env (or other place you prefer)
JSP_ADMIN_ID=**yourid**
JSP_ADMIN_PW=**yourpw**
JSP_DB_URL=jdbc:postgresql://localhost:5432/**yourdatabase**
JSP_DB_USER=**yourdbname**
JSP_DB_PW=**yourdbpw**
JSP_DB_DRIVER=org.postgresql.Driver
# optional: specify JAVA_HOME
# JAVA_HOME=/usr/lib/jvm/java-17-openjdk-*
```

適切なJavaと`postgres`がインストールされているのかも確認。DBは`psql`で設定をお願いします(JPAじゃなくてごめん)。ネットで調べれば出るから。

ログインは環境変数ファイルで設定した`id`と`pw`を入力すればできます。これができると環境変数はちゃんとロードされったってことです。

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

- デプロイ作業がちょっと多い
- デモプロジェクトであるため、暗号化やCSRF対策などは意図的に見逃しました。

---

## 👀 今後の見込み

- [ ] 本番環境を想定したアクセス制限の設定の強化
- [ ] MVCパターンをもっと明確に分離するためのリファクタリング
- [ ] Docker対応
- [ ] (あわよくば)ユニットテスト対応
- [ ] デプロイ自動化

---

## 🔧 クレジット

- README文書まで全部、私Kadeが担当しました。かつて就活塾にて作成したプロジェクトを(ほぼ)完璧に再現したものです。Forkや引用などもご自由にどうぞ。
