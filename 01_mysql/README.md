# 01 MySQL

MySQLに直接データを投入します。

## API

```shell
# ユーザ登録
curl -X POST -H 'Content-Type: application/json' -d '{"name": "nob", "age": 13}' localhost:8081/api/v1/user

# ユーザ検索
curl -X GET localhost:8081/api/v1/user?id=98030cdf-0c95-41fe-82a8-c8c6827c66b8
```

## データベース

```shell
# usersテーブル検索
docker exec -it eadb mariadb -u root -ppassword eadb -e "select * from users;"
```
