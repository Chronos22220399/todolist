# STEP1: 编码

## 编码顺序
- 配置 main.ts：全局引入 Element Plus、Pinia、Router

```ts
import { createApp } from "vue";
import "./style.css";
import App from "./App.vue";

// 1. 引入 Element Plus 及样式
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";

// 2. 引入 Pinia
import { createPinia } from "pinia";

// 3. 引入 Router
import router from "./router/";

// 4. 创建 Vue 应用示例
const app = createApp(App);

// 5. 挂载插件
app.use(ElemnetPlus);
app.use(createPinia());
app.use(router);

// 6. 挂载页面
app.mount("#app");
```

- 配置 router：实现页面路由及路由懒加载
- 配置 store：初始化 Pinia 状态管理
- 封装 axios：统一接口请求和错误处理
- 实现页面布局：layouts + pages
- 开发通用组件：如自定义表格、弹窗等
- 业务开发：如 TodoList、用户管理等
- 工程规范：接入 ESLint、Prettier
- 环境变量配置：如 base API、不同环境区分
- 权限/路由守卫：如有鉴权需求
