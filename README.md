# データストア性能計測プロジェクト

MySQL, Igniteを使ってデータベースおよびキャッシュのデータ読み書き性能を計測するプロジェクトです。

## 構成

下記3つのJava Projectから構成されます:

- `01_mysql`: MySQL, Java間でのみデータをやり取りするAPI
- `02_combi`: Ignite, MySQL間でリードスルー/ライトバックでデータがやり取りされるAPI
- `03_ignite`: Ignite, Java間でのみデータをやり取りするAPI

## 01 MySQL

MySQLに直接データを投入します。

### API

```shell
# ユーザ登録
curl -X POST -H 'Content-Type: application/json' -d '{"name": "nob", "age": 13}' localhost:8081/api/v1/user

# ユーザ検索
curl -X GET localhost:8081/api/v1/user?id=98030cdf-0c95-41fe-82a8-c8c6827c66b8
```

### データベース

```shell
# usersテーブル検索
docker exec -it eadb mariadb -u root -ppassword eadb -e "select * from users;"
```

## 03 Ignite

Igniteにのみデータを投入します。

### API

```shell
# ユーザ登録
curl -X POST -H 'Content-Type: application/json' -d '{"name": "nob", "age": 13}' localhost:8083/api/v1/user

# ユーザ検索
curl -X GET localhost:8083/api/v1/user?id=a186394a-83d5-40ed-97a3-e488b5797e13
```

### Ignite

- 事前にテーブルの作成が必要です:

```shell
# SQLLine起動
docker exec -it ignite /opt/ignite/apache-ignite/bin/sqlline.sh --verbose=true -u jdbc:ignite:thin://127.0.0.1/
```

```sql
-- テーブル作成
CREATE TABLE IF NOT EXISTS users (
    id varchar(36) PRIMARY KEY
    , name varchar(8)
    , age int
);
```
