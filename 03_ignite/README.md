# 03 Ignite

Igniteにのみデータを投入します。

## API

```shell
# ユーザ登録
curl -X POST -H 'Content-Type: application/json' -d '{"name": "nob", "age": 13}' localhost:8083/api/v1/user

# ユーザ検索
curl -X GET localhost:8083/api/v1/user?id=a186394a-83d5-40ed-97a3-e488b5797e13
```

## Ignite

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
