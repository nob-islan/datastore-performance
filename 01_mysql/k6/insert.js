import http from "k6/http";
import { sleep, check } from "k6";

export const options = {
  scenarios: {
    contacts: {
      executor: "shared-iterations",
      vus: 100,
      iterations: 1000000,
      maxDuration: "3h",
    },
  },
};

/**
 * 大量データを作成します。
 */
export default function () {
  // 年齢を乱数生成
  const age = Math.floor(Math.random() * 100);

  // リクエスト送信
  const res = http.post(
    "http://host.docker.internal:8081/api/v1/user",
    JSON.stringify({ name: "nob", age: age }),
    {
      headers: { "Content-Type": "application/json" },
    },
  );
}
