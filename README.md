# データストア性能計測プロジェクト

MySQL, Igniteを使ってデータベースおよびキャッシュのデータ読み書き性能を計測するプロジェクトです。

## 構成

下記3つのJava Projectから構成されます:

- `01_mysql`: MySQL, Java間でのみデータをやり取りするAPI
- `02_combi`: Ignite, MySQL間でリードスルー/ライトバックでデータがやり取りされるAPI
- `03_ignite`: Ignite, Java間でのみデータをやり取りするAPI
