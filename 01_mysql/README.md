# 01 MySQL

MySQLに直接データを投入します。

## API

```shell
# ユーザ登録
curl -X POST -H 'Content-Type: application/json' -d '{"name": "nob", "password": "passwd"}' localhost:8081/api/v1/user

# ユーザ検索
curl -X GET localhost:8081/api/v1/user?id=4f02318a-173a-45db-bd3e-08c682617f2e
```

## データベース

```shell
# usersテーブル検索
docker exec -it eadb mariadb -u root -ppassword eadb -e "select * from users;"
```
